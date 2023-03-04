package com.example.expandablelistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private TextView textView;

    private int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.usernameId);
        passwordEditText = (EditText) findViewById(R.id.passwordId);
        loginButton = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("admin") && password.equals("1234")){

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                }

                else {

                    counter--;
                    textView.setText("Number of Attempts Remaining: "+counter);
                    if (counter==0){
                        loginButton.setEnabled(false);
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        alertDialogBuilder.setIcon(R.drawable.exit);
        alertDialogBuilder.setTitle(R.string.alerttitel);
        alertDialogBuilder.setMessage(R.string.alertmsg);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}