package reflection;

/**
 * @Description: 测试类加载
 * --------------------------------------
 * @ClassName: ClassLoaderTest.java
 * @Date: 2021/5/14 11:26
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class ClassLoaderTest {
    static {
        System.out.println("ClassLoader类静态代码块初始化");
    }

    public static void main(String[] args) {
        /* 1. 主动引用
         * ClassLoader类静态代码块初始化
         * 父类静态代码块初始化
         * 子类静态代码块初始化
         * 父类无参构造初始化
         * 子类无参构造初始化
         * */
//         Son son = new Son();


        /* 2. 反射也会产生主动引用
         * ClassLoader类静态代码块初始化
         * 父类静态代码块初始化
         * 子类静态代码块初始化
         * */
//        try {
//            Class.forName("reflection.Son");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        /* 3. 不会产生类的引用的方法
         * ClassLoader类静态代码块初始化
         * 父类静态代码块初始化
         * 子类静态代码块初始化
         * 1000
         * */
//        System.out.println(Son.m);


        /* 4. 操作子类
         * ClassLoader类静态代码块初始化
         * */
//        Son[] array = new Son[5];
    }
}

class Father {
    static int m = 100;

    public Father() {
        System.out.println("父类无参构造初始化");
    }

    static {
        System.out.println("父类静态代码块初始化");
    }
}

class Son extends Father {
    static int m = 1000;

    public Son() {
        System.out.println("子类无参构造初始化");
    }

    static {
        System.out.println("子类静态代码块初始化");
    }
}
