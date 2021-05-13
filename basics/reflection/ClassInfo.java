package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 获得类的信息
 * --------------------------------------
 * @ClassName: ClassInfo.java
 * @Date: 2021/5/13 22:25
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ClassInfo {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.ClassInfo");
        //获得类的信息
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得包名+类名
        reflection.ClassInfo demo = new reflection.ClassInfo();
        Class c2 = demo.getClass();
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

        //获得类的属性
        System.out.println("=======================");
        Field[] fields = c1.getFields();//获取类的公开属性和父类的公开属性
        fields = c1.getDeclaredFields();//获取类的任何属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("=========================");
        Method[] methods = c1.getMethods();//获得本类和父类的所有public方法
        for (Method method : methods) {
            System.out.println("获得本类和父类的所有public方法：" + method);
        }

        System.out.println("=========================");
        Method[] decmethods = c1.getDeclaredMethods();//获得本类的所有方法
        for (Method method : decmethods) {
            System.out.println("获得本类的所有方法：" + method);
        }

        //获得指定方法
        //需要传参数的原因：存在重载，参数可找到指定的方法
        System.out.println("=========================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得构造器
        System.out.println("=========================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("getConstructors " + constructor);
        }
        System.out.println("=========================");
        Constructor[] constructors1 = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("getDeclaredConstructors " + constructor);
        }

        //获得指定的构造器
        Constructor getDeclaredConstructor = c1.getDeclaredConstructor(String.class);
        System.out.println("指定构造器" + getDeclaredConstructor);
    }
}

