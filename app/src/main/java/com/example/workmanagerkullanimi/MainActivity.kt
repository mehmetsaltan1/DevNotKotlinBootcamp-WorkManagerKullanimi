package com.example.workmanagerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.example.workmanagerkullanimi.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        tasarim.buttonYap.setOnClickListener {
            val calismaKosulu = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

            val istek = OneTimeWorkRequestBuilder<MyWorker>().setInitialDelay(10,TimeUnit.SECONDS)
                .setConstraints(calismaKosulu)
                .build()
            WorkManager.getInstance(this@MainActivity).enqueue(istek)
        }
        tasarim.buttonBildirim.setOnClickListener {
            val istek = PeriodicWorkRequestBuilder<MyWorkerBildirim>(15,TimeUnit.MINUTES)
                .setInitialDelay(10,TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(this@MainActivity).enqueue(istek)
        }
    }
}