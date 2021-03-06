/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15.implementation;

import org.joda.time.DateTime;
import com.microsoft.azure.management.labservices.v2018_10_15.GalleryImageReference;
import com.microsoft.azure.management.labservices.v2018_10_15.LatestOperationResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * Represents an image from the Azure Marketplace.
 */
@JsonFlatten
@SkipParentValidation
public class GalleryImageInner extends Resource {
    /**
     * The author of the gallery image.
     */
    @JsonProperty(value = "properties.author", access = JsonProperty.Access.WRITE_ONLY)
    private String author;

    /**
     * The creation date of the gallery image.
     */
    @JsonProperty(value = "properties.createdDate", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdDate;

    /**
     * The description of the gallery image.
     */
    @JsonProperty(value = "properties.description", access = JsonProperty.Access.WRITE_ONLY)
    private String description;

    /**
     * The image reference of the gallery image.
     */
    @JsonProperty(value = "properties.imageReference", access = JsonProperty.Access.WRITE_ONLY)
    private GalleryImageReference imageReference;

    /**
     * The icon of the gallery image.
     */
    @JsonProperty(value = "properties.icon", access = JsonProperty.Access.WRITE_ONLY)
    private String icon;

    /**
     * Indicates whether this gallery image is enabled.
     */
    @JsonProperty(value = "properties.isEnabled")
    private Boolean isEnabled;

    /**
     * Indicates whether this gallery has been overridden for this lab account.
     */
    @JsonProperty(value = "properties.isOverride")
    private Boolean isOverride;

    /**
     * The third party plan that applies to this image.
     */
    @JsonProperty(value = "properties.planId", access = JsonProperty.Access.WRITE_ONLY)
    private String planId;

    /**
     * Indicates if the plan has been authorized for programmatic deployment.
     */
    @JsonProperty(value = "properties.isPlanAuthorized")
    private Boolean isPlanAuthorized;

    /**
     * The provisioning status of the resource.
     */
    @JsonProperty(value = "properties.provisioningState")
    private String provisioningState;

    /**
     * The unique immutable identifier of a resource (Guid).
     */
    @JsonProperty(value = "properties.uniqueIdentifier")
    private String uniqueIdentifier;

    /**
     * The details of the latest operation. ex: status, error.
     */
    @JsonProperty(value = "properties.latestOperationResult", access = JsonProperty.Access.WRITE_ONLY)
    private LatestOperationResult latestOperationResult;

    /**
     * Get the author of the gallery image.
     *
     * @return the author value
     */
    public String author() {
        return this.author;
    }

    /**
     * Get the creation date of the gallery image.
     *
     * @return the createdDate value
     */
    public DateTime createdDate() {
        return this.createdDate;
    }

    /**
     * Get the description of the gallery image.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Get the image reference of the gallery image.
     *
     * @return the imageReference value
     */
    public GalleryImageReference imageReference() {
        return this.imageReference;
    }

    /**
     * Get the icon of the gallery image.
     *
     * @return the icon value
     */
    public String icon() {
        return this.icon;
    }

    /**
     * Get indicates whether this gallery image is enabled.
     *
     * @return the isEnabled value
     */
    public Boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Set indicates whether this gallery image is enabled.
     *
     * @param isEnabled the isEnabled value to set
     * @return the GalleryImageInner object itself.
     */
    public GalleryImageInner withIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Get indicates whether this gallery has been overridden for this lab account.
     *
     * @return the isOverride value
     */
    public Boolean isOverride() {
        return this.isOverride;
    }

    /**
     * Set indicates whether this gallery has been overridden for this lab account.
     *
     * @param isOverride the isOverride value to set
     * @return the GalleryImageInner object itself.
     */
    public GalleryImageInner withIsOverride(Boolean isOverride) {
        this.isOverride = isOverride;
        return this;
    }

    /**
     * Get the third party plan that applies to this image.
     *
     * @return the planId value
     */
    public String planId() {
        return this.planId;
    }

    /**
     * Get indicates if the plan has been authorized for programmatic deployment.
     *
     * @return the isPlanAuthorized value
     */
    public Boolean isPlanAuthorized() {
        return this.isPlanAuthorized;
    }

    /**
     * Set indicates if the plan has been authorized for programmatic deployment.
     *
     * @param isPlanAuthorized the isPlanAuthorized value to set
     * @return the GalleryImageInner object itself.
     */
    public GalleryImageInner withIsPlanAuthorized(Boolean isPlanAuthorized) {
        this.isPlanAuthorized = isPlanAuthorized;
        return this;
    }

    /**
     * Get the provisioning status of the resource.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioning status of the resource.
     *
     * @param provisioningState the provisioningState value to set
     * @return the GalleryImageInner object itself.
     */
    public GalleryImageInner withProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get the unique immutable identifier of a resource (Guid).
     *
     * @return the uniqueIdentifier value
     */
    public String uniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Set the unique immutable identifier of a resource (Guid).
     *
     * @param uniqueIdentifier the uniqueIdentifier value to set
     * @return the GalleryImageInner object itself.
     */
    public GalleryImageInner withUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    /**
     * Get the details of the latest operation. ex: status, error.
     *
     * @return the latestOperationResult value
     */
    public LatestOperationResult latestOperationResult() {
        return this.latestOperationResult;
    }

}
