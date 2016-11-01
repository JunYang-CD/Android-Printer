package jerry.yang.printerlib.adapter;

/**
 * Created by jerry on 10/31/16.
 */

public class PrinterFactory {
    public static PrinterFactory instance;
    public static int PrinterOne = 1;
    public static int PrinterTwo = 2;

    protected PrinterFactory(){

    }

    public static PrinterFactory getInstance(){
        if(null == instance){
            instance = new PrinterFactory();
        }

        return instance;
    }

    public Printer getPrinter(int printerIndex){
        Printer printer = null;
        switch (printerIndex){
            case 1:
                printer = new PrinterAdapterOne();
                break;
            case 2:
                printer = new PrinterAdapterTwo();
                break;
        }
        return printer;
    }

}
