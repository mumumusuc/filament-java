package com.mumumusuc.filament.android

import android.os.Bundle
import android.view.Choreographer
import android.view.Surface
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.filament.Filament
import com.google.android.filament.android.UiHelper
import com.mumumusuc.filament.sample.HelloWorld

class FilamentActivity : AppCompatActivity() {
    private val mApp = HelloWorld()
    private val mUiHelper = UiHelper()
    private lateinit var mSurface: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSurface = SurfaceView(this).also {
            setContentView(it)
        }
        mUiHelper.renderCallback = object : UiHelper.RendererCallback {
            override fun onNativeWindowChanged(surface: Surface) {
                mApp.onAttach(surface)
            }

            override fun onResized(width: Int, height: Int) {
                mApp.onResized(width, height)
            }

            override fun onDetachedFromSurface() {
                mApp.onDetach()
            }
        }
        mUiHelper.attachTo(mSurface)
        mApp.onCreate()
        Choreographer.getInstance().postFrameCallback(object : Choreographer.FrameCallback {
            override fun doFrame(frameTimeNanos: Long) {
                mApp.onRender()
                Choreographer.getInstance().postFrameCallback(this)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mApp.onDestroy()
    }

    companion object {
        init {
            Filament.init()
        }
    }
}
