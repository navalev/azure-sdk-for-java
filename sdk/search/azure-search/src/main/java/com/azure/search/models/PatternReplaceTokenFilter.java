// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A character filter that replaces characters in the input string. It uses a
 * regular expression to identify character sequences to preserve and a
 * replacement pattern to identify characters to replace. For example, given
 * the input text "aa bb aa bb", pattern "(aa)\s+(bb)", and replacement
 * "$1#$2", the result would be "aa#bb aa#bb". This token filter is implemented
 * using Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Azure.Search.PatternReplaceTokenFilter")
@Fluent
public final class PatternReplaceTokenFilter extends TokenFilter {
    /*
     * A regular expression pattern.
     */
    @JsonProperty(value = "pattern", required = true)
    private String pattern;

    /*
     * The replacement text.
     */
    @JsonProperty(value = "replacement", required = true)
    private String replacement;

    /**
     * Get the pattern property: A regular expression pattern.
     *
     * @return the pattern value.
     */
    public String getPattern() {
        return this.pattern;
    }

    /**
     * Set the pattern property: A regular expression pattern.
     *
     * @param pattern the pattern value to set.
     * @return the PatternReplaceTokenFilter object itself.
     */
    public PatternReplaceTokenFilter setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    /**
     * Get the replacement property: The replacement text.
     *
     * @return the replacement value.
     */
    public String getReplacement() {
        return this.replacement;
    }

    /**
     * Set the replacement property: The replacement text.
     *
     * @param replacement the replacement value to set.
     * @return the PatternReplaceTokenFilter object itself.
     */
    public PatternReplaceTokenFilter setReplacement(String replacement) {
        this.replacement = replacement;
        return this;
    }
}
