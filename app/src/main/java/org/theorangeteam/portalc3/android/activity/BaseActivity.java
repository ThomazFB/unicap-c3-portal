package org.theorangeteam.portalc3.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.theorangeteam.portalc3.android.component.dialog.MaterialDialogBuilder;
import org.theorangeteam.portalc3.api.message.CreateLoadingDialogEvent;
import org.theorangeteam.portalc3.api.message.DismissLoadingDialogEvent;
import org.theorangeteam.portalc3.api.message.ErrorMessage;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity
{
    @Inject EventBus eventBus;

    protected MaterialDialog loadingMaterialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (loadingMaterialDialog != null) loadingMaterialDialog.dismiss();
    }

    @Override
    protected void onStop()
    {
        eventBus.unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onCreateLoadingDialogMessageEvent(CreateLoadingDialogEvent createLoadingDialogEvent)
    {
        loadingMaterialDialog = MaterialDialogBuilder.buildWithLoadingSettings(this);
        loadingMaterialDialog.show();
    }

    @Subscribe
    public void onDismissLoadingDialogMessageEvent(DismissLoadingDialogEvent dismissLoadingDialogEvent)
    {
        if (loadingMaterialDialog != null) loadingMaterialDialog.dismiss();
    }

    @Subscribe
    public void onErrorMessageEvent(ErrorMessage errorMessage)
    {
        MaterialDialogBuilder.buildWithErrorSettings(this, errorMessage.getError()).show();
    }
}
