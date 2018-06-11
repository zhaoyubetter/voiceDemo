package com.github.lib.voice.player

/**
 * player interface
 */
interface PlayerAPI {
    fun startPlay(filePath: String, listener: PlayListener)
    fun stopPlay()
    fun pause()
    fun isPlaying(): Boolean
    fun release()
}