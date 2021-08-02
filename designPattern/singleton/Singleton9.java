import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: 使用CAS 锁实现（线程安全）
 * --------------------------------------
 * @ClassName: Singleton9.java
 * @Date: 2021/8/2 18:16
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton9 {
    private static final AtomicReference<Singleton9> INSTANCE = new AtomicReference<Singleton9>();

    private Singleton9() {
    }


    /**
     * CAS确保线程安全
     */
    public static final Singleton9 getInstance() {
        for (; ; ) {
            Singleton9 current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new Singleton9();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

    public static void main(String[] args) {
        Singleton9 s1 = Singleton9.getInstance();
        Singleton9 s2 = Singleton9.getInstance();
        System.out.println(s1 == s2);
    }

}







