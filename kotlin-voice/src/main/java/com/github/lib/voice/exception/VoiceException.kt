package com.github.lib.voice.exception

class VoiceException(val code: Int = 0, msg: String? = null, e: Exception? = null) : Exception() {
    constructor(code: Int = 0, msg: String) : this(0, msg, null)
    constructor(e: Exception) : this(code = 0, msg = null, e = e)
}