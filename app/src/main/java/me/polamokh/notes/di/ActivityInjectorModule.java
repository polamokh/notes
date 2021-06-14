package me.polamokh.notes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import me.polamokh.notes.ui.MainActivity;

@Module
public abstract class ActivityInjectorModule {

    @ContributesAndroidInjector(
            modules = {FragmentInjectorModule.class}
    )
    public abstract MainActivity contributeMainActivity();
}
