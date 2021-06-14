package me.polamokh.notes.repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import me.polamokh.notes.data.local.NoteDao;
import me.polamokh.notes.model.Note;

public class NoteRepository {

    private final NoteDao noteDao;

    @Inject
    public NoteRepository(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public Completable insert(Note... notes) {
        return noteDao.insert(notes);
    }

    public Completable update(Note... notes) {
        return noteDao.update(notes);
    }

    public Completable delete(Note... notes) {
        return noteDao.delete(notes);
    }

    public Flowable<List<Note>> loadAllNotes() {
        return noteDao.loadAllNotes();
    }
}
