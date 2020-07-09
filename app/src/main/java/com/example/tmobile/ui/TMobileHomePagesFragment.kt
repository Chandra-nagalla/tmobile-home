package com.example.tmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobile.R
import com.example.tmobile.adapter.TMobileHomePageAdapter
import com.example.tmobile.repository.ImageDownloaderRepository
import com.example.tmobile.repository.ImageDownloaderRepositoryImpl

class TMobileHomePagesFragment : Fragment() {

    private lateinit var viewModel: TMobileHomePageViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TMobileHomePageAdapter
    private lateinit var imageLoader: ImageDownloaderRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tmobile_home_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureViewModel()
        configureUI(view)
    }

    /**
     * view setup and configuration
     * @param view used to setup widgets
     */
    private fun configureUI(view: View) {
        view.apply {
            imageLoader = ImageDownloaderRepositoryImpl()
            recyclerView = findViewById(R.id.tmobile_recyclerview)
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

    /**
     * view model configuration and initialization with repository
     */
    private fun configureViewModel() {
        viewModel = ViewModelProvider(this).get(TMobileHomePageViewModel::class.java)
        viewModel.getTMobileHomePageData()
        viewModel.tMobileHomePageData.observe(viewLifecycleOwner, Observer {
            adapter = TMobileHomePageAdapter(it.page.cards,imageLoader)
            recyclerView.adapter = adapter

        })

    }

}