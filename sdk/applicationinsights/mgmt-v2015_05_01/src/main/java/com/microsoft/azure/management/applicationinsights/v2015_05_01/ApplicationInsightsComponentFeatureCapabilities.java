/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.applicationinsights.v2015_05_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.applicationinsights.v2015_05_01.implementation.InsightsManager;
import com.microsoft.azure.management.applicationinsights.v2015_05_01.implementation.ApplicationInsightsComponentFeatureCapabilitiesInner;

/**
 * Type representing ApplicationInsightsComponentFeatureCapabilities.
 */
public interface ApplicationInsightsComponentFeatureCapabilities extends HasInner<ApplicationInsightsComponentFeatureCapabilitiesInner>, HasManager<InsightsManager> {
    /**
     * @return the analyticsIntegration value.
     */
    Boolean analyticsIntegration();

    /**
     * @return the apiAccessLevel value.
     */
    String apiAccessLevel();

    /**
     * @return the applicationMap value.
     */
    Boolean applicationMap();

    /**
     * @return the burstThrottlePolicy value.
     */
    String burstThrottlePolicy();

    /**
     * @return the dailyCap value.
     */
    Double dailyCap();

    /**
     * @return the dailyCapResetTime value.
     */
    Double dailyCapResetTime();

    /**
     * @return the liveStreamMetrics value.
     */
    Boolean liveStreamMetrics();

    /**
     * @return the metadataClass value.
     */
    String metadataClass();

    /**
     * @return the multipleStepWebTest value.
     */
    Boolean multipleStepWebTest();

    /**
     * @return the openSchema value.
     */
    Boolean openSchema();

    /**
     * @return the powerBIIntegration value.
     */
    Boolean powerBIIntegration();

    /**
     * @return the proactiveDetection value.
     */
    Boolean proactiveDetection();

    /**
     * @return the supportExportData value.
     */
    Boolean supportExportData();

    /**
     * @return the throttleRate value.
     */
    Double throttleRate();

    /**
     * @return the trackingType value.
     */
    String trackingType();

    /**
     * @return the workItemIntegration value.
     */
    Boolean workItemIntegration();

}
