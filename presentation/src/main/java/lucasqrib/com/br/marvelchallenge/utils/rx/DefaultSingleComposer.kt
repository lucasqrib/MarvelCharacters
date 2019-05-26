package lucasqrib.com.br.marvelchallenge.utils.rx

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleLoadingBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleNetworkErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleEmptyStateBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView

class DefaultSingleComposer<T>(val view: BaseView) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(SingleLoadingBehavior(view))
            .compose(SingleEmptyStateBehavior(view))
            .compose(SingleErrorBehavior(view))
            .compose(SingleNetworkErrorBehavior(view))
    }

}