package com.ak.newsfeed.ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.ui.home.HomeScreen

@Composable
internal fun NavGraph(
    openWebCustomTab: (article: NewsArticle, color: Int) -> Unit
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {
        composable(route = ScreenRoute.Home.route) {
            val primaryInt = MaterialTheme.colorScheme.primary.toArgb()
            HomeScreen(
                onNewsClick = { article ->
                    openWebCustomTab(article, primaryInt)
                }
            )
        }
    }
}