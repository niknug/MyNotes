package ru.niknug.android.mynotes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.niknug.android.mynotes.Author
import ru.niknug.android.mynotes.Book

@Database(entities = [Author::class, Book::class], version = 1)
abstract class MyNotesDatabase : RoomDatabase() {
}