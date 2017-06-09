package com.example.adam.binaryconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editPlain = (EditText) findViewById(R.id.editText);
        final EditText editBinary = (EditText) findViewById(R.id.editText2);
        Button convertToBinary = (Button) findViewById(R.id.button);
        Button convertToText = (Button) findViewById(R.id.button2);
        convertToBinary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String content = editPlain.getText().toString();
                String result = new Convert(content).toBinary();
                editBinary.setText(result, TextView.BufferType.EDITABLE);
            }
        });
        convertToText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String content = editBinary.getText().toString();
                String[] result = new Convert(content).toPlain();
                if (result[1] == "0") {
                    editPlain.setText(result[0], TextView.BufferType.EDITABLE);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Your binary wasn't formatted " +
                            "as ASCII!", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
