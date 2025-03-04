package andes.campus.analytic.pg.di

import andes.campus.analytic.pg.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel{ ArticlesViewModel(get()) }
}