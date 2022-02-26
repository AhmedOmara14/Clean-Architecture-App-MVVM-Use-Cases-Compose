package com.omaradev.coinpaprika_app.di
import com.omaradev.coinpaprika_app.common.Constants.BASE_URL
import com.omaradev.coinpaprika_app.data.remote.Api
import com.omaradev.coinpaprika_app.data.repository.CoinRepositoryImpl
import com.omaradev.coinpaprika_app.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() :Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: Api):CoinRepository{
        return CoinRepositoryImpl(api)
    }

}