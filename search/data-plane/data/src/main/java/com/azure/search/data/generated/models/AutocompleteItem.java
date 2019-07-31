// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.data.generated.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The result of Autocomplete requests.
 */
@Fluent
public final class AutocompleteItem {
    /*
     * The completed term.
     */
    @JsonProperty(value = "text", access = JsonProperty.Access.WRITE_ONLY)
    private String text;

    /*
     * The query along with the completed term.
     */
    @JsonProperty(value = "queryPlusText", access = JsonProperty.Access.WRITE_ONLY)
    private String queryPlusText;

    /**
     * Get the text property: The completed term.
     *
     * @return the text value.
     */
    public String text() {
        return this.text;
    }

    /**
     * Get the queryPlusText property: The query along with the completed term.
     *
     * @return the queryPlusText value.
     */
    public String queryPlusText() {
        return this.queryPlusText;
    }
}
