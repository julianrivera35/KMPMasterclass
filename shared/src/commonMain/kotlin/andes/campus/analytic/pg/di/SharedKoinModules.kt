package andes.campus.analytic.pg.di

import andes.campus.analytic.pg.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)