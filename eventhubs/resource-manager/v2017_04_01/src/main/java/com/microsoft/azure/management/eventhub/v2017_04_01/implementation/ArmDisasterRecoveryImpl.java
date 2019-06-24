/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventhub.v2017_04_01.implementation;

import com.microsoft.azure.management.eventhub.v2017_04_01.ArmDisasterRecovery;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.eventhub.v2017_04_01.ProvisioningStateDR;
import com.microsoft.azure.management.eventhub.v2017_04_01.RoleDisasterRecovery;

class ArmDisasterRecoveryImpl extends CreatableUpdatableImpl<ArmDisasterRecovery, ArmDisasterRecoveryInner, ArmDisasterRecoveryImpl> implements ArmDisasterRecovery, ArmDisasterRecovery.Definition, ArmDisasterRecovery.Update {
    private final EventHubManager manager;
    private String resourceGroupName;
    private String namespaceName;
    private String alias;

    ArmDisasterRecoveryImpl(String name, EventHubManager manager) {
        super(name, new ArmDisasterRecoveryInner());
        this.manager = manager;
        // Set resource name
        this.alias = name;
        //
    }

    ArmDisasterRecoveryImpl(ArmDisasterRecoveryInner inner, EventHubManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.alias = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.namespaceName = IdParsingUtils.getValueFromIdByName(inner.id(), "namespaces");
        this.alias = IdParsingUtils.getValueFromIdByName(inner.id(), "disasterRecoveryConfigs");
        //
    }

    @Override
    public EventHubManager manager() {
        return this.manager;
    }

    @Override
    public Observable<ArmDisasterRecovery> createResourceAsync() {
        DisasterRecoveryConfigsInner client = this.manager().inner().disasterRecoveryConfigs();
        return client.createOrUpdateAsync(this.resourceGroupName, this.namespaceName, this.alias, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<ArmDisasterRecovery> updateResourceAsync() {
        DisasterRecoveryConfigsInner client = this.manager().inner().disasterRecoveryConfigs();
        return client.createOrUpdateAsync(this.resourceGroupName, this.namespaceName, this.alias, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ArmDisasterRecoveryInner> getInnerAsync() {
        DisasterRecoveryConfigsInner client = this.manager().inner().disasterRecoveryConfigs();
        return client.getAsync(this.resourceGroupName, this.namespaceName, this.alias);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String alternateName() {
        return this.inner().alternateName();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String partnerNamespace() {
        return this.inner().partnerNamespace();
    }

    @Override
    public Long pendingReplicationOperationsCount() {
        return this.inner().pendingReplicationOperationsCount();
    }

    @Override
    public ProvisioningStateDR provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public RoleDisasterRecovery role() {
        return this.inner().role();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public ArmDisasterRecoveryImpl withExistingNamespace(String resourceGroupName, String namespaceName) {
        this.resourceGroupName = resourceGroupName;
        this.namespaceName = namespaceName;
        return this;
    }

    @Override
    public ArmDisasterRecoveryImpl withAlternateName(String alternateName) {
        this.inner().withAlternateName(alternateName);
        return this;
    }

    @Override
    public ArmDisasterRecoveryImpl withPartnerNamespace(String partnerNamespace) {
        this.inner().withPartnerNamespace(partnerNamespace);
        return this;
    }

}