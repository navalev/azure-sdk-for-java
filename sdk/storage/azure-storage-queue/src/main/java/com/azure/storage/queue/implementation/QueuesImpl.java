// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.queue.implementation;

import com.azure.core.implementation.RestProxy;
import com.azure.core.implementation.annotation.BodyParam;
import com.azure.core.implementation.annotation.Delete;
import com.azure.core.implementation.annotation.ExpectedResponses;
import com.azure.core.implementation.annotation.Get;
import com.azure.core.implementation.annotation.HeaderParam;
import com.azure.core.implementation.annotation.Host;
import com.azure.core.implementation.annotation.HostParam;
import com.azure.core.implementation.annotation.PathParam;
import com.azure.core.implementation.annotation.Put;
import com.azure.core.implementation.annotation.QueryParam;
import com.azure.core.implementation.annotation.ReturnType;
import com.azure.core.implementation.annotation.ServiceInterface;
import com.azure.core.implementation.annotation.ServiceMethod;
import com.azure.core.implementation.annotation.UnexpectedResponseExceptionType;
import com.azure.core.util.Context;
import com.azure.storage.queue.models.QueuesCreateResponse;
import com.azure.storage.queue.models.QueuesDeleteResponse;
import com.azure.storage.queue.models.QueuesGetAccessPolicyResponse;
import com.azure.storage.queue.models.QueuesGetPropertiesResponse;
import com.azure.storage.queue.models.QueuesSetAccessPolicyResponse;
import com.azure.storage.queue.models.QueuesSetMetadataResponse;
import com.azure.storage.queue.models.SignedIdentifier;
import com.azure.storage.queue.models.StorageErrorException;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * Queues.
 */
