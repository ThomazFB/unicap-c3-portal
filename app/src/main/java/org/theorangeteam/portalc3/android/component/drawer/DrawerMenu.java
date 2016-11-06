package org.theorangeteam.portalc3.android.component.drawer;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.theorangeteam.portalc3.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DrawerMenu extends LinearLayout
{
    @Bind(R.id.drawer_menu_recycler_view) RecyclerView recyclerView;

    public DrawerMenu(Context context)
    {
        super(context);
        init();
    }

    public DrawerMenu(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public DrawerMenu(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.component_drawer_menu, this);
        ButterKnife.bind(this);
        initMenu();
    }

    private void initMenu()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(new DrawerMenuAdapter());
    }
}
