package linkedList;

/**
 * @Description: 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * --------------------------------------
 * @ClassName: test_21.java
 * @Date: 2019/12/23 20:09
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_21 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {1, 2, 3, 7, 8, 9};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }

        LinkedLists l2 = new LinkedLists();
        int[] nums2 = {0, 1, 2, 3, 4};
        for (int num : nums2) {
            l2.addListNodeFromLast(num);
        }

        Solution_21 solution = new Solution_21();
        l1.showList(solution.mergeTwoListsTwo(l1.head, l2.head));
    }
}

class Solution_21 {
    /**
     * @Description:
     * 1.构造结果节点；
     * 2.遍历两个链表长度相同的部分，将小的节点加入结果链表；
     * 3.将两个链表的余下部分直接拼接结果链表
     * @Date: 2019/12/24 18:04
     * @param: l1
     * @param: l2
     * @Return:
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 构造临时节点，在其后拼接结果链表
        ListNode head = new ListNode(-1);

        // 排除空链表的情况
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 遍历两个链表长度相同的部分，将小的节点加入结果链表
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                addListNodeFromLast(head, l1.data);
                l1 = l1.next;
            } else {
                addListNodeFromLast(head, l2.data);
                l2 = l2.next;
            }
        }

        // 将两个链表的余下部分直接拼接结果链表
        if (l1 == null) {
            while (l2 != null) {
                addListNodeFromLast(head, l2.data);
                l2 = l2.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                addListNodeFromLast(head, l1.data);
                l1 = l1.next;
            }
        }
        // head 为临时节点，其后拼接的链表为结果链表
        return head.next;
    }


    /**
     * @Description: 从尾部插入节点
     * 尾插入： 额外定义指针
     * @Date: 2019/8/29 20:17
     * @Params:
     * @ReturnType:
     **/
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



    //递归
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        // 递归调用，返回较小的节点，作为 .next 后的节点
        if (l1.data < l2.data) {
            l1.next = mergeTwoListsTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsTwo(l1, l2.next);
            return l2;
        }

    }
}
