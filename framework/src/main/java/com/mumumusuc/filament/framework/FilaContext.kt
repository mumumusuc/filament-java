package com.mumumusuc.filament.framework

import java.io.InputStream
import com.google.android.filament.View

interface FilaBackend {
    fun asset(path: String): InputStream
}

interface FilaAdapter {
    fun create(backend: FilaBackend)
    fun attach(window: Any)
    fun dispatch(event: FilaEvent): Boolean
    fun detach()
    fun destroy()
}

interface FilaContext : FilaBackend {
    val frameTimeNanos: Long

    fun render(view: View)
}

interface FilaLayer {
    fun onCreate(context: FilaContext)
    fun onStart(context: FilaContext)
    fun onResized(context: FilaContext, width: Int, height: Int)
    fun onKeyEvent(context: FilaContext, event: FilaKeyEvent)
    fun onMouseEvent(context: FilaContext, event: FilaMouseEvent)
    fun onStop(context: FilaContext)
    fun onDestroy(context: FilaContext)
}
