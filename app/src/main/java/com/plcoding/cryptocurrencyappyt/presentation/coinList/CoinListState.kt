package com.plcoding.cryptocurrencyappyt.presentation.coinList

import com.plcoding.cryptocurrencyappyt.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
