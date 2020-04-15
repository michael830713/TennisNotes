package com.mike.tennisnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mike.tennisnotes.data.TennisNote
import com.mike.tennisnotes.databinding.FragmentHomeBinding
import com.mike.tennisnotes.ui.adapters.MainAdapter
import com.mike.tennisnotes.ui.model.Note

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

val url="https://upload.wikimedia.org/wikipedia/commons/8/8e/Roger_Federer_2012_Indian_Wells.jpg"
    val items = listOf(

        TennisNote("apple",url),
        TennisNote("banana",url),
        TennisNote("cherry",url),
        TennisNote("durian",url),
        TennisNote("grape",url),
        TennisNote("honeydew melon",url),
        TennisNote("lemon",url),
        TennisNote("orange",url),
        TennisNote("kiwi fruit",url),
        TennisNote("papaya",url),
        TennisNote("tangerine",url),
        TennisNote("watermelon",url)
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.notes.layoutManager = LinearLayoutManager(activity)
        val adapter = MainAdapter()
        adapter.submitList(items)
        binding.notes.adapter = adapter

        return binding.root


    }
}
