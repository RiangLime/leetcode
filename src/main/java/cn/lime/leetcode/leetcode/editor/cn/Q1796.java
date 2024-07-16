//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。 
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
//
// Related Topics 哈希表 字符串 👍 64 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Q1796 {
    public static void main(String[] args) {
        Solution solution = new Q1796().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondHighest(String s) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') set.add(c);
            }
            // 使用最小堆来保存最大的两个数
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(2);
            for (Character c : set) {
                int num = Integer.parseInt(String.valueOf(c));
                // 将当前数字加入堆中
                minHeap.offer(num);

                // 如果堆的大小超过2，就移除最小的元素
                if (minHeap.size() > 2) {
                    minHeap.poll();
                }
            }
            return minHeap.size() <= 1 ? -1 : minHeap.poll();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}