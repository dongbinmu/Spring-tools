package ioc.service;

import ioc.annotation.Component;
import ioc.bean.User;

/**
 * Created by dongbin on 2018/4/26.
 */
@Component
public class UserService {
    public User getUser() {
        return new User("dongbin", 18);
    }
}
