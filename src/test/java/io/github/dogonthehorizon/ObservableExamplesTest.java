package io.github.dogonthehorizon;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

public class ObservableExamplesTest {

    @Test public void testEmptyObservable() {
        Observable<Object> o = ObservableExamples.empty();
        TestObserver<Object> testObserver = new TestObserver<>();
        o.subscribe(testObserver);

        testObserver.assertSubscribed();
        testObserver.assertNoValues();
        testObserver.assertComplete();
    }

    @Test public void testNeverObservable() {
        Observable<Object> o = ObservableExamples.never();
        TestObserver<Object> testObserver = new TestObserver<>();
        o.subscribe(testObserver);

        testObserver.assertSubscribed();
        testObserver.assertNotComplete();
    }

    @Test public void testRangeObservable() {
        Observable<Integer> o = ObservableExamples.range(0, 3);
        TestObserver<Integer> testObserver = new TestObserver<>();
        o.subscribe(testObserver);


        testObserver.assertValues(0, 1, 2, 3);
        testObserver.assertComplete();
    }
}
