/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datamigration.v2018_07_15_preview;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes how a MongoDB data migration should be performed.
 */
public class MongoDbMigrationSettings {
    /**
     * The RU limit on a CosmosDB target that collections will be temporarily
     * increased to (if lower) during the initial copy of a migration, from
     * 10,000 to 1,000,000, or 0 to use the default boost (which is generally
     * the maximum), or null to not boost the RUs. This setting has no effect
     * on non-CosmosDB targets.
     */
    @JsonProperty(value = "boostRUs")
    private Integer boostRUs;

    /**
     * The databases on the source cluster to migrate to the target. The keys
     * are the names of the databases.
     */
    @JsonProperty(value = "databases", required = true)
    private Map<String, MongoDbDatabaseSettings> databases;

    /**
     * Describes how changes will be replicated from the source to the target.
     * The default is OneTime. Possible values include: 'Disabled', 'OneTime',
     * 'Continuous'.
     */
    @JsonProperty(value = "replication")
    private MongoDbReplication replication;

    /**
     * Settings used to connect to the source cluster.
     */
    @JsonProperty(value = "source", required = true)
    private MongoDbConnectionInfo source;

    /**
     * Settings used to connect to the target cluster.
     */
    @JsonProperty(value = "target", required = true)
    private MongoDbConnectionInfo target;

    /**
     * Settings used to limit the resource usage of the migration.
     */
    @JsonProperty(value = "throttling")
    private MongoDbThrottlingSettings throttling;

    /**
     * Get the RU limit on a CosmosDB target that collections will be temporarily increased to (if lower) during the initial copy of a migration, from 10,000 to 1,000,000, or 0 to use the default boost (which is generally the maximum), or null to not boost the RUs. This setting has no effect on non-CosmosDB targets.
     *
     * @return the boostRUs value
     */
    public Integer boostRUs() {
        return this.boostRUs;
    }

    /**
     * Set the RU limit on a CosmosDB target that collections will be temporarily increased to (if lower) during the initial copy of a migration, from 10,000 to 1,000,000, or 0 to use the default boost (which is generally the maximum), or null to not boost the RUs. This setting has no effect on non-CosmosDB targets.
     *
     * @param boostRUs the boostRUs value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withBoostRUs(Integer boostRUs) {
        this.boostRUs = boostRUs;
        return this;
    }

    /**
     * Get the databases on the source cluster to migrate to the target. The keys are the names of the databases.
     *
     * @return the databases value
     */
    public Map<String, MongoDbDatabaseSettings> databases() {
        return this.databases;
    }

    /**
     * Set the databases on the source cluster to migrate to the target. The keys are the names of the databases.
     *
     * @param databases the databases value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withDatabases(Map<String, MongoDbDatabaseSettings> databases) {
        this.databases = databases;
        return this;
    }

    /**
     * Get describes how changes will be replicated from the source to the target. The default is OneTime. Possible values include: 'Disabled', 'OneTime', 'Continuous'.
     *
     * @return the replication value
     */
    public MongoDbReplication replication() {
        return this.replication;
    }

    /**
     * Set describes how changes will be replicated from the source to the target. The default is OneTime. Possible values include: 'Disabled', 'OneTime', 'Continuous'.
     *
     * @param replication the replication value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withReplication(MongoDbReplication replication) {
        this.replication = replication;
        return this;
    }

    /**
     * Get settings used to connect to the source cluster.
     *
     * @return the source value
     */
    public MongoDbConnectionInfo source() {
        return this.source;
    }

    /**
     * Set settings used to connect to the source cluster.
     *
     * @param source the source value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withSource(MongoDbConnectionInfo source) {
        this.source = source;
        return this;
    }

    /**
     * Get settings used to connect to the target cluster.
     *
     * @return the target value
     */
    public MongoDbConnectionInfo target() {
        return this.target;
    }

    /**
     * Set settings used to connect to the target cluster.
     *
     * @param target the target value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withTarget(MongoDbConnectionInfo target) {
        this.target = target;
        return this;
    }

    /**
     * Get settings used to limit the resource usage of the migration.
     *
     * @return the throttling value
     */
    public MongoDbThrottlingSettings throttling() {
        return this.throttling;
    }

    /**
     * Set settings used to limit the resource usage of the migration.
     *
     * @param throttling the throttling value to set
     * @return the MongoDbMigrationSettings object itself.
     */
    public MongoDbMigrationSettings withThrottling(MongoDbThrottlingSettings throttling) {
        this.throttling = throttling;
        return this;
    }

}
