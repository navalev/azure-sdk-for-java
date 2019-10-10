// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.azure.search.Document;
/**
 * A result containing a document found by a suggestion query, plus associated
 * metadata.
 */
@Fluent
public final class SuggestResult {
    /*
     * Unmatched properties from the message are deserialized this collection
     */
    @JsonProperty(value = "")
    private Document additionalProperties;

    /*
     * The text of the suggestion result.
     */
    @JsonProperty(value = "@search.text", access = JsonProperty.Access.WRITE_ONLY)
    private String text;

    /**
     * Get the additionalProperties property: Unmatched properties from the
     * message are deserialized this collection.
     *
     * @return the additionalProperties value.
     */
    public Document getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Unmatched properties from the
     * message are deserialized this collection.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the SuggestResult object itself.
     */
    public SuggestResult setAdditionalProperties(Document additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get the text property: The text of the suggestion result.
     *
     * @return the text value.
     */
    public String getText() {
        return this.text;
    }
}
