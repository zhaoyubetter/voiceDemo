package com.github.lib.voice.player

interface PlayListener {
    fun onStart()
    fun onPause()
    fun onStop()
    fun onError(e: Exception)
    fun onComplete()
}