package com.mtingwi.chisoni.zakumunda;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogBox extends AlertDialog.Builder {
    AlertDialog.Builder dialogBoxBuilder;
    private String message;
    private DialogBoxType dialogBoxType;
    private Context context;

    public enum DialogBoxType {OK_ONLY, OK_CANCEL}

    public DialogBox(Context context, String message, DialogBoxType dialogBoxType) {
        super(context);
        this.context = context;
        this.message = message;
        this.dialogBoxType = dialogBoxType;
        createMessage();
    }

    private void createMessage() {
        dialogBoxBuilder = new AlertDialog.Builder(context);
        dialogBoxBuilder.setTitle(R.string.app_name);
        dialogBoxBuilder.setMessage(message);
        dialogBoxBuilder.setCancelable(false);

        dialogBoxBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        if (dialogBoxType == DialogBoxType.OK_CANCEL) {
            dialogBoxBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }

        AlertDialog dialogBox = dialogBoxBuilder.create();
        dialogBox.show();
    }
}
