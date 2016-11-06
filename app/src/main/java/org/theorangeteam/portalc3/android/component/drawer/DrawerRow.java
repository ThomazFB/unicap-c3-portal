package org.theorangeteam.portalc3.android.component.drawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.theorangeteam.portalc3.R;
import org.theorangeteam.portalc3.api.message.DrawerMessage;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

class DrawerRow extends RelativeLayout
{
    @Bind(R.id.drawer_row_line_divisor) View lineDivisor;
    @Bind(R.id.drawer_row_icon) ImageView icon;
    @Bind(R.id.drawer_row_text) TextView content;

    private DrawerRowType rowType;

    public DrawerRow(Context context)
    {
        super(context);
        init();
    }

    public DrawerRow(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public DrawerRow(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.component_drawer_row, this);
        ButterKnife.bind(this);
    }

    public void setRowData(DrawerRowType rowType)
    {
        this.rowType = rowType;
        icon.setImageResource(rowType.getIconResource());
        content.setText(rowType.getItemText(getContext()));
        setLineDivisorVisibility(rowType.isWithLineDivisor());
    }

    private void setLineDivisorVisibility(boolean isVisible)
    {
        if (isVisible)
            lineDivisor.setVisibility(VISIBLE);
        else
            lineDivisor.setVisibility(INVISIBLE);
    }

    @OnClick(R.id.drawer_row_layout)
    public void onDrawerRowClick(View view)
    {
        EventBus.getDefault().post(new DrawerMessage(rowType));
    }
}
