/**
 * @Description: 单例模式之懒汉式（线程安全）
 * 优点：
 * 1.访问受控，保证访问的是唯一的实例。
 * 2.由于只有一个实例，所以节省资源。
 * 缺点:
 * 灵活性低，如果对象的应用场景多变，则不适用单例模式。
 * --------------------------------------
 * @ClassName: SingletonTest.java
 * @Date: 2021/5/4 18:03
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SingletonTest {
    public static void main(String[] args) {
        // Singleton 的唯一实例只能通过getInstance()方法访问
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}

/**
 * DCL双重检查锁定单例(JDK1.5之后的版本)
 * 双重检验锁第一次加载慢
 */
class Singleton {
    // 定义单例对象
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
