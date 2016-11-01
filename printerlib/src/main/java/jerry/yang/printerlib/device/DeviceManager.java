package jerry.yang.printerlib.device;

/**
 * Created by jerry on 11/1/16.
 */

public interface DeviceManager {

    void setCallBack(DeviceManagerCallBack callBack);
    void removeCallBack(DeviceManagerCallBack callBack);
    void startDeviceDiscovery();
    void cancelDeviceDiscovery();
    void connect();
    void disConnect();
}
