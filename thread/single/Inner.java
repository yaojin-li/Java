package single;

/**
 * @Description: 静态内部类
 * --------------------------------------
 * @ClassName: Inner.java
 * @Date: 2021/7/12 23:21
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Inner {

    private Inner() {
    }

    public static Inner getInstance() {
        return InnerClass.INNER;
    }

    public static class InnerClass {
        private static final Inner INNER = new Inner();
    }

}
