package com.omaradev.coinpaprika_app.data.remote

import com.omaradev.coinpaprika_app.data.remote.dto.all_coins.AllCoinsDto
import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.DetailCoinDto
import retrofit2.http.GET
import retrofit2.http.Path
interface Api {
  @GET("v1/coins/")
  suspend fun getAllCoins() :List<AllCoinsDto>

  @GET("v1/coins/{coin_id}")
  suspend fun getCoinById(@Path("coin_id") coinId:String) :DetailCoinDto
}