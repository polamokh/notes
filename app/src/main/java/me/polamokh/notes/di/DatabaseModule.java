package me.polamokh.notes.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.polamokh.notes.data.local.AppDatabase;
import me.polamokh.notes.data.local.NoteDao;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    public AppDatabase provideAppDatabase(Application application) {
        return AppDatabase.create(application);
    }

    @Singleton
    @Provides
    public NoteDao provideNoteDao(AppDatabase database) {
        return database.noteDao();
    }
}
