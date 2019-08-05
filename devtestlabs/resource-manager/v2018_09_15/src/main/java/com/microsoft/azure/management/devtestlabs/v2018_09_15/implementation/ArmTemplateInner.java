/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import org.joda.time.DateTime;
import java.util.List;
import com.microsoft.azure.management.devtestlabs.v2018_09_15.ParametersValueFileInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * An Azure Resource Manager template.
 */
@JsonFlatten
@SkipParentValidation
public class ArmTemplateInner extends Resource {
    /**
     * The display name of the ARM template.
     */
    @JsonProperty(value = "properties.displayName", access = JsonProperty.Access.WRITE_ONLY)
    private String displayName;

    /**
     * The description of the ARM template.
     */
    @JsonProperty(value = "properties.description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /**
     * The publisher of the ARM template.
     */
    @JsonProperty(value = "properties.publisher", access = JsonProperty.Access.WRITE_ONLY)
    private String publisher;

    /**
     * The URI to the icon of the ARM template.
     */
    @JsonProperty(value = "properties.icon", access = JsonProperty.Access.WRITE_ONLY)
    private String icon;

    /**
     * The contents of the ARM template.
     */
    @JsonProperty(value = "properties.contents", access = JsonProperty.Access.WRITE_ONLY)
    private Object contents;

    /**
     * The creation date of the armTemplate.
     */
    @JsonProperty(value = "properties.createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdDate;

    /**
     * File name and parameter values information from all
     * azuredeploy.*.parameters.json for the ARM template.
     */
    @JsonProperty(value = "properties.parametersValueFilesInfo", access = JsonProperty.Access.WRITE_ONLY)
    private List<ParametersValueFileInfo> parametersValueFilesInfo;

    /**
     * Whether or not ARM template is enabled for use by lab user.
     */
    @JsonProperty(value = "properties.enabled", access = JsonProperty.Access.WRITE_ONLY)
    private Boolean enabled;

    /**
     * Get the display name of the ARM template.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Get the description of the ARM template.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Get the publisher of the ARM template.
     *
     * @return the publisher value
     */
    public String publisher() {
        return this.publisher;
    }

    /**
     * Get the URI to the icon of the ARM template.
     *
     * @return the icon value
     */
    public String icon() {
        return this.icon;
    }

    /**
     * Get the contents of the ARM template.
     *
     * @return the contents value
     */
    public Object contents() {
        return this.contents;
    }

    /**
     * Get the creation date of the armTemplate.
     *
     * @return the createdDate value
     */
    public DateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Get file name and parameter values information from all azuredeploy.*.parameters.json for the ARM template.
     *
     * @return the parametersValueFilesInfo value
     */
    public List<ParametersValueFileInfo> parametersValueFilesInfo() {
        return this.parametersValueFilesInfo;
    }

    /**
     * Get whether or not ARM template is enabled for use by lab user.
     *
     * @return the enabled value
     */
    public Boolean enabled() {
        return this.enabled;
    }

}
