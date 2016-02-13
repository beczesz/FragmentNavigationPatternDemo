package com.exarlabs.android.fragmentnavigationdemo.business.dagger;

import javax.inject.Singleton;

import android.app.Application;

import com.exarlabs.android.fragmentnavigationdemo.business.dagger.modules.AppModule;
import com.exarlabs.android.fragmentnavigationdemo.business.dagger.modules.DevelModule;
import com.exarlabs.android.fragmentnavigationdemo.business.dagger.modules.NavigationModule;

import dagger.Component;

/**
 * Dagger interface which connects all the modules
 * Created by becze on 9/17/2015.
 */
@Singleton
@Component(modules = { AppModule.class, NavigationModule.class, DevelModule.class})
public interface MainComponent extends DaggerComponentGraph {

    final class Initializer {

        public static MainComponent init(Application app) {

            //@formatter:off
            return DaggerMainComponent.builder()
                            .appModule(new AppModule(app))
                            .navigationModule(new NavigationModule())
                            .develModule(new DevelModule())
                            .build();
            //@formatter:on
        }

    }
}
