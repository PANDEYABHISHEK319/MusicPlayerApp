package music.com.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Song> songsList = new ArrayList<>();
    SongsAdapter mAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.songs_list_view);
        // Custom Adapter
        mAdapter = new SongsAdapter(songsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // OnClick on a song fromm the list
        recyclerView.addOnItemTouchListener(new RecyclerClickListner(getApplicationContext(), recyclerView, new RecyclerClickListner.ClickListener() {
            // Single Click
            @Override
            public void onClick(View view, int position) {
                // Launch the song player activity
                Song song = songsList.get(position);
                Intent intent = new Intent(getApplicationContext(), SongPlayActivity.class);
                // pass the song information to be played
                intent.putExtra("SONG_NAME", song.getSong_name());
                intent.putExtra("ARTIST_NAME", song.getArtist_name());
                startActivity(intent);
            }


            @Override
            public void onLongClick(View view, int position) {
                // Do nothing for now
            }
        }));

        recyclerView.setAdapter(mAdapter);
        prepareSongsData();
    }

    private void prepareSongsData() {
        songsList.add(new Song("First Song Song Song song song  ", "Artist 1", "03:10"));
        songsList.add(new Song("Second Song", "Artist 2", "03:50"));
        songsList.add(new Song("Third Song", "Artist 3", "02:49"));
        songsList.add(new Song("Forth Song", "Artist 4", "03:01"));
        songsList.add(new Song("Fifth Song", "Artist 5", "01:11"));
        songsList.add(new Song("Six Song", "Artist 6", "02:12"));
        songsList.add(new Song("Seven Song", "Artist 7", "03:22"));
        songsList.add(new Song("Eight Song", "Artist 8", "01:17"));
        songsList.add(new Song("Nine Song", "Artist 9", "02:53"));
        songsList.add(new Song("Ten Song", "Artist 9", "03:34"));
        songsList.add(new Song("11th Song", "Artist 10", "02:44"));
        songsList.add(new Song("12th Song", "Artist 11", "01:50"));
        songsList.add(new Song("13th Song", "Artist 12", "04:10"));
        songsList.add(new Song("14th Song", "Artist 13", "02:47"));
        songsList.add(new Song("15th Song", "Artist 14", "01:04"));
        songsList.add(new Song("16th Song", "Artist 15", "02:01"));
        songsList.add(new Song("17th Song", "Artist 16", "03:58"));
        songsList.add(new Song("18th Song", "Artist 17", "02:45"));
        songsList.add(new Song("19th Song", "Artist 18", "02:37"));
        songsList.add(new Song("20th Song", "Artist 1", "03:19"));
        mAdapter.notifyDataSetChanged();
    }
}
