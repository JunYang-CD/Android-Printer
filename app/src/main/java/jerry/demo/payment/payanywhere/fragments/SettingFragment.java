package jerry.demo.payment.payanywhere.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jerry.demo.payment.payanywhere.R;
import jerry.demo.payment.payanywhere.databinding.FragmentSettingBinding;

/**
 * Created by jerry on 11/2/16.
 */

public class SettingFragment extends PayAnywhereFragment {
    private static SettingFragment instance;

    public static SettingFragment getInstance() {
        if (null == instance) {
            instance = new SettingFragment();
        }
        return instance;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSettingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, null, false);
        return binding.getRoot();
    }
}
