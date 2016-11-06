package org.theorangeteam.portalc3.model;

import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThomazFB on 10/11/16.
 */

public class Event
{
    @SerializedName("eventoTitulo")
    String title;

    @SerializedName("eventoDescricao")
    String description;

    @SerializedName("eventoCriador")
    String creatorName;

    @SerializedName("eventoImagemUrl")
    String imageUrl;

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public String getCreatorName()
    {
        return creatorName;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
}
