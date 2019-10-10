#!/bin/bash

AUTOREST_JAVA_DIR=$1

# Clone the azure rest api spec repo, to get the spec for Azure Search
mkdir azure-rest-api-spec
cd azure-rest-api-spec
git clone https://github.com/Azure/azure-rest-api-specs.git .

# Copy the directories of interest and clean up
cd ..
mkdir 2019-05-06
mkdir 2019-05-06/data
mkdir 2019-05-06/service

cp -r azure-rest-api-spec/specification/search/data-plane/Microsoft.Azure.Search.Data/stable/2019-05-06/* 2019-05-06/data/.
cp -r azure-rest-api-spec/specification/search/data-plane/Microsoft.Azure.Search.Service/stable/2019-05-06/* 2019-05-06/service/.
rm -rf azure-rest-api-spec

# Generate the data api
autorest --use=$AUTOREST_JAVA_DIR ./data-readme.md
mv ../azure-search/src/main/java/com/azure/search/Documents.java ../azure-search/src/main/java/com/azure/search/implementation/Documents.java
mv ../azure-search/src/main/java/com/azure/search/SearchIndexRestClient.java ../azure-search/src/main/java/com/azure/search/implementation/SearchIndexRestClient.java

# Generate the service api
autorest --use=$AUTOREST_JAVA_DIR ./service-readme.md

# Cleanup
rm -rf 2019-05-06
