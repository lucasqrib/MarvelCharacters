package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.NetworkErrorView
import java.io.IOException

class SingleNetworkErrorBehavior<T>(val view: NetworkErrorView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .doOnSubscribe { view.hideNetworkError() }
            .doOnError {
                if (it is IOException)
                    view.showNetworkError()
            }
    }

}