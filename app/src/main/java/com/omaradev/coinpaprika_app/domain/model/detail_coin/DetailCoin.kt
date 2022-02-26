package com.omaradev.coinpaprika_app.domain.model.detail_coin

import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.*

data class DetailCoin(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>,
)
