package ru.niknug.android.mynotes

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.niknug.android.mynotes.database.MyNotesDatabase
import java.util.UUID

private const val DATABASE_NAME = "mynotes-database"

class MyNotesRepository private constructor(context: Context) {

    private val coroutineScope: CoroutineScope = GlobalScope

    private val database: MyNotesDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            MyNotesDatabase::class.java,
            DATABASE_NAME
        )
        .build()

    fun getAuthors(): Flow<List<Author>> = database.authorDao().getAuthors()

    suspend fun getAuthor(id: UUID): Author = database.authorDao().getAuthor(id)

    fun updateAuthor(author: Author) {
        coroutineScope.launch {
            database.authorDao().updateAuthor(author)
        }
    }

    suspend fun addAuthor(author: Author) {
        database.authorDao().addAuthor(author)
    }

    companion object {
        private var INSTANCE: MyNotesRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = MyNotesRepository(context)
            }
        }

        fun get(): MyNotesRepository {
            return INSTANCE ?: throw IllegalStateException("MyNotesRepository must be initialized")
        }
    }
}