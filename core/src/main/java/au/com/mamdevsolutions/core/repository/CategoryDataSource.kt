package au.com.mamdevsolutions.core.repository

import au.com.mamdevsolutions.core.data.Category
import au.com.mamdevsolutions.core.network.model.GetCategories

interface CategoryDataSource {
    suspend fun getCategories(): GetCategories
}