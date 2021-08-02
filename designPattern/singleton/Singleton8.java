/**
 * @Description: 使用 ThreadLocal 实现（线程安全）
 * --------------------------------------
 * @ClassName: Singleton8.java
 * @Date: 2021/8/2 18:07
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton8 {
    private static final ThreadLocal<Singleton8> singleton8 = new ThreadLocal<Singleton8>() {
        @Override
        protected Singleton8 initialValue() {
            return new Singleton8();
        }
    };


    private Singleton8() {
    }

    public static Singleton8 getInstance() {
        return singleton8.get();
    }
}
