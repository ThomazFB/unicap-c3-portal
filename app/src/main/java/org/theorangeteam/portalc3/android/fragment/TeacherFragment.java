package org.theorangeteam.portalc3.android.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.android.activity.TeacherProfileActivity;
import org.theorangeteam.portalc3.android.component.teacherList.TeacherClickEvent;
import org.theorangeteam.portalc3.android.component.teacherList.TeacherList;
import org.theorangeteam.portalc3.api.message.TeachersMessage;
import org.theorangeteam.portalc3.model.Teacher;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeacherFragment extends BaseFragment
{
    @Bind(R.id.teacher_list)
    TeacherList teacherList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View fragmentView = inflater.inflate(R.layout.fragment_teacher, container, false);
        ButterKnife.bind(this, fragmentView);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        return fragmentView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        api.request(new TeachersMessage());
    }

    @Subscribe
    public void onTeachersMessageReturn(TeachersMessage message)
    {
        teacherList.startList(message.getResult());
    }

    @Subscribe
    public void onTeacherClickEvent(TeacherClickEvent event)
    {
        startTeacherProfileActivity(event.getTeacherClicked());
    }

    private void startTeacherProfileActivity(Teacher teacher)
    {
        Intent teacherProfileIntent = new Intent(getContext(), TeacherProfileActivity.class);
        teacherProfileIntent.putExtra(TeacherProfileActivity.TEACHER_SERIALIZABLE_TAG, teacher);
        getActivity().startActivity(teacherProfileIntent);
    }
}
