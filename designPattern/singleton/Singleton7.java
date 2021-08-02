/**
 * @Description: 懒汉式双重检查终极版
 * --------------------------------------
 * @ClassName: Singleton7.java
 * @Date: 2021/8/1 18:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton7 {
    private static volatile Singleton7 singleton7;

    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        if (singleton7 == null) {
            synchronized (Singleton7.class) {
                if (singleton7 == null) {
                    singleton7 = new Singleton7();
                }
            }
        }
        return singleton7;
    }
}
