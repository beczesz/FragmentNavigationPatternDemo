package com.exarlabs.android.fragmentnavigationdemo;

import android.app.Application;
import android.graphics.Typeface;

import com.exarlabs.android.fragmentnavigationdemo.business.dagger.DaggerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.BuildConfig;
import com.facebook.stetho.Stetho;
import com.norbsoft.typefacehelper.TypefaceCollection;
import com.norbsoft.typefacehelper.TypefaceHelper;

/**
 * Application base class implementation
 * Created by becze on 12/15/2015.
 */
public class FragmentNavigationDemoApplication extends Application {

    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    @Override
    public void onCreate() {
        super.onCreate();

        initLibs();
    }

    private void initLibs() {

        // Initialize dagger
        DaggerManager.getInstance().buildComponentAndInject(this);

        //@formatter:off
        // Initialize typeface helper
        TypefaceCollection typeface = new TypefaceCollection.Builder()
                .set(Typeface.NORMAL, Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf"))
                .set(Typeface.BOLD, Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf"))
                .create();
        TypefaceHelper.init(typeface);
        //@formatter:on

        if (BuildConfig.DEBUG) {
            // Facebook Stetho
            Stetho.initializeWithDefaults(this);
        }
    }


    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------
}
