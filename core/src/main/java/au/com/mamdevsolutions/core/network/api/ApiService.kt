package au.com.mamdevsolutions.core.network.api


import au.com.mamdevsolutions.core.network.model.GetCategories
import au.com.mamdevsolutions.core.network.model.QuoteEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/qod/categories")
    suspend fun getCategories(): Call<GetCategories>

    @GET("/qod?category={category}")
    suspend fun getQuote(@Path(value = "category", encoded = false) category : String): Response<QuoteEntity>
}
