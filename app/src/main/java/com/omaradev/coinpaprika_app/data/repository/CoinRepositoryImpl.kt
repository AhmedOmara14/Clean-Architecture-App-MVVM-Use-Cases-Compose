package com.omaradev.coinpaprika_app.data.repository

import com.omaradev.coinpaprika_app.data.remote.Api
import com.omaradev.coinpaprika_app.data.remote.dto.all_coins.AllCoinsDto
import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.DetailCoinDto
import com.omaradev.coinpaprika_app.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: Api) :CoinRepository {
    override suspend fun getAllCoins(): List<AllCoinsDto> {
       return api.getAllCoins()
    }

    override suspend fun getCoinById(coinId: String): DetailCoinDto {
        return api.getCoinById(coinId)
    }
}