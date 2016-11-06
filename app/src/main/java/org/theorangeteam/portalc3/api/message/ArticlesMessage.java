package org.theorangeteam.portalc3.api.message;

import com.google.gson.Gson;

import org.theorangeteam.portalc3.api.Routes;
import org.theorangeteam.portalc3.model.Article;

/**
 * Created by ThomazFB on 5/10/16.
 */
public class ArticlesMessage extends GETMessage
{
    private Article[] result;

    public ArticlesMessage()
    {
        super(Routes.create());
    }

    @Override
    public void initURL()
    {
        URL = routes.getPostsRoute();
    }

    @Override
    public Article[] getResult()
    {
        return result;
    }

    @Override
    public void parse()
    {
        result = new Gson().fromJson(jsonResponse, Article[].class);
    }
}
