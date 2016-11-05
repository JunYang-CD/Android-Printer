package jerry.demo.payment.payanywhere.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.ArrayList;

import javax.inject.Inject;

import jerry.demo.payment.payanywhere.PayAnywhereApp;
import jerry.demo.payment.payanywhere.arch.message.MessageBus;
import jerry.demo.payment.payanywhere.event.PayAnyWhereEvent;
import jerry.yang.printerlib.Exception.PrinterLibException;
import jerry.yang.printerlib.adapter.PrinterAdapter;
import jerry.yang.printerlib.adapter.PrinterAdapterFactory;
import jerry.yang.printerlib.broadcast.BroadcastMsg;
import jerry.yang.printerlib.device.Device;


/**
 * Created by jerry on 11/3/16.
 */

public class    DeviceManager {
    private static DeviceManager instance;
    private Context context;
    private DeviceBroadcastReceiver broadcastReceiver;
    private PrinterAdapter printer;
    private ArrayList<Device> devices;

    @Inject
    MessageBus messageBus;

    public static DeviceManager getInstance(Context context) {
        if (null == instance) {
            instance = new DeviceManager(context);
        }
        return instance;
    }

    public DeviceManager(Context context) {
        this.context = context;
        PayAnywhereApp.getDaggerComponent().inject(this);
    }

    private void registerBroadcast() {
        if (null == broadcastReceiver) {
            broadcastReceiver = new DeviceBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter(BroadcastMsg.NEW_DEVICE_FOUND);
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    private class DeviceBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (BroadcastMsg.NEW_DEVICE_FOUND.contentEquals(intent.getAction())) {
                devices = printer.getList();
                messageBus.post(new PayAnyWhereEvent.NewDeviceFound());
            }
        }
    }

    public void startDeviceDiscovery(int deviceType) {
        registerBroadcast();
        printer = PrinterAdapterFactory.getInstance().getPrinterAdapter(context,
                PrinterAdapterFactory.PrinterAdapterOne);
        try {
            printer.discoveryDevices(deviceType);
        } catch (PrinterLibException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Device> getDeviceList(){
        return devices;
    }

}
