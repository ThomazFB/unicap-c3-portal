package org.theorangeteam.portalc3.android.component.postsPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.theorangeteam.portalc3.android.fragment.PostPageFragment;
import org.theorangeteam.portalc3.model.Article;

public class PostsViewPagerAdapter extends FragmentStatePagerAdapter
{
    private Article[] articles;

    public PostsViewPagerAdapter(FragmentManager fragmentManager, Article[] articles)
    {
        super(fragmentManager);
        this.articles = articles;
    }

    @Override
    public Fragment getItem(int position)
    {
        return PostPageFragment.newInstance(articles[position]);
    }

    @Override
    public int getCount()
    {
        return articles.length;
    }
}
