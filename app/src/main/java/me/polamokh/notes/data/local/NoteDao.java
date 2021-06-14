package me.polamokh.notes.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import me.polamokh.notes.model.Note;

@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(Note... notes);

    @Update
    Completable update(Note... notes);

    @Delete
    Completable delete(Note... notes);

    @Query("SELECT * FROM notes")
    Flowable<List<Note>> loadAllNotes();
}
