package com.omaradev.coinpaprika_app.domain.use_case.get_all_coins

import com.omaradev.coinpaprika_app.common.Resource
import com.omaradev.coinpaprika_app.data.remote.dto.all_coins.toCoin
import com.omaradev.coinpaprika_app.domain.model.all_coins.AllCoins
import com.omaradev.coinpaprika_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCoinsUseCase @Inject constructor(val repository: CoinRepository) {
    operator fun invoke():Flow<Resource<List<AllCoins>>> = flow {
        try {
            emit(Resource.Loading<List<AllCoins>>())
            val coins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<AllCoins>>(e.localizedMessage ?: "an Error Occurred"))
        }catch (e:IOException){
            emit(Resource.Error<List<AllCoins>>("No Internet Connection, Check your Internet"))
        }
    }
}