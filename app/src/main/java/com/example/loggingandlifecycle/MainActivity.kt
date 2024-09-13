package com.example.loggingandlifecycle

import android.app.TaskStackBuilder
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.nfc.Tag
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // in java a static constant was declared how...
    // public static final int PI = 3

    // in Kotlin without a static keyword we use a companion object
    companion object {
        // all of the variables in here will be static
        val TAG = "MainActivity" // useful for the log functions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: hi from Oncreate")


        // here is a comment to learn how to use github
        // hit command+k to commit something (git-> commit in the menu)
        // select which files you want to include in the commit.
        // give a description of the commit
        // select commit and push

        // more changes

        // Hi from the web github
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Hello from onResume")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG, "Hello from onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"Hello from onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Hello from onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Hello from onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "hello fron onDestroy")
    }

}

