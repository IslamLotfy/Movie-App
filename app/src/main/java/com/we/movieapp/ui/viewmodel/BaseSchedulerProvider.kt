package com.we.movieapp.ui.viewmodel

import io.reactivex.Scheduler

interface BaseSchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler

}