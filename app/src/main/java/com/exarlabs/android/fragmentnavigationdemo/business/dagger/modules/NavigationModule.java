package com.exarlabs.android.fragmentnavigationdemo.business.dagger.modules;

import javax.inject.Singleton;

import com.exarlabs.android.fragmentnavigationdemo.ui.drawer.DrawerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.navigation.NavigationManager;

import dagger.Module;
import dagger.Provides;

/**
 * Provides instances for navigation
 * Created by becze on 11/13/2015.
 */
@Module
public class NavigationModule {


    @Provides
    @Singleton
    protected NavigationManager provideNavigationManager() {
        return new NavigationManager();
    }

    @Provides
    @Singleton
    protected DrawerManager provideDrawerManager() {
        return new DrawerManager();
    }
}
