package org.theorangeteam.portalc3.api.message;

import org.theorangeteam.portalc3.api.Routes;

/**
 * Created by tfbc on 10/10/2016.
 */

public abstract class GETMessage extends Message
{
    String URL;
    String jsonResponse;
    Routes routes;

    public GETMessage(Routes routes)
    {
        this.routes = routes;
        initURL();
    }

    public abstract void initURL();

    public String getUrl()
    {
        return URL;
    }

    public void setJsonResponse(String json)
    {
        this.jsonResponse = json;
        parse();
    }
}
