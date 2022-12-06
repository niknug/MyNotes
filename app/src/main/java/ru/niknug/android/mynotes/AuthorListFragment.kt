package ru.niknug.android.mynotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.niknug.android.mynotes.databinding.FragmentAuthorListBinding

private const val TAG = "AuthorListFragment"

class AuthorListFragment : Fragment() {

    private var _binding: FragmentAuthorListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val authorListViewModel: AuthorListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total authors: ${authorListViewModel.authors.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorListBinding.inflate(inflater, container, false)
        binding.authorRecyclerView.layoutManager = LinearLayoutManager(context)

        val authors = authorListViewModel.authors
        val adapter = AuthorListAdapter(authors)
        binding.authorRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}