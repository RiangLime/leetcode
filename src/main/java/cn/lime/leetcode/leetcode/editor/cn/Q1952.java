//给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。 
//
// 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：false
//解释：2 只有两个除数：1 和 2 。 
//
// 示例 2： 
//
// 输入：n = 4
//输出：true
//解释：4 有三个除数：1、2 和 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 数学 枚举 数论 👍 32 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q1952 {
    public static void main(String[] args) {
        Solution solution = new Q1952().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isThree(int n) {
            if (n == 4) return true;
            for (int i = 1; i < n / 2; i++) {
                if (i * i == n) {
                    return isPrime(i);
                }
            }
            return false;
        }

        public boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}