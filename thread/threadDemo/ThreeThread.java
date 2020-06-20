/**
 * @Description:
 * 继承Thread类；
 * 重写Runnable接口；（优先选择）
 *      避免单继承的局限性，优先使用接口；
 *      方便共享资源；
 * --------------------------------------
 * @ClassName: ThreeThread.java
 * @Date: 2020/6/20 16:35
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ThreeThread {
    public static void main(String[] args) {
        ShowInfo showInfo = new ShowInfo("10", "张三");
        ShowInfo showInfo1 = new ShowInfo("20", "李四");
        ShowInfo showInfo2 = new ShowInfo("30", "王五");

        // 继承Thread类
        showInfo.start();
        showInfo1.start();
        showInfo2.start();

        ShowInfo2 showInfo3 = new ShowInfo2("40", "40");
        ShowInfo2 showInfo4 = new ShowInfo2("50", "50");
        ShowInfo2 showInfo5 = new ShowInfo2("60", "60");

        // 重写Runnable接口 （new Thread()为创建代理类对象）
        new Thread(showInfo3).start();
        new Thread(showInfo4).start();
        new Thread(showInfo5).start();
    }
}

class ShowInfo extends Thread {
    String age;
    String url;

    @Override
    public void run() {
        ShowInfo showInfo = new ShowInfo(age, url);
        System.out.println(showInfo.age);
    }

    public ShowInfo(String age, String url) {
        this.age = age;
        this.url = url;
    }
}

class ShowInfo2 implements Runnable {
    String age;
    String url;

    @Override
    public void run() {
        ShowInfo2 showInfo2 = new ShowInfo2(age, url);
        System.out.println(showInfo2.age);
    }

    public ShowInfo2(String age, String url) {
        this.age = age;
        this.url = url;
    }
}


