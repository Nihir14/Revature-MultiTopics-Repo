import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private UserClient userClient;

//
//    public String placeOrder(Long userId) {
//
//        UserResponse user = userClient.getUserById(userId);
//
//        return  "Order placed for user: "+user.getName();
//    }


    @Autowired
    private CircuitBreakerFactory breakerFactory;

    public String placeOrder(Long userId) {
        CircuitBreaker breaker = breakerFactory.create("userCB");

        return breaker.run(
                ()->{
                    UserResponse user =userClient.getUserById(userId);
                            return "order placed for: "+user.getName();
                },
                throwable -> fallbackOrder(userId,throwable)
        );
    }

    public String fallbackOrder(Long userId, Throwable throwable) {
        return "user service is down! Cannot place order for: "+userId;
    }
}
