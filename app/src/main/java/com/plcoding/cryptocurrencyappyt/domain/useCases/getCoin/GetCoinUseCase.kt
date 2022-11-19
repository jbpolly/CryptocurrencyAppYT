package com.plcoding.cryptocurrencyappyt.domain.useCases.getCoin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.models.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return flow {
            emit(Resource.Loading())
            val coin = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }.flowOn(Dispatchers.IO).catch { cause: Throwable ->
            if (cause is HttpException) {
                emit(Resource.Error(cause.localizedMessage ?: "An unexpected error occurred"))
            } else if (cause is IOException) {
                emit(Resource.Error("Could not reach server. Check your internet connection"))
            }
        }
    }
}