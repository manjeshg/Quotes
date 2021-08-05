package au.com.mamdevsolutions.quotes.framework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import au.com.mamdevsolutions.core.network.api.ApiService
import au.com.mamdevsolutions.core.repository.CategoryRepository
import au.com.mamdevsolutions.core.repository.QuoteRepository

class MainViewModelFactory(
    private val categoryRepository: CategoryRepository,
    private val quoteRepository: QuoteRepository,
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return MainViewModel(categoryRepository, quoteRepository) as T
    }
}