package ru.niknug.android.mynotes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

private const val TAG = "AuthorListFragment"

class AuthorListFragment : Fragment() {

    private val authorListViewModel: AuthorListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total authors: ${authorListViewModel.authors.size}")
    }

}