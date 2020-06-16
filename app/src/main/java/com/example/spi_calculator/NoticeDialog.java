package com.example.spi_calculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class NoticeDialog extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder ad=new AlertDialog.Builder(getActivity());
        ad.setTitle("Default Instructions, Please read it Once...");
        ad.setMessage("All the subject under one Elective have same credit of course. So it doesn't matter which elective you have taken. Just enter Grades in respective Electives. Enter the Grades only like 'A/A+/B/B+/C/C+/D'...Not numbers.");
        ad.setPositiveButton("Understood", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return ad.create();
    }
}
