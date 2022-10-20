package com.example.weatherapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cleancoderxjava.comman.rxjava.addToCompositeDisposable
import com.example.weatherapp.comman.rxjava.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel<S : Any, E> : ViewModel() {

    val store by lazy {
        ViewStateStore(this.initState())
    }

    abstract fun initState(): S

    private val _liveEvent: SingleLiveEvent<E> = SingleLiveEvent()
    val liveEvent: LiveData<E>
        get() = _liveEvent


    val currentState: S
        get() = store.state

    private val compositeDisposable = CompositeDisposable()

    fun Disposable.addToCompositeDisposable() {
        addToCompositeDisposable(compositeDisposable)
    }

    protected fun dispatchEvent(event: E) {
        _liveEvent.value = event!!
    }

    protected fun dispatchState(state: S) {
        store.dispatchState(state)
    }


}