package florent37.github.com.rxcomponentlifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import florent37.github.com.rxlifecycle.RxLifecycle;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class MainActivity extends AbstractActivity implements LifecycleRegistryOwner {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

        RxLifecycle.with(getLifecycle())
                .onEvent()
                .subscribe(new Consumer<Lifecycle.Event>() {
                    @Override
                    public void accept(@NonNull Lifecycle.Event event) throws Exception {
                        final CharSequence text = textView.getText();
                        textView.setText(text + "\n" + event.toString());
                    }
                });
    }

}
