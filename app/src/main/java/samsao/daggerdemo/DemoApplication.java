package samsao.daggerdemo;

import android.app.Application;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import samsao.daggerdemo.rest.OkHttp;
import samsao.daggerdemo.rest.RestClient;

/**
 * @author Lukasz Piliszczuk <lukasz.pili@gmail.com>
 */
public class DemoApplication extends Application {

    private AppComponent component;

    @Inject
    protected RestClient restClient;

    @Override
    public void onCreate() {

        component = DaggerDemoApplication_AppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }

    @Component(modules = {AppModule.class})
    @DaggerScope(AppComponent.class)
    public interface AppComponent {

        RestClient restClient();

        void inject(DemoApplication demoApplication);
    }

    @Module
    public class AppModule {

        @Provides
        @DaggerScope(AppComponent.class)
        public RestClient providesRestClient(OkHttp okHttp) {
            return new RestClient(okHttp);
        }

        @Provides
        @DaggerScope(AppComponent.class)
        public OkHttp providesOkHttp() {
            return new OkHttp();
        }
    }
}











