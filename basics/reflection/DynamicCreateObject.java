package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: --------------------------------------
 * @ClassName: DynamicCreateObject.java
 * @Date: 2021/5/13 19:40
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class DynamicCreateObject {
    //动态的创建对象，通过反射
    public static void main(String[] args) throws Exception {
        //获得Class对象
        Class c1 = Class.forName("reflection.User");

        //构造一个对象，本质上调用了类的无参构造器
        User user = (User) c1.newInstance();
        System.out.println(user);//reflection.User@1b6d3586

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) constructor.newInstance("张三", 10, 17);
        System.out.println(user1);
        //(默认)的构造方法。str[张三],age[10],height[17]
        //reflection.User@1ff8b8f


        //通过反射调用普通方法
        User user2 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke:激活
        // (对象,"方法值")
        setName.invoke(user2, "李四（invoke）");
        System.out.println(user2.getName());//李四（invoke）

        //通过反射操作属性
        User user3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性,我们需要关闭程序的安全检测，属性或方法的setAccessible(true)
        //设置安全检测
        name.setAccessible(true);

        name.set(user3, "王五（修改name属性）");
        System.out.println(user3.getName());//王五（修改name属性）
    }
}
