package jerry.demo.payment.payanywhere.arch.message;

/**
 * Created by jerry on 11/4/16.
 */

public interface MessageBus {

    void register(Object subscriber);

    void post(Object message);

    void deregister(Object subscriber);
}
