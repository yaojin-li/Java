/**
 * @Description: 懒汉式（线程安全，同步方法，不推荐使用）
 * --------------------------------------
 * @ClassName: Singleton2.java
 * @Date: 2021/8/1 16:43
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
