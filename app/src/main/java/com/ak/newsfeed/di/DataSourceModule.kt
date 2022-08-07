package com.ak.newsfeed.di

import com.ak.newsfeed.data.local.source.ILocalDataSource
import com.ak.newsfeed.data.local.source.LocalDataSource
import com.ak.newsfeed.data.remote.source.IRemoteDataSource
import com.ak.newsfeed.data.remote.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DataSourceModule {
// todo @InstallIn activitycomponent is not working
    @Binds
    fun bindRemoteDataSource(remote: RemoteDataSource): IRemoteDataSource

    @Binds
    fun bindLocalDataSource(remote: LocalDataSource): ILocalDataSource

}