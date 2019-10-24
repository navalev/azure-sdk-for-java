/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.storage.v2019_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.storage.v2019_06_01.implementation.SkuInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.storage.v2019_06_01.implementation.StorageManager;
import java.util.List;

/**
 * Type representing Sku.
 */
public interface Sku extends HasInner<SkuInner>, HasManager<StorageManager> {
    /**
     * @return the capabilities value.
     */
    List<SKUCapability> capabilities();

    /**
     * @return the kind value.
     */
    Kind kind();

    /**
     * @return the locations value.
     */
    List<String> locations();

    /**
     * @return the name value.
     */
    SkuName name();

    /**
     * @return the resourceType value.
     */
    String resourceType();

    /**
     * @return the restrictions value.
     */
    List<Restriction> restrictions();

    /**
     * @return the tier value.
     */
    SkuTier tier();

}
