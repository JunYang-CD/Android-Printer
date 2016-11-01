package jerry.yang.printerlib.adapter;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by jerry on 10/31/16.
 */

public class PrinterAdapterTwo extends PrinterAdapter {
    private Context context;

    public PrinterAdapterTwo(Context context){
        this.context = context;
    }

    @Override
    public void printLine(String str) {

    }

    @Override
    public ArrayList<Integer> getSupportTypes() {
        return null;
    }
}
