// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.data.cosmos;

import com.azure.data.cosmos.internal.AsyncDocumentClient;
import com.google.common.base.Strings;
import org.testng.ITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public abstract class DocumentClientTest implements ITest {

    private final AsyncDocumentClient.Builder clientBuilder;
    private String testName;

    public DocumentClientTest() {
         this(new AsyncDocumentClient.Builder());
    }

    public DocumentClientTest(AsyncDocumentClient.Builder clientBuilder) {
        this.clientBuilder = clientBuilder;
    }

    public final AsyncDocumentClient.Builder clientBuilder() {
        return this.clientBuilder;
    }

    @Override
    public final String getTestName() {
        return this.testName;
    }

    @BeforeMethod(alwaysRun = true)
    public final void setTestName(Method method) {
        String testClassAndMethodName = Strings.lenientFormat("%s::%s",
                method.getDeclaringClass().getSimpleName(),
                method.getName());

        if (this.clientBuilder.getConnectionPolicy() != null && this.clientBuilder.getConfigs() != null) {
            String connectionMode = this.clientBuilder.getConnectionPolicy().connectionMode() == ConnectionMode.DIRECT
                    ? "Direct " + this.clientBuilder.getConfigs().getProtocol()
                    : "Gateway";

            this.testName = Strings.lenientFormat("%s[%s with %s consistency]",
                    testClassAndMethodName,
                    connectionMode,
                    clientBuilder.getDesiredConsistencyLevel());
        } else {
            this.testName = testClassAndMethodName;
        }
    }

    @AfterMethod(alwaysRun = true)
    public final void unsetTestName() {
        this.testName = null;
    }
}
