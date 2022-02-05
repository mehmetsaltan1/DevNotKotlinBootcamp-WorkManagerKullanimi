package com.example.workmanagerkullanimi

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.android.material.snackbar.Snackbar

class MyWorker(appContext: Context,workerParams: WorkerParameters) : Worker(appContext,workerParams) {
    override fun doWork(): Result {
        val toplam = 10 + 20
        return Result.success()
    }
}