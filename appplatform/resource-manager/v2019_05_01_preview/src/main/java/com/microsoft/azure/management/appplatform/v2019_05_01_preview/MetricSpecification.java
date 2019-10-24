/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2019_05_01_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifications of the Metrics for Azure Monitoring.
 */
public class MetricSpecification {
    /**
     * Name of the metric.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Localized friendly display name of the metric.
     */
    @JsonProperty(value = "displayName")
    private String displayName;

    /**
     * Localized friendly description of the metric.
     */
    @JsonProperty(value = "displayDescription")
    private String displayDescription;

    /**
     * Unit that makes sense for the metric.
     */
    @JsonProperty(value = "unit")
    private String unit;

    /**
     * Name of the metric category that the metric belongs to. A metric can
     * only belong to a single category.
     */
    @JsonProperty(value = "category")
    private String category;

    /**
     * Only provide one value for this field. Valid values: Average, Minimum,
     * Maximum, Total, Count.
     */
    @JsonProperty(value = "aggregationType")
    private String aggregationType;

    /**
     * Supported aggregation types.
     */
    @JsonProperty(value = "supportedAggregationTypes")
    private List<String> supportedAggregationTypes;

    /**
     * Supported time grain types.
     */
    @JsonProperty(value = "supportedTimeGrainTypes")
    private List<String> supportedTimeGrainTypes;

    /**
     * Optional. If set to true, then zero will be returned for time duration
     * where no metric is emitted/published.
     */
    @JsonProperty(value = "fillGapWithZero")
    private Boolean fillGapWithZero;

    /**
     * Dimensions of the metric.
     */
    @JsonProperty(value = "dimensions")
    private List<MetricDimension> dimensions;

    /**
     * Get name of the metric.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the metric.
     *
     * @param name the name value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get localized friendly display name of the metric.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set localized friendly display name of the metric.
     *
     * @param displayName the displayName value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get localized friendly description of the metric.
     *
     * @return the displayDescription value
     */
    public String displayDescription() {
        return this.displayDescription;
    }

    /**
     * Set localized friendly description of the metric.
     *
     * @param displayDescription the displayDescription value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withDisplayDescription(String displayDescription) {
        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * Get unit that makes sense for the metric.
     *
     * @return the unit value
     */
    public String unit() {
        return this.unit;
    }

    /**
     * Set unit that makes sense for the metric.
     *
     * @param unit the unit value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get name of the metric category that the metric belongs to. A metric can only belong to a single category.
     *
     * @return the category value
     */
    public String category() {
        return this.category;
    }

    /**
     * Set name of the metric category that the metric belongs to. A metric can only belong to a single category.
     *
     * @param category the category value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get only provide one value for this field. Valid values: Average, Minimum, Maximum, Total, Count.
     *
     * @return the aggregationType value
     */
    public String aggregationType() {
        return this.aggregationType;
    }

    /**
     * Set only provide one value for this field. Valid values: Average, Minimum, Maximum, Total, Count.
     *
     * @param aggregationType the aggregationType value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
        return this;
    }

    /**
     * Get supported aggregation types.
     *
     * @return the supportedAggregationTypes value
     */
    public List<String> supportedAggregationTypes() {
        return this.supportedAggregationTypes;
    }

    /**
     * Set supported aggregation types.
     *
     * @param supportedAggregationTypes the supportedAggregationTypes value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withSupportedAggregationTypes(List<String> supportedAggregationTypes) {
        this.supportedAggregationTypes = supportedAggregationTypes;
        return this;
    }

    /**
     * Get supported time grain types.
     *
     * @return the supportedTimeGrainTypes value
     */
    public List<String> supportedTimeGrainTypes() {
        return this.supportedTimeGrainTypes;
    }

    /**
     * Set supported time grain types.
     *
     * @param supportedTimeGrainTypes the supportedTimeGrainTypes value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withSupportedTimeGrainTypes(List<String> supportedTimeGrainTypes) {
        this.supportedTimeGrainTypes = supportedTimeGrainTypes;
        return this;
    }

    /**
     * Get optional. If set to true, then zero will be returned for time duration where no metric is emitted/published.
     *
     * @return the fillGapWithZero value
     */
    public Boolean fillGapWithZero() {
        return this.fillGapWithZero;
    }

    /**
     * Set optional. If set to true, then zero will be returned for time duration where no metric is emitted/published.
     *
     * @param fillGapWithZero the fillGapWithZero value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withFillGapWithZero(Boolean fillGapWithZero) {
        this.fillGapWithZero = fillGapWithZero;
        return this;
    }

    /**
     * Get dimensions of the metric.
     *
     * @return the dimensions value
     */
    public List<MetricDimension> dimensions() {
        return this.dimensions;
    }

    /**
     * Set dimensions of the metric.
     *
     * @param dimensions the dimensions value to set
     * @return the MetricSpecification object itself.
     */
    public MetricSpecification withDimensions(List<MetricDimension> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

}
