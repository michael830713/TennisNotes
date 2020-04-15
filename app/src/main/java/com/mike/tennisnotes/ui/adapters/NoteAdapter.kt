package com.mike.tennisnotes.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mike.tennisnotes.R
import com.mike.tennisnotes.data.TennisNote
import com.mike.tennisnotes.databinding.NoteViewholderBinding
import com.mike.tennisnotes.viewmodels.NotesViewModel

class MainAdapter :
    ListAdapter<TennisNote, MainAdapter.ViewHolder>(GardenPlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.note_viewholder, parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: NoteViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                Toast.makeText(view.context, binding?.viewModel?.title, Toast.LENGTH_LONG).show()
            }
        }

        fun bind(notes: TennisNote) {
            with(binding) {
                viewModel = NotesViewModel(notes)
                executePendingBindings()
            }
        }
    }
}

private class GardenPlantDiffCallback : DiffUtil.ItemCallback<TennisNote>() {
    override fun areItemsTheSame(oldItem: TennisNote, newItem: TennisNote): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TennisNote, newItem: TennisNote): Boolean {
        return oldItem.title == newItem.title

    }


}