// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.search.models.SuggestParameters;
import com.azure.search.models.SuggestResult;
import com.azure.search.test.environment.models.Author;
import com.azure.search.test.environment.models.Book;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.azure.search.SearchTestBase.HOTELS_DATA_JSON;
import static com.azure.search.SearchTestBase.HOTELS_INDEX_NAME;

public class SuggestSyncTests extends SuggestTestBase {

    private SearchIndexClient client;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canSuggestDynamicDocuments() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(Collections.singletonList("HotelId"));

        PagedIterable<SuggestResult> suggestResult = client.suggest("more", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        verifyDynamicDocumentSuggest(iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void searchFieldsExcludesFieldsFromSuggest() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        SuggestParameters suggestParams = new SuggestParameters()
            .setSearchFields(Collections.singletonList("HotelName"));

        PagedIterable<SuggestResult> suggestResult = client.suggest("luxury", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        verifyFieldsExcludesFieldsSuggest(iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void canUseSuggestHitHighlighting() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        SuggestParameters suggestParams = new SuggestParameters()
            .setHighlightPreTag("<b>")
            .setHighlightPostTag("</b>")
            .setFilter("Category eq 'Luxury'")
            .setTop(1);

        PagedIterable<SuggestResult> suggestResult = client.suggest("hotel", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        verifyHitHighlightingSuggest(iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void canGetFuzzySuggestions() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        SuggestParameters suggestParams = new SuggestParameters()
            .setUseFuzzyMatching(true);

        PagedIterable<SuggestResult> suggestResult = client.suggest("hitel", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        verifyFuzzySuggest(iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    public void canSuggestStaticallyTypedDocuments() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        List<Map<String, Object>> hotels = uploadDocumentsJson(client, HOTELS_DATA_JSON);
        //arrange
        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(Collections.singletonList("HotelId"));

        //act
        PagedIterable<SuggestResult> suggestResult = client.suggest("more", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        //assert
        verifyCanSuggestStaticallyTypedDocuments(iterator.next(), hotels);
    }

    @Override
    public void canSuggestWithDateTimeInStaticModel() throws Exception {
        setupIndexFromJsonFile(BOOKS_INDEX_JSON);
        client = getClientBuilder(BOOKS_INDEX_NAME).buildClient();

        Author tolkien = new Author();
        tolkien.firstName("J.R.R.");
        tolkien.lastName("Tolkien");
        Book doc1 = new Book();
        doc1.ISBN("123");
        doc1.title("Lord of the Rings");
        doc1.author(tolkien);

        Book doc2 = new Book();
        doc2.ISBN("456");
        doc2.title("War and Peace");
        doc2.publishDate(OffsetDateTime.parse("2015-08-18T00:00:00Z"));
        uploadDocuments(client, Arrays.asList(doc1, doc2));

        SuggestParameters suggestParams = new SuggestParameters();
        suggestParams.setSelect(Arrays.asList("ISBN", "Title", "PublishDate"));
        PagedIterable<SuggestResult> suggestResult = client.suggest("War", "sg", suggestParams, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        //assert
        verifyCanSuggestWithDateTimeInStaticModel(iterator.next());
    }

    @Override
    public void fuzzyIsOffByDefault() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);

        PagedIterable<SuggestResult> suggestResult = client.suggest("hitel", "sg", null, null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        verifyFuzzyIsOffByDefault(iterator.next());
    }

    @Override
    public void suggestThrowsWhenGivenBadSuggesterName() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        thrown.expect(HttpResponseException.class);
        thrown.expectMessage("The specified suggester name 'Suggester does not exist' "
            + "does not exist in this index definition.");

        PagedIterable<SuggestResult> suggestResult = client.suggest("Hotel", "Suggester does not exist", null, null);
        suggestResult.iterableByPage().iterator().next();
    }

    @Override
    public void suggestThrowsWhenRequestIsMalformed() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        thrown.expect(HttpResponseException.class);
        thrown.expectMessage("Invalid expression: Syntax error at position 7 in 'This is not a valid orderby.'");

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(new LinkedList<>(Collections.singletonList("This is not a valid orderby.")));

        PagedIterable<SuggestResult> suggestResult = client.suggest("hotel", "sg", suggestParams, null);
        suggestResult.iterableByPage().iterator().next();
    }

    @Override
    public void testCanSuggestWithMinimumCoverage() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);

        //arrange
        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(new LinkedList<>(Collections.singletonList("HotelId")))
            .setMinimumCoverage(50.0);

        //act
        PagedResponse<SuggestResult> suggestResult = client
            .suggest("luxury", "sg", suggestParams, null)
            .iterableByPage()
            .iterator()
            .next();

        verifyMinimumCoverage(suggestResult);

    }

    @Override
    public void testTopTrimsResults() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);
        //arrange
        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(Collections.singletonList("HotelId"))
            .setTop(3);

        //act
        PagedIterable<SuggestResult> suggestResult = client.suggest("hotel",
            "sg",
            suggestParams,
            null);
        Iterator<PagedResponse<SuggestResult>> iterator = suggestResult.iterableByPage().iterator();

        //assert
        verifyTopDocumentSuggest(iterator.next());
    }

    @Override
    public void testCanFilter() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);

        SuggestParameters suggestParams = new SuggestParameters()
            .setFilter("Rating gt 3 and LastRenovationDate gt 2000-01-01T00:00:00Z")
            .setOrderBy(Arrays.asList("HotelId"));

        PagedIterable<SuggestResult> suggestResult = client.suggest("hotel", "sg", suggestParams, null);
        PagedResponse<SuggestResult> result = suggestResult.iterableByPage().iterator().next();

        Assert.assertNotNull(result);
        List<String> actualIds = result.getValue().stream().map(s -> (String) s.getAdditionalProperties().get("HotelId")).collect(Collectors.toList());
        List<String> expectedIds = Arrays.asList("1", "5");
        Assert.assertEquals(expectedIds, actualIds);
    }

    @Override
    public void testOrderByProgressivelyBreaksTies() {
        createHotelIndex();
        client = getClientBuilder(HOTELS_INDEX_NAME).buildClient();

        uploadDocumentsJson(client, HOTELS_DATA_JSON);

        SuggestParameters suggestParams = new SuggestParameters()
            .setOrderBy(Arrays.asList("Rating desc",
                "LastRenovationDate asc",
                "geo.distance(Location, geography'POINT(-122.0 49.0)')"));

        PagedIterable<SuggestResult> suggestResult = client.suggest("hotel", "sg", suggestParams, null);
        PagedResponse<SuggestResult> result = suggestResult.iterableByPage().iterator().next();

        Assert.assertNotNull(result);
        List<String> actualIds = result.getValue().stream().map(s -> (String) s.getAdditionalProperties().get("HotelId")).collect(Collectors.toList());
        List<String> expectedIds = Arrays.asList("1", "9", "4", "3", "5");
        Assert.assertEquals(expectedIds, actualIds);
    }
}
