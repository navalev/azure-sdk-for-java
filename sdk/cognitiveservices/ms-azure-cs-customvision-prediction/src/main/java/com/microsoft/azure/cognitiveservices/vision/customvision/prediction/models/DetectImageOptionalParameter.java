/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.customvision.prediction.models;


/**
 * The DetectImageOptionalParameter model.
 */
public class DetectImageOptionalParameter {
    /**
     * Optional. Specifies the name of application using the endpoint.
     */
    private String application;

    /**
     * Gets or sets the preferred language for the response.
     */
    private String thisclientacceptLanguage;

    /**
     * Get the application value.
     *
     * @return the application value
     */
    public String application() {
        return this.application;
    }

    /**
     * Set the application value.
     *
     * @param application the application value to set
     * @return the DetectImageOptionalParameter object itself.
     */
    public DetectImageOptionalParameter withApplication(String application) {
        this.application = application;
        return this;
    }

    /**
     * Get the thisclientacceptLanguage value.
     *
     * @return the thisclientacceptLanguage value
     */
    public String thisclientacceptLanguage() {
        return this.thisclientacceptLanguage;
    }

    /**
     * Set the thisclientacceptLanguage value.
     *
     * @param thisclientacceptLanguage the thisclientacceptLanguage value to set
     * @return the DetectImageOptionalParameter object itself.
     */
    public DetectImageOptionalParameter withThisclientacceptLanguage(String thisclientacceptLanguage) {
        this.thisclientacceptLanguage = thisclientacceptLanguage;
        return this;
    }

}
