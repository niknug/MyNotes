package ru.niknug.android.mynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import java.util.*

class AuthorListViewModel : ViewModel() {
    val authors = mutableListOf<Author>()

    init {
        viewModelScope.launch {
            authors += loadAuthors()
        }
    }

    suspend fun loadAuthors(): List<Author> {
        val result = mutableListOf<Author>()
        for (i in 0 until 100) {
            val author = Author(
                id = UUID.randomUUID(),
                name = "Author #$i",
                dateOfBirth = DateTime.now(),
                dateOfDeath = DateTime.now()
            )

            result += author
        }
        return result
    }
}