package com.omaradev.coinpaprika_app.presentation.note_list

import com.omaradev.coinpaprika_app.domain.model.all_coins.AllCoins

data class ListCoinState (
    val isLoading:Boolean =false,
    val coins:List<AllCoins> = emptyList(),
    val error:String =""
)