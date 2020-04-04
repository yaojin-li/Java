package reflection;

/**
 * @Description: Java 反射机制 demo
 * 1 Object ——> getClass();     能获取到对象就不需要反射；
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性；      需要导入类的包，依赖性强；
 * 3 通过Class类的静态方法：forName（String  className）(常用)     常用的方式；
 * --------------------------------------
 * @ClassName: ReflectionDemo.java
 * @Date: 2020/2/22 15:24
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReflectionDemo {
    public static void main(String[] args) {
        // 1. 对象.getClass() 方法获得 Class 对象
        Student student = new Student();
        Class stuClass = student.getClass();
        System.out.println(stuClass);   // class reflection.Student
        System.out.println(stuClass.getName());     // reflection.Student

        // 2. “静态”的 class 熟悉
        Class stuClass2 = Student.class;
        System.out.println(stuClass2 == stuClass);  // true

        // 3. 静态方法 forName()
        try{
            Class stuClass3 = Class.forName("reflection.Student");  // 存在 classNotFound 异常
            System.out.println(stuClass3 == stuClass);  // true
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
