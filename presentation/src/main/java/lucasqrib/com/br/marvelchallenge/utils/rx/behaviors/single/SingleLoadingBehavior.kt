package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.LoadingView

class SingleLoadingBehavior<T>(val view: LoadingView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .doOnSubscribe { view.showLoading() }
            .doOnSuccess { view.hideLoading() }
            .doOnError { view.hideLoading() }
    }
}