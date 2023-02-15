package com.example.restartapplicationexam

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restartBtn: Button = findViewById(R.id.restartAppBtn)
        restartBtn.setOnClickListener {
            restartApplication(this)
        }
    }

    private fun restartApplication(mContext: Context) {
        val packageManager: PackageManager = mContext.packageManager
        val intent = packageManager.getLaunchIntentForPackage(mContext.packageName)
        val componentName = intent!!.component
        val mainIntent = Intent.makeRestartActivityTask(componentName)
        mContext.startActivity(mainIntent)
        exitProcess(0)
    }
}