package org.theorangeteam.portalc3.api.message;

import com.google.gson.Gson;

import org.theorangeteam.portalc3.api.Routes;
import org.theorangeteam.portalc3.model.Event;

/**
 * Created by ThomazFB on 10/11/16.
 */

public class EventsMessage extends GETMessage
{
    private Event[] result;

    public EventsMessage()
    {
        super(Routes.create());
    }

    @Override
    public void initURL()
    {
        URL = routes.getEventsRoute();
    }

    @Override
    public Object getResult()
    {
        return result;
    }

    @Override
    public void parse()
    {
        result = new Gson().fromJson(jsonResponse, Event[].class);
    }
}
