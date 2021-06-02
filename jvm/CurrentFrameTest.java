/**
 * @Description: --------------------------------------
 * @ClassName: CurrentFrameTest.java
 * @Date: 2021/6/1 19:50
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class CurrentFrameTest {
    public static void main(String[] args) {
        CurrentFrameTest test = new CurrentFrameTest();
        test.methodA();
    }

    public void methodA() {
        System.out.println("当前栈帧对应的方法->methodA");
        methodB();
        System.out.println("当前栈帧对应的方法->methodA");
    }

    public void methodB() {
        System.out.println("当前栈帧对应的方法->methodB");
    }

}

// 当前栈帧对应的方法->methodA
// 当前栈帧对应的方法->methodB
// 当前栈帧对应的方法->methodA