public final class QueuesImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private QueuesService service;

    /**
     * The service client containing this operation class.
     */
    private AzureQueueStorageImpl client;

    /**
     * Initializes an instance of QueuesImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    public QueuesImpl(AzureQueueStorageImpl client) {
        this.service = RestProxy.create(QueuesService.class, client.getHttpPipeline());
        this.client = client;
    }

    /**
     * The interface defining all the services for AzureQueueStorageQueues to
     * be used by the proxy service to perform REST calls.
     */
    @Host("{url}")
    @ServiceInterface(name = "AzureQueueStorageQueues")
    private interface QueuesService {
        @Put("{queueName}")
        @ExpectedResponses({201, 204})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesCreateResponse> create(@PathParam("queueName") String queueName, @HostParam("url") String url, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-meta-") Map<String, String> metadata, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, Context context);

        @Delete("{queueName}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesDeleteResponse> delete(@PathParam("queueName") String queueName, @HostParam("url") String url, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, Context context);

        @Get("{queueName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesGetPropertiesResponse> getProperties(@PathParam("queueName") String queueName, @HostParam("url") String url, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, @QueryParam("comp") String comp, Context context);

        @Put("{queueName}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesSetMetadataResponse> setMetadata(@PathParam("queueName") String queueName, @HostParam("url") String url, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-meta-") Map<String, String> metadata, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, @QueryParam("comp") String comp, Context context);

        @Get("{queueName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesGetAccessPolicyResponse> getAccessPolicy(@PathParam("queueName") String queueName, @HostParam("url") String url, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, @QueryParam("comp") String comp, Context context);

        @Put("{queueName}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(StorageErrorException.class)
        Mono<QueuesSetAccessPolicyResponse> setAccessPolicy(@PathParam("queueName") String queueName, @HostParam("url") String url, @BodyParam("application/xml; charset=utf-8") SignedIdentifiersWrapper queueAcl, @QueryParam("timeout") Integer timeout, @HeaderParam("x-ms-version") String version, @HeaderParam("x-ms-client-request-id") String requestId, @QueryParam("comp") String comp, Context context);
    }

    /**
     * creates a new queue under the given account.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesCreateResponse> createWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final Map<String, String> metadata = null;
        final String requestId = null;
        return service.create(queueName, this.client.getUrl(), timeout, metadata, this.client.getVersion(), requestId, context);
    }

    /**
     * creates a new queue under the given account.
     *
     * @param queueName The queue name.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param metadata Optional. Include this parameter to specify that the queue's metadata be returned as part of the response body. Note that metadata requested with this parameter must be stored in accordance with the naming restrictions imposed by the 2009-09-19 version of the Queue service. Beginning with this version, all metadata names must adhere to the naming conventions for C# identifiers.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesCreateResponse> createWithRestResponseAsync(String queueName, Integer timeout, Map<String, String> metadata, String requestId, Context context) {
        return service.create(queueName, this.client.getUrl(), timeout, metadata, this.client.getVersion(), requestId, context);
    }

    /**
     * operation permanently deletes the specified queue.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesDeleteResponse> deleteWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final String requestId = null;
        return service.delete(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, context);
    }

    /**
     * operation permanently deletes the specified queue.
     *
     * @param queueName The queue name.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesDeleteResponse> deleteWithRestResponseAsync(String queueName, Integer timeout, String requestId, Context context) {
        return service.delete(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, context);
    }

    /**
     * Retrieves user-defined metadata and queue properties on the specified queue. Metadata is associated with the queue as name-values pairs.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesGetPropertiesResponse> getPropertiesWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final String requestId = null;
        final String comp = "metadata";
        return service.getProperties(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * Retrieves user-defined metadata and queue properties on the specified queue. Metadata is associated with the queue as name-values pairs.
     *
     * @param queueName The queue name.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesGetPropertiesResponse> getPropertiesWithRestResponseAsync(String queueName, Integer timeout, String requestId, Context context) {
        final String comp = "metadata";
        return service.getProperties(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * sets user-defined metadata on the specified queue. Metadata is associated with the queue as name-value pairs.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesSetMetadataResponse> setMetadataWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final Map<String, String> metadata = null;
        final String requestId = null;
        final String comp = "metadata";
        return service.setMetadata(queueName, this.client.getUrl(), timeout, metadata, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * sets user-defined metadata on the specified queue. Metadata is associated with the queue as name-value pairs.
     *
     * @param queueName The queue name.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param metadata Optional. Include this parameter to specify that the queue's metadata be returned as part of the response body. Note that metadata requested with this parameter must be stored in accordance with the naming restrictions imposed by the 2009-09-19 version of the Queue service. Beginning with this version, all metadata names must adhere to the naming conventions for C# identifiers.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesSetMetadataResponse> setMetadataWithRestResponseAsync(String queueName, Integer timeout, Map<String, String> metadata, String requestId, Context context) {
        final String comp = "metadata";
        return service.setMetadata(queueName, this.client.getUrl(), timeout, metadata, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * returns details about any stored access policies specified on the queue that may be used with Shared Access Signatures.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesGetAccessPolicyResponse> getAccessPolicyWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final String requestId = null;
        final String comp = "acl";
        return service.getAccessPolicy(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * returns details about any stored access policies specified on the queue that may be used with Shared Access Signatures.
     *
     * @param queueName The queue name.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesGetAccessPolicyResponse> getAccessPolicyWithRestResponseAsync(String queueName, Integer timeout, String requestId, Context context) {
        final String comp = "acl";
        return service.getAccessPolicy(queueName, this.client.getUrl(), timeout, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * sets stored access policies for the queue that may be used with Shared Access Signatures.
     *
     * @param queueName The queue name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesSetAccessPolicyResponse> setAccessPolicyWithRestResponseAsync(String queueName, Context context) {
        final Integer timeout = null;
        final String requestId = null;
        final String comp = "acl";
        SignedIdentifiersWrapper queueAclConverted = new SignedIdentifiersWrapper(null);
        return service.setAccessPolicy(queueName, this.client.getUrl(), queueAclConverted, timeout, this.client.getVersion(), requestId, comp, context);
    }

    /**
     * sets stored access policies for the queue that may be used with Shared Access Signatures.
     *
     * @param queueName The queue name.
     * @param queueAcl the acls for the queue.
     * @param timeout The The timeout parameter is expressed in seconds. For more information, see &lt;a href="https://docs.microsoft.com/en-us/rest/api/storageservices/setting-timeouts-for-queue-service-operations&gt;Setting Timeouts for Queue Service Operations.&lt;/a&gt;.
     * @param requestId Provides a client-generated, opaque value with a 1 KB character limit that is recorded in the analytics logs when storage analytics logging is enabled.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<QueuesSetAccessPolicyResponse> setAccessPolicyWithRestResponseAsync(String queueName, List<SignedIdentifier> queueAcl, Integer timeout, String requestId, Context context) {
        final String comp = "acl";
        SignedIdentifiersWrapper queueAclConverted = new SignedIdentifiersWrapper(queueAcl);
        return service.setAccessPolicy(queueName, this.client.getUrl(), queueAclConverted, timeout, this.client.getVersion(), requestId, comp, context);
    }
}
