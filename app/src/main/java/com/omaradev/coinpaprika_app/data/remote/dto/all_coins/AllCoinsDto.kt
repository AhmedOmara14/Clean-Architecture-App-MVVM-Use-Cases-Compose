package com.omaradev.coinpaprika_app.data.remote.dto.all_coins

import com.omaradev.coinpaprika_app.domain.model.all_coins.AllCoins

data class AllCoinsDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun AllCoinsDto.toCoin() :AllCoins{
    return AllCoins(
        id, is_active, name, rank, symbol
    )
}