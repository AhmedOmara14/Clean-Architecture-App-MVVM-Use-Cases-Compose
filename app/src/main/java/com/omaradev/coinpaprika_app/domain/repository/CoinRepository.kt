package com.omaradev.coinpaprika_app.domain.repository
import com.omaradev.coinpaprika_app.data.remote.dto.all_coins.AllCoinsDto
import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.DetailCoinDto

interface CoinRepository {
    suspend fun getAllCoins():List<AllCoinsDto>
    suspend fun getCoinById(coinId:String):DetailCoinDto
}