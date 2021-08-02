/**
 * @Description: --------------------------------------
 * @ClassName: Singleton5.java
 * @Date: 2021/8/2 17:11
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class Singleton5 {
    public static void main(String[] args) {
        SinglentonEnum.INSTANCE.menthod();
    }
}

enum SinglentonEnum {
    INSTANCE;

    public void menthod() {
    }
}
