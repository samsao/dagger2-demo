package samsao.daggerdemo;

import android.app.Fragment;
import android.os.Bundle;

import dagger.Component;

/**
 * @author Lukasz Piliszczuk <lukasz.pili@gmail.com>
 */
public class FirstFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FirstActivity activity = (FirstActivity) getActivity();
        activity.getComponent();
    }

    @Component(dependencies = FirstActivity.FirstActivityComponent.class)
    @DaggerScope(FirstFragment.class)
    public interface FirstFragmentComponent extends FirstActivity.FirstActivityComponent {

        void inject(FirstFragment fragment);
    }

}
