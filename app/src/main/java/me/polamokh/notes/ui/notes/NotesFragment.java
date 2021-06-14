package me.polamokh.notes.ui.notes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import me.polamokh.notes.viewmodel.ViewModelProviderFactory;
import me.polamokh.notes.databinding.FragmentNotesBinding;
import me.polamokh.notes.model.Note;

public class NotesFragment extends DaggerFragment {

    private static final String TAG = "NotesFragment";

    private FragmentNotesBinding binding;
    private CompositeDisposable disposable;

    private NotesViewModel viewModel;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        disposable = new CompositeDisposable();

        viewModel = new ViewModelProvider(this, viewModelProviderFactory)
                .get(NotesViewModel.class);

        NotesAdapter notesAdapter = new NotesAdapter();
        binding.notesRecyclerView.setAdapter(notesAdapter);

        disposable.add(viewModel.getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(notesAdapter::submitList));

        binding.addNote.setOnClickListener(v -> {
            Note note = new Note("Title", "");
            disposable.add(viewModel.insetNotes(note)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> {
                        Log.d(TAG, "onAddClick: Added " + note.getId());
                    }));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}