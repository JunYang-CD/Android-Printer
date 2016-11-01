package jerry.yang.printerlib.adapter;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import jerry.yang.printerlib.Exception.PrinterLibException;
import jerry.yang.printerlib.broadcast.BroadcastMsg;
import jerry.yang.printerlib.device.Device;
import jerry.yang.printerlib.device.DeviceManager;
import jerry.yang.printerlib.device.DeviceManagerCallBack;
import jerry.yang.printerlib.device.DeviceManagerFactory;

/**
 * Created by jerry on 10/31/16.
 */

public abstract class PrinterAdapter implements DeviceManagerCallBack {

    protected Context context;
    protected ArrayList<Device> devices;
    protected ArrayList capabilities;
    protected Object deviceListMutex;
    protected Device connectedDevice;

    public PrinterAdapter(Context context){
        this.context = context;
        this.capabilities = new ArrayList();
        this.deviceListMutex = new Object();
        this.devices = new ArrayList<>();
    }

    public abstract void connect(Device device);
    public abstract void disconnect(Device device);
    public abstract void printLine(String str);

    public ArrayList<Integer> getSupportTypes() {
        return capabilities;
    }

    public void discoveryDevices(int deviceType) throws PrinterLibException {
        if (capabilities.contains(deviceType)) {
            synchronized (deviceListMutex) {
                devices.clear();
            }
            DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager(context, deviceType);
            deviceManager.setCallBack(this);
            deviceManager.startDeviceDiscovery();
        } else {
            throw new PrinterLibException(PrinterLibException.NO_COMPABILITY);
        }
    }

    public void cancelDiscoveryDevice(int deviceType) {
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager(context, deviceType);
        deviceManager.removeCallBack(this);
        deviceManager.cancelDeviceDiscovery();
    }

    @Override
    public void newDeviceFound(Device device) {
        synchronized (deviceListMutex) {
            devices.add(device);
        }
        context.sendBroadcast(new Intent(BroadcastMsg.NEW_DEVICE_FOUND));
    }

}
