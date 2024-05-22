package com.ak.newsfeed.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.ui.home.HomeScreen
import com.ak.newsfeed.ui.home.HomeViewModel


data class BottomNavigationItem(
    val icon: ImageVector,
    val text: String
)

@Composable
internal fun NavGraph(
    openWebCustomTab: (article: NewsArticle, color: Int) -> Unit
) {

    val navController = rememberNavController()
    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = Icons.Outlined.Home, text = "Home"),
            BottomNavigationItem(icon = Icons.Outlined.Search, text = "Search"),
            BottomNavigationItem(icon = Icons.Outlined.FavoriteBorder, text = "Bookmark"),
        )
    }

    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {
        composable(route = ScreenRoute.Home.route) {
            val primaryInt = MaterialTheme.colorScheme.primary.toArgb()
            val viewModel: HomeViewModel = hiltViewModel()
            val viewState by viewModel.homeState.collectAsState()
            HomeScreen(
                viewState = viewState,
                onNewsClick = { article ->
                    openWebCustomTab(article, primaryInt)
                }
            )
        }
    }
}