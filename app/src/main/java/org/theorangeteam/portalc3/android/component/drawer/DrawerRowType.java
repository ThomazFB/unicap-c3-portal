package org.theorangeteam.portalc3.android.component.drawer;

import android.content.Context;

import org.theorangeteam.portalc3.R;

public enum DrawerRowType
{
    POSTS(R.drawable.ic_dashboard_grey600_48dp, false),
    DISCIPLINES(R.drawable.ic_star_grey600_48dp, false),
    TEACHER(R.drawable.ic_notifications_grey600_48dp, false);

    private int iconResource;
    private boolean withLineDivisor;

    DrawerRowType(int iconResource, boolean withLineDivisor)
    {
        this.iconResource = iconResource;
        this.withLineDivisor = withLineDivisor;
    }

    int getIconResource()
    {
        return iconResource;
    }

    boolean isWithLineDivisor()
    {
        return withLineDivisor;
    }

    public String getItemText(Context context)
    {
        switch (this)
        {
            case POSTS:
                return context.getString(R.string.article);

            case DISCIPLINES:
                return context.getString(R.string.disciplines);

            case TEACHER:
                return context.getString(R.string.teachers);

            default:
                throw new RuntimeException("Text for this type isn't implemented");
        }
    }

    public static DrawerRowType fromItemText(Context context, String itemText)
    {
        if (itemText.equals(context.getString(R.string.disciplines)))
            return DISCIPLINES;
        else if (itemText.equals(context.getString(R.string.teachers)))
            return TEACHER;
        else
            return POSTS;
    }
}
