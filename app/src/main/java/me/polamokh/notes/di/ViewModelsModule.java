package me.polamokh.notes.di;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import me.polamokh.notes.ui.notes.NotesViewModel;

@Module
public abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel.class)
    public abstract ViewModel bindNotesViewModel(NotesViewModel notesViewModel);
}
