package ru.niknug.android.mynotes

import java.util.*

data class Author(val id: UUID, val name: String, val dateOfBirth: Date, val dateOfDeath: Date?)