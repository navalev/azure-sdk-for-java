// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search;

import com.azure.search.models.FacetResult;
import com.azure.search.models.Index;
import com.azure.search.models.QueryType;
import com.azure.search.models.RangeFacetResult;
import com.azure.search.models.RequestOptions;
import com.azure.search.models.SearchOptions;
import com.azure.search.models.SearchResult;
import com.azure.search.models.SynonymMap;
import com.azure.search.models.ValueFacetResult;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.io.IOException;
import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Abstract base class for all Search API tests
 */
public abstract class SearchTestBase extends SearchIndexClientTestBase {

    static final String HOTELS_INDEX_NAME = "hotels";
    static final String HOTELS_DATA_JSON = "HotelsDataArray.json";
    static final String HOTELS_DATA_JSON_WITHOUT_FR_DESCRIPTION = "HotelsDataArrayWithoutFr.json";
    private static final String SEARCH_SCORE_FIELD = "@search.score";
    static final String MODEL_WITH_VALUE_TYPES_INDEX_JSON = "ModelWithValueTypesIndexData.json";
    static final String MODEL_WITH_VALUE_TYPES_DOCS_JSON = "ModelWithValueTypesDocsData.json";
    static final String MODEL_WITH_INDEX_TYPES_INDEX_NAME = "testindex";
    static final String NON_NULLABLE_INDEX_JSON = "NonNullableIndexData.json";
    static final String NON_NULLABLE_INDEX_NAME = "non-nullable-index";

    protected List<Map<String, Object>> hotels;

