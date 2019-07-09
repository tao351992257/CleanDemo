package com.example.domain.usercase

import com.example.domain.observer.ETObserver
import dagger.internal.Preconditions
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 *  Author : JinTao Li
 *  Create Time : 2019/7/9
 */
abstract class ExecuteUseCase {
    private val disposables: CompositeDisposable by lazy { CompositeDisposable() }

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observable build
     * by [.buildUseCaseObservable] ()} method.
     * @param observableT [Observable] which will be used when executing the current [ExecuteUseCase]
     */
    fun <T> execute(observer: DisposableObserver<T>, observableT: Observable<T>) {
        Preconditions.checkNotNull(observer)
        val observable = observableT
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        addDisposable(observable.subscribeWith(observer))
    }
    /**
     * Executes the current use case.
     *
     * by [.buildUseCaseObservable] ()} method.
     * @param observableT [Observable] which will be used when executing the current [ExecuteUseCase]
     */
    fun <T> execute(observableT: Observable<T>) {
        val etObserver = object : ETObserver<T>(null) {
            override fun onSuccess(t: T) {

            }

            override fun onFail(e: Throwable) {

            }

        }
        Preconditions.checkNotNull(etObserver)
        val observable = observableT
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        addDisposable(observable.subscribeWith(etObserver))
    }

    fun <T> executeNoDispose(observer: Observer<T>, observable: Observable<T>) {
        Preconditions.checkNotNull(observer)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun <T> executeSync(observer: Observer<T>, observable: Observable<T>) {
        Preconditions.checkNotNull(observer)
        observable.subscribe(observer)
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    /**
     * Clear from current [CompositeDisposable].
     */
    fun clear() {
        disposables.clear()
    }

    /**
     * Has Dispose from current [CompositeDisposable].
     */
    fun hasDisposables(): Boolean {
        return disposables.size() > 0
    }

    /**
     * Add Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}