package lucasqrib.com.br.marvelchallenge.utils.rx

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable.EmptyStateBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable.ErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable.LoadingBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.observable.NetworkErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleLoadingBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.behaviors.single.SingleNetworkErrorBehavior
import lucasqrib.com.br.marvelchallenge.utils.rx.views.BaseView

class DefaultComposer<T>(val view: BaseView) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(LoadingBehavior(view))
            .compose(EmptyStateBehavior(view))
            .compose(ErrorBehavior(view))
            .compose(NetworkErrorBehavior(view))
    }
}