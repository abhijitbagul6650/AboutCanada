package com.infosys.aboutcanada.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infosys.aboutcanada.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AboutCanadaFragment.newInstance())
                .commitNow()
        }
    }
}