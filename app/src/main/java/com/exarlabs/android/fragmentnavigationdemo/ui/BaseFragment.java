package com.exarlabs.android.fragmentnavigationdemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;

import com.norbsoft.typefacehelper.TypefaceHelper;

import butterknife.ButterKnife;

/**
 * Base class for every Fragment, it provides some custom behavior for all of the fragments
 * sucn as dependency injection.
 * Created by becze on 9/21/2015.
 */
public class BaseFragment extends Fragment {

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        TypefaceHelper.typeface(view);

        initActionBar(true, getString(R.string.app_name));


    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("BSZ", "onDestroy: " + this);
    }



    /**
     * Initializes the ActionBar
     *
     * @param showHomeButton
     * @param title
     */
    protected void initActionBar(boolean showHomeButton, String title) {
        if (getActivity() != null && getActivity() instanceof BaseActivity ) {
            ActionBar supportActionBar = ((BaseActivity) getActivity()).getSupportActionBar();
            supportActionBar.setHomeButtonEnabled(showHomeButton);
            supportActionBar.setTitle(title);
        }
    }

    /**
     * Shows and hides the actionbar
     *
     * @param isShown
     */
    protected void showActionbar(boolean isShown) {
        if (getActivity() != null && getActivity() instanceof BaseActivity ) {
            ActionBar supportActionBar = ((BaseActivity) getActivity()).getSupportActionBar();
            if (isShown) {
                supportActionBar.show();
            } else {
                supportActionBar.hide();
            }
        }
    }


    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------
}
