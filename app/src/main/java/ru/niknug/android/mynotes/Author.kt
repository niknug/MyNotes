package ru.niknug.android.mynotes

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import org.joda.time.DateTime

@Entity
data class Author(@PrimaryKey val id: UUID, val name: String, val dateOfBirth: DateTime, val dateOfDeath: DateTime)