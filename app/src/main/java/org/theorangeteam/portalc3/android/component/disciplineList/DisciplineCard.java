package org.theorangeteam.portalc3.android.component.disciplineList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.component.teacherList.TeacherClickEvent;
import org.theorangeteam.portalc3.model.Discipline;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisciplineCard extends LinearLayout
{
    @Bind(R.id.discipline_name)
    TextView disciplineName;

    @Bind(R.id.discipline_code)
    TextView disciplineCode;

    public DisciplineCard(Context context)
    {
        super(context);
        init();
    }

    public DisciplineCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public DisciplineCard(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.component_discipline_card, this);
        ButterKnife.bind(this);
    }

    public void setNewsData(Discipline discipline)
    {
        disciplineName.setText(discipline.getName());
        disciplineCode.setText(discipline.getCode());
    }
}