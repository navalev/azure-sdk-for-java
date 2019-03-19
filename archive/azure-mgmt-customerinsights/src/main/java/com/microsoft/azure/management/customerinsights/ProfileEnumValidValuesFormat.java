/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.customerinsights;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Valid enum values in case of an enum property.
 */
public class ProfileEnumValidValuesFormat {
    /**
     * The integer value of the enum member.
     */
    @JsonProperty(value = "value")
    private Integer value;

    /**
     * Localized names of the enum member.
     */
    @JsonProperty(value = "localizedValueNames")
    private Map<String, String> localizedValueNames;

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public Integer value() {
        return this.value;
    }

    /**
     * Set the value value.
     *
     * @param value the value value to set
     * @return the ProfileEnumValidValuesFormat object itself.
     */
    public ProfileEnumValidValuesFormat withValue(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * Get the localizedValueNames value.
     *
     * @return the localizedValueNames value
     */
    public Map<String, String> localizedValueNames() {
        return this.localizedValueNames;
    }

    /**
     * Set the localizedValueNames value.
     *
     * @param localizedValueNames the localizedValueNames value to set
     * @return the ProfileEnumValidValuesFormat object itself.
     */
    public ProfileEnumValidValuesFormat withLocalizedValueNames(Map<String, String> localizedValueNames) {
        this.localizedValueNames = localizedValueNames;
        return this;
    }

}