package au.com.mamdevsolutions.quotes.framework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.com.mamdevsolutions.core.network.api.ApiService
import au.com.mamdevsolutions.core.network.api.RetrofitClient
import au.com.mamdevsolutions.core.network.model.GetCategories

import au.com.mamdevsolutions.core.network.model.QuoteEntity
import au.com.mamdevsolutions.core.repository.CategoryRepository
import au.com.mamdevsolutions.core.repository.QuoteRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val categoryRepository: CategoryRepository,
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    private val _categories = MutableLiveData<GetCategories>()

    private val _quote = MutableLiveData<QuoteEntity>()

    val categories: LiveData<GetCategories>
            get() = _categories

    val quote: LiveData<QuoteEntity>
        get() = _quote

    public fun fetchCategories() {
        viewModelScope.launch {
            categoryRepository.getCategories().let {
//                _categories.postValue(it.)
            }
        }
    }

    private fun fetchQuote(category: String) {
//        viewModelScope.launch {
//            quoteRepository.getQuote(category).let {
//                _quote.postValue(it)
//            }
//        }
    }
}