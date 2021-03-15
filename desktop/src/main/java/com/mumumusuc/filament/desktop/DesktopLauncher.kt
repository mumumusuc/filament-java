package com.mumumusuc.filament.desktop

import com.mumumusuc.filament.sample.HelloWorld
import java.awt.Canvas
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame

private const val kWindowWidth = 400
private const val kWindowHeight = 400

class DesktopLauncher {
    private var mQuit = false
    private val mCanvas: Canvas = Canvas().apply {
        preferredSize = Dimension(kWindowWidth, kWindowHeight)
        isVisible = true
    }

    init {
        JFrame(javaClass.simpleName).run {
            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(e: WindowEvent) {
                    mQuit = true
                }
            })
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            add(mCanvas)
            pack()
            isResizable = false
            isVisible = true
            setLocationRelativeTo(null)
        }
    }

    fun start() {
        HelloWorld().run {
            onCreate()
            onAttach(mCanvas)
            onResized(mCanvas.width, mCanvas.height)
            while (!mQuit) {
                onRender()
                Thread.sleep(16)
            }
            onDetach()
            onDestroy()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            DesktopLauncher().start()
        }

        init {
            System.loadLibrary("jawt")
            System.loadLibrary("filament-jni")
        }
    }
}