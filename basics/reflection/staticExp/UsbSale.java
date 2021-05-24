package reflection.staticExp;

/**
 * @Description: 定义卖 u 盘的业务接口
 * --------------------------------------
 * @ClassName: UsbSale.java
 * @Date: 2021/5/23 19:52
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public interface UsbSale {

    float sale(int amount);

    /**
     * 添加接口的方法
     * 只需要修改接口的方法和目标类的方法，用Proxy对象调用即可
     */
    void hello();
}
