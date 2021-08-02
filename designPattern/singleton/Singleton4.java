/**
 * @Description: 静态内部类加载（线程安全）
 * --------------------------------------
 * @ClassName: Singleton4.java
 * @Date: 2021/8/2 16:57
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton4 {
    private static Singleton4 singleton4;

    private Singleton4() {
    }

    private static class SingletonInner {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonInner.instance;
    }
}
