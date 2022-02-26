package com.omaradev.coinpaprika_app.data.remote.dto.detail_coin

import com.omaradev.coinpaprika_app.domain.model.detail_coin.DetailCoin

data class DetailCoinDto(
    val contract: String,
    val contracts: List<Contract>,
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val parent: Parent,
    val platform: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)

fun DetailCoinDto.toDetailCoin() :DetailCoin{
    return DetailCoin(
        description = description,
        id = id,
        is_active = is_active,
        is_new = is_new,
        name = name,
        symbol = symbol,
        tags = tags.map { it.name },
        team = team,
    )
}