// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.implementation;
import com.azure.search.Document;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.implementation.CollectionFormat;
import com.azure.core.implementation.RestProxy;
import com.azure.core.implementation.serializer.jackson.JacksonAdapter;
import com.azure.core.implementation.serializer.SerializerAdapter;
import com.azure.core.util.Context;
import com.azure.search.models.AutocompleteMode;
import com.azure.search.models.AutocompleteOptions;
import com.azure.search.models.AutocompleteRequest;
import com.azure.search.models.AutocompleteResult;
import com.azure.search.models.DocumentIndexResult;
import com.azure.search.models.DocumentSearchResult;
import com.azure.search.models.DocumentSuggestResult;
import com.azure.search.models.IndexBatch;
import com.azure.search.models.QueryType;
import com.azure.search.models.SearchMode;
import com.azure.search.models.SearchOptions;
import com.azure.search.models.SearchRequest;
import com.azure.search.models.SearchRequestOptions;
import com.azure.search.models.SuggestOptions;
import com.azure.search.models.SuggestRequest;
import java.util.List;
import java.util.UUID;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * Documents.
 */
public final class DocumentsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private DocumentsService service;

    /**
     * The service client containing this operation class.
     */
    private SearchIndexRestClientImpl client;

    /**
     * Initializes an instance of DocumentsImpl.
     *
     * @param client the instance of the service client containing this operation class.
     * @param serializer the serializer to be used for service client requests.
     */
    public DocumentsImpl(SearchIndexRestClientImpl client, SerializerAdapter serializer) {
        this.service = RestProxy.create(DocumentsService.class, client.getHttpPipeline(), serializer);
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * SearchIndexRestClientDocuments to be used by the proxy service to
     * perform REST calls.
     */
    @Host("https://{searchServiceName}.{searchDnsSuffix}/indexes('{indexName}')")
    @ServiceInterface(name = "SearchIndexRestClientDocuments")
    private interface DocumentsService {
        @Get("docs/$count")
        @ExpectedResponses({200})
        Mono<SimpleResponse<Long>> count(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("docs")
        @ExpectedResponses({200})
        Mono<SimpleResponse<DocumentSearchResult>> searchGet(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("search") String searchText, @QueryParam("api-version") String apiVersion, @QueryParam("$count") Boolean includeTotalResultCount, @QueryParam("facet") String facets, @QueryParam("$filter") String filter, @QueryParam("highlight") String highlightFields, @QueryParam("highlightPostTag") String highlightPostTag, @QueryParam("highlightPreTag") String highlightPreTag, @QueryParam("minimumCoverage") Double minimumCoverage, @QueryParam("$orderby") String orderBy, @QueryParam("queryType") QueryType queryType, @QueryParam("scoringParameter") String scoringParameters, @QueryParam("scoringProfile") String scoringProfile, @QueryParam("searchFields") String searchFields, @QueryParam("searchMode") SearchMode searchMode, @QueryParam("$select") String select, @QueryParam("$skip") Integer skip, @QueryParam("$top") Integer top, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Post("docs/search.post.search")
        @ExpectedResponses({200})
        Mono<SimpleResponse<DocumentSearchResult>> searchPost(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @BodyParam("application/json; charset=utf-8") SearchRequest searchRequest, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("docs('{key}')")
        @ExpectedResponses({200})
        Mono<SimpleResponse<Document>> get(@PathParam("key") String key, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("$select") String selectedFields, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("docs/search.suggest")
        @ExpectedResponses({200})
        Mono<SimpleResponse<DocumentSuggestResult>> suggestGet(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("search") String searchText, @QueryParam("suggesterName") String suggesterName, @QueryParam("api-version") String apiVersion, @QueryParam("$filter") String filter, @QueryParam("fuzzy") Boolean useFuzzyMatching, @QueryParam("highlightPostTag") String highlightPostTag, @QueryParam("highlightPreTag") String highlightPreTag, @QueryParam("minimumCoverage") Double minimumCoverage, @QueryParam("$orderby") String orderBy, @QueryParam("searchFields") String searchFields, @QueryParam("$select") String select, @QueryParam("$top") Integer top, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Post("docs/search.post.suggest")
        @ExpectedResponses({200})
        Mono<SimpleResponse<DocumentSuggestResult>> suggestPost(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @BodyParam("application/json; charset=utf-8") SuggestRequest suggestRequest, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Post("docs/search.index")
        @ExpectedResponses({200, 207})
        <T> Mono<SimpleResponse<DocumentIndexResult>> index(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @BodyParam("application/json; charset=utf-8") IndexBatch<T> batch, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("docs/search.autocomplete")
        @ExpectedResponses({200})
        Mono<SimpleResponse<AutocompleteResult>> autocompleteGet(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("api-version") String apiVersion, @QueryParam("search") String searchText, @QueryParam("suggesterName") String suggesterName, @HeaderParam("client-request-id") UUID clientRequestId, @QueryParam("autocompleteMode") AutocompleteMode autocompleteMode, @QueryParam("$filter") String filter, @QueryParam("fuzzy") Boolean useFuzzyMatching, @QueryParam("highlightPostTag") String highlightPostTag, @QueryParam("highlightPreTag") String highlightPreTag, @QueryParam("minimumCoverage") Double minimumCoverage, @QueryParam("searchFields") String searchFields, @QueryParam("$top") Integer top, Context context);

        @Post("docs/search.post.autocomplete")
        @ExpectedResponses({200})
        Mono<SimpleResponse<AutocompleteResult>> autocompletePost(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @HostParam("indexName") String indexName, @QueryParam("api-version") String apiVersion, @BodyParam("application/json; charset=utf-8") AutocompleteRequest autocompleteRequest, @HeaderParam("client-request-id") UUID clientRequestId, Context context);
    }

    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Long>> countWithRestResponseAsync(Context context) {
        final UUID clientRequestId = null;
        return service.count(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Long>> countWithRestResponseAsync(SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        return service.count(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSearchResult>> searchGetWithRestResponseAsync(Context context) {
        final String searchText = null;
        final Boolean includeTotalResultCount = null;
        final String filter = null;
        final String highlightPostTag = null;
        final String highlightPreTag = null;
        final Double minimumCoverage = null;
        final QueryType queryType = null;
        final String scoringProfile = null;
        final SearchMode searchMode = null;
        final Integer skip = null;
        final Integer top = null;
        final UUID clientRequestId = null;
        String facetsConverted = null;
        String highlightFieldsConverted = null;
        String orderByConverted = null;
        String scoringParametersConverted = null;
        String searchFieldsConverted = null;
        String selectConverted = null;
        return service.searchGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchText, this.client.getApiVersion(), includeTotalResultCount, facetsConverted, filter, highlightFieldsConverted, highlightPostTag, highlightPreTag, minimumCoverage, orderByConverted, queryType, scoringParametersConverted, scoringProfile, searchFieldsConverted, searchMode, selectConverted, skip, top, clientRequestId, context);
    }

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchText A full-text search query expression; Use "*" or omit this parameter to match all documents.
     * @param searchOptions Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSearchResult>> searchGetWithRestResponseAsync(String searchText, SearchOptions searchOptions, SearchRequestOptions searchRequestOptions, Context context) {
        Boolean includeTotalResultCount = null;
        if (searchOptions != null) {
            includeTotalResultCount = searchOptions.isIncludeTotalResultCount();
        }
        List<String> facets = null;
        if (searchOptions != null) {
            facets = searchOptions.getFacets();
        }
        String filter = null;
        if (searchOptions != null) {
            filter = searchOptions.getFilter();
        }
        List<String> highlightFields = null;
        if (searchOptions != null) {
            highlightFields = searchOptions.getHighlightFields();
        }
        String highlightPostTag = null;
        if (searchOptions != null) {
            highlightPostTag = searchOptions.getHighlightPostTag();
        }
        String highlightPreTag = null;
        if (searchOptions != null) {
            highlightPreTag = searchOptions.getHighlightPreTag();
        }
        Double minimumCoverage = null;
        if (searchOptions != null) {
            minimumCoverage = searchOptions.getMinimumCoverage();
        }
        List<String> orderBy = null;
        if (searchOptions != null) {
            orderBy = searchOptions.getOrderBy();
        }
        QueryType queryType = null;
        if (searchOptions != null) {
            queryType = searchOptions.getQueryType();
        }
        List<String> scoringParameters = null;
        if (searchOptions != null) {
            scoringParameters = searchOptions.getScoringParameters();
        }
        String scoringProfile = null;
        if (searchOptions != null) {
            scoringProfile = searchOptions.getScoringProfile();
        }
        List<String> searchFields = null;
        if (searchOptions != null) {
            searchFields = searchOptions.getSearchFields();
        }
        SearchMode searchMode = null;
        if (searchOptions != null) {
            searchMode = searchOptions.getSearchMode();
        }
        List<String> select = null;
        if (searchOptions != null) {
            select = searchOptions.getSelect();
        }
        Integer skip = null;
        if (searchOptions != null) {
            skip = searchOptions.getSkip();
        }
        Integer top = null;
        if (searchOptions != null) {
            top = searchOptions.getTop();
        }
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        String facetsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(facets, CollectionFormat.MULTI);
        String highlightFieldsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(highlightFields, CollectionFormat.CSV);
        String orderByConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(orderBy, CollectionFormat.CSV);
        String scoringParametersConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(scoringParameters, CollectionFormat.MULTI);
        String searchFieldsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(searchFields, CollectionFormat.CSV);
        String selectConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(select, CollectionFormat.CSV);
        return service.searchGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchText, this.client.getApiVersion(), includeTotalResultCount, facetsConverted, filter, highlightFieldsConverted, highlightPostTag, highlightPreTag, minimumCoverage, orderByConverted, queryType, scoringParametersConverted, scoringProfile, searchFieldsConverted, searchMode, selectConverted, skip, top, clientRequestId, context);
    }

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSearchResult>> searchPostWithRestResponseAsync(SearchRequest searchRequest, Context context) {
        final UUID clientRequestId = null;
        return service.searchPost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchRequest, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSearchResult>> searchPostWithRestResponseAsync(SearchRequest searchRequest, SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        return service.searchPost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchRequest, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Document>> getWithRestResponseAsync(String key, Context context) {
        final UUID clientRequestId = null;
        String selectedFieldsConverted = null;
        return service.get(key, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), selectedFieldsConverted, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @param selectedFields List of field names to retrieve for the document; Any field not retrieved will be missing from the returned document.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Document>> getWithRestResponseAsync(String key, List<String> selectedFields, SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        String selectedFieldsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(selectedFields, CollectionFormat.CSV);
        return service.get(key, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), selectedFieldsConverted, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSuggestResult>> suggestGetWithRestResponseAsync(String searchText, String suggesterName, Context context) {
        final String filter = null;
        final Boolean useFuzzyMatching = null;
        final String highlightPostTag = null;
        final String highlightPreTag = null;
        final Double minimumCoverage = null;
        final Integer top = null;
        final UUID clientRequestId = null;
        String orderByConverted = null;
        String searchFieldsConverted = null;
        String selectConverted = null;
        return service.suggestGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchText, suggesterName, this.client.getApiVersion(), filter, useFuzzyMatching, highlightPostTag, highlightPreTag, minimumCoverage, orderByConverted, searchFieldsConverted, selectConverted, top, clientRequestId, context);
    }

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param suggestOptions Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSuggestResult>> suggestGetWithRestResponseAsync(String searchText, String suggesterName, SuggestOptions suggestOptions, SearchRequestOptions searchRequestOptions, Context context) {
        String filter = null;
        if (suggestOptions != null) {
            filter = suggestOptions.getFilter();
        }
        Boolean useFuzzyMatching = null;
        if (suggestOptions != null) {
            useFuzzyMatching = suggestOptions.isUseFuzzyMatching();
        }
        String highlightPostTag = null;
        if (suggestOptions != null) {
            highlightPostTag = suggestOptions.getHighlightPostTag();
        }
        String highlightPreTag = null;
        if (suggestOptions != null) {
            highlightPreTag = suggestOptions.getHighlightPreTag();
        }
        Double minimumCoverage = null;
        if (suggestOptions != null) {
            minimumCoverage = suggestOptions.getMinimumCoverage();
        }
        List<String> orderBy = null;
        if (suggestOptions != null) {
            orderBy = suggestOptions.getOrderBy();
        }
        List<String> searchFields = null;
        if (suggestOptions != null) {
            searchFields = suggestOptions.getSearchFields();
        }
        List<String> select = null;
        if (suggestOptions != null) {
            select = suggestOptions.getSelect();
        }
        Integer top = null;
        if (suggestOptions != null) {
            top = suggestOptions.getTop();
        }
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        String orderByConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(orderBy, CollectionFormat.CSV);
        String searchFieldsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(searchFields, CollectionFormat.CSV);
        String selectConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(select, CollectionFormat.CSV);
        return service.suggestGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), searchText, suggesterName, this.client.getApiVersion(), filter, useFuzzyMatching, highlightPostTag, highlightPreTag, minimumCoverage, orderByConverted, searchFieldsConverted, selectConverted, top, clientRequestId, context);
    }

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSuggestResult>> suggestPostWithRestResponseAsync(SuggestRequest suggestRequest, Context context) {
        final UUID clientRequestId = null;
        return service.suggestPost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), suggestRequest, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<DocumentSuggestResult>> suggestPostWithRestResponseAsync(SuggestRequest suggestRequest, SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        return service.suggestPost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), suggestRequest, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> Mono<SimpleResponse<DocumentIndexResult>> indexWithRestResponseAsync(IndexBatch<T> batch, Context context) {
        final UUID clientRequestId = null;
        return service.index(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), batch, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> Mono<SimpleResponse<DocumentIndexResult>> indexWithRestResponseAsync(IndexBatch<T> batch, SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        return service.index(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), batch, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AutocompleteResult>> autocompleteGetWithRestResponseAsync(String searchText, String suggesterName, Context context) {
        final UUID clientRequestId = null;
        final AutocompleteMode autocompleteMode = null;
        final String filter = null;
        final Boolean useFuzzyMatching = null;
        final String highlightPostTag = null;
        final String highlightPreTag = null;
        final Double minimumCoverage = null;
        final Integer top = null;
        String searchFieldsConverted = null;
        return service.autocompleteGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), searchText, suggesterName, clientRequestId, autocompleteMode, filter, useFuzzyMatching, highlightPostTag, highlightPreTag, minimumCoverage, searchFieldsConverted, top, context);
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param autocompleteOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AutocompleteResult>> autocompleteGetWithRestResponseAsync(String searchText, String suggesterName, SearchRequestOptions searchRequestOptions, AutocompleteOptions autocompleteOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        AutocompleteMode autocompleteMode = null;
        if (autocompleteOptions != null) {
            autocompleteMode = autocompleteOptions.getAutocompleteMode();
        }
        String filter = null;
        if (autocompleteOptions != null) {
            filter = autocompleteOptions.getFilter();
        }
        Boolean useFuzzyMatching = null;
        if (autocompleteOptions != null) {
            useFuzzyMatching = autocompleteOptions.isUseFuzzyMatching();
        }
        String highlightPostTag = null;
        if (autocompleteOptions != null) {
            highlightPostTag = autocompleteOptions.getHighlightPostTag();
        }
        String highlightPreTag = null;
        if (autocompleteOptions != null) {
            highlightPreTag = autocompleteOptions.getHighlightPreTag();
        }
        Double minimumCoverage = null;
        if (autocompleteOptions != null) {
            minimumCoverage = autocompleteOptions.getMinimumCoverage();
        }
        List<String> searchFields = null;
        if (autocompleteOptions != null) {
            searchFields = autocompleteOptions.getSearchFields();
        }
        Integer top = null;
        if (autocompleteOptions != null) {
            top = autocompleteOptions.getTop();
        }
        String searchFieldsConverted = JacksonAdapter.createDefaultSerializerAdapter().serializeList(searchFields, CollectionFormat.CSV);
        return service.autocompleteGet(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), searchText, suggesterName, clientRequestId, autocompleteMode, filter, useFuzzyMatching, highlightPostTag, highlightPreTag, minimumCoverage, searchFieldsConverted, top, context);
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AutocompleteResult>> autocompletePostWithRestResponseAsync(AutocompleteRequest autocompleteRequest, Context context) {
        final UUID clientRequestId = null;
        return service.autocompletePost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), autocompleteRequest, clientRequestId, context);
    }

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AutocompleteResult>> autocompletePostWithRestResponseAsync(AutocompleteRequest autocompleteRequest, SearchRequestOptions searchRequestOptions, Context context) {
        UUID clientRequestId = null;
        if (searchRequestOptions != null) {
            clientRequestId = searchRequestOptions.getClientRequestId();
        }
        return service.autocompletePost(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getIndexName(), this.client.getApiVersion(), autocompleteRequest, clientRequestId, context);
    }
}
