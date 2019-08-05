/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation.DevTestLabsManager;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation.ApplicableScheduleInner;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation.ScheduleInner;
import java.util.Map;

/**
 * Type representing ApplicableSchedule.
 */
public interface ApplicableSchedule extends HasInner<ApplicableScheduleInner>, HasManager<DevTestLabsManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the labVmsShutdown value.
     */
    ScheduleInner labVmsShutdown();

    /**
     * @return the labVmsStartup value.
     */
    ScheduleInner labVmsStartup();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * @return the type value.
     */
    String type();

}
