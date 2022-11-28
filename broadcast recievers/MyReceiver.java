package com.example.codingwithteanavdrawer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String actionString = intent.getAction();
        Toast.makeText(context.getApplicationContext(), actionString, Toast.LENGTH_SHORT).show();
    }
}