package ru.niknug.android.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import java.util.*

private const val TAG = "AuthorListViewModel"

class AuthorListViewModel : ViewModel() {
    private val myNotesRepository = MyNotesRepository.get()

    private val _authors: MutableStateFlow<List<Author>> = MutableStateFlow(emptyList())

    val authors: StateFlow<List<Author>>
        get() = _authors.asStateFlow()

    init {
        viewModelScope.launch {
            myNotesRepository.getAuthors().collect() {
                _authors.value = it
            }
        }
    }
}