package com.example.tmobile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobile.R
import com.example.tmobile.adapter.TMobileHomePageAdapter
import com.example.tmobile.model.TMobileHomePages

class TMobileHomePagesFragment : Fragment() {

    private lateinit var viewModel: TMobileHomePageViewModel
    private var data :TMobileHomePages? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TMobileHomePageAdapter

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
            recyclerView = findViewById(R.id.tmobile_recyclerview)
            recyclerView.layoutManager = LinearLayoutManager(context)
            data?.page?.apply {
                adapter = TMobileHomePageAdapter(this.cards)
                recyclerView.adapter = adapter
            }
        }
    }

    /**
     * view model configuration and initialization with repository
     */
    private fun configureViewModel() {
        viewModel = ViewModelProvider(this).get(TMobileHomePageViewModel::class.java)
        viewModel.init()
        viewModel.getTMobileHomePageData()

    }

}