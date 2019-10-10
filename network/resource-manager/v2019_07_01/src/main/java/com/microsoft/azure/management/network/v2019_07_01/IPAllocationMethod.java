/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2019_07_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for IPAllocationMethod.
 */
public final class IPAllocationMethod extends ExpandableStringEnum<IPAllocationMethod> {
    /** Static value Static for IPAllocationMethod. */
    public static final IPAllocationMethod STATIC = fromString("Static");

    /** Static value Dynamic for IPAllocationMethod. */
    public static final IPAllocationMethod DYNAMIC = fromString("Dynamic");

    /**
     * Creates or finds a IPAllocationMethod from its string representation.
     * @param name a name to look for
     * @return the corresponding IPAllocationMethod
     */
    @JsonCreator
    public static IPAllocationMethod fromString(String name) {
        return fromString(name, IPAllocationMethod.class);
    }

    /**
     * @return known IPAllocationMethod values
     */
    public static Collection<IPAllocationMethod> values() {
        return values(IPAllocationMethod.class);
    }
}
