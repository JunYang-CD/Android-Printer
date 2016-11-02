package jerry.demo.payment.payanywhere;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import jerry.demo.payment.payanywhere.databinding.ActivityMainBinding;
import jerry.demo.payment.payanywhere.fragments.DeviceFragment;
import jerry.demo.payment.payanywhere.fragments.PayAnywhereFragment;
import jerry.demo.payment.payanywhere.fragments.PaymentFragment;
import jerry.demo.payment.payanywhere.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private static final int PAYMENT_FRAG = 0;
    private static final int DEVICE_FRAG = 1;
    private static final int SETTING_FRAG = 2;
    private int curFrag = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new MainActivityViewModel();
        mainActivityViewModel.setHeaderText(getResources().getString(R.string.payment));
        binding.setViewModel(mainActivityViewModel);
        binding.setController(this);
        loadFragment(PAYMENT_FRAG);

    }

    public void loadFragment(int fragmentIndex) {
        if (fragmentIndex == curFrag) {
            return;
        }
        PayAnywhereFragment fragment = getProperFragment(fragmentIndex);
        if (null != fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
            curFrag = fragmentIndex;
        }
    }

    public PayAnywhereFragment getProperFragment(int fragmentIndex) {
        PayAnywhereFragment fragment = null;
        switch (fragmentIndex) {
            case PAYMENT_FRAG:
                fragment = PaymentFragment.getInstance();
                break;
            case DEVICE_FRAG:
                fragment = DeviceFragment.getInstance();
                break;
            case SETTING_FRAG:
                fragment = SettingFragment.getInstance();
                break;
        }
        return fragment;
    }


    public void onFirstTabClicked() {
        mainActivityViewModel.setHeaderText(getResources().getString(R.string.payment));
        loadFragment(PAYMENT_FRAG);
    }

    public void onSecondTabClicked() {
        mainActivityViewModel.setHeaderText(getResources().getString(R.string.devices));
        loadFragment(DEVICE_FRAG);
    }

    public void onThirdTabClicked() {
        mainActivityViewModel.setHeaderText(getResources().getString(R.string.setting));
        loadFragment(SETTING_FRAG);
    }
}
