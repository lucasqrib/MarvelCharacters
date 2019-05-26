package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.ErrorView
import retrofit2.HttpException

class SingleErrorBehavior<T>(val view: ErrorView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .doOnSubscribe { view.hideError() }
            .doOnError {
                if (it is HttpException && it.code() == 404) return@doOnError
                else if (it is HttpException) view.showError()
            }
    }
}