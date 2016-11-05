package jerry.demo.payment.payanywhere.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

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

public class DeviceManager {
    private static DeviceManager instance;
    private Context context;
    private PrinterAdapter printer;
    private ArrayList<Device> devices;
    private FakeDeviceDiscoveryTask fakeDeviceDiscoveryTask;

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
        devices = new ArrayList<>();
    }


    public void startDeviceDiscovery(int deviceType) {
        fakeDeviceDiscoveryTask = new FakeDeviceDiscoveryTask();
        fakeDeviceDiscoveryTask.execute(0);
    }

    public ArrayList<Device> getDeviceList(){
        return devices;
    }

    private class FakeDeviceDiscoveryTask extends AsyncTask<Integer, Integer, Integer> {

        private int fakeDeviceNum = 3;

        @Override
        protected Integer doInBackground(Integer... integers) {
            devices.clear();
            try {
                for (int i = 0; i < fakeDeviceNum; i++) {
                    Thread.sleep(1000);
                    String address = "AA:BB:CC:DD:EE::FF";
                    String name = "printer" + i;
                    Device device = new Device(address, name, null);
                    devices.add(device);
                    publishProgress(0);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            messageBus.post(new PayAnyWhereEvent.NewDeviceFound());
        }
    }

}
