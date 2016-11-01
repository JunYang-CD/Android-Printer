package jerry.yang.printerlib.Exception;

/**
 * Created by jerry on 11/1/16.
 */

public class PrinterLibException extends Exception {
    public static final String NO_COMPABILITY = "The printer doesn't support the selected type";

    public PrinterLibException(String msg){
        super(msg);
    }

}
