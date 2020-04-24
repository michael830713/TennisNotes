package com.mike.tennisnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mike.tennisnotes.data.TennisNote
import com.mike.tennisnotes.data.TennisNoteRepository
import com.mike.tennisnotes.databinding.FragmentHomeBinding
import com.mike.tennisnotes.ui.adapters.MainAdapter
import com.mike.tennisnotes.ui.model.Note

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeViewModelFactory: HomeViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        homeViewModelFactory = HomeViewModelFactory(TennisNoteRepository(requireContext()))
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.notes.layoutManager = LinearLayoutManager(activity)
        val adapter = MainAdapter()
        subscribeUi(adapter)
        binding.notes.adapter = adapter

        return binding.root


    }

    private fun subscribeUi(adapter: MainAdapter) =
        homeViewModel.notes.observe(viewLifecycleOwner, Observer(adapter::submitList))
}
