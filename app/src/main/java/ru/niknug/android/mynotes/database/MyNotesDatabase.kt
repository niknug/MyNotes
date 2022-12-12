package ru.niknug.android.mynotes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.niknug.android.mynotes.Author
import ru.niknug.android.mynotes.Book

@Database(entities = [Author::class, Book::class], version = 1)
@TypeConverters(MyNotesConverters::class)
abstract class MyNotesDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun authorDao(): AuthorDao
}