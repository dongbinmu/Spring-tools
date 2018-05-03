package aop.common;

public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    private void preRequest() {
        System.out.println("代理前");
    }

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void postRequest() {
        System.out.println("代理后");
    }
}
