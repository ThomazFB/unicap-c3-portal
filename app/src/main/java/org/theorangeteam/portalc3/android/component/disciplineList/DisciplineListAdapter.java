package org.theorangeteam.portalc3.android.component.disciplineList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.theorangeteam.portalc3.model.Discipline;
import org.theorangeteam.portalc3.model.Teacher;

class DisciplineListAdapter extends RecyclerView.Adapter<DisciplineListAdapter.ViewHolder>
{
    private Discipline[] disciplines;

    public DisciplineListAdapter(Discipline[] disciplines)
    {
        this.disciplines = disciplines;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        DisciplineCard disciplineCard = new DisciplineCard(parent.getContext());
        return new ViewHolder(disciplineCard);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        DisciplineCard disciplineCard = (DisciplineCard) holder.itemView;
        disciplineCard.setNewsData(disciplines[position]);
    }

    @Override
    public int getItemCount()
    {
        return disciplines.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
