package andes.campus.analytic.pg.articles.di

import andes.campus.analytic.pg.articles.data.ArticlesDataSource
import andes.campus.analytic.pg.articles.data.ArticlesRepository
import andes.campus.analytic.pg.articles.data.ArticlesService
import andes.campus.analytic.pg.articles.application.ArticlesUseCase
import andes.campus.analytic.pg.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService>{ ArticlesService(get()) }
    single<ArticlesUseCase>{ ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository>{ ArticlesRepository(get(),get()) }
}