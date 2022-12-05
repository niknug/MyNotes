package ru.niknug.android.mynotes

import androidx.lifecycle.ViewModel
import org.joda.time.DateTime
import java.util.*

class AuthorListViewModel : ViewModel() {
    val authors = mutableListOf<Author>()

    init {
        for (i in 0 until 100) {
            val author = Author(
                id = UUID.randomUUID(),
                name = "Author #$i",
                dateOfBirth = DateTime.now(),
                dateOfDeath = DateTime.now()
            )

            authors += author
        }
    }
}