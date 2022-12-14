package ru.niknug.android.mynotes.database

import androidx.room.Dao
import androidx.room.Query
import ru.niknug.android.mynotes.Author
import java.util.UUID

@Dao
interface AuthorDao {

    @Query("SELECT * FROM author")
    suspend fun getAuthors(): List<Author>

    @Query("SELECT * FROM author WHERE id=(:id)")
    suspend fun getAuthor(id: UUID): Author
}