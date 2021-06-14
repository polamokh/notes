package me.polamokh.notes.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import me.polamokh.notes.model.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    public static AppDatabase create(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "notes_database")
                .build();
    }
}
