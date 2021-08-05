package au.com.mamdevsolutions.core.network.api


import au.com.mamdevsolutions.core.network.model.GetCategories
import au.com.mamdevsolutions.core.network.model.QuoteEntity
import retrofit2.Call
import retrofit2.Response

interface ApiHelper {
    suspend fun getCategories(): Call<GetCategories>
    suspend fun getQuote(category: String): Response<QuoteEntity>
}