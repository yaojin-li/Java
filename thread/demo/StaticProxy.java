/**
 * @Description: 静态代理模式
 * 真实对象和代理对象都要实现同一个接口；
 * 代理对象要代理真实角色，做了“结婚前”和“结婚后”的事，而真实对象只需要“结婚”；
 * 优点：
 * 1. 代理对象可以做很多真实对象做不了的事情；
 * 2. 真实对象专注做自己的事情；
 * --------------------------------------
 * @ClassName: StaticProxy.java
 * @Date: 2021/4/6 21:40
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        // 多线程和静态代理模式很像
        // Thread和WeddingCompany都是代理，都代理了真实对象
        new Thread(() -> System.out.println("结婚")).start();
        new WeddingCompany(you).marry();
    }
}

interface Marry {
    void marry();
}

class You implements Marry {

    @Override
    public void marry() {
        System.out.println("结婚了...");
    }
}

class WeddingCompany implements Marry {
    // 创建目标对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        before();
        this.target.marry();
        after();
    }

    private void after() {
        System.out.println("结婚之后,收尾款");
    }

    private void before() {
        System.out.println("结婚之前,布置现场");
    }

}
