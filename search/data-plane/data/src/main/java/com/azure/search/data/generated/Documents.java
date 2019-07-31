// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

package com.azure.search.data.generated;

import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.implementation.annotation.ReturnType;
import com.azure.core.implementation.annotation.ServiceMethod;
import com.azure.search.data.generated.models.AutocompleteParameters;
import com.azure.search.data.generated.models.AutocompleteRequest;
import com.azure.search.data.generated.models.AutocompleteResult;
import com.azure.search.data.generated.models.DocumentIndexResult;
import com.azure.search.data.generated.models.DocumentSearchResult;
import com.azure.search.data.generated.models.DocumentSuggestResult;
import com.azure.search.data.generated.models.IndexBatch;
import com.azure.search.data.generated.models.SearchParameters;
import com.azure.search.data.generated.models.SearchRequest;
import com.azure.search.data.generated.models.SearchRequestOptions;
import com.azure.search.data.generated.models.SuggestParameters;
import com.azure.search.data.generated.models.SuggestRequest;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * Documents.
 */
public interface Documents {
    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<Long>> countWithRestResponseAsync();

    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Long> countAsync();

    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<Long>> countWithRestResponseAsync(SearchRequestOptions searchRequestOptions);

    /**
     * Queries the number of documents in the Azure Search index.
     *
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Long> countAsync(SearchRequestOptions searchRequestOptions);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSearchResult>> searchGetWithRestResponseAsync();

    /**
     * Searches for documents in the Azure Search index.
     *
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSearchResult> searchGetAsync();

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchText A full-text search query expression; Use "*" or omit this parameter to match all documents.
     * @param searchParameters Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSearchResult>> searchGetWithRestResponseAsync(String searchText, SearchParameters searchParameters, SearchRequestOptions searchRequestOptions);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchText A full-text search query expression; Use "*" or omit this parameter to match all documents.
     * @param searchParameters Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSearchResult> searchGetAsync(String searchText, SearchParameters searchParameters, SearchRequestOptions searchRequestOptions);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSearchResult>> searchPostWithRestResponseAsync(SearchRequest searchRequest);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSearchResult> searchPostAsync(SearchRequest searchRequest);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSearchResult>> searchPostWithRestResponseAsync(SearchRequest searchRequest, SearchRequestOptions searchRequestOptions);

    /**
     * Searches for documents in the Azure Search index.
     *
     * @param searchRequest The definition of the Search request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSearchResult> searchPostAsync(SearchRequest searchRequest, SearchRequestOptions searchRequestOptions);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<Object>> getWithRestResponseAsync(String key);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Object> getAsync(String key);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @param selectedFields List of field names to retrieve for the document; Any field not retrieved will be missing from the returned document.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<Object>> getWithRestResponseAsync(String key, List<String> selectedFields, SearchRequestOptions searchRequestOptions);

    /**
     * Retrieves a document from the Azure Search index.
     *
     * @param key The key of the document to retrieve.
     * @param selectedFields List of field names to retrieve for the document; Any field not retrieved will be missing from the returned document.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<Object> getAsync(String key, List<String> selectedFields, SearchRequestOptions searchRequestOptions);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSuggestResult>> suggestGetWithRestResponseAsync(String searchText, String suggesterName);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSuggestResult> suggestGetAsync(String searchText, String suggesterName);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param suggestParameters Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSuggestResult>> suggestGetWithRestResponseAsync(String searchText, String suggesterName, SuggestParameters suggestParameters, SearchRequestOptions searchRequestOptions);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param searchText The search text to use to suggest documents. Must be at least 1 character, and no more than 100 characters.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param suggestParameters Additional parameters for the operation.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSuggestResult> suggestGetAsync(String searchText, String suggesterName, SuggestParameters suggestParameters, SearchRequestOptions searchRequestOptions);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSuggestResult>> suggestPostWithRestResponseAsync(SuggestRequest suggestRequest);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSuggestResult> suggestPostAsync(SuggestRequest suggestRequest);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentSuggestResult>> suggestPostWithRestResponseAsync(SuggestRequest suggestRequest, SearchRequestOptions searchRequestOptions);

    /**
     * Suggests documents in the Azure Search index that match the given partial query text.
     *
     * @param suggestRequest The Suggest request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentSuggestResult> suggestPostAsync(SuggestRequest suggestRequest, SearchRequestOptions searchRequestOptions);

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentIndexResult>> indexWithRestResponseAsync(IndexBatch batch);

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentIndexResult> indexAsync(IndexBatch batch);

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<DocumentIndexResult>> indexWithRestResponseAsync(IndexBatch batch, SearchRequestOptions searchRequestOptions);

    /**
     * Sends a batch of document write actions to the Azure Search index.
     *
     * @param batch The batch of index actions.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<DocumentIndexResult> indexAsync(IndexBatch batch, SearchRequestOptions searchRequestOptions);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<AutocompleteResult>> autocompleteGetWithRestResponseAsync(String searchText, String suggesterName);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AutocompleteResult> autocompleteGetAsync(String searchText, String suggesterName);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param autocompleteParameters Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<AutocompleteResult>> autocompleteGetWithRestResponseAsync(String searchText, String suggesterName, SearchRequestOptions searchRequestOptions, AutocompleteParameters autocompleteParameters);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param searchText The incomplete term which should be auto-completed.
     * @param suggesterName The name of the suggester as specified in the suggesters collection that's part of the index definition.
     * @param searchRequestOptions Additional parameters for the operation.
     * @param autocompleteParameters Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AutocompleteResult> autocompleteGetAsync(String searchText, String suggesterName, SearchRequestOptions searchRequestOptions, AutocompleteParameters autocompleteParameters);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<AutocompleteResult>> autocompletePostWithRestResponseAsync(AutocompleteRequest autocompleteRequest);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AutocompleteResult> autocompletePostAsync(AutocompleteRequest autocompleteRequest);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<SimpleResponse<AutocompleteResult>> autocompletePostWithRestResponseAsync(AutocompleteRequest autocompleteRequest, SearchRequestOptions searchRequestOptions);

    /**
     * Autocompletes incomplete query terms based on input text and matching terms in the Azure Search index.
     *
     * @param autocompleteRequest The definition of the Autocomplete request.
     * @param searchRequestOptions Additional parameters for the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Mono<AutocompleteResult> autocompletePostAsync(AutocompleteRequest autocompleteRequest, SearchRequestOptions searchRequestOptions);
}
