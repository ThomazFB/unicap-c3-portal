package org.theorangeteam.portalc3.android.fragment;


import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.api.API;

import javax.inject.Inject;

/**
 * Created by tfbc on 10/10/2016.
 */

public abstract class BaseFragment extends Fragment
{
    @Inject
    API api;

    @Override
    public void onResume()
    {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop()
    {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
