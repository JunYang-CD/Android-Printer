package jerry.yang.printerlib.adapter;

import android.content.Context;

import java.util.ArrayList;

import jerry.yang.printerlib.device.Device;
import jerry.yang.printerlib.device.Device.Type;

/**
 * Created by jerry on 10/31/16.
 */

public class PrinterAdapterOne extends PrinterAdapter {

    public PrinterAdapterOne(Context context) {
        super(context);
        capabilities.add(Type.USB);
        capabilities.add(Type.BT);
        capabilities.add(Type.WIFI);
    }

    @Override
    public void printLine(String str) {
        if (null != connectedDevice) {
        }
    }

    @Override
    public void connect(Device device) {
        connectedDevice = device;
    }

    @Override
    public void disconnect(Device device) {
        if (null != device && connectedDevice == device) {

        } else if (null != connectedDevice) {
            connectedDevice = null;
        }
    }


}
