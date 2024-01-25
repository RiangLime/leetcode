//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 140 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QLCR077 {
    public static void main(String[] args) {
        Solution solution = new QLCR077().new Solution();
        ListNode b = new ListNode(1);
        ListNode a = new ListNode(2,b);
        ListNode res = solution.sortList(a);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null){
                return null;
            }
            if (head.next == null) {
                return head;
            }
            List<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }

            list = list.stream().sorted(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    if (o1.val > o2.val) return 1;
                    else if (o1.val < o2.val) {
                        return -1;
                    }
                    return 0;
                }
            }).toList();

            head = list.get(0);
            cur = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                cur.next = list.get(i);
                cur = cur.next;
                if (i == list.size() - 1){
                    cur.next = null;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}