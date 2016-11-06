package org.theorangeteam.portalc3.android.component.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

class DrawerMenuAdapter extends RecyclerView.Adapter<DrawerMenuAdapter.ViewHolder>
{
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        DrawerRow drawerRow = new DrawerRow(parent.getContext());
        return new ViewHolder(drawerRow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        DrawerRow drawerRow = (DrawerRow) holder.itemView;
        drawerRow.setRowData(DrawerRowType.values()[position]);
    }

    @Override
    public int getItemCount()
    {
        return DrawerRowType.values().length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
