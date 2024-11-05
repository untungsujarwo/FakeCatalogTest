package com.untung.fakestoreapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.untung.fakestoreapp.R
import com.untung.fakestoreapp.databinding.FragmentListProductBinding
import com.untung.fakestoreapp.presentation.home.adapter.ListProductAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListProductFragment : Fragment() {


    private val viewModel by viewModel<ListProductViewModel>()
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var adapter: ListProductAdapter

    private var _binding: FragmentListProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentListProductBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

    }

    private fun setupView() = with(binding){
        linearLayoutManager = LinearLayoutManager(requireContext())
        rvBreakingNews.layoutManager = linearLayoutManager

        rvBreakingNews.hasFixedSize()
        lifecycleScope.launch {
            adapter = ListProductAdapter(viewModel.getProduct(), context!!)
            rvBreakingNews.adapter = adapter
        }
        rvBreakingNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
                val lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()
                val itemCount = linearLayoutManager.itemCount
                if (firstVisibleItemPosition != RecyclerView.NO_POSITION) {
                    lifecycleScope.launch {
                        delay(500L)
                        viewModel.lastFirstVisiblePosition = firstVisibleItemPosition
                    }
                }

                if (binding.rvBreakingNews.canScrollVertically(-1)) {
                    // binding.tvAppBar.cardElevation = 20f
                } else {
                    // binding.tvAppBar.cardElevation = 0f
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }


    override fun onResume() {
        super.onResume()
        if (viewModel.lastFirstVisiblePosition != RecyclerView.NO_POSITION) {
            binding.rvBreakingNews.scrollToPosition(viewModel.lastFirstVisiblePosition)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}