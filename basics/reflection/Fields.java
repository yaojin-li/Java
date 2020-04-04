package reflection;

import java.lang.reflect.Field;

/**
 * @Description: 通过反射获取成员变量并调用
 * 1.批量获取：
 * 1).Field[] getFields():获取所有的"公有字段"
 * 2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 * <p>
 * 设置字段的值：
 * Field --> public void set(Object obj,Object value):
 * 参数说明：
 * 1.obj:要设置的字段所在的对象；
 * 2.value:要为字段设置的值；
 * --------------------------------------
 * @ClassName: Fields.java
 * @Date: 2020/2/22 16:10
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Fields {
    public static void main(String[] args) throws Exception{
        // 1. 通过反射获取 class 对象
        Class stuClass = Class.forName("reflection.Student");

        // 2. 获取所有的"公有字段"
        Field[] fields = stuClass.getFields();
        for (Field oneField : fields) {
            System.out.println(oneField);
        }

        // 3. 获取所有的字段(包括私有、受保护、默认的)
        Field[] fields1 = stuClass.getDeclaredFields();
        for (Field oneField : fields1) {
            System.out.println(oneField);
        }

        // 4. 获取公有字段并调用
        try {
            // 获取指定的公有字段
            Field field = stuClass.getField("name");
            System.out.println(field);
            // 获取一个 student 对象 -> Student stu = new Student();
            Object object = stuClass.getConstructor().newInstance();
            // 为 Student 对象中的 name 属性赋值 -> stu.name = "小李子"
            // 赋值方式与一般对象赋值字段不同，此处为：字段.set(对象, "字段值");
            field.set(object, "小李子");

            // 验证
            Student student = (Student) object;
            System.out.println(student.name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5. 获取私有字段并调用
        try {
            Field field = stuClass.getDeclaredField("phoneNum");
            System.out.println(field);
            Object object = stuClass.getConstructor().newInstance();
            // 暴力反射，解除私有限定
            field.setAccessible(true);
            field.set(object, "15021952808");

            // 验证
            Student student = (Student) object;
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
