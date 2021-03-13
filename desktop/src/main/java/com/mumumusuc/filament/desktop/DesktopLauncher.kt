package com.mumumusuc.filament.desktop

class DesktopLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("hello world")
        }

        init {
            System.loadLibrary("filament-jni")
        }
    }
}