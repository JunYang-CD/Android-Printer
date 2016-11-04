package jerry.demo.payment.payanywhere.fragments.viewmodel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import jerry.demo.payment.payanywhere.PayAnywhereApp;
import jerry.demo.payment.payanywhere.R;
import jerry.demo.payment.payanywhere.databinding.DeviceItemBinding;
import jerry.yang.printerlib.device.Device;

/**
 * Created by jerry on 11/4/16.
 */

public class DeviceListViewAdapter extends BaseAdapter {

    @Inject
    Context context;

    public ArrayList<Device> devices;
    private LayoutInflater inflater;


    public  DeviceListViewAdapter(){
        PayAnywhereApp.getDaggerComponent().inject(this);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(null != devices){
            return devices.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return devices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DeviceItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.device_item, null, false);
        binding.setDevice(devices.get(i));
        return binding.getRoot();
    }
}
