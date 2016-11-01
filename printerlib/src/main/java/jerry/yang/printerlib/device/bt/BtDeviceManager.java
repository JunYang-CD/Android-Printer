package jerry.yang.printerlib.device.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import jerry.yang.printerlib.broadcast.BroadcastMsg;
import jerry.yang.printerlib.device.Device;
import jerry.yang.printerlib.device.DeviceManager;
import jerry.yang.printerlib.device.DeviceManagerCallBack;

/**
 * Created by jerry on 11/1/16.
 */

public class BtDeviceManager implements DeviceManager {

    private static BtDeviceManager instance;
    private Context context;
    private ArrayList<DeviceManagerCallBack> callbacks;
    private BlueToothReceiver blueToothReceiever;

    protected BtDeviceManager(Context context){
        callbacks = new ArrayList<>();
        this.context = context;
        blueToothReceiever = new BlueToothReceiver();
    }

    public static BtDeviceManager getInstance(Context context){
        if(null == instance){
            instance = new BtDeviceManager(context);
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
    public void removeCallBack(DeviceManagerCallBack callBack){
        if(callbacks.contains(callBack)){
            callbacks.remove(callBack);
        }
    }

    @Override
    public void startDeviceDiscovery() {
        cancelDeviceDiscovery();

        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        context.registerReceiver(blueToothReceiever, intentFilter);

        BluetoothAdapter.getDefaultAdapter().startDiscovery();

    }

    @Override
    public void cancelDeviceDiscovery() {
        BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
        context.unregisterReceiver(blueToothReceiever);
    }

    @Override
    public void connect() {

    }

    @Override
    public void disConnect() {

    }

    private class BlueToothReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(BluetoothDevice.ACTION_FOUND.contentEquals(intent.getAction())){
                BluetoothDevice btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Device device = new Device(btDevice.getAddress(), btDevice.getName(), null);
                if(null != callbacks){
                    for(DeviceManagerCallBack callBack : callbacks){
                        callBack.newDeviceFound(device);
                    }
                }
            }
        }
    }

}
