package org.theorangeteam.portalc3.android;

import android.content.Context;
import android.content.SharedPreferences;

import org.theorangeteam.portalc3.android.component.drawer.DrawerRowType;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by tfbc on 11/10/2016.
 */

public class SharedPreferencesHelper
{
    private static final String APPLICATION_PREFERENCES = "applicationPreferences";
    private static final String LAST_OPENED_HOME_FRAGMENT = "lastOpenedHomeFragment";

    public static void saveLastFragmentOpened(Context context, DrawerRowType drawerRowType)
    {
        SharedPreferences.Editor editor = openSharedPreferencesEditor(context);
        editor.putString(LAST_OPENED_HOME_FRAGMENT, drawerRowType.getItemText(context));
        editor.apply();
    }

    public static DrawerRowType getLastFragmentOpened(Context context)
    {
        SharedPreferences preferences = getSharedPreferences(context);
        String drawerRowItemText =  preferences.getString(LAST_OPENED_HOME_FRAGMENT, "");
        return DrawerRowType.fromItemText(context, drawerRowItemText);
    }

    private static SharedPreferences getSharedPreferences(Context context)
    {
        return context.getSharedPreferences(APPLICATION_PREFERENCES, MODE_PRIVATE);
    }

    private static SharedPreferences.Editor openSharedPreferencesEditor(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCES, MODE_PRIVATE);
        return preferences.edit();
    }
}