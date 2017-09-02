package com.naitiks.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alertOne = (Button) findViewById(R.id.alert_one);
        alertOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert("Information", "Single button dialog", "OK");
            }
        });

        Button alertTwo = (Button) findViewById(R.id.alert_two);
        alertTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert("Warning", "Are you sure you want to delete?", "YES", "NO");
            }
        });
    }

    private void showAlert(String heading, String msg, String buttonText){
        builder = getAlertDialogBuilderObj(heading, msg);
        builder.setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        })
        .show();
    }

    private void showAlert(String heading, String msg, String posBtnText, String negBtnText){
        builder = getAlertDialogBuilderObj(heading, msg);
        builder.setPositiveButton(posBtnText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        })
        .setNegativeButton(negBtnText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
            }
        })
        .show();
    }

    private AlertDialog.Builder getAlertDialogBuilderObj(String heading, String msg){
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(heading)
                .setMessage(msg);
        return builder;
    }
}
