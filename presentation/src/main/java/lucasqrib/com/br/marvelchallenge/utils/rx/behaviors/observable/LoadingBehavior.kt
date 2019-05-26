package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.LoadingView

class LoadingBehavior<T>(val view: LoadingView) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .doOnSubscribe { view.showLoading() }
            .doOnTerminate { view.hideLoading() }
    }
}