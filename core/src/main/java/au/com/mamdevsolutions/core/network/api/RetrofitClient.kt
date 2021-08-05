package au.com.mamdevsolutions.core.network.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {
    fun getRetrofit() : Retrofit {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("http://quotes.rest/")
            .client(client)
            .build()
    }
}
