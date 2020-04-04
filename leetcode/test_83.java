package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * --------------------------------------
 * @ClassName: test_83.java
 * @Date: 2019/12/25 17:44
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_83 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {-3, -1, 0, 0, 0, 3, 3};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }
        Solution_83 solution = new Solution_83();
        l1.showList(solution.deleteDuplicates(l1.head));
    }
}

class Solution_83 {
    /**
     * @Description: 去重
     * @Date: 2019/12/25 17:46
     * @param: head
     * @Return:
     **/
    public ListNode deleteDuplicatesTwo(ListNode head) {
        if (head == null) {
            return null;
        }

        // 构建 list 顺序存储节点值
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (!list.contains(head.data)){
                list.add(head.data);
            }
            head = head.next;
        }

        // 构造首节点
        ListNode result = new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            // 添加节点
            addListNodeFromLast(result, list.get(i));
        }
        return result;
    }


    /**
     * @Description:
     * @Date: 2019/12/25 19:23
     * @param: result
     * @param: num
     * @Return:
     **/
    public ListNode addListNodeFromLast(ListNode result, int num) {
        ListNode newNode = new ListNode(num);
        // 遍历需要一个额外的存储空间存储当前节点，找到尾节点
        ListNode temp = result;
        // 头节点非空，遍历节点
        while (temp.next != null) {
            // 节点后移
            temp = temp.next;
        }
        // 把当前节点设置为尾节点
        temp.next = newNode;
        return result;
    }


    /**
     * @Description: 递归
     * @Date: 2019/12/25 19:26
     * @param: head
     * @Return:
     **/
    public ListNode deleteDuplicates(ListNode head) {
        // 递归出口
        if (head == null || head.next == null) {
            return head;
        }

        // 返回值
        head.next = deleteDuplicates(head.next);

        // 相邻节点值相同时，删除后面的节点
        if(head.data == head.next.data) {
            head = head.next;
        }
        return head;
    }
}
