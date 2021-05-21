package reflection.service;

/**
 * @Description: --------------------------------------
 * @ClassName: HelloServiceImpl.java
 * @Date: 2021/5/20 19:37
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println(name + "say hello...");
    }
}
