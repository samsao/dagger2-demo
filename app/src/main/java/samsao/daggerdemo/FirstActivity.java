package samsao.daggerdemo;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.Component;
import samsao.daggerdemo.rest.RestClient;

public class FirstActivity extends Activity {

    @Inject
    protected RestClient restClient;

    private FirstActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        DemoApplication application = (DemoApplication) getApplication();

        component = DaggerFirstActivity_FirstActivityComponent.builder()
                .appComponent(application.getComponent())
                .build();

        component.inject(this);


    }



    public FirstActivityComponent getComponent() {
        return component;
    }

    @Component(dependencies = DemoApplication.AppComponent.class)
    @DaggerScope(FirstActivityComponent.class)
    public interface FirstActivityComponent extends DemoApplication.AppComponent {

        void inject(FirstActivity activity);

    }
}
