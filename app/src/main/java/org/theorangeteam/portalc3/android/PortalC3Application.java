package org.theorangeteam.portalc3.android;

import android.app.Application;

import org.theorangeteam.portalc3.AppGraph;

public class PortalC3Application extends Application
{

    private static PortalC3Application instance;
    private AppGraph appGraph;

    public static PortalC3Application getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        appGraph = AppGraph.Initializer.init(false);
    }

    public AppGraph getAppGraph()
    {
        return appGraph;
    }
}
