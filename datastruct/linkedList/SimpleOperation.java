package linkedList;

/**
 * @Description: 链表操作
 * --------------------------------------
 * @ClassName: SimpleOperation.java
 * @Date: 2019/12/9 21:39
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class SimpleOperation {

    public static ListNode head = new LinkedLists().head;

    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        int[] nums = {1, 2, 3, 4, 5, 6};

        for (int num : nums) {
            linkedLists.addListNodeFromLast(num);
        }

        // 1. 插入某个节点
        insert(new ListNode(10));
        linkedLists.showList(linkedLists.head);

//        // 2. 从中间某个节点 tarNode 处插入目标节点
//        insert(new ListNode(10), new ListNode(1));
//        linkedLists.showList(linkedLists.head);
//
//        // 6. 删除某个节点
//        delete(new ListNode(1));
//        linkedLists.showList(linkedLists.head);
    }

    /**
     * @Description: 插入某个节点
     * @Date: 2019/9/13 21:25
     * @Params:
     * @ReturnType:
     **/
    public static ListNode insert(ListNode addNode) {
        if (addNode == null) {
            return head;
        }
        ListNode temp = head;
        // 从末尾插入节点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 最末尾节点指向新插入的节点
        temp.next = addNode;
        return head;
    }

    /**
     * @Description: 从中间某个节点 tarNode 处插入目标节点
     * @Date: 2019/9/13 21:43
     * @Params:
     * @ReturnType:
     **/
    public static ListNode insert(ListNode addNode, ListNode tarNode) {
        if (addNode == null) {
            return head;
        }
        ListNode nowNode = head;
        ListNode temp = head;
        while (nowNode.data != tarNode.data) {
            temp = nowNode;
            nowNode = nowNode.next;
        }
        // 先将当前节点的下一个节点赋给目标节点的下一个节点
        tarNode.next = nowNode.next;
        // 将目标节点设置为新增节点的下个节点
        addNode.next = tarNode;
        // 将新增节点设置到目标节点的位置
        temp.next = addNode;
        return head;
    }


    /**
     * @Description: 删除某个节点
     * @Date: 2019/9/13 20:57
     * @Params:
     * @ReturnType:
     **/
    public static ListNode delete(ListNode delNode) {
        if (delNode == null) {
            return head;
        }
        // 头节点
        if (head.data == delNode.data) {
            head = head.next;
        } else {
            // 非头节点
            ListNode nowNode = head;
            // 临时保存节点
            ListNode temp = head;
            while (nowNode.data != delNode.data) {
                temp = nowNode;
                nowNode = nowNode.next;
            }
            temp.next = nowNode.next;
        }
        return head;
    }
}
