/**
 * @Description: --------------------------------------
 * @ClassName: Singleton6.java
 * @Date: 2021/8/2 17:19
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton6 {
    private static Singleton6 singleton6;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}
