package au.com.mamdevsolutions.core.repository

import au.com.mamdevsolutions.core.data.Quote

interface QuoteDataSource {
    suspend fun getQuote(category: String): Quote
}