package ru.niknug.android.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*

class AuthorDetailViewModel(authorId: UUID) : ViewModel() {
    private val myNotesRepository = MyNotesRepository.get()

    private val _author: MutableStateFlow<Author?> = MutableStateFlow(null)
    val author: StateFlow<Author?> = _author.asStateFlow()
    init {
        viewModelScope.launch {
            _author.value = myNotesRepository.getAuthor(authorId)
        }
    }

    fun updateAuthor(onUpdate: (Author) -> Author) {
        _author.update { oldAuthor ->
            oldAuthor?.let { onUpdate(it) }
        }
    }

    override fun onCleared() {
        super.onCleared()

        author.value?.let { myNotesRepository.updateAuthor(it) }
    }
}

class AuthorDetailViewModelFactory(private val authorId: UUID) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthorDetailViewModel(authorId) as T
    }
}