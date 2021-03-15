package com.mumumusuc.filament.sample

import com.google.android.filament.*

class HelloWorld {
    private lateinit var mEngine: Engine
    private lateinit var mRenderer: Renderer
    private lateinit var mCamera: Camera
    private lateinit var mScene: Scene
    private lateinit var mView: View
    private var mSwapChain: SwapChain? = null

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
        mCamera = mEngine.createCamera()
        mScene = mEngine.createScene()
        mView = mEngine.createView().apply {
            camera = mCamera
            scene = mScene
        }
    }

    fun onAttach(window: Any) {
        check(mSwapChain == null) {
            println("already attached")
        }
        mSwapChain = mEngine.createSwapChain(window, SwapChain.CONFIG_DEFAULT)
    }

    fun onResized(width: Int, height: Int) {
        mView.viewport = Viewport(0, 0, width, height)
    }

    fun onRender() {
        mSwapChain?.run {
            if (mRenderer.beginFrame(this, 0L)) {
                mRenderer.render(mView)
                mRenderer.endFrame()
            }
        }
    }

    fun onDetach() {
        mSwapChain?.run {
            mEngine.destroySwapChain(this)
        }
        mSwapChain = null
    }

    fun onDestroy() {
        mEngine.run {
            destroyView(mView)
            destroyScene(mScene)
            destroyCamera(mCamera)
            destroyRenderer(mRenderer)
            mSwapChain?.run { destroySwapChain(this) }
            destroy()
        }
    }
}