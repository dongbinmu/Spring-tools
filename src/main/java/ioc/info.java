package ioc;

import ioc.controller.UserController;

/**
 * Created by dongbin on 2018/4/26.
 */
public class info {
    public static void main(String[] args) {
        UserController userController = (UserController) IocContext.applicationContext.get(UserController.class);
        userController.getUser();
    }
}
