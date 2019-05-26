package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.NetworkErrorView
import java.io.IOException

class NetworkErrorBehavior<T>(val view: NetworkErrorView) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .doOnSubscribe { view.hideNetworkError() }
            .doOnError {
                if (it is IOException)
                    view.showNetworkError()
            }
    }
}