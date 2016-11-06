package org.theorangeteam.portalc3.android.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.android.component.disciplineList.DisciplineList;
import org.theorangeteam.portalc3.api.message.DisciplinesMessage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DisciplinesFragment extends BaseFragment
{
    @Bind(R.id.discipline_list)
    DisciplineList disciplineList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View fragmentView = inflater.inflate(R.layout.fragment_disciplines, container, false);
        ButterKnife.bind(this, fragmentView);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        return fragmentView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        api.request(new DisciplinesMessage());
    }

    @Subscribe
    public void onDisciplinesMessageReturn(DisciplinesMessage message)
    {
        disciplineList.startList(message.getResult());
    }
}
