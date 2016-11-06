package org.theorangeteam.portalc3.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class Article implements Serializable
{
    @SerializedName("postImagemUrl")
    private String imageUrl;
    @SerializedName("postTitulo")
    private String title;
    @SerializedName("postDescricao")
    private String content;

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }
}
