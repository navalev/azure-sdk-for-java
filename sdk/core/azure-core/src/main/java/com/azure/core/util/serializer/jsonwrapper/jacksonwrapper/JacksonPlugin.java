// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.core.util.serializer.jsonwrapper.jacksonwrapper;


import com.azure.core.util.serializer.jsonwrapper.api.JsonApi;
import com.azure.core.util.serializer.jsonwrapper.spi.JsonPlugin;

/**
 * JacksonPlugin for jsonwrapper
 */
public class JacksonPlugin implements JsonPlugin {
    @Override
    public Class<? extends JsonApi> getType() {
        return JacksonDeserializer.class;
    }

    @Override
    public JsonApi newInstance() {
        return new JacksonDeserializer();
    }
}
