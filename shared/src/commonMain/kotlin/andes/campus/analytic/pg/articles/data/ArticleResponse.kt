package andes.campus.analytic.pg.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse (
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults:Int,
    @SerialName("articles")
    val articles: List<ArticleRaw>
)