package org.theorangeteam.portalc3.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewAnimationUtils;

public class Animation
{
    public static void makeCircularReveal(View view)
    {
        int xAxysCenter = view.getWidth() / 2;
        int yAxysCenter = view.getHeight() / 2;
        float finalRadius = (float) Math.hypot(xAxysCenter, yAxysCenter);
        Animator circularAnimation =
                ViewAnimationUtils.createCircularReveal(view, xAxysCenter, yAxysCenter, 0, finalRadius);
        view.setVisibility(View.VISIBLE);
        circularAnimation.start();
    }

    public static void makeCircularFade(final View view)
    {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;
        float initialRadius = (float) Math.hypot(cx, cy);
        Animator circularAnimation =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
        circularAnimation.addListener(new AnimatorListenerAdapter()
        {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });
        circularAnimation.start();
    }
}
