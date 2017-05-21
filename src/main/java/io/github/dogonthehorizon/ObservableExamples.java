package io.github.dogonthehorizon;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.stream.IntStream;

/**
 * As an exercise, try to implement never(), empty(), or even range() by using only create().
 *
 * Reactive Programming with RxJava, Nurkiewicz & Christensen; pg.35
 */
public class ObservableExamples {

    /**
     * Never emits any notifications, neither values nor completion or error. This stream is useful for testing
     * purposes.
     *
     * @return a 'never' Observable.
     */
    public static <T> Observable<T> never() {
        return Observable.create(subscriber -> {
            // Do nothing
        });
    }

    /**
     * Completes immediately after subscription, without emitting any values.
     *
     * @return an 'empty' Observable.
     */
    public static <T> Observable<T> empty() {
        return Observable.create(ObservableEmitter::onComplete);
    }

    /**
     * Produces 'n' integer numbers starting from 'from'.
     *
     * For example, range(5,3) will emit 5, 6, and 7 and then complete normally. Each subscriber will receive the
     * same set of numbers.
     *
     * @param from the number to start emitting from.
     * @param n the number of iterations.
     * @return a 'range' observable.
     */
    public static Observable<Integer> range(int from, int n) {
        return Observable.create(subscriber -> {
            IntStream.rangeClosed(from, from + n).boxed().forEach(subscriber::onNext);
            subscriber.onComplete();
        });
    }
}
