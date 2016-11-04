package jerry.demo.payment.payanywhere.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import jerry.demo.payment.payanywhere.BR;
import jerry.demo.payment.payanywhere.PayAnywhereApp;
import jerry.demo.payment.payanywhere.R;
import jerry.demo.payment.payanywhere.arch.message.MessageBus;
import jerry.demo.payment.payanywhere.databinding.FragmentDeviceBinding;
import jerry.demo.payment.payanywhere.event.PayAnyWhereEvent;
import jerry.demo.payment.payanywhere.fragments.viewmodel.DeviceListViewAdapter;
import jerry.demo.payment.payanywhere.model.DeviceManager;
import jerry.yang.printerlib.device.Device;

/**
 * Created by jerry on 11/2/16.
 */

public class DeviceFragment extends PayAnywhereFragment {
    private static DeviceFragment instance;

    @Inject
    DeviceManager deviceManager;

    @Inject
    MessageBus messageBus;

    DeviceListViewAdapter deviceListViewAdapter;

    public static DeviceFragment getInstance() {
        if (null == instance) {
            instance = new DeviceFragment();
        }
        return instance;
    }

    public DeviceFragment() {
        PayAnywhereApp.getDaggerComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageBus.register(this);
        deviceListViewAdapter = new DeviceListViewAdapter();
    }

    @Override
    public void onDestroy() {
        messageBus.deregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDeviceBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_device, null, false);
        binding.deviceListView.setAdapter(deviceListViewAdapter);
        deviceManager.startDeviceDiscovery(Device.Type.BT);

        return binding.getRoot();
    }

    @Subscribe
    public void onNewDeviceFound(PayAnyWhereEvent.NewDeviceFound event) {
        deviceListViewAdapter.devices = deviceManager.getDeviceList();
        deviceListViewAdapter.notifyDataSetChanged();
    }


}
