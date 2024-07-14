package com.ak.newsfeed.ui.detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ak.newsfeed.R
import com.ak.newsfeed.domain.model.NewsArticle
import com.ak.newsfeed.ui.theme.NewsFeedTheme

@Composable
fun NewsDetailsScreen(
    state: NewsDetailState,
    onUrlClick: (String) -> Unit
) {
    NewsDetailContent(
        state = state,
        onUrlClick = onUrlClick
    )
}

@Composable
private fun NewsDetailContent(
    state: NewsDetailState,
    modifier: Modifier = Modifier,
    onUrlClick: (String) -> Unit
) {
    AnimatedVisibility(visible = state.article != null) {
        ArticleDetail(
            article = state.article!!,
            onUrlClick = onUrlClick
        )
    }
}

@Composable
fun ArticleDetail(
    article: NewsArticle,
    modifier: Modifier = Modifier,
    onUrlClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(4.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                model = article.newsImage,
                placeholder = painterResource(id = R.drawable.ic_baseline_news_24),
                error = painterResource(id = R.drawable.ic_baseline_news_24)
            ),
            contentDescription = article.title
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.source,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                .align(Alignment.End),
            text = article.getReadableDate(),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = article.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = article.content,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .clickable { onUrlClick(article.url) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = article.url)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = article.url,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
//        todo add categories
    }
}

@Preview
@Composable
private fun NewsDetailContentPreview() {
    NewsFeedTheme {
        Surface {
            NewsDetailContent(
                state = NewsDetailState(
                        article = NewsArticle(
                            "title 1",
                            "author 1",
                            "imgUrl",
                            "content 1",
                            "content url1",
                            "2021-04-07T01:08:45Z",
                            "Times of India"
                        )
                    ),
                onUrlClick = {}
            )
        }
    }
}
