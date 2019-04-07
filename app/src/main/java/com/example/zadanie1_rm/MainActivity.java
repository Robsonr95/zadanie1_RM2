package com.example.zadanie1_rm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ekran_gowny);

        final MediaPlayer play_sound[] = {MediaPlayer.create(this, R.raw.mario),MediaPlayer.create(this, R.raw.ring04),MediaPlayer.create(this, R.raw.ring03),
                MediaPlayer.create(this, R.raw.ring04),MediaPlayer.create(this, R.raw.ring02), MediaPlayer.create(this, R.raw.ring01)  };

        final FloatingActionButton tap = findViewById(R.id.floating);
        Button sound_button = findViewById(R.id.change_sound);

        String my_contacts[] = getResources().getStringArray(R.array.my_contacts);
        final TextView textView = findViewById(R.id.textView);
        final Intent intent1 = getIntent();
        Button contact_button = findViewById(R.id.change_contact);
        contact_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kontakty = new Intent ( getApplicationContext (), kontakty.class );
                kontakty.putExtra("Name", textView.getText());
                startActivity (kontakty);
            }
        });


        String Name = intent1.getStringExtra("Name");;
        if(Name == null)
             Name = my_contacts[0];
            textView.setText(Name);
        sound_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String muzyka = intent1.getStringExtra("Sound");
                Intent sound = new Intent ( getApplicationContext (), sound.class );
                sound.putExtra("Sound", muzyka);
                startActivity (sound);
            }
        });


        //sound_button.setText(muzyka);

        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String muzyka = intent1.getStringExtra("Sound");
                if(muzyka == null)
                    muzyka = "sound1";
                switch (muzyka) {
                        case ("sound1"):
                            graj(play_sound[0]);
                            break;
                        case ("sound2"):
                           graj(play_sound[1]);
                            break;
                        case ("sound3"):
                            graj(play_sound[2]);
                            break;
                        case ("sound4"):
                            graj(play_sound[3]);
                            break;
                        case ("sound5"):
                            graj(play_sound[4]);
                            break;
                        case ("sound6"):
                            graj(play_sound[5]);
                            break;
                    }
            }



        });

        image();

    }

    public void graj(MediaPlayer mediaPlayer) {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    public void image() {
        final ImageView imageview = findViewById(R.id.imageView);
        Random rand = new Random();
        int n = rand.nextInt(2);
        String images[] = getResources().getStringArray(R.array.images);
        imageview.setImageResource(getResources().getIdentifier(images[n],"drawable", getPackageName()));
    }


}


