package ru.niknug.android.mynotes.database

import androidx.room.TypeConverter
import org.joda.time.DateTime

class MyNotesConverters {

    @TypeConverter
    fun fromDateTime(date: DateTime): Long {
        return date.millis
    }

    @TypeConverter
    fun toDateTime(millis: Long): DateTime {
        return DateTime(millis)
    }
}