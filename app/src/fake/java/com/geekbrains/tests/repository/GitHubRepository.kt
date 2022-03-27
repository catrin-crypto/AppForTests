package com.geekbrains.tests.repository

import com.geekbrains.tests.model.SearchResponse
import com.geekbrains.tests.presenter.RepositoryContract
import io.reactivex.Observable
import retrofit2.Response

class GitHubRepository : RepositoryContract {

    override fun searchGithub(
        query: String,
        callback: RepositoryCallback
    ) {
        callback.handleGitHubResponse(Response.success(SearchResponse(42, listOf())))
    }

    override fun searchGithub(query: String): Observable<SearchResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun searchGithubAsync(query: String): SearchResponse {
        TODO("Not yet implemented")
    }
}