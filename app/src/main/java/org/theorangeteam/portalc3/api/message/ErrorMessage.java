package org.theorangeteam.portalc3.api.message;

import org.theorangeteam.portalc3.android.PortalC3Application;

/**
 * Created by Thomaz on 19/03/2016.
 */
public class ErrorMessage
{
    private final String error;

    public ErrorMessage(String error)
    {
        this.error = error;
    }

    public ErrorMessage(int errorId)
    {
        error = PortalC3Application.getInstance().getBaseContext().getString(errorId);
    }

    public String getError()
    {
        return error;
    }
}
