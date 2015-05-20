package samsao.daggerdemo;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.Component;
import samsao.daggerdemo.rest.RestClient;

public class SecondActivity extends Activity {

    @Inject
    protected RestClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        DemoApplication application = (DemoApplication) getApplication();

        SecondActivityComponent component = DaggerSecondActivity_SecondActivityComponent.builder()
                .appComponent(application.getComponent())
                .build();

        component.inject(this);


    }

    @Component(dependencies = DemoApplication.AppComponent.class)
    @DaggerScope(SecondActivityComponent.class)
    public interface SecondActivityComponent extends DemoApplication.AppComponent {

        void inject(SecondActivity activity);

    }
}
