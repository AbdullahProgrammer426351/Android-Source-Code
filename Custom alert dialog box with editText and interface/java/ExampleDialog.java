package com.example.alertandsnackbar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextUserName;
    private EditText editTextPassword;
    private ExampleDialogListener listener;



    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userName = editTextUserName.getText().toString();
                        String password = editTextPassword.getText().toString();
                        listener.applyTexts(userName,password);
                    }
                });

        editTextUserName = view.findViewById(R.id.edit_userName);
        editTextPassword = view.findViewById(R.id.edit_password);

//        It was a big mistake for me that caused app crashes for hundreds of times. I wrote 'textView_password' instead of 'edit_password' in above line.


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement Example Dialog Listener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String userName, String password);
    }
}
