package com.mumumusuc.filament.desktop

class DesktopLauncher {
    companion object {
        @JvmStatic
        @Suppress("unused")
        fun main(args: Array<String>) {
            println("hello world")
        }

        init {
            System.loadLibrary("awt")
            System.loadLibrary("filament-jni")
        }
    }
}