package org.theorangeteam.portalc3.android.component.teacherList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.model.Teacher;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeacherCard extends LinearLayout
{
    @Bind(R.id.teacher_card_image)
    ImageView thumbnail;

    @Bind(R.id.teacher_name)
    TextView teacherName;

    @Bind(R.id.teacher_email)
    TextView teacherEmail;

    private Teacher teacher;

    public TeacherCard(Context context)
    {
        super(context);
        init();
    }

    public TeacherCard(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public TeacherCard(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.component_teacher_card, this);
        ButterKnife.bind(this);
    }

    public void setNewsData(Teacher teacher)
    {
        this.teacher = teacher;
        teacherName.setText(teacher.getName());
        teacherEmail.setText(teacher.getEmail());
        Picasso.with(getContext())
                .load(teacher.getImageUrl())
                .error(R.drawable.error)
                .into(thumbnail);
    }

    @OnClick(R.id.teacher_card_layout)
    public void onClick(View view)
    {
        EventBus.getDefault().post(new TeacherClickEvent(teacher));
    }
}
