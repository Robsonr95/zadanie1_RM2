package com.example.zadanie1_rm;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class kontakty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakty);
        final RadioGroup radioGroup;
        radioGroup = findViewById(R.id.radioGroup);


        String kontakt[] = getResources().getStringArray(R.array.my_contacts);
        RadioButton guzik1 = findViewById(R.id.radioButton1);
        RadioButton guzik2 = findViewById(R.id.radioButton2);
        RadioButton guzik3 = findViewById(R.id.radioButton3);
        RadioButton guzik4 = findViewById(R.id.radioButton4);
        RadioButton guzik5 = findViewById(R.id.radioButton5);
        RadioButton guzik6 = findViewById(R.id.radioButton6);

        guzik1.setText(kontakt[0]);
        guzik2.setText(kontakt[1]);
        guzik3.setText(kontakt[2]);
        guzik4.setText(kontakt[3]);
        guzik5.setText(kontakt[4]);
        guzik6.setText(kontakt[5]);


            final Button button_ok = findViewById((R.id.ok));
            button_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final RadioButton radioButton;
                    int radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(radioId);
                    //   button_ok.setText("Your choice: " + radioButton.getText());
                    Intent main_station = new Intent(getApplicationContext(), MainActivity.class);
                    main_station.putExtra("Name", radioButton.getText());
                    startActivity(main_station);

                }
            });
        final Intent intent1 = getIntent();
        final Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_station = new Intent(getApplicationContext(), MainActivity.class);
                String wyslane = intent1.getStringExtra("Name");
                main_station.putExtra("Name", wyslane);
                startActivity(main_station);

            }

        });
    }

}









