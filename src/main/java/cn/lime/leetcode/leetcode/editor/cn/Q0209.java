//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返
//回其长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2067 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0209 {
    public static void main(String[] args) {
        Solution solution = new Q0209().new Solution();
        solution.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }

    /**
     * 滑动窗口
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int min = Integer.MAX_VALUE;

            int sum = nums[0];

            for (int start = 0, end = 0; start < nums.length && end < nums.length; ) {
                if (sum >= target) {
                    min = Math.min(min, end - start+1);
                    sum = sum - nums[start];
                    start++;
                } else {
                    end++;
                    if (end < nums.length) {
                        sum = sum + nums[end];
                    }
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 暴力计算
     * 会超时
     */
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target)
                    return 1;
                int sum = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    sum = sum + nums[j];
                    if (sum >= target) {
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }

}