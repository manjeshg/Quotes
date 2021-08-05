package au.com.mamdevsolutions.quotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import au.com.mamdevsolutions.core.network.api.ApiHelper
import au.com.mamdevsolutions.core.network.api.ApiHelperImpl
import au.com.mamdevsolutions.core.network.api.ApiService
import au.com.mamdevsolutions.core.network.api.RetrofitClient
import au.com.mamdevsolutions.core.network.model.GetCategories

import au.com.mamdevsolutions.core.network.model.QuoteEntity
import au.com.mamdevsolutions.core.repository.CategoryRepository
import au.com.mamdevsolutions.core.repository.QuoteRepository
import au.com.mamdevsolutions.quotes.R
import au.com.mamdevsolutions.quotes.framework.MainViewModel
import au.com.mamdevsolutions.quotes.framework.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_quote.*
import kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy


class QuoteFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var apiService = RetrofitClient.getRetrofit().create(ApiService::class.java)

        var factory = MainViewModelFactory(CategoryRepository(ApiHelperImpl(apiService)), QuoteRepository(ApiHelperImpl(apiService)))

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

//        Toast.makeText(requireActivity().applicationContext, "Test", Toast.LENGTH_SHORT).show()

        setupObserver()

        fetchButton.setOnClickListener(View.OnClickListener {
            viewModel.fetchCategories()
        })

    }

    private fun setupObserver() {
        val categoryListObserver = Observer<GetCategories> { categoryEntity ->
            Toast.makeText(requireActivity().applicationContext, categoryEntity.baseurl, Toast.LENGTH_SHORT)
        }

        viewModel.categories.observe(viewLifecycleOwner, categoryListObserver)
    }
}

