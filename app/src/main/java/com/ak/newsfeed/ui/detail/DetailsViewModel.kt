package com.ak.newsfeed.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ak.newsfeed.domain.usecase.GetNewsDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsDetail: GetNewsDetail,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var detailState: MutableStateFlow<NewsDetailState> = MutableStateFlow(NewsDetailState())
        private set
    val id = savedStateHandle.get<String>("articleUrl") ?: throw IllegalStateException("No id found to show details")

    init {
        fetchDetails(id)
    }

    private fun fetchDetails(id: String) {
        viewModelScope.launch {
            val article = newsDetail(id)
            detailState.update {
                it.copy(article = article)
            }
        }
    }
}
