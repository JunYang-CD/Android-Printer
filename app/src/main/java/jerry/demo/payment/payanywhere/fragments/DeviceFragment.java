package jerry.demo.payment.payanywhere.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jerry.demo.payment.payanywhere.R;
import jerry.demo.payment.payanywhere.databinding.FragmentDeviceBinding;

/**
 * Created by jerry on 11/2/16.
 */

public class DeviceFragment extends PayAnywhereFragment {
    private static DeviceFragment instance;

    public static DeviceFragment getInstance() {
        if (null == instance) {
            instance = new DeviceFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDeviceBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device, null, false);
        return binding.getRoot();
    }

}
