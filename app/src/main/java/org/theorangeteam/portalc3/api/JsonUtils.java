package org.theorangeteam.portalc3.api;

import org.theorangeteam.portalc3.android.PortalC3Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by tfbc on 10/10/2016.
 */

public final class JsonUtils
{
    public static String loadJSONFromAsset(String jsonFileName)
    {
        String json;
        try
        {
            InputStream is = PortalC3Application.getInstance().getAssets().open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            if(is.read(buffer) > 0)
            {
                is.close();
                json = new String(buffer, "UTF-8");
            }
            else
            {
                throw new RuntimeException();
            }
        }
        catch (IOException ex)
        {
            throw new RuntimeException();
        }
        return json;
    }
}

