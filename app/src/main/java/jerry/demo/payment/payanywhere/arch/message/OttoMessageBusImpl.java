package jerry.demo.payment.payanywhere.arch.message;

import com.squareup.otto.Bus;

/**
 * Created by jerry on 11/4/16.
 */

public class OttoMessageBusImpl implements MessageBus {
    private Bus bus;

    public OttoMessageBusImpl(){
        bus = new Bus();
    }

    @Override
    public void register(Object subscriber) {
        bus.register(subscriber);
    }

    @Override
    public void post(Object message) {
        bus.post(message);
    }

    @Override
    public void deregister(Object subscriber) {
        bus.unregister(subscriber);
    }
}
