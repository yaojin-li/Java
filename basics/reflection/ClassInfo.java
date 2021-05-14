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
        //获得指定类的信息
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1.getName());//reflection.User
        System.out.println(c1.getSimpleName());//User

        //获得指定类的信息
        reflection.ClassInfo demo = new reflection.ClassInfo();
        Class c2 = demo.getClass();
        System.out.println(c2.getName());//reflection.ClassInfo
        System.out.println(c2.getSimpleName());//ClassInfo

        //获得类的属性
        System.out.println("=======================");
        Field[] fields = c1.getFields();//获取类的public属性和父类的public属性
        fields = c1.getDeclaredFields();//获取类的所有属性
        for (Field field : fields) {
            System.out.println(field);
        }
        //private int reflection.User.age
        //private java.lang.String reflection.User.name
        //public int reflection.User.height
        //protected java.lang.String reflection.User.address

        //获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);
        //private java.lang.String reflection.User.name

        //获得类的方法
        System.out.println("=========================");
        Method[] methods = c1.getMethods();//获得本类和父类的所有public方法
        for (Method method : methods) {
            System.out.println("获得本类和父类的所有public方法：" + method);
        }
        //获得本类和父类的所有public方法：public java.lang.String reflection.User.getAddress()
        //获得本类和父类的所有public方法：public java.lang.String reflection.User.getName()
        //获得本类和父类的所有public方法：public void reflection.User.setName(java.lang.String)
        //获得本类和父类的所有public方法：public void reflection.User.setAge(int)
        //获得本类和父类的所有public方法：public int reflection.User.getAge()
        //获得本类和父类的所有public方法：public void reflection.User.setAddress(java.lang.String)
        //获得本类和父类的所有public方法：public int reflection.User.getHeight()
        //获得本类和父类的所有public方法：public void reflection.User.setHeight(int)
        //获得本类和父类的所有public方法：public final void java.lang.Object.wait() throws java.lang.InterruptedException
        //获得本类和父类的所有public方法：public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
        //获得本类和父类的所有public方法：public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
        //获得本类和父类的所有public方法：public boolean java.lang.Object.equals(java.lang.Object)
        //获得本类和父类的所有public方法：public java.lang.String java.lang.Object.toString()
        //获得本类和父类的所有public方法：public native int java.lang.Object.hashCode()
        //获得本类和父类的所有public方法：public final native java.lang.Class java.lang.Object.getClass()
        //获得本类和父类的所有public方法：public final native void java.lang.Object.notify()
        //获得本类和父类的所有public方法：public final native void java.lang.Object.notifyAll()


        System.out.println("=========================");
        Method[] decmethods = c1.getDeclaredMethods();//获得本类的所有方法
        for (Method method : decmethods) {
            System.out.println("获得本类的所有方法：" + method);
        }
        //获得本类的所有方法：public java.lang.String reflection.User.getAddress()
        //获得本类的所有方法：public java.lang.String reflection.User.getName()
        //获得本类的所有方法：public void reflection.User.setName(java.lang.String)
        //获得本类的所有方法：public void reflection.User.setAge(int)
        //获得本类的所有方法：public int reflection.User.getAge()
        //获得本类的所有方法：public void reflection.User.setAddress(java.lang.String)
        //获得本类的所有方法：public int reflection.User.getHeight()
        //获得本类的所有方法：public void reflection.User.setHeight(int)


        //获得指定方法
        //需要传参数的原因：存在重载，参数可找到指定的方法
        System.out.println("=========================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);//public java.lang.String reflection.User.getName()
        System.out.println(setName);//public void reflection.User.setName(java.lang.String)

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
        //getDeclaredConstructors reflection.User(java.lang.String)


        //获得指定的构造器     与string传参的构造方法相关
        Constructor getDeclaredConstructor = c1.getDeclaredConstructor(String.class);
        System.out.println("指定构造器" + getDeclaredConstructor);
        //指定构造器reflection.User(java.lang.String)
    }
}