    List<Map<String, Object>> createHotelsList(int count) {
        List<Map<String, Object>> documents = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Map<String, Object> doc = new HashMap<>();

            doc.put("HotelId", Integer.toString(i));
            doc.put("HotelName", "Hotel" + i);
            doc.put("Description", "Desc" + i);
            doc.put("Description_fr", "Desc_fr" + i);
            doc.put("Category", "Catg" + i);
            doc.put("Tags", Collections.singletonList("tag" + i));
            doc.put("ParkingIncluded", false);
            doc.put("SmokingAllowed", false);
            doc.put("LastRenovationDate", OffsetDateTime.parse("2010-06-27T00:00:00Z"));
            doc.put("Rating", i);

            documents.add(doc);
        }
        return documents;
    }

    /**
     * Drop fields that shouldn't be in the returned object
     *
     * @param map the map to drop items from
     * @return the new map
     */
    static Map<String, Object> dropUnnecessaryFields(Map<String, Object> map) {
        map.remove(SEARCH_SCORE_FIELD);
        return map;
    }

    boolean compareResults(List<Map<String, Object>> searchResults, List<Map<String, Object>> hotels) {
        Iterator<Map<String, Object>> searchIterator = searchResults.iterator();
        Iterator<Map<String, Object>> hotelsIterator = hotels.iterator();
        while (searchIterator.hasNext() && hotelsIterator.hasNext()) {
            Map<String, Object> result = searchIterator.next();
            Map<String, Object> hotel = hotelsIterator.next();

            hotel.entrySet().forEach(e -> checkEquals(e, result));
        }

        return true;
    }

    private void checkEquals(Map.Entry<String, Object> hotel, Map<String, Object> result) {
        if (hotel.getValue() != null && result.get(hotel.getKey()) != null) {
            assertReflectionEquals(hotel.getValue(), result.get(hotel.getKey()), ReflectionComparatorMode.IGNORE_DEFAULTS);
        }
    }

    void assertRangeFacets(List<RangeFacetResult> baseRateFacets, List<RangeFacetResult> lastRenovationDateFacets) {
        Assert.assertNull(baseRateFacets.get(0).getFrom());
        Assert.assertEquals(5.0, baseRateFacets.get(0).getTo());
        Assert.assertEquals(5.0, baseRateFacets.get(1).getFrom());
        Assert.assertEquals(8.0, baseRateFacets.get(1).getTo());
        Assert.assertEquals(8.0, baseRateFacets.get(2).getFrom());
        Assert.assertEquals(10.0, baseRateFacets.get(2).getTo());
        Assert.assertEquals(10.0, baseRateFacets.get(3).getFrom());
        Assert.assertNull(baseRateFacets.get(3).getTo());

        Assert.assertEquals(1, baseRateFacets.get(0).getCount().intValue());
        Assert.assertEquals(1, baseRateFacets.get(1).getCount().intValue());
        Assert.assertEquals(1, baseRateFacets.get(2).getCount().intValue());
        Assert.assertEquals(0, baseRateFacets.get(3).getCount().intValue());

        Assert.assertNull(lastRenovationDateFacets.get(0).getFrom());
        Assert.assertEquals("2000-01-01T00:00:00.000+0000", lastRenovationDateFacets.get(0).getTo());
        Assert.assertEquals("2000-01-01T00:00:00.000+0000", lastRenovationDateFacets.get(1).getFrom());
        Assert.assertNull(lastRenovationDateFacets.get(1).getTo());

        Assert.assertEquals(5, lastRenovationDateFacets.get(0).getCount().intValue());
        Assert.assertEquals(2, lastRenovationDateFacets.get(1).getCount().intValue());
    }

    List<RangeFacetResult> getRangeFacetsForField(
        Map<String, List<FacetResult>> facets, String expectedField, int expectedCount) {
        List<FacetResult> facetCollection = getFacetsForField(facets, expectedField, expectedCount);
        return facetCollection.stream().map(RangeFacetResult::new)
            .collect(Collectors.toList());
    }

    List<ValueFacetResult> getValueFacetsForField(
        Map<String, List<FacetResult>> facets, String expectedField, int expectedCount) {
        List<FacetResult> facetCollection = getFacetsForField(facets, expectedField, expectedCount);
        return facetCollection.stream().map(ValueFacetResult::new)
            .collect(Collectors.toList());
    }

    List<FacetResult> getFacetsForField(
        Map<String, List<FacetResult>> facets, String expectedField, int expectedCount) {
        Assert.assertTrue(facets.containsKey(expectedField));
        List<FacetResult> results = facets.get(expectedField);
        Assert.assertEquals(expectedCount, results.size());
        return results;
    }

    void assertContainHotelIds(List<Map<String, Object>> expected, List<SearchResult> actual) {
        Assert.assertNotNull(actual);
        List<String> actualKeys = actual.stream().filter(item -> item.getDocument().containsKey("HotelId"))
            .map(item -> (String) item.getDocument().get("HotelId")).collect(Collectors.toList());
        List<String> expectedKeys = expected.stream().filter(item -> item.containsKey("HotelId"))
            .map(item -> (String) item.get("HotelId")).collect(Collectors.toList());
        Assert.assertEquals(expectedKeys, actualKeys);
    }

    void assertValueFacetsEqual(List<ValueFacetResult> actualFacets, ArrayList<ValueFacetResult> expectedFacets) {
        Assert.assertEquals(expectedFacets.size(), actualFacets.size());
        for (int i = 0; i < actualFacets.size(); i++) {
            Assert.assertEquals(expectedFacets.get(i).getCount(), actualFacets.get(i).getCount());
            Assert.assertEquals(expectedFacets.get(i).getValue(), actualFacets.get(i).getValue());
        }
    }

    String getSearchResultId(SearchResult searchResult, String idFieldName) {
        return searchResult.getDocument().get(idFieldName).toString();
    }

    SearchOptions getSearchOptionsForRangeFacets() {
        return new SearchOptions().setFacets("Rooms/BaseRate,values:5|8|10",
            "LastRenovationDate,values:2000-01-01T00:00:00Z");
    }

    SearchOptions getSearchOptionsForValueFacets() {
        return new SearchOptions().setFacets("Rating,count:2,sort:-value",
            "SmokingAllowed,sort:count",
            "Category",
            "LastRenovationDate,interval:year",
            "Rooms/BaseRate,sort:value",
            "Tags,sort:value");
    }

    void prepareHotelsSynonymMap(String name, String synonyms, String fieldName) {
        if (!interceptorManager.isPlaybackMode()) {
            // In RECORDING mode (only), create a new index:
            SearchServiceClient searchServiceClient = getSearchServiceClientBuilder().buildClient();

            // Create a new SynonymMap
            searchServiceClient.createSynonymMap(new SynonymMap()
                .setName(name)
                .setSynonyms(synonyms));

            // Attach index field to SynonymMap
            Index hotelsIndex = searchServiceClient.getIndex(HOTELS_INDEX_NAME);
            hotelsIndex.getFields().stream()
                .filter(f -> fieldName.equals(f.getName()))
                .findFirst().get().setSynonymMaps(Collections.singletonList(name));

            // Update the index with the SynonymMap
            searchServiceClient.createOrUpdateIndex(hotelsIndex);

            // Wait for the index to update with the SynonymMap
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void assertListEqualHotelIds(List<String> expected, List<SearchResult> actual) {
        Assert.assertNotNull(actual);
        List<String> actualKeys = actual.stream().filter(item -> item.getDocument().containsKey("HotelId"))
            .map(item -> (String) item.getDocument().get("HotelId")).collect(Collectors.toList());
        Assert.assertEquals(expected, actualKeys);
    }

    @Test
    public void searchThrowsWhenRequestIsMalformed() {
        SearchOptions invalidSearchOptions = new SearchOptions().setFilter("This is not a valid filter.");

        assertHttpResponseException(
            () -> search("*", invalidSearchOptions, new RequestOptions()),
            HttpResponseStatus.BAD_REQUEST,
            "Invalid expression: Syntax error at position 7 in 'This is not a valid filter.'");
    }

    @Test
    public void searchThrowsWhenSpecialCharInRegexIsUnescaped() {
        SearchOptions invalidSearchOptions = new SearchOptions().setQueryType(QueryType.FULL);

        assertHttpResponseException(
            () -> search("/.*/.*/", invalidSearchOptions, new RequestOptions()),
            HttpResponseStatus.BAD_REQUEST,
            "Failed to parse query string at line 1, column 8.");
    }

    @Test
    public abstract void canSearchDynamicDocuments() throws IOException;

    @Test
    public abstract void canContinueSearch();

    @Test
    public abstract void canContinueSearchWithTop();

    @Test
    public abstract void canSearchWithSelectedFields() throws IOException;

    @Test
    public abstract void canUseTopAndSkipForClientSidePaging() throws IOException;

    @Test
    public abstract void canFilterNonNullableType() throws Exception;

    @Test
    public abstract void searchWithoutOrderBySortsByScore() throws IOException;

    @Test
    public abstract void orderByProgressivelyBreaksTies() throws IOException;

    @Test
    public abstract void canFilter() throws IOException;

    @Test
    public abstract void canSearchWithRangeFacets() throws IOException;

    @Test
    public abstract void canSearchWithLuceneSyntax() throws IOException;

    @Test
    public abstract void canSearchWithValueFacets() throws IOException;

    @Test
    public abstract void canSearchWithSearchModeAll() throws IOException;

    @Test
    public abstract void defaultSearchModeIsAny() throws IOException;

    @Test
    public abstract void canGetResultCountInSearch() throws IOException;

    @Test
    public abstract void canSearchWithRegex() throws IOException;

    @Test
    public abstract void canSearchWithEscapedSpecialCharsInRegex() throws IOException;

    @Test
    public abstract void canSearchWithMinimumCoverage() throws IOException;

    @Test
    public abstract void searchWithScoringProfileBoostsScore() throws IOException;

    @Test
    public abstract void canUseHitHighlighting() throws IOException;

    @Test
    public abstract void canSearchStaticallyTypedDocuments() throws IOException;

    @Test
    public abstract void canRoundTripNonNullableValueTypes() throws Exception;

    @Test
    public abstract void canSearchWithDateInStaticModel() throws ParseException, IOException;

    @Test
    public abstract void canSearchWithSynonyms() throws IOException;

    abstract void search(String searchText, SearchOptions searchOptions, RequestOptions requestOptions);
}
