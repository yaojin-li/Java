package reflection;

import reflection.service.HelloService;
import reflection.service.HelloServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 动态代理测试
 * --------------------------------------
 * @ClassName: DynamicDemo.java
 * @Date: 2021/5/20 20:31
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class DynamicDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloServiceImpl target = new HelloServiceImpl();
        Method sayHello = HelloService.class.getMethod("sayHello", String.class);
        // 通过method反射对象。参数为method的参数。
        /**
         *  public Object invoke(Object obj, Object... args)  表示执行方法的调用
         *  参数:
         *       1.Object,表示对象,要执行这个对象的方法
         *       2.Object...args,方法执行时的参数值
         * 返回值:
         *       Object:方法执行后的返回值
         * */
        sayHello.invoke(target, "张三");
        sayHello.invoke(target, "李四");
    }
}
