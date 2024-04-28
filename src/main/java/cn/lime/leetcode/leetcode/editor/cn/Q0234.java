//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1888 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0234{
    public static void main(String[] args) {
         Solution solution = new Q0234().new Solution();
    } 
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = arr.size()-1;
        while (left<right){
            if (!arr.get(left).equals(arr.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}