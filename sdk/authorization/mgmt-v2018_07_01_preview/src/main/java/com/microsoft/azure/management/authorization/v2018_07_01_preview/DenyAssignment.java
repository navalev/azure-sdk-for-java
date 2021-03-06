/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.authorization.v2018_07_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.authorization.v2018_07_01_preview.implementation.AuthorizationManager;
import com.microsoft.azure.management.authorization.v2018_07_01_preview.implementation.DenyAssignmentInner;
import java.util.List;

/**
 * Type representing DenyAssignment.
 */
public interface DenyAssignment extends HasInner<DenyAssignmentInner>, HasManager<AuthorizationManager> {
    /**
     * @return the denyAssignmentName value.
     */
    String denyAssignmentName();

    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the doNotApplyToChildScopes value.
     */
    Boolean doNotApplyToChildScopes();

    /**
     * @return the excludePrincipals value.
     */
    List<Principal> excludePrincipals();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the isSystemProtected value.
     */
    Boolean isSystemProtected();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the permissions value.
     */
    List<DenyAssignmentPermission> permissions();

    /**
     * @return the principals value.
     */
    List<Principal> principals();

    /**
     * @return the scope value.
     */
    String scope();

    /**
     * @return the type value.
     */
    String type();

}
