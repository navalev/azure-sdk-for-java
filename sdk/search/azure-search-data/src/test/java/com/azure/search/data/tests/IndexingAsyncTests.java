// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search.data.tests;

import com.azure.search.data.SearchIndexAsyncClient;
import com.azure.search.data.generated.models.*;
import com.azure.search.data.helpers.EntityMapper;
import com.azure.search.data.models.Hotel;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import org.junit.Assert;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.azure.core.exception.HttpResponseException;
import com.azure.search.data.customization.Document;
import com.azure.search.data.generated.models.DocumentIndexResult;
import com.azure.search.data.generated.models.IndexAction;
import com.azure.search.data.generated.models.IndexActionType;
import com.azure.search.data.generated.models.IndexBatch;
import io.netty.handler.codec.http.HttpResponseStatus;


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

        List<IndexAction> indexActions = new LinkedList<>();
        Hotel myHotel = new Hotel().hotelId(expectedHotelId);
        Map<String, Object> hotelMap = new EntityMapper<Hotel>().objectToMap(myHotel);

        addDocumentToIndexActions(indexActions, IndexActionType.UPLOAD, hotelMap);
        Mono<DocumentIndexResult> asyncResult = indexDocumentsAsync(indexActions);

        StepVerifier.create(asyncResult).consumeNextWith(res -> {
            List<IndexingResult> result = res.results();
            this.AssertIndexActionSucceeded(expectedHotelId, result.get(0), 201);
        }).thenAwait(Duration.ofSeconds(4)).verifyComplete();

        StepVerifier.create(client.countDocuments()).expectNext(expectedHotelCount).expectComplete().verify();
    }

    @Override
    public void canIndexWithPascalCaseFields() {
        String expectedHotelId = "1";
        Long expectedHotelCount = 1L;

        List<IndexAction> indexActions = new LinkedList<>();
        Hotel myHotel = new Hotel().hotelId(expectedHotelId);
        myHotel.hotelName("My Pascal Hotel");
        myHotel.description("A Great Pascal Description.");
        myHotel.category("Category Pascal");

        Map<String, Object> hotelMap = new EntityMapper<Hotel>().objectToMap(myHotel);

        addDocumentToIndexActions(indexActions, IndexActionType.UPLOAD, hotelMap);
        Mono<DocumentIndexResult> asyncResult = indexDocumentsAsync(indexActions);

        StepVerifier.create(asyncResult).consumeNextWith(res -> {
            List<IndexingResult> result = res.results();
            this.AssertIndexActionSucceeded(expectedHotelId, result.get(0), 201);
        }).thenAwait(Duration.ofSeconds(4)).verifyComplete();

        StepVerifier.create(client.countDocuments()).expectNext(expectedHotelCount).expectComplete().verify();
    }

    @Override
    public void indexWithInvalidDocumentThrowsException() {
        List<IndexAction> indexActions = new LinkedList<>();
        addDocumentToIndexActions(indexActions, IndexActionType.UPLOAD, new Document());
        Mono<DocumentIndexResult> indexResult = client.index(new IndexBatch().actions(indexActions));

        StepVerifier
            .create(indexResult)
            .verifyErrorSatisfies(error -> {
                Assert.assertEquals(HttpResponseException.class, error.getClass());
                Assert.assertEquals(HttpResponseStatus.BAD_REQUEST.code(), ((HttpResponseException) error).response().statusCode());
                Assert.assertTrue(error.getMessage().contains("The request is invalid. Details: actions : 0: Document key cannot be missing or empty."));
            });
    }

    @Override
    protected void initializeClient() {
        client = builderSetup().indexName(INDEX_NAME).buildAsyncClient();
    }

    protected Mono<DocumentIndexResult> indexDocumentsAsync(List<IndexAction> indexActions) {
        IndexBatch indexBatch = new IndexBatch().actions(indexActions);
        Mono<DocumentIndexResult> indexResult = client.index(indexBatch);

        return indexResult;
    }
}
