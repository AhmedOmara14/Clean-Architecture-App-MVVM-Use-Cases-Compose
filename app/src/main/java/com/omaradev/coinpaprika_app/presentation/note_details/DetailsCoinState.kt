package com.omaradev.coinpaprika_app.presentation.note_details

import com.omaradev.coinpaprika_app.domain.model.detail_coin.DetailCoin

data class DetailsCoinState (
    val isLoading:Boolean=false,
    val detailsCoin: DetailCoin?=null,
    val error:String="",
)