package com.github.lib.voice.player

import android.media.AudioManager
import android.media.MediaPlayer
import com.github.lib.voice.exception.VoiceException

/**
 * mediaPlayer 工具类封装
 * <pre>
 * 参考：
 * 1.http://blog.csdn.net/u014365133/article/details/53330776
 * 2.http://www.cnblogs.com/MMLoveMeMM/articles/3444718.html
 * </pre>
 * Created by zhaoyu on 2017/10/20.
 */
class MediaPlayer : PlayerAPI {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playListener: PlayListener

    init {
        mediaPlayer = MediaPlayer().apply {
            // 设置流媒体类型
            setAudioStreamType(AudioManager.STREAM_MUSIC)
        }
    }

    override fun startPlay(filePath: String, listener: PlayListener) {
        this.playListener = listener
        setListeners()
        try {
            mediaPlayer.apply {
                reset()
                setDataSource(filePath)
                prepareAsync()
            }
        } catch (e: Exception) {
            playListener.onError(VoiceException(e))
        }
    }

    override fun pause() {
        mediaPlayer.pause()
        playListener.onPause()
    }


    override fun stopPlay() {
        if (mediaPlayer?.isPlaying) {
            mediaPlayer.stop()
            playListener.onStop()
        }
    }

    override fun isPlaying() = mediaPlayer.isPlaying
    override fun release() {
        stop()
        if (mediaPlayer != null) {
            mediaPlayer.release()
        }
    }

    private inline fun setListeners() {
        mediaPlayer.setOnPreparedListener {
            mediaPlayer.start()
            playListener.onStart()
        }

        mediaPlayer.setOnCompletionListener {
            stop()
            playListener.onComplete()
        }
        mediaPlayer.setOnErrorListener { _, what, extra ->
            playListener.onError(VoiceException(what, "MediaPlayer error: $extra"))
            false
        }
    }

    private inline fun stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }

}