package syn;

/**
 * @Description: 不安全取钱
 * 俩人去银行取钱，账户
 * --------------------------------------
 * @ClassName: UnSafeBank.java
 * @Date: 2021/4/12 22:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "基金");
        Drawing zhangsan = new Drawing(account, 50, "张三");
        Drawing lisi = new Drawing(account, 100, "李四");

        zhangsan.start();
        lisi.start();
    }
}

// 账户
class Account {
    // 余额
    int money;
    // 卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行：模拟取款
class Drawing extends Thread {
    // 账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 现在手里有多少钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    // 取钱
    @Override
    public void run() {
        /**
         * 对账户添加锁
         * 公共资源和对象：账户
         * synchronized 默认锁的是this
         * */
        synchronized(account) {
            // 判断是否有钱
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够...");
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 卡内余额 = 余额-取钱数
            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱：" + nowMoney);
        }
    }

}
