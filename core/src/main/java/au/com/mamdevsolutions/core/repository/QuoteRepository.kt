package au.com.mamdevsolutions.core.repository

import au.com.mamdevsolutions.core.network.api.ApiHelper
import au.com.mamdevsolutions.core.network.api.ApiService

class QuoteRepository(private val apiHelper: ApiHelper) {
    suspend fun getQuote(category: String) = apiHelper.getQuote(category)
}