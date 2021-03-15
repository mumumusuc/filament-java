package com.mumumusuc.filament.desktop

import com.mumumusuc.filament.sample.HelloWorld

class DesktopLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            HelloWorld().run {
                onCreate()
                onRender()
                onDestroy()
            }
        }

        init {
            System.loadLibrary("jawt")
            System.loadLibrary("filament-jni")
        }
    }
}