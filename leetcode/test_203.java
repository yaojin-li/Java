package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * --------------------------------------
 * @ClassName: test_203.java
 * @Date: 2019/12/26 9:36
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_203 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {1, 2, 3, 3, 4};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }
        Solution_203 solution = new Solution_203();
        l1.showList(solution.removeElementsTwo(l1.head, 3));
    }
}

class Solution_203 {
    /**
     * @Description: 链表转数组，再构造新的链表
     * @Date: 2019/12/26 10:14
     * @param: head
     * @param: val
     * @Return:
     **/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 筛选 list
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.data != val) {
                list.add(head.data);
            }
            head = head.next;
        }

        // 防止 get(0) 异常
        if (list.isEmpty()) {
            return null;
        }

        // 构造结果链表
        ListNode result = new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            addListNodeFromLast(result, list.get(i));
        }
        return result;
    }

    public static ListNode addListNodeFromLast(ListNode head, int num) {
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
        return head;
    }


    /**
     * @Description: 构造双指针指向同一链表，一个用来读链表，一个用来删除链表元素
     * @Date: 2019/12/26 10:13
     * @param: head
     * @param: val
     * @Return:
     **/
    public ListNode removeElementsTwo(ListNode head, int val) {
        // 构造临时节点。（用来读取链表）
        ListNode temp = new ListNode(-1);
        // 临时节点之后拼接原链表。由于可能删除的节点是首节点，所以在原链表之前先拼接一个临时节点。
        temp.next = head;
        // 再构造一个指针指向同一链表的首节点。（用来操作链表）
        ListNode cur = temp;

        // 由于需要移动节点，所以比较 cur.next 节点。
        while (cur.next != null) {
            if (cur.next.data == val) {
                // 删除 cur.next 元素。改变 cur.next 的指向。
                cur.next = cur.next.next;
            } else {
                // 移动下一个节点
                cur = cur.next;
            }
        }
        // 返回临时节点后的链表
        return temp.next;
    }

}
