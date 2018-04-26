package ioc.controller;

import ioc.annotation.Component;
import ioc.annotation.Inject;
import ioc.bean.User;
import ioc.service.UserService;

/**
 * Created by dongbin on 2018/4/26.
 */
@Component
public class UserController {

    @Inject
    public UserService userService;

    public void  getUser(){
        User u = userService.getUser();
        System.out.println(u.getUserName()+":"+u.getAge());
    }
}
