package jerry.yang.printerlib.device;

import android.content.Context;

import jerry.yang.printerlib.device.bt.BtDeviceManager;

/**
 * Created by jerry on 11/1/16.
 */

public class DeviceManagerFactory {
    private static DeviceManagerFactory instance;
    protected DeviceManagerFactory(){

    }

    public DeviceManagerFactory getInstance(){
        if(null == instance){
            instance = new DeviceManagerFactory();
        }
        return instance;
    }

    public static DeviceManager getDeviceManager(Context context, int type){
        DeviceManager deviceManager = null;
        switch (type){
            case Device.Type.BT:
                deviceManager = BtDeviceManager.getInstance(context);
                break;
            case Device.Type.USB:
                break;
            case Device.Type.WIFI:
                break;
        }
        return deviceManager;
    }
}
