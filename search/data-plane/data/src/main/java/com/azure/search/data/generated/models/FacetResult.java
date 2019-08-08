// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.data.generated.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * A single bucket of a facet query result. Reports the number of documents
 * with a field value falling within a particular range or having a particular
 * value or interval.
 */
@Fluent
public final class FacetResult {
    /*
     * Unmatched properties from the message are deserialized this collection
     */
    @JsonProperty(value = "")
    private Map<String, Object> additionalProperties;

    /*
     * The approximate count of documents falling within the bucket described
     * by this facet.
     */
    @JsonProperty(value = "count", access = JsonProperty.Access.WRITE_ONLY)
    private Long count;

    /**
     * Get the additionalProperties property: Unmatched properties from the
     * message are deserialized this collection.
     *
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Unmatched properties from the
     * message are deserialized this collection.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the FacetResult object itself.
     */
    public FacetResult additionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get the count property: The approximate count of documents falling
     * within the bucket described by this facet.
     *
     * @return the count value.
     */
    public Long count() {
        return this.count;
    }
}