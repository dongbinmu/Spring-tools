package aop.jdk;

public class RealSubjectB implements SubjectB {
    @Override
    public void sayHello(String name) {
        System.out.println(name+":hello world!!!");
    }
}
