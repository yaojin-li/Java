package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Description: --------------------------------------
 * @ClassName: AnnoDemo.java
 * @Date: 2021/5/16 19:27
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class AnnoDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.Student2");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);//@reflection.Table(value=db_student)
        }

        //获得注解中的value值
        Table table = (Table) c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);//db_student

        //获得类指定的属性
        Field field = c1.getDeclaredField("name");
        //获得指定属性的注解
        Filed annotation = field.getAnnotation(Filed.class);
        System.out.println(annotation.columnName());//db_name
        System.out.println(annotation.length());//3
        System.out.println(annotation.type());//varchar
    }

}

@Table("db_student")
class Student2 {
    @Filed(columnName = "db_id", type = "int", length = 10)
    private int id;
    @Filed(columnName = "db_age", type = "int", length = 10)
    private int age;
    @Filed(columnName = "db_name", type = "varchar", length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Filed {
    String columnName();

    String type();

    int length();
}