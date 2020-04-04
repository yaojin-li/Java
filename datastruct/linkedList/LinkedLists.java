package linkedList;

/**
 * @Description: --------------------------------------
 * @ClassName: LinkedLists.java
 * @Date: 2019/12/4 21:56
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class LinkedLists {
    /**
     * @Description: 声明指向 null 的头节点
     * @Date: 2019/8/29 21:00
     **/
    public ListNode head;

    /**
     * @Description: 1.1 从尾部插入节点
     * 尾插入：
     * 额外定义指针
     * @Date: 2019/8/29 20:17
     * @Params:
     * @ReturnType:
     **/
    public void addListNodeFromLast(int num) {
        // 新建节点
        ListNode newNode = new ListNode(num);
        // 头节点为空时直接将新建的节点设置为头节点
        if (head == null) {
            head = newNode;
        } else {
            // 遍历需要一个额外的存储空间存储当前节点，找到尾节点
            ListNode temp = head;
            // 头节点非空，遍历节点
            while (temp.next != null) {
                // 节点后移
                temp = temp.next;
            }
            // 把当前节点设置为尾节点
            temp.next = newNode;
        }
    }

    /**
     * @Description: 1.2 从头部插入节点
     * @Date: 2019/8/29 20:17
     * @Params:
     * @ReturnType:
     **/
    public void addListNodeFromHead(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
        } else {
            // 将新节点连接到链表头部。注意左右赋值顺序！！！
            newNode.next = head;
            // 把当前节点置为头节点
            head = newNode;
        }
    }

    /**
     * @Description: 2. 遍历
     * @Date: 2019/8/29 20:17
     * @Params:
     * @ReturnType:
     **/
    public void showList(ListNode head) {
        // 新增临时节点存储当前节点
        ListNode temp = head;
        // 下一节点不为空，遍历
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            // 指针指向下一节点
            temp = temp.next;
        }
        // 输出当前节点，即最后一个节点
        System.out.print(temp.data);
    }
}
