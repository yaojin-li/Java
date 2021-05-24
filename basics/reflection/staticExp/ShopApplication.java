package reflection.staticExp;

/**
 * @Description: 客户端类
 * 访问代理类，顾客进入淘宝买金士顿的 u 盘
 * --------------------------------------
 * @ClassName: ShopApplication.java
 * @Date: 2021/5/24 11:58
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ShopApplication {
    public static void main(String[] args) {
        // 创建代理的商家淘宝对象
        Taobao taobao = new Taobao();
        System.out.println("淘宝的购买价格为：" + taobao.sale(1));
    }
}
