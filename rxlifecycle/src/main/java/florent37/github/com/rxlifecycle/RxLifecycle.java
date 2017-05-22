package florent37.github.com.rxlifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.LifecycleRegistry;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import static android.arch.lifecycle.Lifecycle.Event.*;
import static android.arch.lifecycle.Lifecycle.Event.ON_ANY;
import static android.arch.lifecycle.Lifecycle.Event.ON_CREATE;
import static android.arch.lifecycle.Lifecycle.Event.ON_DESTROY;
import static android.arch.lifecycle.Lifecycle.Event.ON_PAUSE;
import static android.arch.lifecycle.Lifecycle.Event.ON_RESUME;
import static android.arch.lifecycle.Lifecycle.Event.ON_START;
import static android.arch.lifecycle.Lifecycle.Event.ON_STOP;

/**
 * Created by florentchampigny on 21/05/2017.
 */

public class RxLifecycle {

    private final Subject<Lifecycle.Event> subject = PublishSubject.<Lifecycle.Event>create().toSerialized();
    private final RxLifecycleObserver observer;

    public RxLifecycle(LifecycleRegistry lifecycleRegistry) {
        observer = new RxLifecycleObserver(subject);
        lifecycleRegistry.addObserver(observer);
    }

    public static RxLifecycle with(LifecycleRegistry lifecycleRegistry) {
        return new RxLifecycle(lifecycleRegistry);
    }

    public static RxLifecycle with(LifecycleActivity lifecycleActivity) {
        return new RxLifecycle(lifecycleActivity.getLifecycle());
    }

    public static RxLifecycle with(LifecycleFragment lifecycleFragment) {
        return new RxLifecycle(lifecycleFragment.getLifecycle());
    }

    public Observable<Lifecycle.Event> onEvent(){
        return subject;
    }

    public Observable<Lifecycle.Event> onCreate() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_CREATE.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onStart() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_START.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onResume() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_RESUME.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onPause() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_PAUSE.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onStop() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_STOP.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onDestroy() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_DESTROY.equals(event);
            }
        });
    }

    public Observable<Lifecycle.Event> onAny() {
        return onEvent().filter(new Predicate<Lifecycle.Event>() {
            @Override
            public boolean test(@NonNull Lifecycle.Event event) throws Exception {
                return ON_ANY.equals(event);
            }
        });
    }
}
