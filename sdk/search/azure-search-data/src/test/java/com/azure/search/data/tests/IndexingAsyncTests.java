// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search.data.tests;

import com.azure.core.exception.HttpResponseException;
import com.azure.search.data.SearchIndexAsyncClient;
import com.azure.search.data.common.jsonwrapper.JsonWrapper;
import com.azure.search.data.common.jsonwrapper.api.JsonApi;
import com.azure.search.data.common.jsonwrapper.jacksonwrapper.JacksonDeserializer;
import com.azure.search.data.customization.Document;
import com.azure.search.data.customization.IndexBatchBuilder;
import com.azure.search.data.customization.models.GeoPoint;
import com.azure.search.data.generated.models.DocumentIndexResult;
import com.azure.search.data.generated.models.IndexAction;
import com.azure.search.data.generated.models.IndexActionType;
import com.azure.search.data.generated.models.IndexBatch;
import com.azure.search.data.generated.models.IndexingResult;
import com.azure.search.data.models.Book;
import com.azure.search.data.models.Hotel;
import com.azure.search.data.models.HotelAddress;
import com.azure.search.data.models.HotelRoom;
import com.azure.search.service.models.DataType;
import com.azure.search.service.models.Field;
import com.azure.search.service.models.Index;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.Assert;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IndexingAsyncTests extends IndexingTestBase {
    private SearchIndexAsyncClient client;

    @Override
    public void countingDocsOfNewIndexGivesZero() {
        Mono<Long> result = client.countDocuments();
        Long expected = 0L;

        StepVerifier.create(result).expectNext(expected).expectComplete().verify();
    }

    @Override
    public void indexDoesNotThrowWhenAllActionsSucceed() {
        String expectedHotelId = "1";
        Long expectedHotelCount = 1L;

        Hotel myHotel = new Hotel().hotelId(expectedHotelId);
        List<Hotel> toUpload = Arrays.asList(myHotel);
        Mono<DocumentIndexResult> asyncResult = client.uploadDocuments(toUpload);

        StepVerifier.create(asyncResult).assertNext(res -> {
            List<IndexingResult> result = res.results();
            this.assertIndexActionSucceeded(expectedHotelId, result.get(0), 201);
        }).verifyComplete();

        waitFor(2);

        StepVerifier.create(client.countDocuments()).
            expectNext(expectedHotelCount).
            verifyComplete();
    }

    @Override
    public void canIndexWithPascalCaseFields() {
        String expectedHotelId = "1";
        Long expectedHotelCount = 1L;

        Hotel myHotel =
            new Hotel().hotelId(expectedHotelId).
                hotelName("My Pascal Hotel").
                description("A Great Pascal Description.").
                category("Category Pascal");
        List<Hotel> toUpload = Arrays.asList(myHotel);

        Mono<DocumentIndexResult> asyncResult = client.uploadDocuments(toUpload);

        StepVerifier.create(asyncResult).assertNext(res -> {
            List<IndexingResult> result = res.results();
            this.assertIndexActionSucceeded(expectedHotelId, result.get(0), 201);
        }).verifyComplete();

        waitFor(2);

        StepVerifier.create(client.countDocuments()).
            expectNext(expectedHotelCount).
            verifyComplete();
    }

    @Override
    public void canIndexStaticallyTypedDocuments() throws ParseException {
        JsonApi jsonApi = JsonWrapper.newInstance(JacksonDeserializer.class);
        jsonApi.configureTimezone();

        Hotel hotel1 = prepareStaticallyTypedHotel("1");
        Hotel hotel2 = prepareStaticallyTypedHotel("2");
        Hotel hotel3 = prepareStaticallyTypedHotel("3");
        Hotel nonExistingHotel = prepareStaticallyTypedHotel("nonExistingHotel"); // merging with a non existing document
        Hotel randomHotel = prepareStaticallyTypedHotel("randomId"); // deleting a non existing document

        IndexAction uploadAction = new IndexAction().actionType(IndexActionType.UPLOAD).additionalProperties(jsonApi.convertObjectToType(hotel1, Map.class));

        IndexAction deleteAction = new IndexAction()
            .actionType(IndexActionType.DELETE)
            .additionalProperties(jsonApi.convertObjectToType(randomHotel, Map.class));
        IndexAction mergeNonExistingAction = new IndexAction()
            .actionType(IndexActionType.MERGE)
            .additionalProperties(jsonApi.convertObjectToType(nonExistingHotel, Map.class));
        IndexAction mergeOrUploadAction = new IndexAction()
            .actionType(IndexActionType.MERGE_OR_UPLOAD)
            .additionalProperties(jsonApi.convertObjectToType(hotel3, Map.class));
        IndexAction uploadAction2 = new IndexAction()
            .actionType(IndexActionType.UPLOAD)
            .additionalProperties(jsonApi.convertObjectToType(hotel2, Map.class));

        IndexBatch indexBatch = new IndexBatch().actions(Arrays.asList(
            uploadAction,
            deleteAction,
            mergeNonExistingAction,
            mergeOrUploadAction,
            uploadAction2
        ));

        Mono<DocumentIndexResult> response = client.index(indexBatch);

        StepVerifier.create(response)
            .expectNextMatches(documentIndexResult -> {
                List<IndexingResult> indexingResults = documentIndexResult.results();

                assertSuccessfulIndexResult(indexingResults.get(0), "1", 201);
                assertSuccessfulIndexResult(indexingResults.get(1), "randomId", 200);
                assertFailedIndexResult(indexingResults.get(2), "nonExistingHotel", 404, "Document not found.");
                assertSuccessfulIndexResult(indexingResults.get(3), "3", 201);
                assertSuccessfulIndexResult(indexingResults.get(4), "2", 201);

                return indexingResults.size() == indexBatch.actions().size();
            })
            .verifyComplete();

        StepVerifier.create(client.getDocument(hotel1.hotelId()))
            .expectNextMatches(result -> {
                Hotel actual = result.as(Hotel.class);
                return actual.equals(hotel1);
            })
            .expectComplete()
            .verify();

        StepVerifier.create(client.getDocument(hotel2.hotelId()))
            .expectNextMatches(result -> {
                Hotel actual = result.as(Hotel.class);
                return actual.equals(hotel2);
            })
            .verifyComplete();

        StepVerifier.create(client.getDocument(hotel3.hotelId()))
            .expectNextMatches(result -> {
                Hotel actual = result.as(Hotel.class);
                return actual.equals(hotel3);
            })
            .verifyComplete();
    }

    @Override
    public void canIndexDynamicDocuments() {
        Document hotel1 = prepareDynamicallyTypedHotel("1");
        Document hotel2 = prepareDynamicallyTypedHotel("2");
        Document hotel3 = prepareDynamicallyTypedHotel("3");
        Document nonExistingHotel = prepareDynamicallyTypedHotel("nonExistingHotel"); // merging with a non existing document
        Document randomHotel = prepareDynamicallyTypedHotel("randomId"); // deleting a non existing document

        IndexBatchBuilder batchBuilder = new IndexBatchBuilder();
        batchBuilder.
            upload(hotel1).
            delete(randomHotel).
            merge(nonExistingHotel).
            mergeOrUpload(hotel3).
            upload(hotel2);

        Mono<DocumentIndexResult> response = client.index(batchBuilder.build());

        StepVerifier.create(response)
            .expectNextMatches(documentIndexResult -> {
                List<IndexingResult> results = documentIndexResult.results();

                assertSuccessfulIndexResult(results.get(0), "1", 201);
                assertSuccessfulIndexResult(results.get(1), "randomId", 200);
                assertFailedIndexResult(results.get(2), "nonExistingHotel", 404, "Document not found.");
                assertSuccessfulIndexResult(results.get(3), "3", 201);
                assertSuccessfulIndexResult(results.get(4), "2", 201);

                return results.size() == batchBuilder.size();
            })
            .verifyComplete();

        StepVerifier.create(client.getDocument(hotel1.get("HotelId").toString()))
            .expectNext(hotel1)
            .verifyComplete();

        StepVerifier.create(client.getDocument(hotel2.get("HotelId").toString()))
            .expectNext(hotel2)
            .expectComplete()
            .verify();

        StepVerifier.create(client.getDocument(hotel3.get("HotelId").toString()))
            .expectNext(hotel3)
            .verifyComplete();
    }

    @Override
    public void indexWithInvalidDocumentThrowsException() {
        List<Document> toUpload = Arrays.asList(new Document());
        Mono<DocumentIndexResult> indexResult = client.uploadDocuments(toUpload);

        StepVerifier
            .create(indexResult)
            .verifyErrorSatisfies(error -> {
                Assert.assertEquals(HttpResponseException.class, error.getClass());
                Assert.assertEquals(HttpResponseStatus.BAD_REQUEST.code(), ((HttpResponseException) error).response().statusCode());
                Assert.assertTrue(error.getMessage().contains("The request is invalid. Details: actions : 0: Document key cannot be missing or empty."));
            });
    }

    @Override
    public void canUseIndexWithReservedName() {

        Index indexWithReservedName = new Index()
            .withName("prototype")
            .withFields(Collections.singletonList(new Field().withName("ID").withType(DataType.EDM_STRING).withKey(Boolean.TRUE)));

        if (!interceptorManager.isPlaybackMode()) {
            searchServiceClient.indexes().create(indexWithReservedName);
        }

        Map<String, Object> indexData = new HashMap<>();
        indexData.put("ID", "1");

        client.setIndexName(indexWithReservedName.name())
            .index(new IndexBatch()
                .actions(Collections.singletonList(new IndexAction()
                    .actionType(IndexActionType.UPLOAD)
                    .additionalProperties(indexData)))).block();

        StepVerifier
            .create(client.getDocument("1"))
            .assertNext(result -> Assert.assertNotNull(result))
            .verifyComplete();
    }

    @Override
    public void canRoundtripBoundaryValues() throws Exception {
        JsonApi jsonApi = JsonWrapper.newInstance(JacksonDeserializer.class);
        jsonApi.configureTimezone();

        List<Hotel> boundaryConditionDocs = getBoundaryValues();

        List<IndexAction> actions = boundaryConditionDocs.stream()
            .map(h -> new IndexAction()
                .actionType(IndexActionType.UPLOAD)
                .additionalProperties((Map<String, Object>) jsonApi.convertObjectToType(h, Map.class)))
            .collect(Collectors.toList());
        IndexBatch batch = new IndexBatch()
            .actions(actions);

        client.index(batch).block();

        // Wait 2 secs to allow index request to finish
        Thread.sleep(2000);

        for (Hotel expected : boundaryConditionDocs) {
            StepVerifier.create(client.getDocument(expected.hotelId()))
                .expectNextMatches(d -> {
                    Hotel actual = d.as(Hotel.class);
                    return actual.equals(expected);
                })
                .verifyComplete();
        }

    }

    @Override
    public void dynamicDocumentDateTimesRoundTripAsUtc() throws IOException {
        // Book 1's publish date is in UTC format, and book 2's is unspecified.
        List<HashMap<String, Object>> books = Arrays.asList(
            new HashMap<String, Object>() {
                {
                    put(ISBN_FIELD, ISBN1);
                    put(PUBLISH_DATE_FIELD, DATE_UTC);
                }
            },
            new HashMap<String, Object>() {
                {
                    put(ISBN_FIELD, ISBN2);
                    put(PUBLISH_DATE_FIELD, "2010-06-27T00:00:00-00:00");
                }
            }
        );

        // Create 'books' index
        Reader indexData = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(BOOKS_INDEX_JSON));
        Index index = new ObjectMapper().readValue(indexData, Index.class);
        if (!interceptorManager.isPlaybackMode()) {
            searchServiceClient.indexes().create(index);
        }

        // Upload and retrieve book documents
        uploadDocuments(client, BOOKS_INDEX_NAME, books);
        Mono<Document> actualBook1 = client.getDocument(ISBN1);
        Mono<Document> actualBook2 = client.getDocument(ISBN2);

        // Verify
        StepVerifier
            .create(actualBook1)
            .assertNext(res -> {
                Assert.assertEquals(DATE_UTC, res.get(PUBLISH_DATE_FIELD));
            })
            .verifyComplete();
        StepVerifier
            .create(actualBook2)
            .assertNext(res -> {
                Assert.assertEquals(DATE_UTC, res.get(PUBLISH_DATE_FIELD));
            })
            .verifyComplete();
    }

    @Override
    public void staticallyTypedDateTimesRoundTripAsUtc() throws Exception {
        // Book 1's publish date is in UTC format, and book 2's is unspecified.
        DateFormat dateFormatUtc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateFormat dateFormatUnspecifiedTimezone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Book> books = Arrays.asList(
            new Book()
                .ISBN(ISBN1)
                .publishDate(dateFormatUtc.parse(DATE_UTC)),
            new Book()
                .ISBN(ISBN2)
                .publishDate(dateFormatUnspecifiedTimezone.parse("2010-06-27 00:00:00"))
        );

        // Create 'books' index
        Reader indexData = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(BOOKS_INDEX_JSON));
        Index index = new ObjectMapper().readValue(indexData, Index.class);
        if (!interceptorManager.isPlaybackMode()) {
            searchServiceClient.indexes().create(index);
        }

        // Upload and retrieve book documents
        uploadDocuments(client, BOOKS_INDEX_NAME, books);
        Mono<Document> actualBook1 = client.getDocument(ISBN1);
        Mono<Document> actualBook2 = client.getDocument(ISBN2);

        // Verify
        StepVerifier
            .create(actualBook1)
            .assertNext(res -> {
                Assert.assertEquals(books.get(0).publishDate(), res.as(Book.class).publishDate());
            })
            .verifyComplete();
        StepVerifier
            .create(actualBook2)
            .assertNext(res -> {
                Assert.assertEquals(books.get(1).publishDate(), res.as(Book.class).publishDate());
            })
            .verifyComplete();
    }

    @Override
    public void canMergeStaticallyTypedDocuments() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        Hotel originalDoc = new Hotel()
            .hotelId("1")
            .hotelName("Secret Point Motel")
            .description("The hotel is ideally located on the main commercial artery of the city in the heart of New York. A few minutes away is Time's Square and the historic centre of the city, as well as other places of interest that make New York one of America's most attractive and cosmopolitan cities.")
            .descriptionFr("L'hôtel est idéalement situé sur la principale artère commerciale de la ville en plein cœur de New York. A quelques minutes se trouve la place du temps et le centre historique de la ville, ainsi que d'autres lieux d'intérêt qui font de New York l'une des villes les plus attractives et cosmopolites de l'Amérique.")
            .category("Boutique")
            .tags(Arrays.asList("pool",
                "air conditioning",
                "concierge"))
            .parkingIncluded(false)
            .smokingAllowed(true)
            .lastRenovationDate(dateFormat.parse("2010-06-27T00:00:00Z"))
            .rating(4)
            .location(GeoPoint.createWithDefaultCrs(40.760586, -73.975403))
            .address(new HotelAddress()
                .streetAddress("677 5th Ave")
                .city("New York")
                .stateProvince("NY")
                .country("USA")
                .postalCode("10022"))
            .rooms(Arrays.asList(
                new HotelRoom()
                    .description("Budget Room, 1 Queen Bed (Cityside)")
                    .descriptionFr("Chambre Économique, 1 grand lit (côté ville)")
                    .type("Budget Room")
                    .baseRate(9.69)
                    .bedOptions("1 Queen Bed")
                    .sleepsCount(2)
                    .smokingAllowed(true)
                    .tags(Arrays.asList("vcr/dvd")),
                new HotelRoom()
                    .description("Budget Room, 1 King Bed (Mountain View)")
                    .descriptionFr("Chambre Économique, 1 très grand lit (Mountain View)")
                    .type("Budget Room")
                    .baseRate(8.09)
                    .bedOptions("1 King Bed")
                    .sleepsCount(2)
                    .smokingAllowed(true)
                    .tags(Arrays.asList("vcr/dvd",
                        "jacuzzi tub"))
            ));

        // Update category, tags, parking included, rating, and rooms. Erase description, last renovation date, location and address.
        Hotel updatedDoc = new Hotel()
            .hotelId("1")
            .hotelName("Secret Point Motel")
            .description(null)
            .category("Economy")
            .tags(Arrays.asList("pool",
                "air conditioning"))
            .parkingIncluded(true)
            .lastRenovationDate(null)
            .rating(3)
            .location(null)
            .address(new HotelAddress())
            .rooms(Arrays.asList(
                new HotelRoom()
                    .description(null)
                    .type("Budget Room")
                    .baseRate(10.5)
                    .bedOptions("1 Queen Bed")
                    .sleepsCount(2)
                    .tags(Arrays.asList("vcr/dvd",
                        "balcony"))));

        // Fields whose values get updated are updated, and whose values get erased remain the same.
        Hotel expectedDoc = new Hotel()
            .hotelId("1")
            .hotelName("Secret Point Motel")
            .description("The hotel is ideally located on the main commercial artery of the city in the heart of New York. A few minutes away is Time's Square and the historic centre of the city, as well as other places of interest that make New York one of America's most attractive and cosmopolitan cities.")
            .descriptionFr("L'hôtel est idéalement situé sur la principale artère commerciale de la ville en plein cœur de New York. A quelques minutes se trouve la place du temps et le centre historique de la ville, ainsi que d'autres lieux d'intérêt qui font de New York l'une des villes les plus attractives et cosmopolites de l'Amérique.")
            .category("Economy")
            .tags(Arrays.asList("pool",
                "air conditioning"))
            .parkingIncluded(true)
            .smokingAllowed(true)
            .lastRenovationDate(dateFormat.parse("2010-06-27T00:00:00Z"))
            .rating(3)
            .location(GeoPoint.createWithDefaultCrs(40.760586, -73.975403))
            .address(new HotelAddress()
                .streetAddress("677 5th Ave")
                .city("New York")
                .stateProvince("NY")
                .country("USA")
                .postalCode("10022"))
            .rooms(Arrays.asList(
                new HotelRoom()
                    .description(null)
                    .type("Budget Room")
                    .baseRate(10.5)
                    .bedOptions("1 Queen Bed")
                    .sleepsCount(2)
                    .tags(Arrays.asList("vcr/dvd",
                        "balcony"))));

        JsonApi jsonApi = JsonWrapper.newInstance(JacksonDeserializer.class);
        jsonApi.configureTimezone();

        // Upload an original doc and merge it with an updated doc
        IndexAction uploadOriginalDocAction = new IndexAction()
            .actionType(IndexActionType.MERGE_OR_UPLOAD)
            .additionalProperties(jsonApi.convertObjectToType(originalDoc, Map.class));
        IndexAction replaceWithUpdatedDocAction = new IndexAction()
            .actionType(IndexActionType.MERGE)
            .additionalProperties(jsonApi.convertObjectToType(updatedDoc, Map.class));
        IndexBatch batch1 = new IndexBatch()
            .actions(Arrays.asList(uploadOriginalDocAction));
        IndexBatch batch2 = new IndexBatch()
            .actions(Arrays.asList(replaceWithUpdatedDocAction));

        // Verify
        StepVerifier.create(client.index(batch1))
            .expectNextMatches(documentIndexResult -> documentIndexResult.results().size() == batch1.actions().size())
            .verifyComplete();
        StepVerifier.create(client.index(batch2))
            .expectNextMatches(documentIndexResult -> documentIndexResult.results().size() == batch2.actions().size())
            .verifyComplete();
        StepVerifier.create(client.getDocument("1"))
            .expectNextMatches(result -> result.as(Hotel.class).equals(expectedDoc))
            .verifyComplete();

        // Merge with the original doc
        IndexAction replaceWithOriginalDocAction = new IndexAction()
            .actionType(IndexActionType.MERGE)
            .additionalProperties(jsonApi.convertObjectToType(originalDoc, Map.class));
        IndexBatch batch3 = new IndexBatch()
            .actions(Arrays.asList(replaceWithOriginalDocAction));

        // Verify
        StepVerifier.create(client.index(batch3))
            .expectNextMatches(documentIndexResult -> documentIndexResult.results().size() == batch3.actions().size())
            .verifyComplete();
        StepVerifier.create(client.getDocument("1"))
            .expectNextMatches(result -> result.as(Hotel.class).equals(originalDoc))
            .verifyComplete();
    }

    @Override
    protected void initializeClient() {
        client = builderSetup().indexName(INDEX_NAME).buildAsyncClient();
    }
}
