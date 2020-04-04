package reflection;

import java.lang.reflect.Method;

/**
 * @Description: 通过反射获取对象类的 main 方法
 * --------------------------------------
 * @ClassName: ReflectionMain.java
 * @Date: 2020/2/22 16:43
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReflectionMain {
    public static void main(String[] args) {
        try {
            // 1、获取Student对象的字节码
            Class oneClass = Class.forName("reflection.Student");

            // 2、获取main方法
            // 第一个参数：方法名称，第二个参数：方法形参的类型，
            Method methodMain = oneClass.getMethod("main", String[].class);

            // 3、调用main方法。jdk1.4 时的调用方法，jdk1.4 以上版本不支持
//            methodMain.invoke(null, new String[]{"a", "b", "c"});

            // 第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
            // 这里拆的时候将 new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。

            // 方式一
            methodMain.invoke(null, (Object) new String[]{"a", "b", "c"});

            // 方式二
            methodMain.invoke(null, new Object[]{new String[]{"a", "b", "c"}});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
