/**
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.azure.search.service.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A skill that detects the language of input text and reports a single
 * language code for every document submitted on the request. The language code
 * is paired with a score indicating the confidence of the analysis.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@odata\\.type")
@JsonTypeName("#Microsoft.Skills.Text.LanguageDetectionSkill")
public class LanguageDetectionSkill extends Skill {
}