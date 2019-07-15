/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Connector read setting.
 */
public class StoreReadSettings {
    /**
     * Unmatched properties from the message are deserialized this collection.
     */
    @JsonProperty(value = "")
    private Map<String, Object> additionalProperties;

    /**
     * The read setting type.
     */
    @JsonProperty(value = "type", required = true)
    private String type;

    /**
     * The maximum concurrent connection count for the source data store. Type:
     * integer (or Expression with resultType integer).
     */
    @JsonProperty(value = "maxConcurrentConnections")
    private Object maxConcurrentConnections;

    /**
     * Get unmatched properties from the message are deserialized this collection.
     *
     * @return the additionalProperties value
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set unmatched properties from the message are deserialized this collection.
     *
     * @param additionalProperties the additionalProperties value to set
     * @return the StoreReadSettings object itself.
     */
    public StoreReadSettings withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get the read setting type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the read setting type.
     *
     * @param type the type value to set
     * @return the StoreReadSettings object itself.
     */
    public StoreReadSettings withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the maximum concurrent connection count for the source data store. Type: integer (or Expression with resultType integer).
     *
     * @return the maxConcurrentConnections value
     */
    public Object maxConcurrentConnections() {
        return this.maxConcurrentConnections;
    }

    /**
     * Set the maximum concurrent connection count for the source data store. Type: integer (or Expression with resultType integer).
     *
     * @param maxConcurrentConnections the maxConcurrentConnections value to set
     * @return the StoreReadSettings object itself.
     */
    public StoreReadSettings withMaxConcurrentConnections(Object maxConcurrentConnections) {
        this.maxConcurrentConnections = maxConcurrentConnections;
        return this;
    }

}