package com.ak.newsfeed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.ui.home.HomeScreen
import com.ak.newsfeed.ui.navigation.NavGraph
import com.ak.newsfeed.ui.navigation.ScreenRoute
import com.ak.newsfeed.ui.theme.NewsFeedTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NewsFeedTheme {
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemUiColor = rememberSystemUiController()
                SideEffect {
                    systemUiColor.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(
                        openWebCustomTab = { article, color ->
                            openWebCustomTab(article, color)
                        }
                    )
                }
            }
        }
    }

    private fun openWebCustomTab(article: NewsArticle, @ColorInt toResInt: Int) {
        val intent = CustomTabsIntent.Builder()
            .setDefaultColorSchemeParams(
                CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(toResInt)
                    .build()
            ).setColorSchemeParams(
                CustomTabsIntent.COLOR_SCHEME_DARK, CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(toResInt)
                    .build()
            )
//            .setStartAnimations(this@MainActivity, R.anim.slide_in_right, R.anim.slide_out_left)
//            .setExitAnimations(this@MainActivity, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            .setUrlBarHidingEnabled(true)
            .setShowTitle(true)
//            .setCloseButtonIcon(toBitmap(myCustomCloseIcon))
            .build()
        intent.intent.putExtra(
            Intent.EXTRA_REFERRER,
            Uri.parse("android-app://$packageName"))
        intent.launchUrl(this@MainActivity, Uri.parse(article.url))
    }
}
