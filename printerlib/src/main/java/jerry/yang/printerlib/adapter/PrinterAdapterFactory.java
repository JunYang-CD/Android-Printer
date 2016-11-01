package jerry.yang.printerlib.adapter;

import android.content.Context;

/**
 * Created by jerry on 10/31/16.
 */

public class PrinterAdapterFactory {
    public static PrinterAdapterFactory instance;
    public static final int PrinterAdapterOne = 1;
    public static final int PrinterAdapterTwo = 2;

    protected PrinterAdapterFactory(){

    }

    public static PrinterAdapterFactory getInstance(){
        if(null == instance){
            instance = new PrinterAdapterFactory();
        }

        return instance;
    }

    public PrinterAdapter getPrinterAdapter(Context context, int printerAdapter){
        PrinterAdapter printer = null;
        switch (printerAdapter){
            case PrinterAdapterOne:
                printer = new PrinterAdapterOne(context);
                break;
            case PrinterAdapterTwo:
                printer = new PrinterAdapterTwo(context);
                break;
        }
        return printer;
    }

}
