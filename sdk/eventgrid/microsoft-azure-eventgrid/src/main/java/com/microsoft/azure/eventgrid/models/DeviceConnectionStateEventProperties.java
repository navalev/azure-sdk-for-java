/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.eventgrid.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Schema of the Data property of an EventGridEvent for a device connection
 * state event (DeviceConnected, DeviceDisconnected).
 */
public class DeviceConnectionStateEventProperties {
    /**
     * The unique identifier of the device. This case-sensitive string can be
     * up to 128 characters long, and supports ASCII 7-bit alphanumeric
     * characters plus the following special characters: - : . + % _ &amp;#35;
     * * ? ! ( ) , = @ ; $ '.
     */
    @JsonProperty(value = "deviceId")
    private String deviceId;

    /**
     * The unique identifier of the module. This case-sensitive string can be
     * up to 128 characters long, and supports ASCII 7-bit alphanumeric
     * characters plus the following special characters: - : . + % _ &amp;#35;
     * * ? ! ( ) , = @ ; $ '.
     */
    @JsonProperty(value = "moduleId")
    private String moduleId;

    /**
     * Name of the IoT Hub where the device was created or deleted.
     */
    @JsonProperty(value = "hubName")
    private String hubName;

    /**
     * Information about the device connection state event.
     */
    @JsonProperty(value = "deviceConnectionStateEventInfo")
    private DeviceConnectionStateEventInfo deviceConnectionStateEventInfo;

    /**
     * Get the unique identifier of the device. This case-sensitive string can be up to 128 characters long, and supports ASCII 7-bit alphanumeric characters plus the following special characters: - : . + % _ &amp;#35; * ? ! ( ) , = @ ; $ '.
     *
     * @return the deviceId value
     */
    public String deviceId() {
        return this.deviceId;
    }

    /**
     * Set the unique identifier of the device. This case-sensitive string can be up to 128 characters long, and supports ASCII 7-bit alphanumeric characters plus the following special characters: - : . + % _ &amp;#35; * ? ! ( ) , = @ ; $ '.
     *
     * @param deviceId the deviceId value to set
     * @return the DeviceConnectionStateEventProperties object itself.
     */
    public DeviceConnectionStateEventProperties withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * Get the unique identifier of the module. This case-sensitive string can be up to 128 characters long, and supports ASCII 7-bit alphanumeric characters plus the following special characters: - : . + % _ &amp;#35; * ? ! ( ) , = @ ; $ '.
     *
     * @return the moduleId value
     */
    public String moduleId() {
        return this.moduleId;
    }

    /**
     * Set the unique identifier of the module. This case-sensitive string can be up to 128 characters long, and supports ASCII 7-bit alphanumeric characters plus the following special characters: - : . + % _ &amp;#35; * ? ! ( ) , = @ ; $ '.
     *
     * @param moduleId the moduleId value to set
     * @return the DeviceConnectionStateEventProperties object itself.
     */
    public DeviceConnectionStateEventProperties withModuleId(String moduleId) {
        this.moduleId = moduleId;
        return this;
    }

    /**
     * Get name of the IoT Hub where the device was created or deleted.
     *
     * @return the hubName value
     */
    public String hubName() {
        return this.hubName;
    }

    /**
     * Set name of the IoT Hub where the device was created or deleted.
     *
     * @param hubName the hubName value to set
     * @return the DeviceConnectionStateEventProperties object itself.
     */
    public DeviceConnectionStateEventProperties withHubName(String hubName) {
        this.hubName = hubName;
        return this;
    }

    /**
     * Get information about the device connection state event.
     *
     * @return the deviceConnectionStateEventInfo value
     */
    public DeviceConnectionStateEventInfo deviceConnectionStateEventInfo() {
        return this.deviceConnectionStateEventInfo;
    }

    /**
     * Set information about the device connection state event.
     *
     * @param deviceConnectionStateEventInfo the deviceConnectionStateEventInfo value to set
     * @return the DeviceConnectionStateEventProperties object itself.
     */
    public DeviceConnectionStateEventProperties withDeviceConnectionStateEventInfo(DeviceConnectionStateEventInfo deviceConnectionStateEventInfo) {
        this.deviceConnectionStateEventInfo = deviceConnectionStateEventInfo;
        return this;
    }

}
