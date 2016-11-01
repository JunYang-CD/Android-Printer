package jerry.yang.printerlib.device;

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

    public static DeviceManager getDeviceManager(int type){
        DeviceManager deviceManager = null;
        switch (type){
            case Device.Type.BT:
                deviceManager = BtDeviceManager.getInstance();
                break;
            case Device.Type.USB:
                break;
            case Device.Type.WIFI:
                break;
        }
        return deviceManager;
    }
}
