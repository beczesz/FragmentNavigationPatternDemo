package com.exarlabs.android.fragmentnavigationdemo.ui;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.exarlabs.android.fragmentnavigationdemo.business.dagger.DaggerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.navigation.NavigationManager;
import com.norbsoft.typefacehelper.TypefaceHelper;

import butterknife.ButterKnife;

/**
 * Base activity for all the Activities, it provides some common operation for all of the sub-activities.
 * Created by becze on 9/21/2015.
 */
public class BaseActivity extends AppCompatActivity {

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

    public Toolbar mToolbar;

    public FrameLayout mContentLayout;

    @Inject
    public NavigationManager mNavigationManager;


    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerManager.component().inject(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        // We set a toolbar layout as the default and inflate into the content layout
        super.setContentView(R.layout.toolbar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mContentLayout = (FrameLayout) findViewById(R.id.content);

        // use the new toolbar
        setSupportActionBar(mToolbar);

        // Get an inflater
        getLayoutInflater().inflate(layoutResID, mContentLayout);
        ButterKnife.bind(this);
        TypefaceHelper.typeface(this);
    }


    /**
     * Sets the toolbars visibility
     * @param visibility
     */
    public void setToolbarVisibility(int visibility) {
        mToolbar.setVisibility(visibility);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mNavigationManager.navigateBack(this);
    }

    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------
}
