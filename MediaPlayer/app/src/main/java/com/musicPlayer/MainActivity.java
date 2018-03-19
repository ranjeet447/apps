package com.musicPlayer;

import android.media.MediaCodec;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.musicPlayer.R.id.play_button;
import static com.musicPlayer.R.raw.song;

public class MainActivity extends AppCompatActivity {

   private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer =  MediaPlayer.create(MainActivity.this, song);

       Button playButton = (Button) findViewById(play_button);
       Button pauseButton = (Button) findViewById(R.id.pause_button);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(getApplicationContext(),"I'm done!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            boolean userTouch;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer.isPlaying() && userTouch)
                    mediaPlayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userTouch = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userTouch = false;
            }

        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
