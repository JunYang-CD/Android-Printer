package jerry.yang.printerlib.device;

/**
 * Created by jerry on 11/1/16.
 */

public interface DeviceManager {

    public abstract void setCallBack(DeviceManagerCallBack callBack);
    public abstract void removeCallBack(DeviceManagerCallBack callBack);
    public abstract void startDeviceDiscovery();
    public abstract void cancelDeviceDiscovery();
    public abstract void connect();
    public abstract void disConnect();
}
