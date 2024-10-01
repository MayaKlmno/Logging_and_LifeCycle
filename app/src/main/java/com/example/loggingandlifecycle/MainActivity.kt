package com.example.loggingandlifecycle

import android.app.TaskStackBuilder
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.nfc.Tag
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // in java a static constant was declared how...
    // public static final int PI = 3
    private lateinit var startStopButton: Button
    private lateinit var resetButton: Button
    private lateinit var chronometer: Chronometer
    private var start = true
    //private var isRunning = false
    private var displayTime = 0L

    // in Kotlin without a static keyword we use a companion object
    companion object {
        // all of the variables in here will be static
        val TAG = "MainActivity" // useful for the log functions
        val STATE_IS_RUNNING = "is the stopwatch running"
        val STATE_DISPLAY_TIME = "current time on stopwatch"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        wireWidgets()

        Log.d(TAG, "onCreate: hi from Oncreate")

        // retrieve info from the savedInstanceState if it exists
        if(savedInstanceState != null){
            displayTime = savedInstanceState.getLong(STATE_DISPLAY_TIME)
            start = savedInstanceState.getBoolean(STATE_IS_RUNNING)
        }
        chronometer.setBase(SystemClock.elapsedRealtime() - displayTime)
        //displayTime = SystemClock.elapsedRealtime() - chronometer.getBase()

        resetButton.text = "reset"

        if(!start){
            //chronometer.setBase(SystemClock.elapsedRealtime() - displayTime)
            //chronometer.base = SystemClock.elapsedRealtime() - displayTime
            //displayTime = SystemClock.elapsedRealtime() - chronometer.getBase()
            chronometer.start()
            startStopButton.text = "stop"

        }

        if(start){
            //chronometer.setBase(SystemClock.elapsedRealtime() - displayTime)
            //chronometer.text = "start"
            //chronometer.base = SystemClock.elapsedRealtime() - displayTime
            //displayTime = SystemClock.elapsedRealtime() - chronometer.getBase()
            //chronometer.stop()
        }


        // here is a comment to learn how to use github
        // hit command+k to commit something (git-> commit in the menu)
        // select which files you want to include in the commit.
        // give a description of the commit
        // select commit and push



        startStopButton.setOnClickListener {
            if(start) {
                chronometer.base = SystemClock.elapsedRealtime() - displayTime
                chronometer.start()
                startStopButton.text = "Stop"
                //val timeInMilSeconds =
                //val base = SystemClock.elapsedRealtime()

                start = false
            } else {
                chronometer.stop()
                displayTime = SystemClock.elapsedRealtime() - chronometer.base
                startStopButton.text = "Start"
                start = true
            }
        }
        //System.currentTimeMillis()


        resetButton.setOnClickListener {
            chronometer.stop()
            displayTime = 0L
            startStopButton.text = "Start"

            chronometer.base = SystemClock.elapsedRealtime()
        }

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
        Log.d(TAG, "hello from onDestroy")
    }



    // to maintain the state, we use the saved Instance State
    override fun onSaveInstanceState(outState: Bundle) {
        // calculate the display time if needed and then store
        // the values of the display time and is Running

        //The Bundle stores key-value paris
        // while an array is an int --> object relationship,
        // bundles are string --> object
        // generally use constants for code readability/reuse
        outState.putBoolean(STATE_IS_RUNNING, start)
            if(!start){
                displayTime = SystemClock.elapsedRealtime() - chronometer.getBase()
            }
        outState.putLong(STATE_DISPLAY_TIME, displayTime)

        super.onSaveInstanceState(outState)
    }



    private fun wireWidgets(){
        startStopButton = findViewById(R.id.button_mainActivity_startStop)
        resetButton = findViewById(R.id.button_mainActivity_reset)
        chronometer = findViewById(R.id.chronometer_mainActivity_stopwatch)
    }

}

