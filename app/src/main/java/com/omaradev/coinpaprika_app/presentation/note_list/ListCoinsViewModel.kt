package com.omaradev.coinpaprika_app.presentation.note_list
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omaradev.coinpaprika_app.common.Resource
import com.omaradev.coinpaprika_app.domain.use_case.get_all_coins.GetAllCoinsUseCase
import com.omaradev.coinpaprika_app.presentation.note_list.ListCoinState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListCoinsViewModel @Inject constructor( val getAllCoinsUseCase: GetAllCoinsUseCase) :ViewModel(){
    private val _state = mutableStateOf(ListCoinState())
    val state : State<ListCoinState> =_state

    init {
        getCoins()
    }
    private fun getCoins(){
        getAllCoinsUseCase().onEach { response->
            when(response){
                is Resource.Success->{
                     _state.value = ListCoinState(coins = response.data ?: emptyList())
                }
                is Resource.Error->{
                   _state.value= ListCoinState(error = response.message ?: "unexpected error")
                }
                is Resource.Loading->{
                    _state.value= ListCoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}