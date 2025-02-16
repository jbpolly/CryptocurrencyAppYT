package com.plcoding.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.models.Coin

data class CoinDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("is_new")
    val isNew: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("type")
    val type: String?
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id.orEmpty(),
        isActive = isActive ?: false,
        name = name.orEmpty(),
        rank = rank ?: 0,
        symbol = symbol.orEmpty()
    )
}