/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import com.microsoft.azure.management.devtestlabs.v2018_09_15.Secret;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.SecretFragment;
import java.util.Map;
import rx.functions.Func1;

class SecretImpl extends CreatableUpdatableImpl<Secret, SecretInner, SecretImpl> implements Secret, Secret.Definition, Secret.Update {
    private final DevTestLabsManager manager;
    private String resourceGroupName;
    private String labName;
    private String userName;
    private String name;
    private SecretFragment updateParameter;

    SecretImpl(String name, DevTestLabsManager manager) {
        super(name, new SecretInner());
        this.manager = manager;
        // Set resource name
        this.name = name;
        //
        this.updateParameter = new SecretFragment();
    }

    SecretImpl(SecretInner inner, DevTestLabsManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.name = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.labName = IdParsingUtils.getValueFromIdByName(inner.id(), "labs");
        this.userName = IdParsingUtils.getValueFromIdByName(inner.id(), "users");
        this.name = IdParsingUtils.getValueFromIdByName(inner.id(), "secrets");
        //
        this.updateParameter = new SecretFragment();
    }

    @Override
    public DevTestLabsManager manager() {
        return this.manager;
    }

    @Override
    public Observable<Secret> createResourceAsync() {
        SecretsInner client = this.manager().inner().secrets();
        return client.createOrUpdateAsync(this.resourceGroupName, this.labName, this.userName, this.name, this.inner())
            .map(new Func1<SecretInner, SecretInner>() {
               @Override
               public SecretInner call(SecretInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Secret> updateResourceAsync() {
        SecretsInner client = this.manager().inner().secrets();
        return client.updateAsync(this.resourceGroupName, this.labName, this.userName, this.name, this.updateParameter)
            .map(new Func1<SecretInner, SecretInner>() {
               @Override
               public SecretInner call(SecretInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SecretInner> getInnerAsync() {
        SecretsInner client = this.manager().inner().secrets();
        return client.getAsync(this.resourceGroupName, this.labName, this.userName, this.name);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.updateParameter = new SecretFragment();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public String uniqueIdentifier() {
        return this.inner().uniqueIdentifier();
    }

    @Override
    public String value() {
        return this.inner().value();
    }

    @Override
    public SecretImpl withExistingUser(String resourceGroupName, String labName, String userName) {
        this.resourceGroupName = resourceGroupName;
        this.labName = labName;
        this.userName = userName;
        return this;
    }

    @Override
    public SecretImpl withLocation(String location) {
        this.inner().withLocation(location);
        return this;
    }

    @Override
    public SecretImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.inner().withTags(tags);
        } else {
            this.updateParameter.withTags(tags);
        }
        return this;
    }

    @Override
    public SecretImpl withValue(String value) {
        if (isInCreateMode()) {
            this.inner().withValue(value);
        } else {
            this.updateParameter.withValue(value);
        }
        return this;
    }

}
