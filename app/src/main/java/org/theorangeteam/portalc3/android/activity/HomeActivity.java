package org.theorangeteam.portalc3.android.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.Subscribe;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.android.SharedPreferencesHelper;
import org.theorangeteam.portalc3.android.component.drawer.DrawerRowType;
import org.theorangeteam.portalc3.android.fragment.DisciplinesFragment;
import org.theorangeteam.portalc3.android.fragment.PostPaginationFragment;
import org.theorangeteam.portalc3.android.fragment.TeacherFragment;
import org.theorangeteam.portalc3.api.message.DrawerMessage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity
{
    @Bind(R.id.home_activity_drawer_layout)
    DrawerLayout homeDrawerLayout;

    @Bind(R.id.posts_activity_toolbar)
    Toolbar homeToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(homeToolbar);
        setupDrawerLayout();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setFragment(SharedPreferencesHelper.getLastFragmentOpened(this));
    }

    public void setupDrawerLayout()
    {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, homeDrawerLayout, homeToolbar,
                R.string.open_drawer_text, R.string.close_drawer_text);
        homeDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
        {
            supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
        }
        actionBarDrawerToggle.syncState();
    }

    public void setFragment(DrawerRowType drawerRowType)
    {
        SharedPreferencesHelper.saveLastFragmentOpened(this, drawerRowType);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (drawerRowType)
        {
            case POSTS:
                fragmentTransaction.replace(R.id.fragment_container, new PostPaginationFragment());
                break;

            case DISCIPLINES:
                fragmentTransaction.replace(R.id.fragment_container, new DisciplinesFragment());
                break;

            case TEACHER:
                fragmentTransaction.replace(R.id.fragment_container, new TeacherFragment());
                break;

            default:
                throw new RuntimeException("Fragment replacement for this type isn't implemented");
        }
        fragmentTransaction.commit();
        homeToolbar.setTitle(drawerRowType.getItemText(this));
        homeDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Subscribe
    public void onDrawerMessageEvent(DrawerMessage drawerMessage)
    {
        setFragment(drawerMessage.getResult());
    }
}