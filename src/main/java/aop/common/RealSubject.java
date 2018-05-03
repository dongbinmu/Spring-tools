package aop.common;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("get request");
    }
}
