package com.example.androiddemo.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

TODO：讲名字改为MainApplication，放在app根目录下。
这是程序的入口，放在utils下算怎么回事

class MyApplicaiton:Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}
