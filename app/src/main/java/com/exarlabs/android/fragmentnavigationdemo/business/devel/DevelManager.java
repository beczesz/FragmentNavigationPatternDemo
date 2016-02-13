package com.exarlabs.android.fragmentnavigationdemo.business.devel;

import com.exarlabs.android.fragmentnavigationdemo.ui.BuildConfig;

/**
 * Provides utility methods for developers
 * Created by becze on 12/15/2015.
 */
public class DevelManager {

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

    /**
     * @return a string which summarizes the build information in a user friendly way
     */
    public String getBuildDescription() {
        String buildString = "Build: debug " + BuildConfig.FLAVOR + " ";
        buildString += BuildConfig.HAS_BUILD_NUMBER ? "#" + BuildConfig.BUILD_NUMBER : " by " + BuildConfig.USERNAME + "@" + BuildConfig.COMPUTERNAME;
        buildString += " (" + BuildConfig.BUILD_TIME + ")";
        return buildString;
    }

    // ------------------------------------------------------------------------
    // GETTERS / SETTTERS
    // ------------------------------------------------------------------------
}
