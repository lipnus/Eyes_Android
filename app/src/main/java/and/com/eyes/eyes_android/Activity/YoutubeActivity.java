package and.com.eyes.eyes_android.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

import and.com.eyes.eyes_android.R;

public class YoutubeActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;
    String youtubePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);


        youTubePlayerView = findViewById(R.id.youtube_player_view);


        //영상처리
        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        String videoId = "kKZIs5mUZRE";
                        initializedYouTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        }, true);
    }
}
