package lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import lucasqrib.com.br.marvelchallenge.utils.rx.views.EmptyStateView
import retrofit2.HttpException

class SingleEmptyStateBehavior<T>(val view: EmptyStateView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .doOnSubscribe { view.hideEmptyState() }
            .doOnError {
                if (it is HttpException && it.code() == 404) {
                    view.showEmptyState()
                }
            }
    }

}