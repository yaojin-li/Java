package reflection;

import java.lang.reflect.Constructor;

/**
 * @Description: 通过反射获取构造方法
 * 通过 Class 对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 * 1.获取构造方法：
 * 1).批量的方法：
 * public Constructor[] getConstructors()：所有"公有的"构造方法
 * public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
 * 2).获取单个的方法，并调用：
 * public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 * <p>
 * 调用构造方法：
 * Constructor-->newInstance(Object... initargs)
 * --------------------------------------
 * @ClassName: Constructors.java
 * @Date: 2020/2/22 15:42
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Constructors {
    public static void main(String[] args) {
        Class stuClass = null;

        // 1. 通过反射拿到 class 对象
        try {
            stuClass = Class.forName("reflection.Student");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. 获取所有“公有的”构造方法
        Constructor[] constructors = stuClass.getConstructors();
        for (Constructor oneConstructor : constructors) {
            System.out.println(oneConstructor);
        }

        // 3. 所有的构造方法(包括：私有、受保护、默认、公有)
        Constructor[] constructors1 = stuClass.getDeclaredConstructors();
        for (Constructor oneConstructor : constructors1) {
            System.out.println(oneConstructor);
        }

        // 4. 获取公有、无参的构造方法
        // 因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        // 返回的是描述这个无参构造函数的类对象。
        try {
            Constructor constructor = stuClass.getConstructor(null);
            System.out.println(constructor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5. 获取私有构造方法，并调用
        try {
            Constructor constructor = stuClass.getDeclaredConstructor(String.class, int.class);
            // 调用构造方法
            constructor.setAccessible(true);
            constructor.newInstance("小李子", 20); //暴力访问(忽略掉访问修饰符)
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
