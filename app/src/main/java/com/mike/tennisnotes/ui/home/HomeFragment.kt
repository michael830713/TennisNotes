package com.mike.tennisnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mike.tennisnotes.R
import com.mike.tennisnotes.databinding.FragmentHomeBinding
import com.mike.tennisnotes.ui.adapters.MainAdapter
import com.mike.tennisnotes.ui.model.Note

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var mRecyclerView: RecyclerView
    val items = listOf(
        "apple",
        "banana",
        "cherry",
        "durian",
        "grape",
        "honeydew melon",
        "lemon",
        "orange",
        "kiwi fruit",
        "papaya",
        "tangerine",
        "watermelon"
    )


    var threeDayForecast = mutableListOf<Note>(
        Note("first"),
        Note("first"),
        Note("first"),
        Note("first"),
        Note("first"),
        Note("first"),
        Note("first"),
        Note("first")

    )

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.notes.layoutManager = LinearLayoutManager(activity)
        val adapter = MainAdapter()
        adapter.submitList(items)
        binding.notes.adapter = adapter

        return binding.root


    }
}
