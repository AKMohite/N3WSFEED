package com.ak.newsfeed.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.ui.theme.NewsFeedTheme

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val viewState by viewModel.homeState.collectAsState()
    HomeContent(
        viewState = viewState
    )
}

@Composable
private fun HomeContent(
    viewState: HomeViewState,
    modifier: Modifier = Modifier
) {
    BreakingNews(
        newsArticles = viewState.newsArticles,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun BreakingNews(
    modifier: Modifier = Modifier,
    newsArticles: List<NewsArticle>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = newsArticles, key = NewsArticle::url) { article ->
            NewsItem(article)
        }
    }
}

@Composable
fun NewsItem(
    article: NewsArticle,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Image(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .padding(4.dp),
            painter = rememberAsyncImagePainter(article.newsImage),
            contentDescription = article.content
        )
        Column {
            Text(text = article.source)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = article.title)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = article.publishedAt)
        }
    }
}

@Preview(
    name = "Night Mode",
    group = "success",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    group = "success",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun HomeContentPreview() {
    NewsFeedTheme {
        HomeContent(
            HomeViewState(
                newsArticles = listOf(
                    NewsArticle(
                        "title 1",
                        "author 1",
                        "imgUrl",
                        "content 1",
                        "content url1",
                        "1st August",
                        "Times of India"
                    ),
                    NewsArticle(
                        "title 2",
                        "author 2",
                        "imgUrl",
                        "content 2",
                        "content url2",
                        "1st August",
                        "Times of India"
                    ),
                    NewsArticle(
                        "title 3",
                        "author 3",
                        "imgUrl",
                        "content 3",
                        "content url3",
                        "1st August",
                        "Times of India"
                    )
                )
            )
        )
    }
}