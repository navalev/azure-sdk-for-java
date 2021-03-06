/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A collection of Azure Batch Tasks to add.
 */
public class TaskAddCollectionParameter {
    /**
     * The collection of Tasks to add. The maximum count of Tasks is 100.
     * The total serialized size of this collection must be less than 1MB. If
     * it is greater than 1MB (for example if each Task has 100's of resource
     * files or environment variables), the request will fail with code
     * 'RequestBodyTooLarge' and should be retried again with fewer Tasks.
     */
    @JsonProperty(value = "value", required = true)
    private List<TaskAddParameter> value;

    /**
     * Get the total serialized size of this collection must be less than 1MB. If it is greater than 1MB (for example if each Task has 100's of resource files or environment variables), the request will fail with code 'RequestBodyTooLarge' and should be retried again with fewer Tasks.
     *
     * @return the value value
     */
    public List<TaskAddParameter> value() {
        return this.value;
    }

    /**
     * Set the total serialized size of this collection must be less than 1MB. If it is greater than 1MB (for example if each Task has 100's of resource files or environment variables), the request will fail with code 'RequestBodyTooLarge' and should be retried again with fewer Tasks.
     *
     * @param value the value value to set
     * @return the TaskAddCollectionParameter object itself.
     */
    public TaskAddCollectionParameter withValue(List<TaskAddParameter> value) {
        this.value = value;
        return this;
    }

}
