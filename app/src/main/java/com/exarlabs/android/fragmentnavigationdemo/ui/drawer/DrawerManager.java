package com.exarlabs.android.fragmentnavigationdemo.ui.drawer;

import java.util.ArrayList;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.exarlabs.android.fragmentnavigationdemo.business.dagger.DaggerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.R;
import com.exarlabs.android.fragmentnavigationdemo.ui.navigation.NavigationManager;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.octicons_typeface_library.Octicons;

/**
 * Created by becze on 10/21/2015.
 */
public class DrawerManager {

    // ------------------------------------------------------------------------
    // TYPES
    // ------------------------------------------------------------------------


    public enum MenuItem {

        MENU_ITEM1("Module1"),
        MENU_ITEM2("Module2"),
        MENU_ITEM3("Module3"),
        MENU_ITEM4("Module4"),
        MENU_ITEM5("Module5");

        private String mLabel;

        MenuItem(String label) {
            mLabel = label;
        }
    }


    // ------------------------------------------------------------------------
    // STATIC FIELDS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // STATIC METHODS
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------------------------

    private MenuItem mLastSelectedItem;

    @Inject
    public NavigationManager mNavigationManager;

    private Drawer mDrawer;
    // ------------------------------------------------------------------------
    // CONSTRUCTORS
    // ------------------------------------------------------------------------

    public DrawerManager() {
        // we always select the first item on creation
        mLastSelectedItem = MenuItem.MENU_ITEM1;
        DaggerManager.component().inject(this);
    }

    // ------------------------------------------------------------------------
    // METHODS
    // ------------------------------------------------------------------------


    /**
     * Creates a new drawer for this application with predefined items
     *
     * @param activity
     * @param toolbar
     * @return
     */
    public void buildDrawer(Activity activity, Toolbar toolbar) {

        //@formatter:off
        mDrawer = new DrawerBuilder()
                        .withActivity(activity)
                        .withToolbar(toolbar)
                        .withDrawerItems(getDrawerItems())
                        .withSelectedItemByPosition(getLastSelectedItemPosition())
                        .withAccountHeader(getAccountHeader(activity))
                        .addDrawerItems()
                        .build();
        //@formatter:on
    }

    private AccountHeader getAccountHeader(Activity activity) {
        //@formatter:off
        return new AccountHeaderBuilder()
                        .withActivity(activity)
                        .withHeaderBackground(R.color.primary_dark)
                        .addProfiles(
                            new ProfileDrawerItem()
                                            .withName(activity.getString(R.string.app_name))
                        )
                        .build();
        //@formatter:on
    }


    /**
     * @return the list of items
     */
    public ArrayList<IDrawerItem> getDrawerItems() {

        // The menu items in the drawer
        ArrayList<IDrawerItem> items = new ArrayList<>();

        // Dashboard
        //if you want to update the items at a later time it is recommended to keep it in a variable
        //@formatter:off
        items.add(new PrimaryDrawerItem()
                        .withName(MenuItem.MENU_ITEM1.mLabel).withIcon(Octicons.Icon.oct_dashboard)
                        .withIconColorRes(R.color.menu_item_1).withSelectedIconColorRes(R.color.menu_item_1));

        items.add(new PrimaryDrawerItem()
                        .withName(MenuItem.MENU_ITEM2.mLabel).withIcon(Octicons.Icon.oct_graph)
                        .withIconColorRes(R.color.menu_item_2).withSelectedIconColorRes(R.color.menu_item_2));

        items.add(new PrimaryDrawerItem()
                        .withName(MenuItem.MENU_ITEM3.mLabel).withIcon(FontAwesome.Icon.faw_sign_out)
                        .withIconColorRes(R.color.menu_item_3).withSelectedIconColorRes(R.color.menu_item_3));

        items.add(new PrimaryDrawerItem()
                        .withName(MenuItem.MENU_ITEM4.mLabel).withIcon(FontAwesome.Icon.faw_sign_out)
                        .withIconColorRes(R.color.menu_item_4).withSelectedIconColorRes(R.color.menu_item_4));

        items.add(new PrimaryDrawerItem()
                        .withName(MenuItem.MENU_ITEM5.mLabel).withIcon(FontAwesome.Icon.faw_sign_out)
                        .withIconColorRes(R.color.menu_item_5).withSelectedIconColorRes(R.color.menu_item_5));


        //@formatter:on
        decorate(items);

        return items;
    }

    private void decorate(ArrayList<IDrawerItem> items) {
        for (IDrawerItem item : items) {
            if (item instanceof PrimaryDrawerItem) {
                ((PrimaryDrawerItem) item).withSelectedColorRes(R.color.menu_item_selected);
            }
        }
    }


    /**
     * Handles the menu item selected event
     *
     * @param context
     * @param view
     * @param i
     * @param iDrawerItem
     * @return
     */
    public boolean handleItemSelected(Context context, View view, int i, IDrawerItem iDrawerItem) {

        i--;
        if (i >= 0 && i < MenuItem.values().length) {

            MenuItem item = MenuItem.values()[i];

            if (item != mLastSelectedItem) {

                switch (item) {
                    case MENU_ITEM1:
                        mNavigationManager.startMenu1();
                        break;

                    case MENU_ITEM2:
                        mNavigationManager.startMenu2();
                        break;

                    case MENU_ITEM3:
                        mNavigationManager.startMenu3();
                        break;

                    case MENU_ITEM4:
                        mNavigationManager.startMenu4();
                        break;

                    case MENU_ITEM5:
                        mNavigationManager.startMenu5();
                        break;

                    default:
                        mNavigationManager.startMenu1();
                        break;

                }

                mLastSelectedItem = item;
                closeDrawer();
                return true;
            }

        }

        return false;
    }

    private void closeDrawer() {
        if (mDrawer != null) {
            mDrawer.closeDrawer();
        }
    }


    /**
     * Enables/disbales the drawer the drawer
     *
     * @param isEnabled
     */
    public void enableDrawer(boolean isEnabled) {
        if (mDrawer != null) {
            mDrawer.getDrawerLayout().setDrawerLockMode(isEnabled ? DrawerLayout.LOCK_MODE_UNLOCKED : DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

    /**
     * Enable / disable the drawer indicator
     * @param isEnabled
     */
    public void enableActionBarDrawerToggle(boolean isEnabled) {
        if (mDrawer != null) {
            mDrawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(isEnabled);
        }
    }

    /**
     * Initializes the drawer state.
     */
    public void reset() {
        mLastSelectedItem = MenuItem.MENU_ITEM1;
    }


    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------


    /**
     * Get the lst selected drawer item.
     *
     * @return
     */

    public int getLastSelectedItemPosition() {
        return mLastSelectedItem.ordinal();
    }

    public Drawer getDrawer() {
        return mDrawer;
    }
}
