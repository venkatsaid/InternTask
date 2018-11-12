package com.example.venkat_sai.interntask;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

//import com.google.android.exoplayer2.source.ExtractorMediaSource.Factory;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

public class VideoPlayerActivity extends AppCompatActivity {
//
//    SimpleExoPlayerView exoPlayerView;
//    SimpleExoPlayer exoPlayer;
//    String videoUrl;
    Boolean exoplayerReady;
    long VideoPosition;

    SimpleExoPlayerView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    String videoURL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffd974_-intro-creampie/-intro-creampie.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        //videoUrl="https://www.youtube.com/watch?v=s3Q6AM4MDs4";

 /*       //videoUrl="android.resource://" + getPackageName() + "/" + R.raw.videofile;
        //videoUrl="https://www.youtube.com/watch?v=s3Q6AM4MDs4";
        videoUrl="https://d17h27t6h515a5.cloudfront.net/topher/2017/April/58ffd974_-intro-creampie/-intro-creampie.mp4";
        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player);

        if (savedInstanceState!=null){
            VideoPosition=savedInstanceState.getLong("savedPosition");
            exoplayerReady=savedInstanceState.getBoolean("video_state");
        }

//        SimpleExoPlayer exoPlayer = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
//        exoPlayerView.setPlayer(exoPlayer);
//
//        final RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this);
//        DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(R.raw.videofile));
//        try {
//            rawResourceDataSource.open(dataSpec);
//
//            DataSource.Factory factory = new DataSource.Factory() {
//                @Override
//                public DataSource createDataSource() {
//                    return rawResourceDataSource;
//                }
//            };
//            MediaSource videoSource = new ExtractorMediaSource.Factory(factory).createMediaSource(rawResourceDataSource.getUri());
//            exoPlayer.prepare(videoSource);
//
//        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
//            e.printStackTrace();
//        }
        try {
            Log.i("123","1");
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            Log.i("123","2");
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            Log.i("123","3");
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
            Log.i("123","4");
            Uri videoURI = Uri.parse(videoUrl);
            Log.i("123","5");
            DefaultHttpDataSourceFactory dataSourcefactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            Log.i("123","6");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            Log.i("123","7");
            MediaSource mediaSource = new ExtractorMediaSource(videoURI,dataSourcefactory, extractorsFactory, null, null);
            Log.i("123","8");
            exoPlayerView.setPlayer(exoPlayer);
            Log.i("123","9");
            exoPlayer.prepare(mediaSource);
            Log.i("123","10");
            exoPlayer.setPlayWhenReady(exoplayerReady);
            Log.i("123","11");
            exoPlayer.seekTo(VideoPosition);
            Log.i("123","12");
        } catch (Exception e) {
            Log.e("Exoplayer exception", "error");
        }

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)exoPlayerView.getLayoutParams();
            params.width= Resources.getSystem().getDisplayMetrics().widthPixels;
            params.height=Resources.getSystem().getDisplayMetrics().heightPixels;
            exoPlayerView.setLayoutParams(params);
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)exoPlayerView.getLayoutParams();
            params.width= Resources.getSystem().getDisplayMetrics().widthPixels;
            params.height=600;
            exoPlayerView.setLayoutParams(params);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("savedPosition", exoPlayer.getCurrentPosition());
        if (exoPlayer!=null){
            outState.putLong("savedPosition",exoPlayer.getCurrentPosition());
            outState.putBoolean("video_state",exoPlayer.getPlayWhenReady());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }
    public void releasePlayer(){
        if (exoPlayer!=null){
            exoPlayer.stop();
            exoPlayer.release();
        }
    }
*/
        if (savedInstanceState!=null){
            VideoPosition=savedInstanceState.getLong("savedPosition");
            exoplayerReady=savedInstanceState.getBoolean("video_state");
        }
        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.exo_player);
        try {


            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            Uri videoURI = Uri.parse(videoURL);

            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);

            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(exoplayerReady);
            Log.i("123","11");
            exoPlayer.seekTo(VideoPosition);
            Log.i("123","12");
            //exoPlayer.setPlayWhenReady(true);

        }catch (Exception e){
            Log.e("MainAcvtivity"," exoplayer error "+ e.toString());
        }

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)exoPlayerView.getLayoutParams();
            params.width= Resources.getSystem().getDisplayMetrics().widthPixels;
            params.height=Resources.getSystem().getDisplayMetrics().heightPixels;
            exoPlayerView.setLayoutParams(params);
        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            LinearLayout.LayoutParams params=(LinearLayout.LayoutParams)exoPlayerView.getLayoutParams();
            params.width= Resources.getSystem().getDisplayMetrics().widthPixels;
            params.height=600;
            exoPlayerView.setLayoutParams(params);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("savedPosition", exoPlayer.getCurrentPosition());
        if (exoPlayer!=null){
            outState.putLong("savedPosition",exoPlayer.getCurrentPosition());
            outState.putBoolean("video_state",exoPlayer.getPlayWhenReady());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releasePlayer();
    }
    public void releasePlayer(){
        if (exoPlayer!=null){
            exoPlayer.stop();
            exoPlayer.release();
        }
    }
}
