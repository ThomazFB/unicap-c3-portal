package org.theorangeteam.portalc3.android.component.teacherList;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.model.Teacher;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeacherList extends LinearLayout
{
    @Bind(R.id.teacher_recycler_view)
    RecyclerView recyclerView;

    public TeacherList(Context context)
    {
        super(context);
        init();
    }

    public TeacherList(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public TeacherList(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.component_teacher_list, this);
        ButterKnife.bind(this);
    }

    public void startList(Teacher[] teachers)
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(new TeacherListAdapter(teachers));
    }
}
