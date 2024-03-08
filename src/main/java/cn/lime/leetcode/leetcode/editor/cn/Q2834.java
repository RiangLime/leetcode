//给你两个正整数：n 和 target 。 
//
// 如果数组 nums 满足下述条件，则称其为 美丽数组 。 
//
// 
// nums.length == n. 
// nums 由两两互不相同的正整数组成。 
// 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。 
// 
//
// 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 10⁹ + 7。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, target = 3
//输出：4
//解释：nums = [1,3] 是美丽数组。
//- nums 的长度为 n = 2 。
//- nums 由两两互不相同的正整数组成。
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 4 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 2： 
//
// 
//输入：n = 3, target = 3
//输出：8
//解释：
//nums = [1,3,4] 是美丽数组。 
//- nums 的长度为 n = 3 。 
//- nums 由两两互不相同的正整数组成。 
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 8 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 3： 
//
// 
//输入：n = 1, target = 1
//输出：1
//解释：nums = [1] 是美丽数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= target <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 27 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q2834 {
    public static void main(String[] args) {
        Solution solution = new Q2834().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumPossibleSum(int n, int target) {
            final int MOD = (int) 1e9 + 7;
            int m = target / 2;
            if (n <= m) {
                long sum = (n + 1) * (long)n / 2;
                System.out.println(sum);
                return (int)(sum % MOD);
            } else {
                long sum =  (m + 1) * (long)m / 2;
                //  ((long) target + target + (n - m) - 1) * (n - m) / 2
                sum +=  (long)(target + n - m + target - 1) * (n - m) / 2;
                System.out.println(sum);
                return (int)(sum % MOD);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    /*
     * n<=m 只要加到target/2
     * 等差
     *
     *
     * n>m
     * 从target+1 target+2加
     * eg n=3 target=3 m=3/2=1
     * 前一半 sum = (m + 1) * m / 2 = 2*1/2 = 1
     * 后一半 (target + n-m + target) * (n-m) / 2 = (3+2 + 3)
     *
     * n>m
     * eg n=13 target=50 m=50/2=25
     * sum = 26 * 26/2 =
     */
}