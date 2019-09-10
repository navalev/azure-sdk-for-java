/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2019_05_15.implementation;

import com.microsoft.azure.management.kusto.v2019_05_15.DatabasePrincipalRole;
import com.microsoft.azure.management.kusto.v2019_05_15.DatabasePrincipalType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class representing database principal entity.
 */
public class DatabasePrincipalInner {
    /**
     * Database principal role. Possible values include: 'Admin', 'Ingestor',
     * 'Monitor', 'User', 'UnrestrictedViewers', 'Viewer'.
     */
    @JsonProperty(value = "role", required = true)
    private DatabasePrincipalRole role;

    /**
     * Database principal name.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Database principal type. Possible values include: 'App', 'Group',
     * 'User'.
     */
    @JsonProperty(value = "type", required = true)
    private DatabasePrincipalType type;

    /**
     * Database principal fully qualified name.
     */
    @JsonProperty(value = "fqn")
    private String fqn;

    /**
     * Database principal email if exists.
     */
    @JsonProperty(value = "email")
    private String email;

    /**
     * Application id - relevant only for application principal type.
     */
    @JsonProperty(value = "appId")
    private String appId;

    /**
     * The tenant name of the principal.
     */
    @JsonProperty(value = "tenantName", access = JsonProperty.Access.WRITE_ONLY)
    private String tenantName;

    /**
     * Get database principal role. Possible values include: 'Admin', 'Ingestor', 'Monitor', 'User', 'UnrestrictedViewers', 'Viewer'.
     *
     * @return the role value
     */
    public DatabasePrincipalRole role() {
        return this.role;
    }

    /**
     * Set database principal role. Possible values include: 'Admin', 'Ingestor', 'Monitor', 'User', 'UnrestrictedViewers', 'Viewer'.
     *
     * @param role the role value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withRole(DatabasePrincipalRole role) {
        this.role = role;
        return this;
    }

    /**
     * Get database principal name.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set database principal name.
     *
     * @param name the name value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get database principal type. Possible values include: 'App', 'Group', 'User'.
     *
     * @return the type value
     */
    public DatabasePrincipalType type() {
        return this.type;
    }

    /**
     * Set database principal type. Possible values include: 'App', 'Group', 'User'.
     *
     * @param type the type value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withType(DatabasePrincipalType type) {
        this.type = type;
        return this;
    }

    /**
     * Get database principal fully qualified name.
     *
     * @return the fqn value
     */
    public String fqn() {
        return this.fqn;
    }

    /**
     * Set database principal fully qualified name.
     *
     * @param fqn the fqn value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withFqn(String fqn) {
        this.fqn = fqn;
        return this;
    }

    /**
     * Get database principal email if exists.
     *
     * @return the email value
     */
    public String email() {
        return this.email;
    }

    /**
     * Set database principal email if exists.
     *
     * @param email the email value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get application id - relevant only for application principal type.
     *
     * @return the appId value
     */
    public String appId() {
        return this.appId;
    }

    /**
     * Set application id - relevant only for application principal type.
     *
     * @param appId the appId value to set
     * @return the DatabasePrincipalInner object itself.
     */
    public DatabasePrincipalInner withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Get the tenant name of the principal.
     *
     * @return the tenantName value
     */
    public String tenantName() {
        return this.tenantName;
    }

}
