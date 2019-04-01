package com.clearcrane.playerdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String TAG = "playerdemo";

    public ClearVideoView videoView;
    public EditText urlTextView;
    public SharedPreferences globalSharedPreferences = null;
    String playUrl = "http://192.168.18.235/live/BEIJINGWS/BEIJINGWS.m3u8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        globalSharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        playUrl = globalSharedPreferences.getString("url", playUrl);
        videoView = this.findViewById(R.id.global_video_view);
        urlTextView =  this.findViewById(R.id.url_edit_view);
        urlTextView.setText(playUrl);
        videoView.setLooping(true);
//        videoView.setVideoPath("http://192.18.18.235/live/CCTV1HD/CCTV1HD.m3u8");
        videoView.setVideoPath(playUrl);
//        videoView.setVideoPath("http://192.18.18.235/live/cc/CCTV1HD.m3u8");
//        videoView.setVideoPath("http://192.168.18.101/openvod/now/Video/resource/BEIJINGWS/BEIJINGWS.m3u8");
//        videoView.setVideoPath("http://192.168.18.101/openvod/now/Video/resource/SHANDONGWS/SHANDONGWS.m3u8");
//        videoView.setVideoPath("/tmp/zrx.mp4");
//        videoView.setVideoPath("/tmp/CCTV1HD/CCTV1HD-83455.ts");
//        videoView.setVideoPath("/tmp/BEIJINGWS/BEIJINGWS-1329.ts");
//        videoView.setVideoPath("/tmp/BEIJINGWS/BEIJINGWS.m3u8");
        videoView.start();
    }

//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode){
//            case KeyEvent.KEYCODE_DPAD_RIGHT:
//                videoView.setVideoPath("http://192.168.18.235/live/cc/CCTV1HD.m3u8");
//                videoView.start();
//                return true;
//            case KeyEvent.KEYCODE_DPAD_LEFT:
//                videoView.setVideoPath("http://192.168.18.235/live/BEIJINGWS/BEIJINGWS.m3u8");
//                videoView.start();
//                return true;
//            case KeyEvent.KEYCODE_DPAD_DOWN:
//                videoView.setVideoPath("http://192.168.18.235/live/BEIJINGWS/BEIJINGWS-1329.ts");
//                videoView.start();
//                return true;
//        }
//        return false;
//    }

    public void playVideo(View v){
        String url = urlTextView.getText().toString();
        SharedPreferences.Editor editor = globalSharedPreferences.edit();
        editor.putString("url", url);
        editor.commit();
        Log.i(TAG, "url:" + url);
        videoView.setVideoPath(url);
        videoView.start();
    }


}
