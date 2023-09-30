package com.ak.newsfeed.ui.navigation

internal sealed class ScreenRoute(
    val route: String
) {
    object Home : ScreenRoute(route = "home-screen")

    object Search : ScreenRoute(route = "search-screen")

    object Bookmark : ScreenRoute(route = "bookmark-screen")

    object Details : ScreenRoute(route = "details-screen")
}