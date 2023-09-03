package com.ak.newsfeed.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.ak.newsfeed.R
import com.ak.newsfeed.domain.model.NewsArticle

@Composable
fun HomeScreen(
    onNewsClick: (NewsArticle) -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val viewState by viewModel.homeState.collectAsState()
    HomeContent(
        viewState = viewState,
        onNewsClick = onNewsClick
    )
}

@Composable
private fun HomeContent(
    viewState: HomeViewState,
    modifier: Modifier = Modifier,
    onNewsClick: (NewsArticle) -> Unit,
) {
    BreakingNews(
        newsArticles = viewState.newsArticles,
        modifier = modifier.fillMaxSize(),
        onNewsClick = onNewsClick
    )
}

@Composable
fun BreakingNews(
    modifier: Modifier = Modifier,
    newsArticles: List<NewsArticle>,
    onNewsClick: (NewsArticle) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = newsArticles, key = NewsArticle::url) { article ->
            NewsItem(
                article = article,
                onNewsClick = onNewsClick
            )
        }
    }
}

@Composable
fun NewsItem(
    article: NewsArticle,
    onNewsClick: (NewsArticle) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .clickable(onClick = { onNewsClick(article) })
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)


    ) {
        Image(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                model = article.newsImage,
                placeholder = painterResource(id = R.drawable.ic_baseline_news_24),
                error = painterResource(id = R.drawable.ic_baseline_news_24)
            ),
            contentDescription = article.content
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(4.dp)
                .align(Alignment.Bottom)
        ) {
            Text(
                text = article.source,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.6f),
                    fontSize = 14.sp
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = article.title,
                maxLines = 2,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = article.getReadableDate(),
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontWeight = FontWeight.Light
                )
            )
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
    Surface {
        HomeContent(
            HomeViewState(
                newsArticles = listOf(
                    NewsArticle(
                        "title 1",
                        "author 1",
                        "imgUrl",
                        "content 1",
                        "content url1",
                        "2021-04-07T01:08:45Z",
                        "Times of India"
                    ),
                    NewsArticle(
                        "title 2",
                        "author 2",
                        "imgUrl",
                        "content 2",
                        "content url2",
                        "2021-04-06T23:34:00Z",
                        "Times of India"
                    ),
                    NewsArticle(
                        "title 3",
                        "author 3",
                        "imgUrl",
                        "content 3",
                        "content url3",
                        "2021-04-06T23:34:00Z",
                        "Times of India"
                    )
                )
            ),
            onNewsClick = {}
        )
    }
}