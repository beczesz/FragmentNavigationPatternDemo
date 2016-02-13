package com.exarlabs.android.fragmentnavigationdemo.business.dagger;

import com.exarlabs.android.fragmentnavigationdemo.FragmentNavigationDemoApplication;
import com.exarlabs.android.fragmentnavigationdemo.ui.BaseActivity;
import com.exarlabs.android.fragmentnavigationdemo.ui.MainActivity;
import com.exarlabs.android.fragmentnavigationdemo.ui.SampleFragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.module1.Module1Fragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.module1.Module1InternalFragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.module2.Module2Fragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.drawer.DrawerManager;
import com.exarlabs.android.fragmentnavigationdemo.ui.module5.Module5Fragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.module4.Module4Fragment;
import com.exarlabs.android.fragmentnavigationdemo.ui.module3.Module3Fragment;

/**
 * Here are listed all the loations where injection is needed.
 * Created by becze on 9/17/2015.
 */
public interface DaggerComponentGraph {


    void inject(FragmentNavigationDemoApplication app);

    void inject(BaseActivity baseActivity);

    void inject(SampleFragment sampleFragment);

    void inject(Module3Fragment rulesOverviewFragment);

    void inject(MainActivity baseActivity);

    void inject(DrawerManager drawerManager);

    void inject(Module2Fragment conditionsOverviewFragment);

    void inject(Module5Fragment eventsOverviewFragment);

    void inject(Module1Fragment actionsOverviewFragment);

    void inject(Module4Fragment historyListFragment);

    void inject(Module1InternalFragment module1InternalFragment);
}
