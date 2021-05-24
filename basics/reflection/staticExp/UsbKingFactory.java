package reflection.staticExp;

/**
 * @Description: 创建目标类（厂家），实现业务接口
 * --------------------------------------
 * @ClassName: UsbKingFactory.java
 * @Date: 2021/5/23 19:53
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
@SuppressWarnings("all")
// 目标类:金士顿厂家,不接受用户的单独购买
public class UsbKingFactory implements UsbSale {
    @Override
    public float sale(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("商品数量参数错误");
        }
        if (amount < 1000) {
            System.out.println("目标类（厂家）售价：" + 85 * amount);
            return 85 * amount;
        } else if (amount < 3000) {
            System.out.println("目标类（厂家）售价：" + 80 * amount);
            return 80 * amount;
        } else {
            System.out.println("目标类（厂家）售价：" + 75 * amount);
            return 75 * amount;
        }
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
