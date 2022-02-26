package com.omaradev.coinpaprika_app.domain.use_case.get_details_coin

import com.omaradev.coinpaprika_app.common.Resource
import com.omaradev.coinpaprika_app.data.remote.dto.detail_coin.toDetailCoin
import com.omaradev.coinpaprika_app.domain.model.detail_coin.DetailCoin
import com.omaradev.coinpaprika_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDetailsCoinUseCase(@Inject val repository: CoinRepository) {
    operator fun invoke(coinId:String):Flow<Resource<DetailCoin>> = flow{
        try {
            emit(Resource.Loading())
            val detailCoin = repository.getCoinById(coinId).toDetailCoin()
            emit(Resource.Success(detailCoin))
        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"un Expected Error"))
        }
        catch (e: IOException){
            emit(Resource.Error("No Internet Connection, Check your Internet"))

        }
    }
}