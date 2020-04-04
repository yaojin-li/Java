package linkedList;

/**
 * @Description: 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * --------------------------------------
 * @ClassName: test_234.java
 * @Date: 2019/12/26 19:00
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_234 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {0,0};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }
        Solution_234 solution = new Solution_234();
        System.out.println(solution.isPalindrome(l1.head));
    }
}

class Solution_234 {
    /**
     * @Description: 1.快慢指针找到链表中点；2.反转后半部分链表；3.比较两部分
     * @Date: 2019/12/26 19:21
     * @param: head
     * @Return:
     **/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        // 判断 fast.next 与 fast.next.next 是否存在
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表。注意此时后半部分为 slow.next 其后的链表
        ListNode newHead = reverseList(slow.next);

        // 比较两部分链表
        while (newHead != null) {
            if (newHead.data != head.data) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    /**
     * @Description: 递归反转链表
     * @Date: 2019/12/26 19:57
     * @param: head
     * @Return:
     **/
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
