package linkedList;

/**
 * @Description: 反转链表（递归、非递归）
 * --------------------------------------
 * @ClassName: ReverseList.java
 * @Date: 2019/12/4 21:44
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class ReverseList {
    public static void main(String[] args) {
        LinkedLists linkedLists = new LinkedLists();
        int[] nums = {1, 2, 3, 4, 5};

        for (int num : nums) {
            linkedLists.addListNodeFromLast(num);
        }

        ListNode reverseNode = reverseListTwo(linkedLists.head);
        linkedLists.showList(reverseNode);
    }

    /**
     * @Description: 反转链表 递归方式
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @Date: 2019/12/4 22:33
     * @param: head
     * @ReturnType: linkedList.ListNode
     **/
    public static ListNode reverseList(ListNode head) {
        // 当节点为空，或节点是尾节点时，返回当前节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归寻找尾节点
        ListNode newHead = reverseList(head.next);
        // 设置尾节点（新节点）的下一个节点为尾节点的上一个节点
        head.next.next = head;
        // 经过上一步，在尾节点与尾节点的上一个节点间形成死循环，都是对方的下一个节点；
        // head.next = null 设置尾节点的上一个节点指向 null，打破死循环，此时尾节点指向尾节点的上一个节点，完成第一步反转；
        head.next = null;
        // 递归后新节点为之前的尾节点，从尾到头依次反转完成
        return newHead;
    }


    /**
     * @Description: 反转链表 非递归方式
     * 用三个指针 prev,cur,next ，紧紧相邻，不断前进，
     * 每次将 cur.next 指向 prev ，将 prev指向cur, cur 指向 next 。
     * @Date: 2019/12/4 22:00
     * @param: head
     * @ReturnType: linkedList.ListNode
     **/
    public static ListNode reverseListTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 截取第一个节点之后的链表串赋予 next
            ListNode next = cur.next;
            // 取 cur 的第一个节点指向 prev，用来拼接反向链表
            cur.next = prev;
            // 拼接后的结果赋予 prev
            prev = cur;
            // 将 next 赋予 cur，下次循环截取第一个节点
            cur = next;
        }
        return prev;
    }

}
