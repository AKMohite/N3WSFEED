package com.ak.newsfeed.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ak.newsfeed.R

@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
private fun HomeContent() {
    BreakingNews()
}

@Composable
fun BreakingNews(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(text = stringResource(id = R.string.app_name))
        }
    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun HomeContentPreview() {
    HomeContent()
}