package com.mtingwi.chisoni.zakumunda;

import android.support.design.widget.Snackbar;
import android.view.View;

public class SimpleSnackBar {

    private Snackbar snackbar;
    private View coordinatorLayoutView = null;
    private String message;

    public View getCoordinatorLayoutView() {
        return coordinatorLayoutView;
    }

    public void setCoordinatorLayoutView(View coordinatorLayoutView) {
        this.coordinatorLayoutView = coordinatorLayoutView;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void create(int timeout) {
        if ((null != getCoordinatorLayoutView()) && (null != getCoordinatorLayoutView().getContext())) {
            try {
                snackbar = Snackbar.make(getCoordinatorLayoutView(), getMessage(), timeout);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void showDefaultSnackbar() {
        create(Snackbar.LENGTH_LONG);
        try {
            snackbar.show();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void showDefaultSnackbar(View coordinatorLayoutView, String message) {
        setCoordinatorLayoutView(coordinatorLayoutView);
        setMessage(message);
        showDefaultSnackbar();
    }

    public void showOKSnackbar(int timeout) {
        create(timeout);
        addDismissButton();
        snackbar.show();
    }

    public void showOKSnackbar(View coordinatorLayoutView, String message) {
        setCoordinatorLayoutView(coordinatorLayoutView);
        setMessage(message);
        showOKSnackbar(Snackbar.LENGTH_INDEFINITE);
    }


    public void showOKSnackbar(View coordinatorLayoutView, String message, int timeout) {
        setCoordinatorLayoutView(coordinatorLayoutView);
        setMessage(message);
        showOKSnackbar(timeout);
    }

    private void addDismissButton() {
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
