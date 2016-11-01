package jerry.yang.printerlib.adapter;

import android.content.Context;

import java.util.ArrayList;

import jerry.yang.printerlib.Exception.PrinterLibException;
import jerry.yang.printerlib.device.DeviceManager;
import jerry.yang.printerlib.device.DeviceManagerCallBack;
import jerry.yang.printerlib.device.DeviceManagerFactory;

/**
 * Created by jerry on 10/31/16.
 */

public abstract class PrinterAdapter implements DeviceManagerCallBack {

    protected Context context;
    public abstract ArrayList<Integer> getSupportTypes();
    public abstract void printLine(String str);

    public void discoveryDevices(int deviceType) throws PrinterLibException{
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager(context, deviceType);
        deviceManager.setCallBack(this);
        deviceManager.startDeviceDiscovery();
    }

    public void cancelDiscoveryDevice(int deviceType){
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager(context, deviceType);
        deviceManager.removeCallBack(this);
        deviceManager.cancelDeviceDiscovery();
    }

}
