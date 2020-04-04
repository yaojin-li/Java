package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 3 -> 2 -> 0 -> -4 -> 2
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 1 -> 2 -> 1
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * --------------------------------------
 * @ClassName: test_141.java
 * @Date: 2019/12/25 20:02
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_141 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {3, 2, 0, -4, 2};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }
        Solution_141 solution = new Solution_141();
        System.out.println(solution.hasCycle(l1.head));
    }
}

class Solution_141 {
    /**
     * @Description: 双指针
     * 构造一快一慢指针，移动速度不等。当两个指针指向的节点相同时，说明存在环。
     * 当两节点不等时，分别移动指针。循环判断。
     * 复杂度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)，我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)。
     * @Date: 2019/12/25 20:05
     * @param: head
     * @Return:
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        // 当快慢指针指向的节点不等时，继续移动指针
        while (slow != fast) {
            // 当快指针指向的节点为空，或其下一个节点为空时，说明到达链表尾部
            if (fast == null || fast.next == null) {
                return false;
            }
            // 分别不同速的移动双指针
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    /**
     * @Description: hash 表
     * hash 表中存储每个节点的引用。当节点为空，即检测到尾部。
     * 节点存在 hash 表中，返回 true。
     * 复杂度：
     * 时间复杂度：O(n)，对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间。
     * 空间复杂度：O(n)，空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素。
     * @Date: 2019/12/25 20:18
     * @param: head
     * @Return:
     **/
    public boolean hasCycleTwo(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            // hash 表中包含节点，返回true
            if (nodes.contains(head)) {
                return true;
            } else {
                // 节点加入 hash 表中
                nodes.add(head);
            }
            // 移动指针
            head = head.next;
        }
        return false;
    }
}