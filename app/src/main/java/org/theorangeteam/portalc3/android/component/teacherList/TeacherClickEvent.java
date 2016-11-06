package org.theorangeteam.portalc3.android.component.teacherList;

import org.theorangeteam.portalc3.model.Teacher;

/**
 * Created by tfbc on 11/10/2016.
 */

public class TeacherClickEvent
{
    private Teacher teacherClicked;

    public TeacherClickEvent(Teacher teacherClicked)
    {
        this.teacherClicked = teacherClicked;
    }

    public Teacher getTeacherClicked()
    {
        return teacherClicked;
    }
}
