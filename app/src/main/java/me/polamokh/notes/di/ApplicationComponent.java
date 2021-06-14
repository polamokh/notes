package me.polamokh.notes.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import me.polamokh.notes.App;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityInjectorModule.class,
        ViewModelFactoryModule.class,
        DatabaseModule.class
})
public interface ApplicationComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder setApplication(Application application);

        ApplicationComponent build();
    }
}
