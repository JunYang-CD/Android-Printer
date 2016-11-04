package jerry.demo.payment.payanywhere.arch.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jerry.demo.payment.payanywhere.PayAnywhereApp;
import jerry.demo.payment.payanywhere.arch.message.MessageBus;
import jerry.demo.payment.payanywhere.arch.message.OttoMessageBusImpl;
import jerry.demo.payment.payanywhere.model.DeviceManager;

/**
 * Created by jerry on 11/4/16.
 */

@Module
public class AppMainModule {

    public AppMainModule() {

    }

    @Singleton
    @Provides
    Context provideContext() {
        return PayAnywhereApp.getInstance().getApplicationContext();
    }

    @Singleton
    @Provides
    MessageBus provideMessageBus() {
        return new OttoMessageBusImpl();
    }

    @Singleton
    @Provides
    DeviceManager provideDeviceManager(Context context) {
        return new DeviceManager(context);
    }

}
