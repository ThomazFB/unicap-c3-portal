package org.theorangeteam.portalc3.android.component.teacherList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.theorangeteam.portalc3.model.Teacher;

class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.ViewHolder>
{
    private Teacher[] teachers;

    public TeacherListAdapter(Teacher[] teachers)
    {
        this.teachers = teachers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        TeacherCard teacherCard = new TeacherCard(parent.getContext());
        return new ViewHolder(teacherCard);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        TeacherCard teacherCard = (TeacherCard) holder.itemView;
        teacherCard.setNewsData(teachers[position]);
    }

    @Override
    public int getItemCount()
    {
        return teachers.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
