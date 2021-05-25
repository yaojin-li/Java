package reflection.dynamicExp;

import reflection.staticExp.UsbKingFactory;
import reflection.staticExp.UsbSale;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description: newProxyInstance 创建代理对象，实现反射
 * --------------------------------------
 * @ClassName: ShopApplication.java
 * @Date: 2021/5/24 18:56
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
public class ShopApplication {
    public static void main(String[] args) {
        // 1. 创建目标对象
        UsbKingFactory factory = new UsbKingFactory();

        // 2. 创建invocationHandler对象
        InvocationHandler invocationHandler = new MySellHandler(factory);

        // 3. 创建代理对象
        UsbSale usbSale = (UsbSale) Proxy.newProxyInstance(
                factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                invocationHandler
        );

        // 4. 调用方法
//        System.out.println(usbSale.sale(100));
        usbSale.hello();
    }
}
