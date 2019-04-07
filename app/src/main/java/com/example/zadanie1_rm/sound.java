package com.example.zadanie1_rm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class sound extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    String spinners[] = getResources().getStringArray(R.array.sounds);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        final Spinner spinner = findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sounds, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Intent intent1 = getIntent();
        final Button cancel_sound = findViewById(R.id.cancel_sound);
        cancel_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_station = new Intent(getApplicationContext(), MainActivity.class);
                String wyslana_muzyka  = intent1.getStringExtra("Sound");
                main_station.putExtra("Sound", wyslana_muzyka);
                startActivity(main_station);
            }
        });
    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, View view, final int position, long id) {
        final Button ok_sound = findViewById(R.id.ok_sound);
        ok_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_station = new Intent(getApplicationContext(), MainActivity.class);
                main_station.putExtra("Sound", parent.getItemAtPosition(position).toString());
                startActivity(main_station);


            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}