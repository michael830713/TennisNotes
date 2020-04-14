package com.mike.tennisnotes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mike.tennisnotes.R
import com.mike.tennisnotes.ui.adapters.MainAdapter
import com.mike.tennisnotes.ui.model.Note

class HomeFragment : Fragment() {

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
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        mRecyclerView = root.findViewById(R.id.notes)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = MainAdapter(items, container!!.context)




        return root
    }
}
