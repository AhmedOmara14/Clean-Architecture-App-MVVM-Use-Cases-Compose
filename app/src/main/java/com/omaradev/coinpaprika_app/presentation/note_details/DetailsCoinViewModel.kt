package com.omaradev.coinpaprika_app.presentation.note_details
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omaradev.coinpaprika_app.common.Constants
import com.omaradev.coinpaprika_app.common.Resource
import com.omaradev.coinpaprika_app.domain.use_case.get_all_coins.GetAllCoinsUseCase
import com.omaradev.coinpaprika_app.domain.use_case.get_details_coin.GetDetailsCoinUseCase
import com.omaradev.coinpaprika_app.presentation.note_list.ListCoinState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsCoinViewModel (
    @Inject val getDetailsCoinUseCase: GetDetailsCoinUseCase,
    savedStateHandle: SavedStateHandle
    ) :ViewModel(){
    private val _state = mutableStateOf(DetailsCoinState())
    val state : State<DetailsCoinState> =_state
    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let { coinId->
            getCoinById(coinId)
        }
    }
    private fun getCoinById(coinId:String){
        getDetailsCoinUseCase(coinId).onEach { response->
            when(response){
                is Resource.Success->{
                     _state.value = DetailsCoinState(detailsCoin = response.data)
                }
                is Resource.Error->{
                   _state.value= DetailsCoinState(error = response.message ?: "unexpected error")
                }
                is Resource.Loading->{
                    _state.value= DetailsCoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}