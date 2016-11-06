package org.theorangeteam.portalc3.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.Subscribe;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.android.PortalC3Application;
import org.theorangeteam.portalc3.android.component.postsPager.PostsViewPagerAdapter;
import org.theorangeteam.portalc3.api.API;
import org.theorangeteam.portalc3.api.message.ArticlesMessage;
import org.theorangeteam.portalc3.model.Article;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostPaginationFragment extends BaseFragment
{
    @Inject
    API api;

    @Bind(R.id.news_view_pager)
    ViewPager postsViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View fragmentView = inflater.inflate(R.layout.fragment_posts_pagination, container, false);
        ButterKnife.bind(this, fragmentView);
        PortalC3Application.getInstance().getAppGraph().inject(this);
        return fragmentView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        api.request(new ArticlesMessage());
    }

    @Subscribe
    public void onPostMessageReturn(ArticlesMessage message)
    {
        startPostsList(message.getResult());
    }

    public void startPostsList(Article[] articles)
    {
        postsViewPager.setAdapter(new PostsViewPagerAdapter(getFragmentManager(), articles));
    }
}