package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.ErrorView
import retrofit2.HttpException

class ErrorBehavior<T>(val view: ErrorView) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .doOnSubscribe { view.hideError() }
            .doOnError {
                if (it is HttpException && it.code() == 404) return@doOnError
                else if (it is HttpException) view.showError()
            }
    }
}