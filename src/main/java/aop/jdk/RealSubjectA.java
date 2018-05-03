package aop.jdk;

public class RealSubjectA implements SubjectA {
    @Override
    public void setUser(String name, String password) {
        System.out.println("用户名："+name+",密码："+password);
    }
}
