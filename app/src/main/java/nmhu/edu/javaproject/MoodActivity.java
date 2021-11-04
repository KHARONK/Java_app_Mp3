package nmhu.edu.javaproject;

import static android.graphics.Color.BLUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MoodActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);


        Intent intent = getIntent();
        String choice = intent.getStringExtra("extra");

        //String audiofile = getResources().getString(R.string.audio_file);

        if (choice.equals("blue"))
        {
            //imageView
            ImageView raining = (ImageView)findViewById(R.id.imageView1);
            raining.setImageResource(R.drawable.raining);

            //play rain audio
            final MediaPlayer rain = MediaPlayer.create(this, R.raw.rain) ;
            findViewById(R.id.mood_layout).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    rain.start();
                }
            });

        }
        else if (choice.equals("yellow"))
        {//imageView
            ImageView birdi = (ImageView)findViewById(R.id.imageView2);
            birdi.setImageResource(R.drawable.birdy);

            //play bird audio
            final MediaPlayer bird = MediaPlayer.create(this, R.raw.birds) ;
            findViewById(R.id.mood_layout).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    bird.start();
                }
            });


        }
        else if (choice.equals("green"))
        {//imageView
            ImageView windi = (ImageView)findViewById(R.id.imageView3);
            windi.setImageResource(R.drawable.windy);
            //play wind audio
            final MediaPlayer wind = MediaPlayer.create(this, R.raw.wind) ;
            findViewById(R.id.mood_layout).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    wind.start();
                }
            });

        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build());

        String path = "android.resource://" + this.getPackageName() + "/raw/rain";
        Uri uri = Uri.parse(path);
        try {
            {
                mediaPlayer.setDataSource(getApplicationContext(), uri);
                mediaPlayer.prepare();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            mediaPlayer.start();

    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
