// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for BlockListType.
 */
public enum BlockListType {
    /**
     * Enum value committed.
     */
    COMMITTED("committed"),

    /**
     * Enum value uncommitted.
     */
    UNCOMMITTED("uncommitted"),

    /**
     * Enum value all.
     */
    ALL("all");

    /**
     * The actual serialized value for a BlockListType instance.
     */
    private final String value;

    BlockListType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a BlockListType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed BlockListType object, or null if unable to parse.
     */
    @JsonCreator
    public static BlockListType fromString(String value) {
        BlockListType[] items = BlockListType.values();
        for (BlockListType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
