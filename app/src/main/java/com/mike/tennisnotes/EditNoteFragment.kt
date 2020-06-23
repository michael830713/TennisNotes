package com.mike.tennisnotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mike.tennisnotes.databinding.FragmentEditNoteBinding

class EditNoteFragment : Fragment() {
    private lateinit var binding: FragmentEditNoteBinding
    private lateinit var editNoteViewModel: EditNoteViewModel
    private lateinit var viewModelFactory: EditNoteViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModelFactory =
                EditNoteViewModelFactory(EditNoteFragmentArgs.fromBundle(arguments!!).imageSource)
            editNoteViewModel =
                ViewModelProvider(this, viewModelFactory).get(EditNoteViewModel::class.java)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentEditNoteBinding.inflate(inflater, container, false).apply {
            viewModel = editNoteViewModel
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditNoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditNoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
