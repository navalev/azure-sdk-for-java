// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A filter that stems words using a Snowball-generated stemmer. This token
 * filter is implemented using Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata.type")
@JsonTypeName("#Microsoft.Azure.Search.SnowballTokenFilter")
@Fluent
public final class SnowballTokenFilter extends TokenFilter {
    /*
     * The language to use. Possible values include: 'armenian', 'basque',
     * 'catalan', 'danish', 'dutch', 'english', 'finnish', 'french', 'german',
     * 'german2', 'hungarian', 'italian', 'kp', 'lovins', 'norwegian',
     * 'porter', 'portuguese', 'romanian', 'russian', 'spanish', 'swedish',
     * 'turkish'
     */
    @JsonProperty(value = "language", required = true)
    private SnowballTokenFilterLanguage language;

    /**
     * Get the language property: The language to use. Possible values include:
     * 'armenian', 'basque', 'catalan', 'danish', 'dutch', 'english',
     * 'finnish', 'french', 'german', 'german2', 'hungarian', 'italian', 'kp',
     * 'lovins', 'norwegian', 'porter', 'portuguese', 'romanian', 'russian',
     * 'spanish', 'swedish', 'turkish'.
     *
     * @return the language value.
     */
    public SnowballTokenFilterLanguage language() {
        return this.language;
    }

    /**
     * Set the language property: The language to use. Possible values include:
     * 'armenian', 'basque', 'catalan', 'danish', 'dutch', 'english',
     * 'finnish', 'french', 'german', 'german2', 'hungarian', 'italian', 'kp',
     * 'lovins', 'norwegian', 'porter', 'portuguese', 'romanian', 'russian',
     * 'spanish', 'swedish', 'turkish'.
     *
     * @param language the language value to set.
     * @return the SnowballTokenFilter object itself.
     */
    public SnowballTokenFilter language(SnowballTokenFilterLanguage language) {
        this.language = language;
        return this;
    }
}
