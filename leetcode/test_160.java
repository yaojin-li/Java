package linkedList;

/**
 * @Description: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * a1 -> a2 -> c1 -> c2 -> c3
 * b1 -> b2 -> b3 -> c1 -> c2 -> c3
 * 在节点 c1 开始相交。
 * <p>
 * 示例 1：
 * 4 -> 1 -> 8 -> 4 -> 5
 * 5 -> 0 -> 1 -> 8 -> 4 -> 5
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * 0 -> 9 -> 1 -> 2 -> 4
 * 3 -> 2 -> 4
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * 2 -> 6 -> 4
 * 1 -> 5
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * --------------------------------------
 * @ClassName: test_160.java
 * @Date: 2019/12/24 18:20
 * @SoftWare: IntelliJ IDEA
 * --------------------------------------
 * @Author: lixj
 * @Contact: lixj_zj@163.com
 **/
public class test_160 {
    public static void main(String[] args) {
        LinkedLists l1 = new LinkedLists();
        int[] nums1 = {4, 1, 8, 4, 5};
        for (int num : nums1) {
            l1.addListNodeFromLast(num);
        }

        LinkedLists l2 = new LinkedLists();
        int[] nums2 = {4, 1, 8, 4, 5};
        for (int num : nums2) {
            l2.addListNodeFromLast(num);
        }

        Solution_160 solution = new Solution_160();
        l1.showList(solution.getIntersectionNode(l1.head, l2.head));
    }
}

class Solution_160 {
    /**
     * @Description: 暴力法
     * 对于较长的链表，往后移动长链表与短链表之间的长度差，保证两个链表指针开始位置相同，再依次遍历比较两个链表
     * 复杂度分析
     * 时间复杂度 : O(m+n)。
     * 空间复杂度 : O(1)。
     * @Date: 2019/12/24 18:19
     * @param: headA
     * @param: headB
     * @Return:
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        if (headA == null || headB == null) {
            return null;
        }

        // 分别求两个链表的长度
        while (headA != null) {
            aLen++;
            headA = headA.next;
        }
        while (headB != null) {
            bLen++;
            headB = headB.next;
        }

        // 往后移动长链表指针差值的长度，保证两个链表指针位置相同
        int sub = 0;
        headA = tempA;
        headB = tempB;
        if (bLen > aLen) {
            sub = bLen - aLen;
            for (int i = 0; i < sub; i++) {
                headB = headB.next;
            }
        } else {
            sub = aLen - bLen;
            for (int i = 0; i < sub; i++) {
                headA = headA.next;
            }
        }

        // 比较两个链表是否相同
        while (headA != headB) {
            // 分别往后移动指针
            headA = headA.next;
            headB = headB.next;
        }

        // 返回相同的链表段
        return headA;
    }


    /**
     * @Description: 双指针
     * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
     * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点; 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
     * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
     *
     * 例：两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。
     * 由于 B.length (=4) < A.length (=6)，pB 比 pA 少经过 2 个结点，会先到达尾部。
     * 将 pB 重定向到 A 的头结点，pA 重定向到 B 的头结点后，pB 要比 pA 多走 2 个结点。因此，它们会同时到达交点。
     * 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB 到达链表结尾时，
     * 记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
     *
     * 复杂度分析
     * 时间复杂度 : O(m+n)。
     * 空间复杂度 : O(1)。
     * @Date: 2019/12/24 18:22
     * @param: headA
     * @param: headB
     * @Return:
     **/
    public ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        // 当两个链表不同时
        while (pA != pB) {
            // 移动两个链表的指针
            pA = pA.next;
            pB = pB.next;

            if (pA == null && pB == null) {
                return null;
            }

            // 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点，继续循环
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        // 当两个链表相交，则两个指针同时到达相交点，返回此时的节点
        return pA;
    }

}
