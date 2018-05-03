package aop.cglib;

public class Main {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Subject subject = (Subject) proxy.getProxy(Subject.class);
        subject.sayHello();
    }
}
