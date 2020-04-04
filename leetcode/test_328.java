package linkedList;

/**
 * @Description: 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * --------------------------------------
 * @ClassName: test_328.java
 * @Date: 2020/1/6 19:08
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_328 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {1, 2, 3, 4, 5};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }
        Solution_328 solution = new Solution_328();
        l1.showList(solution.oddEvenListTwo(l1.head));
    }
}

class Solution_328 {
    /**
     * @Description: 奇节点放入一个链表，偶节点放入另一个链表，奇链表的尾部指向偶链表
     * @Date: 2020/1/6 20:04
     * @param: head
     * @Return:
     **/
    public ListNode oddEvenListTwo(ListNode head) {
        // 基本校验
        if (head == null) {
            return null;
        }
        // 0. 节点 head 和 odd 保存奇链表的头和尾指针
        // 0. 节点 evenHead 和 even（从head.next，即第二个节点开始）保存偶链表的头和尾指针
        ListNode odd = head, even = head.next, evenHead = even;
        // odd 指针和 even 指针不仅仅是尾指针，也是原链表迭代器
        while (even != null && even.next != null) {
            // 1. 偶节点的下一个是奇节点，放置 odd（奇链表的尾指针）之后
            odd.next = even.next;
            // 1. 移动奇链表尾指针
            odd = odd.next;
            // 1. 偶节点的下一个是奇节点，放置 odd（奇链表的尾指针）之后
            even.next = odd.next;
            // 2. 移动偶链表尾指针
            even = even.next;
        }
        // FINAL. 拼接奇偶链表
        odd.next = evenHead;
        return head;
    }


    /**
     * @Description: 奇节点放入一个链表，偶节点放入另一个链表，奇链表的尾部指向偶链表
     * @Date: 2020/1/6 19:14
     * @param: head
     * @Return:
     **/
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        // 奇链表头结点
        ListNode jHead = new ListNode(head.data);
        // 提取奇节点添加到奇链表头结点之后
        while (head.next != null && head.next.next != null) {
            head = head.next.next;
            jHead = addListNodeFromLast(jHead, head.data);
        }

        // 提取偶节点添加到偶链表头结点之后
        ListNode oHead = null;
        while (temp != null && temp.next != null) {
            temp = temp.next;
            oHead = addListNodeFromLast(oHead, temp.data);
            temp = temp.next;
        }

        // 拼接奇偶链表
        while (oHead != null) {
            jHead = addListNodeFromLast(jHead, oHead.data);
            oHead = oHead.next;
        }
        return jHead;
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

}
