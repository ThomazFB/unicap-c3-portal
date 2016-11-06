package org.theorangeteam.portalc3.api.message;

import com.google.gson.Gson;

import org.theorangeteam.portalc3.api.Routes;
import org.theorangeteam.portalc3.model.Discipline;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class DisciplinesMessage extends GETMessage
{
    private Discipline[] result;

    public DisciplinesMessage()
    {
        super(Routes.create());
    }

    @Override
    public void initURL()
    {
        URL = routes.getDisciplinesRoute();
    }

    @Override
    public Discipline[] getResult()
    {
        return result;
    }

    @Override
    public void parse()
    {
        result = new Gson().fromJson(jsonResponse, Discipline[].class);
    }
}
