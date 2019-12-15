// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.search.implementation.models.AnalyzeResult;
import com.azure.search.models.AccessCondition;
import com.azure.search.models.AnalyzeRequest;
import com.azure.search.models.Index;
import com.azure.search.models.IndexGetStatisticsResult;
import com.azure.search.models.IndexListResult;
import com.azure.search.models.RequestOptions;
import java.util.UUID;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * Indexes.
 */
public final class IndexesImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private IndexesService service;

    /**
     * The service client containing this operation class.
     */
    private SearchServiceRestClientImpl client;

    /**
     * Initializes an instance of IndexesImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public IndexesImpl(SearchServiceRestClientImpl client) {
        this.service = RestProxy.create(IndexesService.class, client.getHttpPipeline());
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * SearchServiceRestClientIndexes to be used by the proxy service to
     * perform REST calls.
     */
    @Host("https://{searchServiceName}.{searchDnsSuffix}")
    @ServiceInterface(name = "SearchServiceRestClientIndexes")
    private interface IndexesService {
        @Post("indexes")
        @ExpectedResponses({201})
        Mono<SimpleResponse<Index>> create(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @BodyParam("application/json; charset=utf-8") Index index, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("indexes")
        @ExpectedResponses({200})
        Mono<SimpleResponse<IndexListResult>> list(@HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @QueryParam("$select") String select, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Put("indexes('{indexName}')")
        @ExpectedResponses({200, 201})
        Mono<SimpleResponse<Index>> createOrUpdate(@PathParam("indexName") String indexName, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @BodyParam("application/json; charset=utf-8") Index index, @QueryParam("allowIndexDowntime") Boolean allowIndexDowntime, @HeaderParam("Prefer") String prefer, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, @HeaderParam("If-Match") String ifMatch, @HeaderParam("If-None-Match") String ifNoneMatch, Context context);

        @Delete("indexes('{indexName}')")
        @ExpectedResponses({204, 404})
        Mono<SimpleResponse<Void>> delete(@PathParam("indexName") String indexName, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, @HeaderParam("If-Match") String ifMatch, @HeaderParam("If-None-Match") String ifNoneMatch, Context context);

        @Get("indexes('{indexName}')")
        @ExpectedResponses({200})
        Mono<SimpleResponse<Index>> get(@PathParam("indexName") String indexName, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Get("indexes('{indexName}')/search.stats")
        @ExpectedResponses({200})
        Mono<SimpleResponse<IndexGetStatisticsResult>> getStatistics(@PathParam("indexName") String indexName, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);

        @Post("indexes('{indexName}')/search.analyze")
        @ExpectedResponses({200})
        Mono<SimpleResponse<AnalyzeResult>> analyze(@PathParam("indexName") String indexName, @HostParam("searchServiceName") String searchServiceName, @HostParam("searchDnsSuffix") String searchDnsSuffix, @BodyParam("application/json; charset=utf-8") AnalyzeRequest request, @QueryParam("api-version") String apiVersion, @HeaderParam("client-request-id") UUID clientRequestId, Context context);
    }

    /**
     * Creates a new search index.
     *
     * @param index The definition of the index to create.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> createWithRestResponseAsync(Index index, Context context) {
        final UUID clientRequestId = null;
        return service.create(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), index, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Creates a new search index.
     *
     * @param index The definition of the index to create.
     * @param requestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> createWithRestResponseAsync(Index index, RequestOptions requestOptions, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        return service.create(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), index, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Lists all indexes available for a search service.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<IndexListResult>> listWithRestResponseAsync(Context context) {
        final String select = null;
        final UUID clientRequestId = null;
        return service.list(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), select, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Lists all indexes available for a search service.
     *
     * @param select Selects which top-level properties of the index definitions to retrieve. Specified as a comma-separated list of JSON property names, or '*' for all properties. The default is all properties.
     * @param requestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<IndexListResult>> listWithRestResponseAsync(String select, RequestOptions requestOptions, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        return service.list(this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), select, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Creates a new search index or updates an index if it already exists.
     *
     * @param indexName The definition of the index to create or update.
     * @param index The definition of the index to create or update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> createOrUpdateWithRestResponseAsync(String indexName, Index index, Context context) {
        final Boolean allowIndexDowntime = null;
        final String prefer = "return=representation";
        final UUID clientRequestId = null;
        final String ifMatch = null;
        final String ifNoneMatch = null;
        return service.createOrUpdate(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), index, allowIndexDowntime, prefer, this.client.getApiVersion(), clientRequestId, ifMatch, ifNoneMatch, context);
    }

    /**
     * Creates a new search index or updates an index if it already exists.
     *
     * @param indexName The definition of the index to create or update.
     * @param index The definition of the index to create or update.
     * @param allowIndexDowntime Allows new analyzers, tokenizers, token filters, or char filters to be added to an index by taking the index offline for at least a few seconds. This temporarily causes indexing and query requests to fail. Performance and write availability of the index can be impaired for several minutes after the index is updated, or longer for very large indexes.
     * @param requestOptions Additional parameters for the operation.
     * @param accessCondition Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> createOrUpdateWithRestResponseAsync(String indexName, Index index, Boolean allowIndexDowntime, RequestOptions requestOptions, AccessCondition accessCondition, Context context) {
        final String prefer = "return=representation";
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        String ifMatch = null;
        if (accessCondition != null) {
            ifMatch = accessCondition.getIfMatch();
        }
        String ifNoneMatch = null;
        if (accessCondition != null) {
            ifNoneMatch = accessCondition.getIfNoneMatch();
        }
        return service.createOrUpdate(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), index, allowIndexDowntime, prefer, this.client.getApiVersion(), clientRequestId, ifMatch, ifNoneMatch, context);
    }

    /**
     * Deletes a search index and all the documents it contains.
     *
     * @param indexName The name of the index to delete.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Void>> deleteWithRestResponseAsync(String indexName, Context context) {
        final UUID clientRequestId = null;
        final String ifMatch = null;
        final String ifNoneMatch = null;
        return service.delete(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, ifMatch, ifNoneMatch, context);
    }

    /**
     * Deletes a search index and all the documents it contains.
     *
     * @param indexName The name of the index to delete.
     * @param requestOptions Additional parameters for the operation.
     * @param accessCondition Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Void>> deleteWithRestResponseAsync(String indexName, RequestOptions requestOptions, AccessCondition accessCondition, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        String ifMatch = null;
        if (accessCondition != null) {
            ifMatch = accessCondition.getIfMatch();
        }
        String ifNoneMatch = null;
        if (accessCondition != null) {
            ifNoneMatch = accessCondition.getIfNoneMatch();
        }
        return service.delete(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, ifMatch, ifNoneMatch, context);
    }

    /**
     * Retrieves an index definition.
     *
     * @param indexName The name of the index to retrieve.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> getWithRestResponseAsync(String indexName, Context context) {
        final UUID clientRequestId = null;
        return service.get(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Retrieves an index definition.
     *
     * @param indexName The name of the index to retrieve.
     * @param requestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<Index>> getWithRestResponseAsync(String indexName, RequestOptions requestOptions, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        return service.get(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Returns statistics for the given index, including a document count and storage usage.
     *
     * @param indexName The name of the index for which to retrieve statistics.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<IndexGetStatisticsResult>> getStatisticsWithRestResponseAsync(String indexName, Context context) {
        final UUID clientRequestId = null;
        return service.getStatistics(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Returns statistics for the given index, including a document count and storage usage.
     *
     * @param indexName The name of the index for which to retrieve statistics.
     * @param requestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<IndexGetStatisticsResult>> getStatisticsWithRestResponseAsync(String indexName, RequestOptions requestOptions, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        return service.getStatistics(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Shows how an analyzer breaks text into tokens.
     *
     * @param indexName The name of the index for which to test an analyzer.
     * @param request The text and analyzer or analysis components to test.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AnalyzeResult>> analyzeWithRestResponseAsync(String indexName, AnalyzeRequest request, Context context) {
        final UUID clientRequestId = null;
        return service.analyze(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), request, this.client.getApiVersion(), clientRequestId, context);
    }

    /**
     * Shows how an analyzer breaks text into tokens.
     *
     * @param indexName The name of the index for which to test an analyzer.
     * @param request The text and analyzer or analysis components to test.
     * @param requestOptions Additional parameters for the operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<AnalyzeResult>> analyzeWithRestResponseAsync(String indexName, AnalyzeRequest request, RequestOptions requestOptions, Context context) {
        UUID clientRequestId = null;
        if (requestOptions != null) {
            clientRequestId = requestOptions.getClientRequestId();
        }
        return service.analyze(indexName, this.client.getSearchServiceName(), this.client.getSearchDnsSuffix(), request, this.client.getApiVersion(), clientRequestId, context);
    }
}
