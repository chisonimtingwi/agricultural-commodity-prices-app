package com.mtingwi.chisoni.zakumunda;


import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

public class SmartSwipeRefreshLayout extends SwipeRefreshLayout {
    private View scrollingView;

    public SmartSwipeRefreshLayout(Context context) {
        super(context);
    }

    public SmartSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean canChildScrollUp() {
        return this.scrollingView != null && ViewCompat.canScrollVertically(this.scrollingView, -1);
    }

    public void setScrollingView(View scrollingView) {
        this.scrollingView = scrollingView;
    }
}
