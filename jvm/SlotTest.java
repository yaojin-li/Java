/**
 * @Description: --------------------------------------
 * @ClassName: SlotTest.java
 * @Date: 2021/6/1 19:12
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SlotTest {
    public void localVar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    public void localVar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        // 此时的b就会复用a的槽位
        int b = 0;
    }
}
