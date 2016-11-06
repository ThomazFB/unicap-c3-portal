package org.theorangeteam.portalc3.android.component.dialog;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;

import com.afollestad.materialdialogs.MaterialDialog;
import org.theorangeteam.portalc3.R;

public class MaterialDialogBuilder
{
    public static MaterialDialog buildWithLoadingSettings(Context context)
    {
        return new MaterialDialog.Builder(context)
                .content(R.string.dialog_loading_message)
                .backgroundColor(ContextCompat.getColor(context, android.R.color.white))
                .contentColor(ContextCompat.getColor(context, android.R.color.black))
                .widgetColor(ContextCompat.getColor(context, R.color.ff_toolbar))
                .progress(true, 0)
                .canceledOnTouchOutside(false)
                .keyListener(keyListener)
                .autoDismiss(false)
                .build();
    }

    public static MaterialDialog buildWithErrorSettings(Context context, String error)
    {
        return new MaterialDialog.Builder(context)
                .content(error)
                .positiveText(R.string.dialog_accept_text)
                .backgroundColor(ContextCompat.getColor(context, android.R.color.white))
                .contentColor(ContextCompat.getColor(context, android.R.color.black))
                .positiveColor(ContextCompat.getColor(context, R.color.ff_toolbar))
                .build();
    }

    private static DialogInterface.OnKeyListener keyListener = new DialogInterface.OnKeyListener()
    {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
        {
            return true;
        }
    };
}
