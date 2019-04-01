package com.clearcrane.playerdemo;

import android.widget.MediaController;

/**
 * Created by jjy on 2018/5/25.
 * <p>
 * ClearVideoView接口，继承自{@link MediaController.MediaPlayerControl}
 */
public interface IClearVideoView extends MediaController.MediaPlayerControl {
    /**
     * 设置视频地址
     *
     * @param uri 可以是网络地址也可以是本地
     */
    void setVideoPath(String uri);

    String getVideoPath();

    /**
     * 开始播放
     */
    void start();

    /**
     * 暂停播放
     */
    void pause();

    /**
     * 停止播放
     */
    void stop();

    /**
     * 释放资源
     */
    void release();

    /**
     * 获取当前播放位置
     *
     * @return 单位：ms
     */
    int getCurrentPosition();

    /**
     * 获取视频总长度
     *
     * @return 单位：ms
     */
    int getDuration();

    /**
     * 跳转到指定时间点
     *
     * @param position 单位：ms
     */
    void seekTo(int position);

    /**
     * 快进
     */
    void fastForward();

    /**
     * 快退
     */
    void fastBackward();

    /**
     * 显示UI
     */
    void show();

    /**
     * 隐藏UI
     */
    void hide();

    /**
     * 设置是否循环
     */
    void setLooping(boolean loop);

    boolean isPlaying();

    void setOnCompleteListener(OnCompleteListener listener);

    void setOnErrorListener(OnErrorListener listener);

    void setOnInfoListener(OnInfoListener listener);

    void setOnPreparedListener(OnPreparedListener listener);

    void setOnSizeChangeListener(OnSizeChangeListener listener);

    interface OnCompleteListener {
        <MP> void onComplete(MP mp);
    }

    interface OnErrorListener {
        <T extends Throwable> void onError(T ex);
    }

    interface OnInfoListener {
        <MP> void onInfo(MP mp, int what, int extra);
    }

    interface OnPreparedListener {
        <MP> void onPrepared(MP mp);
    }

    interface OnSizeChangeListener {
        <MP> void onVideoSizeChanged(MP mp, int width, int height, int sarNum, int sarDen);
    }

}
