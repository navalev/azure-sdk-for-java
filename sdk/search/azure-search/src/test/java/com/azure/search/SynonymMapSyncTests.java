// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search;

import com.azure.core.exception.HttpResponseException;
import com.azure.search.models.SynonymMap;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.Assert;

public class SynonymMapSyncTests extends SynonymMapTestBase {
    private SearchServiceClient client;

    @Override
    public void createSynonymMapReturnsCorrectDefinition() {
        client = getSearchServiceClientBuilder().buildClient();

        SynonymMap expectedSynonymMap = createTestSynonymMap();
        SynonymMap actualSynonymMap = client.createSynonymMap(expectedSynonymMap);

        assertSynonymMapsEqual(expectedSynonymMap, actualSynonymMap);
    }

    @Override
    public void createSynonymMapFailsWithUsefulMessageOnUserError() {
        client = getSearchServiceClientBuilder().buildClient();

        SynonymMap expectedSynonymMap = createTestSynonymMap();
        // Set invalid Synonym
        expectedSynonymMap.setSynonyms("a => b => c");

        try {
            client.createSynonymMap(expectedSynonymMap);
            Assert.fail("createSynonymMap did not throw an expected Exception");
        } catch (Exception ex) {
            Assert.assertEquals(HttpResponseException.class, ex.getClass());
            Assert.assertEquals(HttpResponseStatus.BAD_REQUEST.code(), ((HttpResponseException) ex).getResponse().getStatusCode());
            Assert.assertTrue(ex.getMessage().contains("Syntax error in line 1: 'a => b => c'. "
                    + "Only one explicit mapping (=>) can be specified in a synonym rule."));
        }
    }

    @Override
    public void getSynonymMapReturnsCorrectDefinition() {

    }

    @Override
    public void getSynonymMapThrowsOnNotFound() {

    }

    @Override
    public void canUpdateSynonymMap() {

    }

    @Override
    public void createOrUpdateCreatesWhenSynonymMapDoesNotExist() {

    }

    @Override
    public void createOrUpdateSynonymMapIfNotExistsFailsOnExistingResource() {

    }

    @Override
    public void createOrUpdateSynonymMapIfNotExistsSucceedsOnNoResource() {

    }

    @Override
    public void updateSynonymMapIfExistsSucceedsOnExistingResource() {

    }

    @Override
    public void updateSynonymMapIfExistsFailsOnNoResource() {

    }

    @Override
    public void updateSynonymMapIfNotChangedSucceedsWhenResourceUnchanged() {

    }

    @Override
    public void updateSynonymMapIfNotChangedFailsWhenResourceChanged() {

    }

    @Override
    public void deleteSynonymMapIfNotChangedWorksOnlyOnCurrentResource() {

    }

    @Override
    public void deleteSynonymMapIfExistsWorksOnlyWhenResourceExists() {

    }

    @Override
    public void deleteSynonymMapIsIdempotent() {

    }

    @Override
    public void canCreateAndListSynonymMaps() {

    }

    @Override
    public void existsReturnsTrueForExistingSynonymMap() {

    }

    @Override
    public void existsReturnsFalseForNonExistingSynonymMap() {

    }
}
