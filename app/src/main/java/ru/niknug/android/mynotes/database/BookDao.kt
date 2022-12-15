package ru.niknug.android.mynotes.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.niknug.android.mynotes.Book
import java.util.*

@Dao
interface BookDao {

    @Query("SELECT * FROM book")
    fun getBooks(): Flow<List<Book>>

    @Query("SELECT * FROM book WHERE id=(:id)")
    suspend fun getBook(id: UUID): Book
}