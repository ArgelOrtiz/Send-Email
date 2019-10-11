package com.tec.aoaemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    protected void initComponents(){
        final TextInputEditText addresseeTextInputEditText  = findViewById(R.id.addresseeMainTextInputEditText);
        final TextInputEditText affairTextInputEditText     = findViewById(R.id.affairMainTextInputEditText);
        final EditText messageEditTExt                      = findViewById(R.id.messageMainEditText);
        final CheckBox iconChechBox                         = findViewById(R.id.iconMainChechBox);
        Button sendButton                                   = findViewById(R.id.sendMainButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{addresseeTextInputEditText.getText().toString()});
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, affairTextInputEditText.getText().toString());
                intent.putExtra(android.content.Intent.EXTRA_TEXT, messageEditTExt.getText().toString());

                if (iconChechBox.isChecked()) {
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(
                     "android.resource://+" + getPackageName() +
                     "/" + R.drawable.ic_envelope));
                    intent.setType("image/png");
                }

                startActivity(intent);
            }
        });
    }
}
