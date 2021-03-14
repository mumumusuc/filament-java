package com.mumumusuc.filament.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.filament.Filament

class FilamentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        init {
            Filament.init()
        }
    }
}
