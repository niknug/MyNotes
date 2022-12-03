package ru.niknug.android.mynotes

import org.joda.time.DateTime
import java.util.*

data class Book(val id: UUID, val title: String, val publicationDate: DateTime, var isRead: Boolean, val authorId: UUID)