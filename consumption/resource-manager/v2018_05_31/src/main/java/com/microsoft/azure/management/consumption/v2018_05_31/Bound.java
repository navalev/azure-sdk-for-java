/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.consumption.v2018_05_31;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for Bound.
 */
public final class Bound extends ExpandableStringEnum<Bound> {
    /** Static value Upper for Bound. */
    public static final Bound UPPER = fromString("Upper");

    /** Static value Lower for Bound. */
    public static final Bound LOWER = fromString("Lower");

    /**
     * Creates or finds a Bound from its string representation.
     * @param name a name to look for
     * @return the corresponding Bound
     */
    @JsonCreator
    public static Bound fromString(String name) {
        return fromString(name, Bound.class);
    }

    /**
     * @return known Bound values
     */
    public static Collection<Bound> values() {
        return values(Bound.class);
    }
}