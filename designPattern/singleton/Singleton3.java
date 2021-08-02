/**
 * @Description: 饿汉式（线程安全）
 * --------------------------------------
 * @ClassName: Singleton3.java
 * @Date: 2021/8/2 16:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton3 {
    private static Singleton3 singleton3 = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return singleton3;
    }

}
