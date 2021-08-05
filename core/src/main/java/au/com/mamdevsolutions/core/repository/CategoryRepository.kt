package au.com.mamdevsolutions.core.repository

import au.com.mamdevsolutions.core.network.api.ApiHelper

class CategoryRepository(private val apiHelper: ApiHelper) {
    suspend fun getCategories() = apiHelper.getCategories()
}