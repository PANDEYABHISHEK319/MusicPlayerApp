package music.com.musicplayer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SongPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean songPlay = true;
    private ImageButton playButton;
    private ImageButton previous;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_play);

        // Receive song details to be played and display them
        Intent in = getIntent();

        playButton = findViewById(R.id.play);
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.nextSong);
        TextView song_name = findViewById(R.id.song_name_display);
        TextView artist_name = findViewById(R.id.artist_name_display);
        song_name.setText(in.getStringExtra("SONG_NAME"));
        artist_name.setText(in.getStringExtra("ARTIST_NAME"));
        song_name.setSelected(true);
        song_name.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        playButton.setOnClickListener(this);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.play:
                if (songPlay) {
                    Toast.makeText(this, "Play Song", Toast.LENGTH_SHORT).show();
                    songPlay = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        playButton.setImageDrawable(getResources().getDrawable(R.drawable.pause));
                    }
                } else {
                    Toast.makeText(this, "Pause Song", Toast.LENGTH_SHORT).show();
                    songPlay = true;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        playButton.setImageDrawable(getResources().getDrawable(R.drawable.playbutton));
                    }
                }

                break;
            case R.id.previous:
                Toast.makeText(this, "Previous Song", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextSong:
                Toast.makeText(this, "Next Song ", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
