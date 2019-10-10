// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional parameters for a set of operations.
 */
@Fluent
public final class AccessCondition {
    /*
     * Defines the If-Match condition. The operation will be performed only if
     * the ETag on the server matches this value.
     */
    @JsonProperty(value = "")
    private String ifMatch;

    /*
     * Defines the If-None-Match condition. The operation will be performed
     * only if the ETag on the server does not match this value.
     */
    @JsonProperty(value = "")
    private String ifNoneMatch;

    /**
     * Get the ifMatch property: Defines the If-Match condition. The operation
     * will be performed only if the ETag on the server matches this value.
     *
     * @return the ifMatch value.
     */
    public String ifMatch() {
        return this.ifMatch;
    }

    /**
     * Set the ifMatch property: Defines the If-Match condition. The operation
     * will be performed only if the ETag on the server matches this value.
     *
     * @param ifMatch the ifMatch value to set.
     * @return the AccessCondition object itself.
     */
    public AccessCondition ifMatch(String ifMatch) {
        this.ifMatch = ifMatch;
        return this;
    }

    /**
     * Get the ifNoneMatch property: Defines the If-None-Match condition. The
     * operation will be performed only if the ETag on the server does not
     * match this value.
     *
     * @return the ifNoneMatch value.
     */
    public String ifNoneMatch() {
        return this.ifNoneMatch;
    }

    /**
     * Set the ifNoneMatch property: Defines the If-None-Match condition. The
     * operation will be performed only if the ETag on the server does not
     * match this value.
     *
     * @param ifNoneMatch the ifNoneMatch value to set.
     * @return the AccessCondition object itself.
     */
    public AccessCondition ifNoneMatch(String ifNoneMatch) {
        this.ifNoneMatch = ifNoneMatch;
        return this;
    }
}
