package ru.niknug.android.mynotes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.niknug.android.mynotes.Author
import java.util.UUID

@Dao
interface AuthorDao {

    @Query("SELECT * FROM author")
    fun getAuthors(): Flow<List<Author>>

    @Query("SELECT * FROM author WHERE id=(:id)")
    suspend fun getAuthor(id: UUID): Author

    @Update
    suspend fun updateAuthor(author: Author)

    @Insert
    suspend fun addAuthor(author: Author)
}