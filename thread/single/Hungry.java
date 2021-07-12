package single;

/**
 * @Description: 饿汉式单例模式
 * --------------------------------------
 * @ClassName: Hungry.java
 * @Date: 2021/7/12 22:41
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Hungry {

    private byte[] data1 = new byte[1024 * 1024];
    private byte[] data2 = new byte[1024 * 1024];
    private byte[] data3 = new byte[1024 * 1024];

    private Hungry() {
    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }

}
