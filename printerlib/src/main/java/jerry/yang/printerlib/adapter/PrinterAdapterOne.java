package jerry.yang.printerlib.adapter;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import jerry.yang.printerlib.Exception.PrinterLibException;
import jerry.yang.printerlib.broadcast.BroadcastMsg;
import jerry.yang.printerlib.device.Device;
import jerry.yang.printerlib.device.Device.Type;
import jerry.yang.printerlib.device.DeviceManagerCallBack;

/**
 * Created by jerry on 10/31/16.
 */

public class PrinterAdapterOne extends PrinterAdapter implements DeviceManagerCallBack{

    private  ArrayList capabilities;
    private ArrayList<Device> devices;
    private Object deviceListMutex;
    private Context context;

    public PrinterAdapterOne(Context context){
        this.context = context;
    }

    @Override
    public void printLine(String str) {
        capabilities = new ArrayList();
        capabilities.add(Type.USB);
        capabilities.add(Type.BT);
        capabilities.add(Type.WIFI);

        deviceListMutex = new Object();
        devices = new ArrayList<>();
    }

    @Override
    public ArrayList<Integer> getSupportTypes() {
        return capabilities;
    }

    @Override
    public void discoveryDevices(int deviceType) throws PrinterLibException{
        if(capabilities.contains(deviceType)){
            synchronized (deviceListMutex){
                devices.clear();
            }
            super.discoveryDevices(deviceType);
        }else{
            throw new PrinterLibException(PrinterLibException.NO_COMPABILITY);
        }
    }

    @Override
    public void newDeviceFound(Device device) {
        synchronized (deviceListMutex){
            devices.add(device);
            context.sendBroadcast(new Intent(BroadcastMsg.NEW_DEVICE_FOUND));
        }
    }

    @Override
    public void deviceDiscoveryEnd() {
        context.sendBroadcast(new Intent(BroadcastMsg.DEVICE_DISCOVERY_END));
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }
}
