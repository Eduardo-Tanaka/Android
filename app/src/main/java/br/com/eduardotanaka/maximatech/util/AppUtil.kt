package br.com.eduardotanaka.maximatech.util

import android.os.Looper

fun onMainThread() = Looper.myLooper() == Looper.getMainLooper()
