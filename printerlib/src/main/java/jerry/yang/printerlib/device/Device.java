package jerry.yang.printerlib.device;

/**
 * Created by jerry on 11/1/16.
 */

public class Device {

    public static class Type{
        public static final int BT = 0;
        public static final int USB = 1;
        public static final int WIFI = 2;
    }


    private Type type;
    private String name;
    private String address;
    private String port;
    private String brand;

    public Device(String address, String name, String port){
        this.address = address;
        this.name = name;
        this.port = port;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



}
