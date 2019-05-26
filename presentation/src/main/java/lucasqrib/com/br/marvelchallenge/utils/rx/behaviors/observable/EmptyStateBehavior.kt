package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.EmptyStateView
import retrofit2.HttpException

class EmptyStateBehavior<T>(val view: EmptyStateView) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .doOnSubscribe { view.hideEmptyState() }
            .doOnError {
                if (it is HttpException && it.code() == 404) {
                    view.showEmptyState()
                }
            }
    }
}