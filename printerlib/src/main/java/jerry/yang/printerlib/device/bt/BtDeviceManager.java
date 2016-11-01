package jerry.yang.printerlib.device.bt;

import java.util.ArrayList;

import jerry.yang.printerlib.device.DeviceManager;
import jerry.yang.printerlib.device.DeviceManagerCallBack;

/**
 * Created by jerry on 11/1/16.
 */

public class BtDeviceManager implements DeviceManager {

    private static BtDeviceManager instance;
    private ArrayList<DeviceManagerCallBack> callbacks;

    protected BtDeviceManager(){
        callbacks = new ArrayList<>();
    }

    public static BtDeviceManager getInstance(){
        if(null == instance){
            instance = new BtDeviceManager();
        }
        return instance;
    }


    @Override
    public void setCallBack(DeviceManagerCallBack callBack) {
        if(!callbacks.contains(callBack)){
            callbacks.add(callBack);
        }
    }

    @Override
    public void startDeviceDiscovery() {


    }

    @Override
    public void cancelDeviceDiscovery() {

    }

    @Override
    public void connect() {

    }

    @Override
    public void disConnect() {

    }

}
