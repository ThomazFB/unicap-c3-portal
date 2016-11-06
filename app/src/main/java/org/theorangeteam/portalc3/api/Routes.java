package org.theorangeteam.portalc3.api;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 * Created by tfbc on 10/10/2016.
 */

public class Routes
{
    @Expose
    private String postsRoute;

    @Expose
    private String eventsRoute;

    @Expose
    private String disciplinesRoute;

    @Expose
    private String opportunityRoute;

    @Expose
    private String teachersRoute;

    public static Routes create()
    {
        String routesJson = JsonUtils.loadJSONFromAsset("routes.json");
        return new Gson().fromJson(routesJson, Routes.class);
    }

    private Routes()
    {

    }

    public String getPostsRoute()
    {
        return postsRoute;
    }

    public String getEventsRoute()
    {
        return eventsRoute;
    }

    public String getDisciplinesRoute()
    {
        return disciplinesRoute;
    }

    public String getOpportunityRoute()
    {
        return opportunityRoute;
    }

    public String getTeachersRoute()
    {
        return teachersRoute;
    }
}
