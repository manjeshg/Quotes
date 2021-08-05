package au.com.mamdevsolutions.core.network.api


import au.com.mamdevsolutions.core.network.model.GetCategories
import au.com.mamdevsolutions.core.network.model.QuoteEntity
import retrofit2.Call
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getCategories(): Call<GetCategories> {
        return apiService.getCategories()
    }

    override suspend fun getQuote(category: String): Response<QuoteEntity> {
        return apiService.getQuote(category)
    }
}