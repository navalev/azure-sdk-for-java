/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2018_12_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.network.v2018_12_01.implementation.NetworkInterfaceTapConfigurationInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2018_12_01.implementation.NetworkManager;
import com.microsoft.azure.management.network.v2018_12_01.implementation.VirtualNetworkTapInner;

/**
 * Type representing NetworkInterfaceTapConfiguration.
 */
public interface NetworkInterfaceTapConfiguration extends HasInner<NetworkInterfaceTapConfigurationInner>, Indexable, Refreshable<NetworkInterfaceTapConfiguration>, Updatable<NetworkInterfaceTapConfiguration.Update>, HasManager<NetworkManager> {
    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the provisioningState value.
     */
    String provisioningState();

    /**
     * @return the type value.
     */
    String type();

    /**
     * @return the virtualNetworkTap value.
     */
    VirtualNetworkTap virtualNetworkTap();

    /**
     * The entirety of the NetworkInterfaceTapConfiguration definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithNetworkInterface, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of NetworkInterfaceTapConfiguration definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a NetworkInterfaceTapConfiguration definition.
         */
        interface Blank extends WithNetworkInterface {
        }

        /**
         * The stage of the networkinterfacetapconfiguration definition allowing to specify NetworkInterface.
         */
        interface WithNetworkInterface {
           /**
            * Specifies resourceGroupName, networkInterfaceName.
            * @param resourceGroupName The name of the resource group
            * @param networkInterfaceName The name of the network interface
            * @return the next definition stage
            */
            WithCreate withExistingNetworkInterface(String resourceGroupName, String networkInterfaceName);
        }

        /**
         * The stage of the networkinterfacetapconfiguration definition allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next definition stage
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the networkinterfacetapconfiguration definition allowing to specify Id.
         */
        interface WithId {
            /**
             * Specifies id.
             * @param id Resource ID
             * @return the next definition stage
             */
            WithCreate withId(String id);
        }

        /**
         * The stage of the networkinterfacetapconfiguration definition allowing to specify Name.
         */
        interface WithName {
            /**
             * Specifies name.
             * @param name The name of the resource that is unique within a resource group. This name can be used to access the resource
             * @return the next definition stage
             */
            WithCreate withName(String name);
        }

        /**
         * The stage of the networkinterfacetapconfiguration definition allowing to specify VirtualNetworkTap.
         */
        interface WithVirtualNetworkTap {
            /**
             * Specifies virtualNetworkTap.
             * @param virtualNetworkTap The reference of the Virtual Network Tap resource
             * @return the next definition stage
             */
            WithCreate withVirtualNetworkTap(VirtualNetworkTapInner virtualNetworkTap);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<NetworkInterfaceTapConfiguration>, DefinitionStages.WithEtag, DefinitionStages.WithId, DefinitionStages.WithName, DefinitionStages.WithVirtualNetworkTap {
        }
    }
    /**
     * The template for a NetworkInterfaceTapConfiguration update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<NetworkInterfaceTapConfiguration>, UpdateStages.WithEtag, UpdateStages.WithId, UpdateStages.WithName, UpdateStages.WithVirtualNetworkTap {
    }

    /**
     * Grouping of NetworkInterfaceTapConfiguration update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the networkinterfacetapconfiguration update allowing to specify Etag.
         */
        interface WithEtag {
            /**
             * Specifies etag.
             * @param etag A unique read-only string that changes whenever the resource is updated
             * @return the next update stage
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the networkinterfacetapconfiguration update allowing to specify Id.
         */
        interface WithId {
            /**
             * Specifies id.
             * @param id Resource ID
             * @return the next update stage
             */
            Update withId(String id);
        }

        /**
         * The stage of the networkinterfacetapconfiguration update allowing to specify Name.
         */
        interface WithName {
            /**
             * Specifies name.
             * @param name The name of the resource that is unique within a resource group. This name can be used to access the resource
             * @return the next update stage
             */
            Update withName(String name);
        }

        /**
         * The stage of the networkinterfacetapconfiguration update allowing to specify VirtualNetworkTap.
         */
        interface WithVirtualNetworkTap {
            /**
             * Specifies virtualNetworkTap.
             * @param virtualNetworkTap The reference of the Virtual Network Tap resource
             * @return the next update stage
             */
            Update withVirtualNetworkTap(VirtualNetworkTapInner virtualNetworkTap);
        }

    }
}
