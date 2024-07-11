//给你两个整数，n 和 start 。 
//
// 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。 
//
// 请返回 nums 中所有元素按位异或（XOR）后得到的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5, start = 0
//输出：8
//解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
//     "^" 为按位异或 XOR 运算符。
// 
//
// 示例 2： 
//
// 输入：n = 4, start = 3
//输出：8
//解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8. 
//
// 示例 3： 
//
// 输入：n = 1, start = 7
//输出：7
// 
//
// 示例 4： 
//
// 输入：n = 10, start = 5
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= start <= 1000 
// n == nums.length 
// 
//
// Related Topics 位运算 数学 👍 151 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q1486 {
    public static void main(String[] args) {
        Solution solution = new Q1486().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0    2   4   6   8       10
         * 00   10  100 110 1000    1100
         * 00   10  110 001 1001    0101
         * @param n
         * @param start
         * @return
         */
        public int xorOperation(int n, int start) {
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = res ^ (start + 2*(i-1) );
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}