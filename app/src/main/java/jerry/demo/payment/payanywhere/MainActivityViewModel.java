package jerry.demo.payment.payanywhere;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by jerry on 11/1/16.
 */

public class MainActivityViewModel extends BaseObservable {

    private String headerText;
    @Bindable
    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
        notifyPropertyChanged(BR.headerText);
    }
}
