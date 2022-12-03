package ru.niknug.android.mynotes

import java.util.*
import org.joda.time.DateTime

data class Author(val id: UUID, val name: String, val dateOfBirth: DateTime, val dateOfDeath: DateTime)