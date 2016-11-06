package org.theorangeteam.portalc3.api.message;

import com.google.gson.Gson;

import org.theorangeteam.portalc3.api.Routes;
import org.theorangeteam.portalc3.model.Teacher;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class TeachersMessage extends GETMessage
{
    private Teacher[] result;

    public TeachersMessage()
    {
        super(Routes.create());
    }

    @Override
    public void initURL()
    {
        URL = routes.getTeachersRoute();
    }

    @Override
    public Teacher[] getResult()
    {
        return result;
    }

    @Override
    public void parse()
    {
        result = new Gson().fromJson(jsonResponse, Teacher[].class);
    }
}