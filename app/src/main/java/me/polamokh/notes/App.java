package me.polamokh.notes;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import me.polamokh.notes.di.DaggerApplicationComponent;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .setApplication(this)
                .build();
    }
}
