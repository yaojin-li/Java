package reflection;

import java.lang.reflect.Method;

/**
 * @Description: 通过反射获取成员方法并调用
 * 1.批量的：
 * public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * public Method getMethod(String name,Class<?>... parameterTypes):
 * 参数：
 * name : 方法名；
 * Class ... : 形参的Class类型对象
 * public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 * 调用方法：
 * Method --> public Object invoke(Object obj,Object... args):
 * 参数说明：
 * obj : 要调用方法的对象；
 * args:调用方式时所传递的实参；
 * --------------------------------------
 * @ClassName: MethClass.java
 * @Date: 2020/2/22 16:36
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class MethClass {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("reflection.Student");

        //2.获取所有公有方法
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }

        // 2. 获取所有的方法，包括私有的
        methodArray = stuClass.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }

        // 3. 获取公有的show1()方法
        Method method = stuClass.getMethod("show1", String.class);
        System.out.println(method);
        // 实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        method.invoke(obj, "刘德华");

        // 4. 获取私有的show4()方法
        // 调用制定方法（所有包括私有的），需要传入两个参数，第一个是调用的方法名称，第二个是方法的形参类型，切记是类型。
        method = stuClass.getDeclaredMethod("show4", int.class);
        System.out.println(method);
        // 解除私有限定
        method.setAccessible(true);
        // 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        Object result = method.invoke(obj, 20);
        System.out.println("返回值：" + result);

    }

}
