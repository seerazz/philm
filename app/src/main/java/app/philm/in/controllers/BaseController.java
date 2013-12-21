package app.philm.in.controllers;

import com.google.common.base.Preconditions;

import app.philm.in.Display;

abstract class BaseController {

    private Display mDisplay;
    private boolean mInited;

    public final void init() {
        Preconditions.checkState(mInited == false, "Already inited");
        mInited = true;
        onInited();
    }

    public final void suspend() {
        Preconditions.checkState(mInited == true, "Not inited");
        onSuspended();
        mInited = false;
    }

    public final boolean isInited() {
        return mInited;
    }

    protected void onInited() {}

    protected void onSuspended() {}

    public void setDisplay(Display display) {
        mDisplay = display;
    }

    public final Display getDisplay() {
        return mDisplay;
    }
}
