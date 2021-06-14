package me.polamokh.notes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.polamokh.notes.ui.notes.NotesFragment;

@Module
public abstract class FragmentInjectorModule {

    @ContributesAndroidInjector(
            modules = {ViewModelsModule.class}
    )
    public abstract NotesFragment contributeNotesFragment();
}
