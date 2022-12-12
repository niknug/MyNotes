package ru.niknug.android.mynotes

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime
import java.util.*

@Entity
data class Book(@PrimaryKey val id: UUID, val title: String, val publicationDate: DateTime, var isRead: Boolean, val authorId: UUID)