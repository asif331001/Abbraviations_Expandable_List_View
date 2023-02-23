package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedback extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton, clearButton;
    private EditText nameEditText, mailEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendButton = (Button) findViewById(R.id.send_button);
        clearButton = (Button) findViewById(R.id.clear_button);

        nameEditText = (EditText) findViewById(R.id.name_edittext);
        mailEditText = (EditText) findViewById(R.id.email_edittext);
        messageEditText = (EditText) findViewById(R.id.feedback_edittext);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        try {


            String name = nameEditText.getText().toString();
            String mail = mailEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (view.getId()==R.id.send_button){

                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/email");

                intent1.putExtra(Intent.EXTRA_EMAIL, new  String[] {"asif95331001@gmail.com"});

                intent1.putExtra(Intent.EXTRA_SUBJECT,"Feedback from app");
                intent1.putExtra(Intent.EXTRA_TEXT,"Name: "+name+"\n"+"Email: "+mail+"\n"+"Feedback: "+message);
                startActivity(Intent.createChooser(intent1, "Feedback With"));
            }

            if (view.getId()==R.id.clear_button){

                nameEditText.setText("");
                mailEditText.setText("");
                messageEditText.setText("");
            }

        } catch (Exception e){


        }


    }
}