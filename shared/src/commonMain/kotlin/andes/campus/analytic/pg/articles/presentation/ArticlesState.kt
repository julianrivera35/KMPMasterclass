package andes.campus.analytic.pg.articles.presentation

import andes.campus.analytic.pg.articles.application.Article

data class ArticlesState (
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
