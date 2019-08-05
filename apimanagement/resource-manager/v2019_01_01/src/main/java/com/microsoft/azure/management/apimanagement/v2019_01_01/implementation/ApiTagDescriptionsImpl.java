/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.apimanagement.v2019_01_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.apimanagement.v2019_01_01.ApiTagDescriptions;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.apimanagement.v2019_01_01.TagDescriptionContract;

class ApiTagDescriptionsImpl extends WrapperImpl<ApiTagDescriptionsInner> implements ApiTagDescriptions {
    private final ApiManagementManager manager;

    ApiTagDescriptionsImpl(ApiManagementManager manager) {
        super(manager.inner().apiTagDescriptions());
        this.manager = manager;
    }

    public ApiManagementManager manager() {
        return this.manager;
    }

    @Override
    public TagDescriptionContractImpl define(String name) {
        return wrapModel(name);
    }

    private TagDescriptionContractImpl wrapModel(TagDescriptionContractInner inner) {
        return  new TagDescriptionContractImpl(inner, manager());
    }

    private TagDescriptionContractImpl wrapModel(String name) {
        return new TagDescriptionContractImpl(name, this.manager());
    }

    @Override
    public Completable getEntityTagAsync(String resourceGroupName, String serviceName, String apiId, String tagId) {
        ApiTagDescriptionsInner client = this.inner();
        return client.getEntityTagAsync(resourceGroupName, serviceName, apiId, tagId).toCompletable();
    }

    @Override
    public Observable<TagDescriptionContract> listByServiceAsync(final String resourceGroupName, final String serviceName, final String apiId) {
        ApiTagDescriptionsInner client = this.inner();
        return client.listByServiceAsync(resourceGroupName, serviceName, apiId)
        .flatMapIterable(new Func1<Page<TagDescriptionContractInner>, Iterable<TagDescriptionContractInner>>() {
            @Override
            public Iterable<TagDescriptionContractInner> call(Page<TagDescriptionContractInner> page) {
                return page.items();
            }
        })
        .map(new Func1<TagDescriptionContractInner, TagDescriptionContract>() {
            @Override
            public TagDescriptionContract call(TagDescriptionContractInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<TagDescriptionContract> getAsync(String resourceGroupName, String serviceName, String apiId, String tagId) {
        ApiTagDescriptionsInner client = this.inner();
        return client.getAsync(resourceGroupName, serviceName, apiId, tagId)
        .flatMap(new Func1<TagDescriptionContractInner, Observable<TagDescriptionContract>>() {
            @Override
            public Observable<TagDescriptionContract> call(TagDescriptionContractInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((TagDescriptionContract)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serviceName, String apiId, String tagId, String ifMatch) {
        ApiTagDescriptionsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serviceName, apiId, tagId, ifMatch).toCompletable();
    }

}
