package com.example.newsapp.domain.entities

sealed class DataItem {
    data class NewsEntity(
        val title: String,
        val content: String,
        val imageUrl: String,
        val publishedAt: String,
        val url: String,
    ) : DataItem()

    data class Header(
        val imageUrl: String = "https://sun6-21.userapi.com/impg/GNstZzl1VD7I58NSxK4axsSuCa98N5TxvDI0DA/lhbKtA7qbn4.jpg?size=1114x495&quality=95&sign=62b82c82c48c6d5090cdf67964fb71d7&c_uniq_tag=LqsYUd1FKYbJ8dhy08hs5eDsz9FSqklnt81UM5kigig&type=album"
    ) : DataItem()

}