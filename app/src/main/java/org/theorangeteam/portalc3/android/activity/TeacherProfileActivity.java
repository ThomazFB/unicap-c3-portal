package org.theorangeteam.portalc3.android.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.model.Teacher;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tfbc on 11/10/2016.
 */

public class TeacherProfileActivity extends BaseActivity
{
    public static final String TEACHER_SERIALIZABLE_TAG = "teacherTag";

    @Bind(R.id.posts_page_image)
    ImageView image;

    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.name_field)
    TextView nameField;

    @Bind(R.id.lattes_field)
    TextView lattesField;

    @Bind(R.id.titles_field)
    TextView titlesField;

    @Bind(R.id.interests_field)
    TextView interestsField;

    @Bind(R.id.email_field)
    TextView emailField;

    @Bind(R.id.phone_field)
    TextView phoneField;

    private Teacher teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        ButterKnife.bind(this);
        retrieveIntentData();
        setupLayout();
    }

    private void retrieveIntentData()
    {
        teacher = getIntent().getParcelableExtra(TEACHER_SERIALIZABLE_TAG);
    }

    private void setupLayout()
    {
        nameField.setText(teacher.getName());
        lattesField.setText(teacher.getLattesUrl());
        titlesField.setText(teacher.getTitles());
        interestsField.setText(teacher.getInterests());
        emailField.setText(teacher.getEmail());
        phoneField.setText(teacher.getPhone());

        Picasso.with(this)
                .load(teacher.getImageUrl())
                .error(R.drawable.error)
                .into(image);
    }
}
