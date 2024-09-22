package andes.campus.analytic.pg.articles.application

import andes.campus.analytic.pg.articles.data.ArticleRaw
import andes.campus.analytic.pg.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val repository: ArticlesRepository) {

    suspend fun getArticles(forceFetch:Boolean): List<Article>{
        val articlesRaw = repository.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>):List<Article> = articleRaw.map{
        raw ->
        Article(
            raw.title,
            raw.desc ?: "Click to find out more!",
            getDaysAgoString(raw.date),
            raw.imageURL ?: "https://cdn.abcotvs.com/dip/images/15300346_tesla-fire.png?w=1600",
        )
    }

    private fun getDaysAgoString(date: String) : String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return  result
    }
}