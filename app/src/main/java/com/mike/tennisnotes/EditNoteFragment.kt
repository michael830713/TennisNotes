package com.mike.tennisnotes

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mike.tennisnotes.data.TennisNoteRepository
import com.mike.tennisnotes.databinding.FragmentEditNoteBinding
import com.mike.tennisnotes.utils.SystemUtils
import com.mike.tennisnotes.utils.SystemUtils.Companion.hideKeyboard

class EditNoteFragment : Fragment() {
    private lateinit var binding: FragmentEditNoteBinding
    private lateinit var editNoteViewModel: EditNoteViewModel
    private lateinit var editNoteViewModelFactory: EditNoteViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            editNoteViewModelFactory =
                EditNoteViewModelFactory(
                    TennisNoteRepository(requireContext()),
                    EditNoteFragmentArgs.fromBundle(requireArguments()).imageSource
                )
            editNoteViewModel =
                ViewModelProvider(this, editNoteViewModelFactory).get(EditNoteViewModel::class.java)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentEditNoteBinding.inflate(inflater, container, false).apply {
            viewModel = editNoteViewModel
        }



        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_app_bar, menu);

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show()
                editNoteViewModel.addNoteToDatabase(
                    binding.titleEditText.text.toString(), binding.contentEditText.text.toString()
                )
                hideKeyboard()
                findNavController().navigate(EditNoteFragmentDirections.actionEditNoteFragmentToNavigationHome())
                true
            }
            else -> {
                true
            }
        }
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
