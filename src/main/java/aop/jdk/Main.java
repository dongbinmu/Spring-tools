package aop.jdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        SubjectA subjectA = new RealSubjectA();
        LogHandler logHandler = new LogHandler(subjectA);
        SubjectA proxyObject = (SubjectA) Proxy.newProxyInstance(subjectA.getClass().getClassLoader(),subjectA.getClass().getInterfaces(),logHandler);

        proxyObject.setUser("dongbin","123456");
    }
}
