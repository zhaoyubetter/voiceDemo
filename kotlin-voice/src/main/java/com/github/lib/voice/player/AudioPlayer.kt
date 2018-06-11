//package com.github.lib.voice.player
//
//import android.media.AudioManager
//import android.media.AudioTrack
//import com.github.lib.voice.param.VoiceType
//import java.io.DataInputStream
//
///**
// * pcm 无损格式播放
// * Created by zhaoyu on 2017/10/20.
// */
//class AudioPlayer : PlayerAPI {
//
//    companion object {
//        private val DEFAULT_STREAM_TYPE = AudioManager.STREAM_MUSIC
//        private val DEFAULT_PLAY_MODE = AudioTrack.MODE_STREAM
//    }
//
//    /**
//     * 是否播放
//     */
//    var playing = false
//        private set
//    var minBufferSize = 0
//    private var mAudioTrack: AudioTrack? = null
//    private var dis: DataInputStream? = null
//    private lateinit var playListener: PlayListener
//    private lateinit var voiceType: VoiceType
//    private var param: AudioPlayParam? = null
//    private var audioPlayerExtraHandle: AudioPlayerExtraHandle? = null
//
//
//    override fun startPlay(filePath: String, listener: PlayListener) {
//
//    }
//
//    override fun stopPlay() {
//    }
//
//    override fun pause() {
//    }
//
//    override fun isPlaying(): Boolean {
//    }
//
//    override fun release() {
//    }
//
//}