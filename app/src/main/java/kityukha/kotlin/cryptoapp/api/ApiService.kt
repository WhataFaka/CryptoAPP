package kityukha.kotlin.cryptoapp.api

import io.reactivex.Single
import kityukha.kotlin.cryptoapp.pojo.CoinInfoListOfData
import kityukha.kotlin.cryptoapp.pojo.CoinPriceInfoRawData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "25d03feeb371a453a7b9bf3d23093372a8336261325307d7d91daa686e819df0",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tsym: String = CURRENCY

    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "25d03feeb371a453a7b9bf3d23093372a8336261325307d7d91daa686e819df0",
        @Query(QUERY_PARAM_TO_SYMBOLS) tsyms: String = CURRENCY,
        @Query(QUERY_PARAM_FROM_SYMBOL) fsyms: String
    ): Single<CoinPriceInfoRawData>

    companion object {
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOL = "fsyms"

        private const val CURRENCY = "USD"
    }

}