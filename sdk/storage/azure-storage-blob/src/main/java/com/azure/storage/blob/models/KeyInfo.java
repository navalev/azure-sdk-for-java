// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Key information.
 */
@JacksonXmlRootElement(localName = "KeyInfo")
@Fluent
public final class KeyInfo {
    /*
     * The date-time the key is active in ISO 8601 UTC time
     */
    @JsonProperty(value = "Start", required = true)
    private String start;

    /*
     * The date-time the key expires in ISO 8601 UTC time
     */
    @JsonProperty(value = "Expiry", required = true)
    private String expiry;

    /**
     * Get the start property: The date-time the key is active in ISO 8601 UTC
     * time.
     *
     * @return the start value.
     */
    public String getStart() {
        return this.start;
    }

    /**
     * Set the start property: The date-time the key is active in ISO 8601 UTC
     * time.
     *
     * @param start the start value to set.
     * @return the KeyInfo object itself.
     */
    public KeyInfo setStart(String start) {
        this.start = start;
        return this;
    }

    /**
     * Get the expiry property: The date-time the key expires in ISO 8601 UTC
     * time.
     *
     * @return the expiry value.
     */
    public String getExpiry() {
        return this.expiry;
    }

    /**
     * Set the expiry property: The date-time the key expires in ISO 8601 UTC
     * time.
     *
     * @param expiry the expiry value to set.
     * @return the KeyInfo object itself.
     */
    public KeyInfo setExpiry(String expiry) {
        this.expiry = expiry;
        return this;
    }
}
