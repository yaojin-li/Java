import java.lang.reflect.Method;

/**
 * @Description: --------------------------------------
 * @ClassName: AnnoTest3.java
 * @Date: 2021/5/11 23:06
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class AnnoTest3 {
    public static void main(String[] args) throws Exception {
        long start1 = System.currentTimeMillis();
        User user = new User();
        for (int i = 0; i < 1000000; i++) {
            user.getName();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("普通方式执行：" + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        Class userClass = user.getClass();
        Method getName = userClass.getDeclaredMethod("getName", null);
        for (int i = 0; i < 10000000; i++) {
            getName.invoke(user, null);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("反射方式执行：" + (end2 - start2) + "ms");

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            getName.invoke(user, null);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("反射方式关闭检测执行：" + (end3 - start3) + "ms");
    }
}

class User {
    private String name;

    public void getName() {

    }
}