package lucasqrib.com.br.marvelchallenge.utils.rx

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView

fun <T> Observable<T>.subscribeWithDefaultBehavior(view: BaseView, onNext: (T) -> Unit): Disposable? {
    return this.compose(DefaultComposer(view))
        .subscribe(onNext, {})
}


fun <T> Single<T>.subscribeWithDefaultBehavior(
    view: BaseView,
    onError: (Throwable) -> Unit = {},
    onSuccess: (T) -> Unit
): Disposable? {
    return this.compose(DefaultSingleComposer(view))
        .subscribe(onSuccess, onError)
}

fun Completable.subscribeWithDefaultBehavior(onComplete: () -> Unit, onError: (Throwable) -> Unit = {}): Disposable? {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onComplete, onError)
}