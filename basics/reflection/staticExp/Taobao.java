package reflection.staticExp;

/**
 * @Description: 定义一个淘宝商家，卖金士顿的 u 盘
 * 代理类一般需要完成两个功能：
 * 1.目标类中方法的调用
 * 2.功能增强
 * --------------------------------------
 * @ClassName: Taobao.java
 * @Date: 2021/5/23 19:54
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
// 淘宝是一个商家，代理金士顿U盘的销售
public class Taobao implements UsbSale {

    @Override
    public float sale(int amount) {
        // 声明 商家代理的厂家具体是谁
        UsbKingFactory factory = new UsbKingFactory();
        // 向厂家发送订单，告诉厂家，我买了U盘，厂家发货
        // 发送给工厂，我需要的订单，返回报价
        float price = factory.sale(amount);
        // 商家需要加价也就是代理要增加价格
        price = price + 25 * amount;
        System.out.println("代理类功能增强：淘宝质量保证，价格增加，返回一个优惠券。");
        return price;
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
