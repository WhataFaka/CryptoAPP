package kityukha.kotlin.cryptoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import kityukha.kotlin.cryptoapp.pojo.CoinPriceInfo

@Dao
interface CoinPriceInfoDao {
    @Query("SELECT*FROM full_price_list ORDER BY lastUpdate DESC ")
    fun getPriceList(): LiveData<List<CoinPriceInfo>>

    @Query("SELECT*FROM full_price_list WHERE fromSymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String): LiveData<CoinPriceInfo>

    @Insert(onConflict = REPLACE)
    fun insertPriceList(priceList: List<CoinPriceInfo>)
}