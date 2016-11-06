package org.theorangeteam.portalc3.api.message;

import org.theorangeteam.portalc3.android.component.drawer.DrawerRowType;

public class DrawerMessage extends Message
{
    private DrawerRowType drawerRowType;

    public DrawerMessage(DrawerRowType drawerRowType)
    {
        this.drawerRowType = drawerRowType;
    }

    @Override
    public DrawerRowType getResult()
    {
        return drawerRowType;
    }

    @Override
    public void parse()
    {

    }
}
