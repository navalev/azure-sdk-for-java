/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.v2019_06_01_preview;

import rx.Observable;
import rx.Completable;
import com.microsoft.azure.management.containerregistry.v2019_06_01_preview.implementation.RunsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Runs.
 */
public interface Runs extends HasInner<RunsInner> {
    /**
     * Gets a link to download the run logs.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param runId The run ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<RunGetLogResult> getLogSasUrlAsync(String resourceGroupName, String registryName, String runId);

    /**
     * Cancel an existing run.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param runId The run ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable cancelAsync(String resourceGroupName, String registryName, String runId);

    /**
     * Gets the detailed information for a given run.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @param runId The run ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Run> getAsync(String resourceGroupName, String registryName, String runId);

    /**
     * Gets all the runs for a registry.
     *
     * @param resourceGroupName The name of the resource group to which the container registry belongs.
     * @param registryName The name of the container registry.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<Run> listAsync(final String resourceGroupName, final String registryName);

}
