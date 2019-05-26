package lucasqrib.com.br.domain

import io.reactivex.Single

object BaseUseCase {
    interface ObservableWithParameter<in T, R> {
        fun execute(param: T): io.reactivex.Observable<R>
    }

    interface Observable<R> {
        fun execute(): io.reactivex.Observable<R>
    }

    interface Single<R> {
        fun execute(): io.reactivex.Single<R>
    }

    interface CompletableWithParameter<in T> {
        fun execute(param: T): io.reactivex.Completable
    }

    interface Completable {
        fun execute(): io.reactivex.Completable
    }
}

