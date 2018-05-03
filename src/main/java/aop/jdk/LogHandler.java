package aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    private Object object;

    public LogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
        System.out.println("before()");
        Object result = method.invoke(object,args);
        System.out.println("end()");
        return result;
    }


}
