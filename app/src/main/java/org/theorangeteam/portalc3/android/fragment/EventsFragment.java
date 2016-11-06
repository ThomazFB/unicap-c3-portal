package org.theorangeteam.portalc3.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;

import butterknife.ButterKnife;

/**
 * Created by ThomazFB on 10/11/16.
 */

public class EventsFragment extends BaseFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View fragmentView = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, fragmentView);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        return fragmentView;
    }

}
