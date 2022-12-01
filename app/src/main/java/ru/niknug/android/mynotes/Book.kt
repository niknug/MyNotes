package ru.niknug.android.mynotes

import java.util.*

data class Book(val id: UUID, val title: String, val publicationDate: Date, var isRead: Boolean, val authorId: UUID)