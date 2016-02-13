package com.exarlabs.android.fragmentnavigationdemo.ui;

import javax.inject.Inject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.exarlabs.android.fragmentnavigationdemo.business.dagger.DaggerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.drawer.DrawerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.navigation.NavigationManager;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Main activity which holds the container for the fragment navigation.
 */
public class MainActivity extends BaseActivity implements Drawer.OnDrawerItemClickListener, NavigationManager.NavigationListener {


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

    @Inject
    public NavigationManager mNavigationManager;

    @Inject
    public DrawerManager mDrawerManager;

    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inject members
        DaggerManager.component().inject(this);

        // Initialize the NavigationManager with this activity's FragmentManager
        mNavigationManager.init(getSupportFragmentManager());
        mNavigationManager.setNavigationListener(this);

        // start as the first screen the rules overview
        mNavigationManager.startMenu1();

        initDrawer();
    }

    /**
     * Initializes the drawer
     */
    public void initDrawer() {
        mDrawerManager.buildDrawer(this, mToolbar);
        mDrawerManager.getDrawer().setOnDrawerItemClickListener(this);
    }

    @Override
    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
        boolean isHandled = mDrawerManager.handleItemSelected(this, view, i, iDrawerItem);
        if (isHandled) {
            mDrawerManager.getDrawer().closeDrawer();
        }

        return isHandled;
    }

    @Override
    public void onBackPressed() {
        // Note: we intentionally not calling the super implementation since in the CIS app
        // we decided to use support fragment manager.

        //we pressed the back button, show the logout dialog
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            // we have only one fragment left so we would close the application with this back
            showExitDialog();
        } else {
            mNavigationManager.navigateBack(this);
        }
    }

    /**
     * Shows the logout dialog. Stops the service and finishes the application.
     */
    protected void showExitDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.exit_message).setCancelable(false).setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        }).setNegativeButton(android.R.string.cancel, null);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackstackChanged() {
        // check if we display a root fragment and enable drawer only on root fragments
        boolean rootFragment = mNavigationManager.isRootFragmentVisible();
        mDrawerManager.enableDrawer(rootFragment);
        mDrawerManager.enableActionBarDrawerToggle(rootFragment);
    }


    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------

}
