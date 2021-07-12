package single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Description: 懒汉式单例模式
 * --------------------------------------
 * @ClassName: Lazy.java
 * @Date: 2021/7/12 22:44
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Lazy {

    private static boolean flag = false;

    private Lazy() {
        synchronized (Lazy.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("使用反射破坏异常");
            }
        }
    }

    private volatile static Lazy lazy;

    /**
     * 双重检测锁模式 懒汉式单例 DCL懒汉式
     */
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    // 不是原子操作
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }

    public static void main(String[] args) throws Exception {
        Field flag = Lazy.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);

        Lazy instance = declaredConstructor.newInstance();
        flag.set(instance, false);

        Lazy instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }

}
