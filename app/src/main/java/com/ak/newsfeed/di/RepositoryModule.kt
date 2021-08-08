package com.ak.newsfeed.di

import com.ak.newsfeed.data.repository.INewsRepository
import com.ak.newsfeed.data.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
// todo @InstallIn activitycomponent is not working

    @Binds
    fun bindNewsRepository(repo: NewsRepository): INewsRepository

}