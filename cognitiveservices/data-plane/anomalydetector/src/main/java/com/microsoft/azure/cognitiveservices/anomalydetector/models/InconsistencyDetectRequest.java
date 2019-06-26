/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.anomalydetector.models;

import org.joda.time.DateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The InconsistencyDetectRequest model.
 */
public class InconsistencyDetectRequest {
    /**
     * Inconsistency detect timestamp.
     */
    @JsonProperty(value = "timestamp", required = true)
    private DateTime timestamp;

    /**
     * Parameter to be tuned to get inconsistency.
     */
    @JsonProperty(value = "epsilon")
    private Double epsilon;

    /**
     * IDs of time series need to be detected.
     */
    @JsonProperty(value = "timeSeriesIds", required = true)
    private List<String> timeSeriesIds;

    /**
     * Get inconsistency detect timestamp.
     *
     * @return the timestamp value
     */
    public DateTime timestamp() {
        return this.timestamp;
    }

    /**
     * Set inconsistency detect timestamp.
     *
     * @param timestamp the timestamp value to set
     * @return the InconsistencyDetectRequest object itself.
     */
    public InconsistencyDetectRequest withTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get parameter to be tuned to get inconsistency.
     *
     * @return the epsilon value
     */
    public Double epsilon() {
        return this.epsilon;
    }

    /**
     * Set parameter to be tuned to get inconsistency.
     *
     * @param epsilon the epsilon value to set
     * @return the InconsistencyDetectRequest object itself.
     */
    public InconsistencyDetectRequest withEpsilon(Double epsilon) {
        this.epsilon = epsilon;
        return this;
    }

    /**
     * Get iDs of time series need to be detected.
     *
     * @return the timeSeriesIds value
     */
    public List<String> timeSeriesIds() {
        return this.timeSeriesIds;
    }

    /**
     * Set iDs of time series need to be detected.
     *
     * @param timeSeriesIds the timeSeriesIds value to set
     * @return the InconsistencyDetectRequest object itself.
     */
    public InconsistencyDetectRequest withTimeSeriesIds(List<String> timeSeriesIds) {
        this.timeSeriesIds = timeSeriesIds;
        return this;
    }

}