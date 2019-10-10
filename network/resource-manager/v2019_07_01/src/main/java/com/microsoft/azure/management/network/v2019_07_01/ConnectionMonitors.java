/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_07_01;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.network.v2019_07_01.implementation.ConnectionMonitorsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing ConnectionMonitors.
 */
public interface ConnectionMonitors extends SupportsCreating<ConnectionMonitorResult.DefinitionStages.Blank>, HasInner<ConnectionMonitorsInner> {
    /**
     * Stops the specified connection monitor.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @param connectionMonitorName The name of the connection monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable stopAsync(String resourceGroupName, String networkWatcherName, String connectionMonitorName);

    /**
     * Starts the specified connection monitor.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @param connectionMonitorName The name of the connection monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable startAsync(String resourceGroupName, String networkWatcherName, String connectionMonitorName);

    /**
     * Query a snapshot of the most recent connection states.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @param connectionMonitorName The name given to the connection monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionMonitorQueryResult> queryAsync(String resourceGroupName, String networkWatcherName, String connectionMonitorName);

    /**
     * Gets a connection monitor by name.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @param connectionMonitorName The name of the connection monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionMonitorResult> getAsync(String resourceGroupName, String networkWatcherName, String connectionMonitorName);

    /**
     * Lists all connection monitors for the specified Network Watcher.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<ConnectionMonitorResult> listAsync(String resourceGroupName, String networkWatcherName);

    /**
     * Deletes the specified connection monitor.
     *
     * @param resourceGroupName The name of the resource group containing Network Watcher.
     * @param networkWatcherName The name of the Network Watcher resource.
     * @param connectionMonitorName The name of the connection monitor.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String networkWatcherName, String connectionMonitorName);

}
