/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.appservice.v2018_02_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.appservice.v2018_02_01.DeletedWebApps;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.management.appservice.v2018_02_01.DeletedSite;
import com.microsoft.azure.Page;

class DeletedWebAppsImpl extends WrapperImpl<DeletedWebAppsInner> implements DeletedWebApps {
    private final CertificateRegistrationManager manager;

    DeletedWebAppsImpl(CertificateRegistrationManager manager) {
        super(manager.inner().deletedWebApps());
        this.manager = manager;
    }

    public CertificateRegistrationManager manager() {
        return this.manager;
    }

    private DeletedSiteImpl wrapDeletedSiteModel(DeletedSiteInner inner) {
        return  new DeletedSiteImpl(inner, manager());
    }

    private Observable<DeletedSiteInner> getDeletedSiteInnerUsingDeletedWebAppsInnerAsync(String id) {
        String location = IdParsingUtils.getValueFromIdByName(id, "locations");
        String deletedSiteId = IdParsingUtils.getValueFromIdByName(id, "deletedSites");
        DeletedWebAppsInner client = this.inner();
        return client.getDeletedWebAppByLocationAsync(location, deletedSiteId);
    }

    @Override
    public Observable<DeletedSite> getDeletedWebAppByLocationAsync(String location, String deletedSiteId) {
        DeletedWebAppsInner client = this.inner();
        return client.getDeletedWebAppByLocationAsync(location, deletedSiteId)
        .map(new Func1<DeletedSiteInner, DeletedSite>() {
            @Override
            public DeletedSite call(DeletedSiteInner inner) {
                return wrapDeletedSiteModel(inner);
            }
       });
    }

    @Override
    public Observable<DeletedSite> listByLocationAsync(final String location) {
        DeletedWebAppsInner client = this.inner();
        return client.listByLocationAsync(location)
        .flatMapIterable(new Func1<Page<DeletedSiteInner>, Iterable<DeletedSiteInner>>() {
            @Override
            public Iterable<DeletedSiteInner> call(Page<DeletedSiteInner> page) {
                return page.items();
            }
        })
        .map(new Func1<DeletedSiteInner, DeletedSite>() {
            @Override
            public DeletedSite call(DeletedSiteInner inner) {
                return wrapDeletedSiteModel(inner);
            }
        });
    }

    @Override
    public Observable<DeletedSite> listAsync() {
        DeletedWebAppsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<DeletedSiteInner>, Iterable<DeletedSiteInner>>() {
            @Override
            public Iterable<DeletedSiteInner> call(Page<DeletedSiteInner> page) {
                return page.items();
            }
        })
        .map(new Func1<DeletedSiteInner, DeletedSite>() {
            @Override
            public DeletedSite call(DeletedSiteInner inner) {
                return new DeletedSiteImpl(inner, manager());
            }
        });
    }

}