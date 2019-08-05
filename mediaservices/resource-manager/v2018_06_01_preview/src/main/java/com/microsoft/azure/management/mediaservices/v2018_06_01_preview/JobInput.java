/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_06_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * Base class for inputs to a Job.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type", defaultImpl = JobInput.class)
@JsonTypeName("JobInput")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "#Microsoft.Media.JobInputClip", value = JobInputClip.class),
    @JsonSubTypes.Type(name = "#Microsoft.Media.JobInputs", value = JobInputs.class)
})
public class JobInput {
    /**
     * A label that is assigned to a JobInput, that is used to satisfy a
     * reference used in the Transform. For example, a Transform can be
     * authored so as to take an image file with the label 'xyz' and apply it
     * as an overlay onto the input video before it is encoded. When submitting
     * a Job, exactly one of the JobInputs should be the image file, and it
     * should have the label 'xyz'.
     */
    @JsonProperty(value = "label")
    private String label;

    /**
     * Get a label that is assigned to a JobInput, that is used to satisfy a reference used in the Transform. For example, a Transform can be authored so as to take an image file with the label 'xyz' and apply it as an overlay onto the input video before it is encoded. When submitting a Job, exactly one of the JobInputs should be the image file, and it should have the label 'xyz'.
     *
     * @return the label value
     */
    public String label() {
        return this.label;
    }

    /**
     * Set a label that is assigned to a JobInput, that is used to satisfy a reference used in the Transform. For example, a Transform can be authored so as to take an image file with the label 'xyz' and apply it as an overlay onto the input video before it is encoded. When submitting a Job, exactly one of the JobInputs should be the image file, and it should have the label 'xyz'.
     *
     * @param label the label value to set
     * @return the JobInput object itself.
     */
    public JobInput withLabel(String label) {
        this.label = label;
        return this;
    }

}
