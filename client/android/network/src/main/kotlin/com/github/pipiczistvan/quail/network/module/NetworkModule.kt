package com.github.pipiczistvan.quail.network.module

import com.github.pipiczistvan.quail.common.utils.JsonDateAdapter
import com.github.pipiczistvan.quail.network.rest.api.PreloadApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideHttpClient(interceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideRetroFit(client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(com.github.pipiczistvan.quail.network.utils.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(JsonDateAdapter()).build()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build();

    @Provides
    @Singleton
    fun providePreloadApi(retrofit: Retrofit) =
        retrofit.create(PreloadApi::class.java)
}
