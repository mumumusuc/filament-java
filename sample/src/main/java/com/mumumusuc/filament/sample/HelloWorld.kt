package com.mumumusuc.filament.sample

import com.google.android.filament.*
import java.awt.Canvas
import java.awt.Dimension
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE

private const val kWindowWidth = 400
private const val kWindowHeight = 400

class HelloWorld {
    private lateinit var mEngine: Engine
    private lateinit var mSwapChain: SwapChain
    private lateinit var mRenderer: Renderer
    private lateinit var mCamera: Camera
    private lateinit var mScene: Scene
    private lateinit var mView: View
    private val mCanvas = Canvas()
    private var mQuit = false

    init {
        mCanvas.run {
            preferredSize = Dimension(kWindowWidth, kWindowHeight)
            isVisible = true
        }
        JFrame(javaClass.simpleName).run {
            addWindowListener(object : WindowAdapter() {
                override fun windowClosing(e: WindowEvent) {
                    println("WINDOW_CLOSING")
                    mQuit = true
                }
            })
            defaultCloseOperation = EXIT_ON_CLOSE
            setLocationRelativeTo(null)
            add(mCanvas)
            pack()
            isResizable = false
            isVisible = true
        }
    }

    fun onCreate() {
        mEngine = Engine.create(Engine.Backend.DEFAULT)
        mRenderer = mEngine.createRenderer().apply {
            clearOptions = Renderer.ClearOptions().apply {
                clear = true
                clearColor[0] = 0.0f
                clearColor[1] = 0.0f
                clearColor[2] = 0.6f
                clearColor[3] = 1.0f
            }
        }
        mSwapChain = mEngine.createSwapChain(mCanvas, SwapChain.CONFIG_DEFAULT)
        mCamera = mEngine.createCamera()
        mScene = mEngine.createScene()
        mView = mEngine.createView().apply {
            viewport = Viewport(0, 0, kWindowWidth, kWindowHeight)
            camera = mCamera
            scene = mScene
        }
    }

    fun onRender() {
        while (!mQuit) {
            if (mRenderer.beginFrame(mSwapChain, 0L)) {
                mRenderer.render(mView)
                mRenderer.endFrame()
            }
            Thread.sleep(16)
        }
    }

    fun onDestroy() {
        mEngine.run {
            destroyView(mView)
            destroyScene(mScene)
            destroyCamera(mCamera)
            destroyRenderer(mRenderer)
            destroySwapChain(mSwapChain)
            destroy()
        }
    }
}