package com.omaradev.coinpaprika_app.domain.model.all_coins

data class AllCoins (
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)