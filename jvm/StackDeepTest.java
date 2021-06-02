import java.util.concurrent.TimeUnit;

/**
 * @Description: 栈深度测试
 * --------------------------------------
 * @ClassName: StackDeepTest.java
 * @Date: 2021/6/1 19:06
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class StackDeepTest {
    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }
    }
    // deep of calling = 23362
}
