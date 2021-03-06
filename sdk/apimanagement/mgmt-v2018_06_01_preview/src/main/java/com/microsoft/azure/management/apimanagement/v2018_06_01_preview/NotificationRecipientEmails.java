/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview;

import com.microsoft.azure.arm.collection.SupportsCreating;
import rx.Completable;
import rx.Observable;
import com.microsoft.azure.management.apimanagement.v2018_06_01_preview.implementation.NotificationRecipientEmailsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing NotificationRecipientEmails.
 */
public interface NotificationRecipientEmails extends SupportsCreating<RecipientEmailContract.DefinitionStages.Blank>, HasInner<NotificationRecipientEmailsInner> {
    /**
     * Gets the list of the Notification Recipient Emails subscribed to a notification.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceName The name of the API Management service.
     * @param notificationName Notification Name Identifier. Possible values include: 'RequestPublisherNotificationMessage', 'PurchasePublisherNotificationMessage', 'NewApplicationNotificationMessage', 'BCC', 'NewIssuePublisherNotificationMessage', 'AccountClosedPublisher', 'QuotaLimitApproachingPublisherNotificationMessage'
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<RecipientEmailCollection> listByNotificationAsync(String resourceGroupName, String serviceName, NotificationName notificationName);

    /**
     * Determine if Notification Recipient Email subscribed to the notification.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceName The name of the API Management service.
     * @param notificationName Notification Name Identifier. Possible values include: 'RequestPublisherNotificationMessage', 'PurchasePublisherNotificationMessage', 'NewApplicationNotificationMessage', 'BCC', 'NewIssuePublisherNotificationMessage', 'AccountClosedPublisher', 'QuotaLimitApproachingPublisherNotificationMessage'
     * @param email Email identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable checkEntityExistsAsync(String resourceGroupName, String serviceName, NotificationName notificationName, String email);

    /**
     * Removes the email from the list of Notification.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceName The name of the API Management service.
     * @param notificationName Notification Name Identifier. Possible values include: 'RequestPublisherNotificationMessage', 'PurchasePublisherNotificationMessage', 'NewApplicationNotificationMessage', 'BCC', 'NewIssuePublisherNotificationMessage', 'AccountClosedPublisher', 'QuotaLimitApproachingPublisherNotificationMessage'
     * @param email Email identifier.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable deleteAsync(String resourceGroupName, String serviceName, NotificationName notificationName, String email);

}
