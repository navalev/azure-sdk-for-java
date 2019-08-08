/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Tokenizer for path-like hierarchies. This tokenizer is implemented using
 * Apache Lucene.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Azure.Search.PathHierarchyTokenizerV2")
public class PathHierarchyTokenizerV2 extends Tokenizer {
    /**
     * The delimiter character to use. Default is "/".
     */
    @JsonProperty(value = "delimiter")
    private String delimiter;

    /**
     * A value that, if set, replaces the delimiter character. Default is "/".
     */
    @JsonProperty(value = "replacement")
    private String replacement;

    /**
     * The maximum token length. Default and maximum is 300.
     */
    @JsonProperty(value = "maxTokenLength")
    private Integer maxTokenLength;

    /**
     * A value indicating whether to generate tokens in reverse order. Default
     * is false.
     */
    @JsonProperty(value = "reverse")
    private Boolean reverseTokenOrder;

    /**
     * The number of initial tokens to skip. Default is 0.
     */
    @JsonProperty(value = "skip")
    private Integer numberOfTokensToSkip;

    /**
     * Get the delimiter character to use. Default is "/".
     *
     * @return the delimiter value
     */
    public String delimiter() {
        return this.delimiter;
    }

    /**
     * Set the delimiter character to use. Default is "/".
     *
     * @param delimiter the delimiter value to set
     * @return the PathHierarchyTokenizerV2 object itself.
     */
    public PathHierarchyTokenizerV2 withDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    /**
     * Get a value that, if set, replaces the delimiter character. Default is "/".
     *
     * @return the replacement value
     */
    public String replacement() {
        return this.replacement;
    }

    /**
     * Set a value that, if set, replaces the delimiter character. Default is "/".
     *
     * @param replacement the replacement value to set
     * @return the PathHierarchyTokenizerV2 object itself.
     */
    public PathHierarchyTokenizerV2 withReplacement(String replacement) {
        this.replacement = replacement;
        return this;
    }

    /**
     * Get the maximum token length. Default and maximum is 300.
     *
     * @return the maxTokenLength value
     */
    public Integer maxTokenLength() {
        return this.maxTokenLength;
    }

    /**
     * Set the maximum token length. Default and maximum is 300.
     *
     * @param maxTokenLength the maxTokenLength value to set
     * @return the PathHierarchyTokenizerV2 object itself.
     */
    public PathHierarchyTokenizerV2 withMaxTokenLength(Integer maxTokenLength) {
        this.maxTokenLength = maxTokenLength;
        return this;
    }

    /**
     * Get a value indicating whether to generate tokens in reverse order. Default is false.
     *
     * @return the reverseTokenOrder value
     */
    public Boolean reverseTokenOrder() {
        return this.reverseTokenOrder;
    }

    /**
     * Set a value indicating whether to generate tokens in reverse order. Default is false.
     *
     * @param reverseTokenOrder the reverseTokenOrder value to set
     * @return the PathHierarchyTokenizerV2 object itself.
     */
    public PathHierarchyTokenizerV2 withReverseTokenOrder(Boolean reverseTokenOrder) {
        this.reverseTokenOrder = reverseTokenOrder;
        return this;
    }

    /**
     * Get the number of initial tokens to skip. Default is 0.
     *
     * @return the numberOfTokensToSkip value
     */
    public Integer numberOfTokensToSkip() {
        return this.numberOfTokensToSkip;
    }

    /**
     * Set the number of initial tokens to skip. Default is 0.
     *
     * @param numberOfTokensToSkip the numberOfTokensToSkip value to set
     * @return the PathHierarchyTokenizerV2 object itself.
     */
    public PathHierarchyTokenizerV2 withNumberOfTokensToSkip(Integer numberOfTokensToSkip) {
        this.numberOfTokensToSkip = numberOfTokensToSkip;
        return this;
    }

}