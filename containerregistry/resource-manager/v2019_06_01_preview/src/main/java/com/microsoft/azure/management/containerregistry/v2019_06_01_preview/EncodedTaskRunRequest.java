/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.v2019_06_01_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The parameters for a quick task run request.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("EncodedTaskRunRequest")
public class EncodedTaskRunRequest extends RunRequest {
    /**
     * Base64 encoded value of the template/definition file content.
     */
    @JsonProperty(value = "encodedTaskContent", required = true)
    private String encodedTaskContent;

    /**
     * Base64 encoded value of the parameters/values file content.
     */
    @JsonProperty(value = "encodedValuesContent")
    private String encodedValuesContent;

    /**
     * The collection of overridable values that can be passed when running a
     * task.
     */
    @JsonProperty(value = "values")
    private List<SetValue> values;

    /**
     * Run timeout in seconds.
     */
    @JsonProperty(value = "timeout")
    private Integer timeout;

    /**
     * The platform properties against which the run has to happen.
     */
    @JsonProperty(value = "platform", required = true)
    private PlatformProperties platform;

    /**
     * The machine configuration of the run agent.
     */
    @JsonProperty(value = "agentConfiguration")
    private AgentProperties agentConfiguration;

    /**
     * The URL(absolute or relative) of the source context. It can be an URL to
     * a tar or git repository.
     * If it is relative URL, the relative path should be obtained from calling
     * listBuildSourceUploadUrl API.
     */
    @JsonProperty(value = "sourceLocation")
    private String sourceLocation;

    /**
     * The properties that describes a set of credentials that will be used
     * when this run is invoked.
     */
    @JsonProperty(value = "credentials")
    private Credentials credentials;

    /**
     * Get base64 encoded value of the template/definition file content.
     *
     * @return the encodedTaskContent value
     */
    public String encodedTaskContent() {
        return this.encodedTaskContent;
    }

    /**
     * Set base64 encoded value of the template/definition file content.
     *
     * @param encodedTaskContent the encodedTaskContent value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withEncodedTaskContent(String encodedTaskContent) {
        this.encodedTaskContent = encodedTaskContent;
        return this;
    }

    /**
     * Get base64 encoded value of the parameters/values file content.
     *
     * @return the encodedValuesContent value
     */
    public String encodedValuesContent() {
        return this.encodedValuesContent;
    }

    /**
     * Set base64 encoded value of the parameters/values file content.
     *
     * @param encodedValuesContent the encodedValuesContent value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withEncodedValuesContent(String encodedValuesContent) {
        this.encodedValuesContent = encodedValuesContent;
        return this;
    }

    /**
     * Get the collection of overridable values that can be passed when running a task.
     *
     * @return the values value
     */
    public List<SetValue> values() {
        return this.values;
    }

    /**
     * Set the collection of overridable values that can be passed when running a task.
     *
     * @param values the values value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withValues(List<SetValue> values) {
        this.values = values;
        return this;
    }

    /**
     * Get run timeout in seconds.
     *
     * @return the timeout value
     */
    public Integer timeout() {
        return this.timeout;
    }

    /**
     * Set run timeout in seconds.
     *
     * @param timeout the timeout value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * Get the platform properties against which the run has to happen.
     *
     * @return the platform value
     */
    public PlatformProperties platform() {
        return this.platform;
    }

    /**
     * Set the platform properties against which the run has to happen.
     *
     * @param platform the platform value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withPlatform(PlatformProperties platform) {
        this.platform = platform;
        return this;
    }

    /**
     * Get the machine configuration of the run agent.
     *
     * @return the agentConfiguration value
     */
    public AgentProperties agentConfiguration() {
        return this.agentConfiguration;
    }

    /**
     * Set the machine configuration of the run agent.
     *
     * @param agentConfiguration the agentConfiguration value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withAgentConfiguration(AgentProperties agentConfiguration) {
        this.agentConfiguration = agentConfiguration;
        return this;
    }

    /**
     * Get the URL(absolute or relative) of the source context. It can be an URL to a tar or git repository.
     If it is relative URL, the relative path should be obtained from calling listBuildSourceUploadUrl API.
     *
     * @return the sourceLocation value
     */
    public String sourceLocation() {
        return this.sourceLocation;
    }

    /**
     * Set the URL(absolute or relative) of the source context. It can be an URL to a tar or git repository.
     If it is relative URL, the relative path should be obtained from calling listBuildSourceUploadUrl API.
     *
     * @param sourceLocation the sourceLocation value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
        return this;
    }

    /**
     * Get the properties that describes a set of credentials that will be used when this run is invoked.
     *
     * @return the credentials value
     */
    public Credentials credentials() {
        return this.credentials;
    }

    /**
     * Set the properties that describes a set of credentials that will be used when this run is invoked.
     *
     * @param credentials the credentials value to set
     * @return the EncodedTaskRunRequest object itself.
     */
    public EncodedTaskRunRequest withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

}
