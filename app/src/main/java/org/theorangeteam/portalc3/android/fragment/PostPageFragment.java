package org.theorangeteam.portalc3.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.model.Article;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostPageFragment extends Fragment
{
    @Bind(R.id.posts_page_image)
    ImageView image;

    @Bind(R.id.posts_page_content)
    TextView content;

    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    private Article article;

    public static PostPageFragment newInstance(Article article)
    {
        PostPageFragment postPageFragment = new PostPageFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("postsInfo", article);
        postPageFragment.setArguments(arguments);
        return postPageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        article = (Article) getArguments().getSerializable("postsInfo");
        View fragmentView = inflater.inflate(R.layout.fragment_post_page, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        setupPageLayout();
    }


    private void setupPageLayout()
    {
        collapsingToolbarLayout.setTitle(article.getTitle());
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.ff_toolbar));
        content.setText(article.getContent());
        Picasso.with(getContext())
                .load(article.getImageUrl())
                .error(R.drawable.error)
                .into(image);
    }
}
