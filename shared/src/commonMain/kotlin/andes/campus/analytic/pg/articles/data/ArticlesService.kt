package andes.campus.analytic.pg.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


class ArticlesService(private val httpClient: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "b364967422fb4df5a3ca57918c6c90f4"

    suspend fun fetchArticles(): List<ArticleRaw>{
        val response: ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}