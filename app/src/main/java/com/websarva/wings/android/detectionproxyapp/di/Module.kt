package com.websarva.wings.android.detectionproxyapp.di

import com.websarva.wings.android.detectionproxyapp.repository.HttpConnectRepository
import com.websarva.wings.android.detectionproxyapp.repository.HttpConnectRepositoryClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class Module {
    @Singleton
    @Binds
    abstract fun bindHttpConnectRepository(httpConnectRepositoryClient: HttpConnectRepositoryClient): HttpConnectRepository
}