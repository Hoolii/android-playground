package be.renaudraas.playground.business.usecase;

import rx.Observable;

interface UseCase<T> {
    Observable<T> execute();
}