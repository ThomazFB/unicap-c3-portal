package org.theorangeteam.portalc3.api.message;

import com.google.gson.Gson;

/**
 * Created by Thomaz on 19/03/2016.
 */

/**
 * Any desired message to the API must be implemented as a class extending Message,
 * this class ensure that for any API operation, all needed info will be reachable
 * <p>
 * All messages must offer a result for the API operation with the getResult() method,
 * and be able to construct the result with the parse() method
 */

public abstract class Message
{
    protected int errorID;
    protected Gson gson = new Gson();

    public abstract Object getResult();

    public abstract void parse();

    public int getErrorID()
    {
        return errorID;
    }

    public void setErrorID(int errorID)
    {
        this.errorID = errorID;
    }
}
