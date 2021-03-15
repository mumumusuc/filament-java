package com.mumumusuc.filament.framework

import com.google.android.filament.Engine
import com.google.android.filament.SwapChain
import java.awt.Canvas
import java.awt.Graphics

class FilaCanvas(private val mEngine: Engine) : Canvas() {
    private var mHasPainted = false
    private val mSwapChain: SwapChain by lazy {
        mEngine.createSwapChain(this, SwapChain.CONFIG_DEFAULT)
    }

    override fun paint(g: Graphics) {
        if (!mHasPainted) {
            super.paint(g)
            mHasPainted = true
        }
    }
}
