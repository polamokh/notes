package me.polamokh.notes.ui.notes;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import me.polamokh.notes.model.Note;
import me.polamokh.notes.repo.NoteRepository;

public class NotesViewModel extends ViewModel {

    private static final String TAG = "NotesViewModel";

    private final NoteRepository noteRepository;

    @Inject
    public NotesViewModel(NoteRepository noteRepository) {
        Log.d(TAG, "NotesViewModel: viewmodel working...");
        this.noteRepository = noteRepository;
    }


    public Flowable<List<Note>> getNotes() {
        return noteRepository.loadAllNotes();
    }

    public Completable insetNotes(Note... notes) {
        return noteRepository.insert(notes);
    }

    public Completable deleteNotes(Note... notes) {
        return noteRepository.delete(notes);
    }
}
