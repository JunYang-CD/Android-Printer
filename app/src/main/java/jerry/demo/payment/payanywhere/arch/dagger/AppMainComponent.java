package jerry.demo.payment.payanywhere.arch.dagger;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;
import jerry.demo.payment.payanywhere.fragments.DeviceFragment;
import jerry.demo.payment.payanywhere.fragments.viewmodel.DeviceListViewAdapter;
import jerry.demo.payment.payanywhere.model.DeviceManager;

/**
 * Created by jerry on 11/4/16.
 */

@Component(modules = AppMainModule.class)
@Singleton
public interface AppMainComponent {
    void inject(DeviceManager deviceManager);

    void inject(DeviceFragment deviceFragment);

    void inject(DeviceListViewAdapter deviceListViewAdapter);
}
