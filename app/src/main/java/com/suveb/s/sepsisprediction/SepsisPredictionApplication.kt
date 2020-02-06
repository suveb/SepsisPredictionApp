package com.suveb.s.sepsisprediction

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class SepsisPredictionApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@SepsisPredictionApplication))

        //BroadcastReceiver
        bind() from singleton { DataClass() }

    }
}