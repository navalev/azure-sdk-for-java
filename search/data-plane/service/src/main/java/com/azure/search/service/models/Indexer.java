/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

//import com.microsoft.rest.IndexingParameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an Azure Search indexer.
 */
public class Indexer {
    /**
     * The name of the indexer.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The description of the indexer.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * The name of the datasource from which this indexer reads data.
     */
    @JsonProperty(value = "dataSourceName", required = true)
    private String dataSourceName;

    /**
     * The name of the cognitive skillset executing with this indexer.
     */
    @JsonProperty(value = "skillsetName")
    private String skillsetName;

    /**
     * The name of the index to which this indexer writes data.
     */
    @JsonProperty(value = "targetIndexName", required = true)
    private String targetIndexName;

    /**
     * The schedule for this indexer.
     */
    @JsonProperty(value = "schedule")
    private IndexingSchedule schedule;

    /**
     * Parameters for indexer execution.
     */
//    @JsonProperty(value = "parameters")
//    private IndexingParameters parameters;

    /**
     * Defines mappings between fields in the data source and corresponding
     * target fields in the index.
     */
    @JsonProperty(value = "fieldMappings")
    private List<FieldMapping> fieldMappings;

    /**
     * Output field mappings are applied after enrichment and immediately
     * before indexing.
     */
    @JsonProperty(value = "outputFieldMappings")
    private List<FieldMapping> outputFieldMappings;

    /**
     * A value indicating whether the indexer is disabled. Default is false.
     */
    @JsonProperty(value = "disabled")
    private Boolean isDisabled;

    /**
     * The ETag of the Indexer.
     */
    @JsonProperty(value = "@odata\\.etag")
    private String eTag;

    /**
     * Get the name of the indexer.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the indexer.
     *
     * @param name the name value to set
     * @return the Indexer object itself.
     */
    public Indexer withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the description of the indexer.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description of the indexer.
     *
     * @param description the description value to set
     * @return the Indexer object itself.
     */
    public Indexer withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the name of the datasource from which this indexer reads data.
     *
     * @return the dataSourceName value
     */
    public String dataSourceName() {
        return this.dataSourceName;
    }

    /**
     * Set the name of the datasource from which this indexer reads data.
     *
     * @param dataSourceName the dataSourceName value to set
     * @return the Indexer object itself.
     */
    public Indexer withDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
        return this;
    }

    /**
     * Get the name of the cognitive skillset executing with this indexer.
     *
     * @return the skillsetName value
     */
    public String skillsetName() {
        return this.skillsetName;
    }

    /**
     * Set the name of the cognitive skillset executing with this indexer.
     *
     * @param skillsetName the skillsetName value to set
     * @return the Indexer object itself.
     */
    public Indexer withSkillsetName(String skillsetName) {
        this.skillsetName = skillsetName;
        return this;
    }

    /**
     * Get the name of the index to which this indexer writes data.
     *
     * @return the targetIndexName value
     */
    public String targetIndexName() {
        return this.targetIndexName;
    }

    /**
     * Set the name of the index to which this indexer writes data.
     *
     * @param targetIndexName the targetIndexName value to set
     * @return the Indexer object itself.
     */
    public Indexer withTargetIndexName(String targetIndexName) {
        this.targetIndexName = targetIndexName;
        return this;
    }

    /**
     * Get the schedule for this indexer.
     *
     * @return the schedule value
     */
    public IndexingSchedule schedule() {
        return this.schedule;
    }

    /**
     * Set the schedule for this indexer.
     *
     * @param schedule the schedule value to set
     * @return the Indexer object itself.
     */
    public Indexer withSchedule(IndexingSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

    /**
     * Get parameters for indexer execution.
     *
     * @return the parameters value
     */
//    public IndexingParameters parameters() {
//        return this.parameters;
//    }

    /**
     * Set parameters for indexer execution.
     *
     * @param parameters the parameters value to set
     * @return the Indexer object itself.
     */
//    public Indexer withParameters(IndexingParameters parameters) {
//        this.parameters = parameters;
//        return this;
//    }

    /**
     * Get defines mappings between fields in the data source and corresponding target fields in the index.
     *
     * @return the fieldMappings value
     */
    public List<FieldMapping> fieldMappings() {
        return this.fieldMappings;
    }

    /**
     * Set defines mappings between fields in the data source and corresponding target fields in the index.
     *
     * @param fieldMappings the fieldMappings value to set
     * @return the Indexer object itself.
     */
    public Indexer withFieldMappings(List<FieldMapping> fieldMappings) {
        this.fieldMappings = fieldMappings;
        return this;
    }

    /**
     * Get output field mappings are applied after enrichment and immediately before indexing.
     *
     * @return the outputFieldMappings value
     */
    public List<FieldMapping> outputFieldMappings() {
        return this.outputFieldMappings;
    }

    /**
     * Set output field mappings are applied after enrichment and immediately before indexing.
     *
     * @param outputFieldMappings the outputFieldMappings value to set
     * @return the Indexer object itself.
     */
    public Indexer withOutputFieldMappings(List<FieldMapping> outputFieldMappings) {
        this.outputFieldMappings = outputFieldMappings;
        return this;
    }

    /**
     * Get a value indicating whether the indexer is disabled. Default is false.
     *
     * @return the isDisabled value
     */
    public Boolean isDisabled() {
        return this.isDisabled;
    }

    /**
     * Set a value indicating whether the indexer is disabled. Default is false.
     *
     * @param isDisabled the isDisabled value to set
     * @return the Indexer object itself.
     */
    public Indexer withIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
        return this;
    }

    /**
     * Get the ETag of the Indexer.
     *
     * @return the eTag value
     */
    public String eTag() {
        return this.eTag;
    }

    /**
     * Set the ETag of the Indexer.
     *
     * @param eTag the eTag value to set
     * @return the Indexer object itself.
     */
    public Indexer withETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

}