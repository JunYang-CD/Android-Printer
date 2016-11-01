package jerry.yang.printerlib.adapter;

import java.util.ArrayList;

import jerry.yang.printerlib.Exception.PrinterLibException;
import jerry.yang.printerlib.device.Device;
import jerry.yang.printerlib.device.DeviceManager;
import jerry.yang.printerlib.device.DeviceManagerFactory;

/**
 * Created by jerry on 10/31/16.
 */

public abstract class PrinterAdapter {

    public abstract ArrayList<Integer> getSupportTypes();
    public abstract void printLine(String str);

    public void discoveryDevices(int deviceType) throws PrinterLibException{
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager(deviceType);
        deviceManager.startDeviceDiscovery();
    }

}
