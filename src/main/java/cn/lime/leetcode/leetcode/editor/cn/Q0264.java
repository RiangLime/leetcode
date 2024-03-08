//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是质因子只包含 2、3 和 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 1165 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q0264 {
    public static void main(String[] args) {
        Solution solution = new Q0264().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            Set<Long> seen = new HashSet<Long>();
            PriorityQueue<Long> queue = new PriorityQueue<>();
            queue.offer(1L);
            seen.add(1L);
            int[] factors = {2, 3, 5};

            int res = 0;
            for (int i = 0; i < n; i++) {
                long cur = queue.poll();
                res = (int) cur;
                for (int factor : factors) {
                    long next = cur * factor;
                    if (seen.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}