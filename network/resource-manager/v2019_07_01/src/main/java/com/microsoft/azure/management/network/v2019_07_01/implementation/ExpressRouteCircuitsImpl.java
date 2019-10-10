/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.network.v2019_07_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuits;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuit;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuitsArpTableListResult;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuitsRoutesTableListResult;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuitsRoutesTableSummaryListResult;
import com.microsoft.azure.management.network.v2019_07_01.ExpressRouteCircuitStats;

class ExpressRouteCircuitsImpl extends GroupableResourcesCoreImpl<ExpressRouteCircuit, ExpressRouteCircuitImpl, ExpressRouteCircuitInner, ExpressRouteCircuitsInner, NetworkManager>  implements ExpressRouteCircuits {
    protected ExpressRouteCircuitsImpl(NetworkManager manager) {
        super(manager.inner().expressRouteCircuits(), manager);
    }

    @Override
    protected Observable<ExpressRouteCircuitInner> getInnerAsync(String resourceGroupName, String name) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<ExpressRouteCircuit> listByResourceGroup(String resourceGroupName) {
        ExpressRouteCircuitsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<ExpressRouteCircuit> listByResourceGroupAsync(String resourceGroupName) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<ExpressRouteCircuitInner>, Iterable<ExpressRouteCircuitInner>>() {
            @Override
            public Iterable<ExpressRouteCircuitInner> call(Page<ExpressRouteCircuitInner> page) {
                return page.items();
            }
        })
        .map(new Func1<ExpressRouteCircuitInner, ExpressRouteCircuit>() {
            @Override
            public ExpressRouteCircuit call(ExpressRouteCircuitInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<ExpressRouteCircuit> list() {
        ExpressRouteCircuitsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<ExpressRouteCircuit> listAsync() {
        ExpressRouteCircuitsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<ExpressRouteCircuitInner>, Iterable<ExpressRouteCircuitInner>>() {
            @Override
            public Iterable<ExpressRouteCircuitInner> call(Page<ExpressRouteCircuitInner> page) {
                return page.items();
            }
        })
        .map(new Func1<ExpressRouteCircuitInner, ExpressRouteCircuit>() {
            @Override
            public ExpressRouteCircuit call(ExpressRouteCircuitInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public ExpressRouteCircuitImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected ExpressRouteCircuitImpl wrapModel(ExpressRouteCircuitInner inner) {
        return  new ExpressRouteCircuitImpl(inner.name(), inner, manager());
    }

    @Override
    protected ExpressRouteCircuitImpl wrapModel(String name) {
        return new ExpressRouteCircuitImpl(name, new ExpressRouteCircuitInner(), this.manager());
    }

    @Override
    public Observable<ExpressRouteCircuitsArpTableListResult> listArpTableAsync(String resourceGroupName, String circuitName, String peeringName, String devicePath) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.listArpTableAsync(resourceGroupName, circuitName, peeringName, devicePath)
        .map(new Func1<ExpressRouteCircuitsArpTableListResultInner, ExpressRouteCircuitsArpTableListResult>() {
            @Override
            public ExpressRouteCircuitsArpTableListResult call(ExpressRouteCircuitsArpTableListResultInner inner) {
                return new ExpressRouteCircuitsArpTableListResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ExpressRouteCircuitsRoutesTableListResult> listRoutesTableAsync(String resourceGroupName, String circuitName, String peeringName, String devicePath) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.listRoutesTableAsync(resourceGroupName, circuitName, peeringName, devicePath)
        .map(new Func1<ExpressRouteCircuitsRoutesTableListResultInner, ExpressRouteCircuitsRoutesTableListResult>() {
            @Override
            public ExpressRouteCircuitsRoutesTableListResult call(ExpressRouteCircuitsRoutesTableListResultInner inner) {
                return new ExpressRouteCircuitsRoutesTableListResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ExpressRouteCircuitsRoutesTableSummaryListResult> listRoutesTableSummaryAsync(String resourceGroupName, String circuitName, String peeringName, String devicePath) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.listRoutesTableSummaryAsync(resourceGroupName, circuitName, peeringName, devicePath)
        .map(new Func1<ExpressRouteCircuitsRoutesTableSummaryListResultInner, ExpressRouteCircuitsRoutesTableSummaryListResult>() {
            @Override
            public ExpressRouteCircuitsRoutesTableSummaryListResult call(ExpressRouteCircuitsRoutesTableSummaryListResultInner inner) {
                return new ExpressRouteCircuitsRoutesTableSummaryListResultImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ExpressRouteCircuitStats> getStatsAsync(String resourceGroupName, String circuitName) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.getStatsAsync(resourceGroupName, circuitName)
        .map(new Func1<ExpressRouteCircuitStatsInner, ExpressRouteCircuitStats>() {
            @Override
            public ExpressRouteCircuitStats call(ExpressRouteCircuitStatsInner inner) {
                return new ExpressRouteCircuitStatsImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<ExpressRouteCircuitStats> getPeeringStatsAsync(String resourceGroupName, String circuitName, String peeringName) {
        ExpressRouteCircuitsInner client = this.inner();
        return client.getPeeringStatsAsync(resourceGroupName, circuitName, peeringName)
        .map(new Func1<ExpressRouteCircuitStatsInner, ExpressRouteCircuitStats>() {
            @Override
            public ExpressRouteCircuitStats call(ExpressRouteCircuitStatsInner inner) {
                return new ExpressRouteCircuitStatsImpl(inner, manager());
            }
        });
    }

}
