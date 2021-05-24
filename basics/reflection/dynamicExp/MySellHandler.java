package reflection.dynamicExp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: --------------------------------------
 * @ClassName: MySellHandler.java
 * @Date: 2021/5/24 18:48
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
//必须实现InvocationHandler接口，完成代理类的功能（调用目标方法、功能增强）
@SuppressWarnings("all")
public class MySellHandler implements InvocationHandler {

    private Object target = null;

    // 动态代理的目标对象是活动的，需要传入进来，传进来的是谁就给谁创建代理
    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        // 调用目标方法
        res = method.invoke(target, args);
        if (res != null) {
            Float price = (Float) res;
            price = price + 25;
            res = price;
        }

        // 功能增强
        System.out.println("返回优惠券");
        return res;
    }
}
