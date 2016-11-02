package jerry.demo.payment.payanywhere.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jerry.demo.payment.payanywhere.R;
import jerry.demo.payment.payanywhere.databinding.FragmentPaymentBinding;

/**
 * Created by jerry on 11/2/16.
 */

public class PaymentFragment extends PayAnywhereFragment {
    private static PaymentFragment instance;

    public static PayAnywhereFragment getInstance() {
        if (null == instance) {
            instance = new PaymentFragment();
        }
        return instance;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentPaymentBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_payment, null, false);
        return binding.getRoot();
    }
}
