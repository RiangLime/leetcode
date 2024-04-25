//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 1121 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0083 {
    public static void main(String[] args) {
        Solution solution = new Q0083().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode res = new ListNode(-1);
            ListNode valid = res;
            ListNode iterate = head;
            Set<Integer> valueSet = new HashSet<>();
            while (iterate!=null){
                if (valueSet.contains(iterate.val)){
                    iterate = iterate.next;
                }else {
                    valueSet.add(iterate.val);
                    valid.next = iterate;
                    valid = valid.next;
                    iterate = iterate.next;
                }
            }
            valid.next=null;
            return res.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}