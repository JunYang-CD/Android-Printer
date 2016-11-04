package jerry.demo.payment.payanywhere;

import android.app.Application;

import jerry.demo.payment.payanywhere.arch.dagger.AppMainComponent;
import jerry.demo.payment.payanywhere.arch.dagger.AppMainModule;
import jerry.demo.payment.payanywhere.arch.dagger.DaggerAppMainComponent;

/**
 * Created by jerry on 11/4/16.
 */

public class PayAnywhereApp extends Application {
    private static AppMainComponent mainComponent;
    private static PayAnywhereApp instance;

    @Override
    public void onCreate(){
        super.onCreate();
        if(null == mainComponent){
            mainComponent = DaggerAppMainComponent.builder()
                    .appMainModule(new AppMainModule())
                    .build();
        }
        if(null == instance) {
            instance = this;
        }
    }

    public static PayAnywhereApp getInstance(){
        return instance;
    }

    public static AppMainComponent getDaggerComponent(){
        return mainComponent;
    }
}
