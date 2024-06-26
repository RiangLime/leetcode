//给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。 
//
// 如果 nums 满足以下条件，那么它是 连续的 ： 
//
// 
// nums 中所有元素都是 互不相同 的。 
// nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。 
// 
//
// 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。 
//
// 请你返回使 nums 连续 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：0
//解释：nums 已经是连续的了。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,5,6]
//输出：1
//解释：一个可能的解是将最后一个元素变为 4 。
//结果数组为 [1,2,3,5,4] ，是连续数组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,10,100,1000]
//输出：3
//解释：一个可能的解是：
//- 将第二个元素变为 2 。
//- 将第三个元素变为 3 。
//- 将第四个元素变为 4 。
//结果数组为 [1,2,3,4] ，是连续数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 65 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2009 {
    public static void main(String[] args) {
        Solution solution = new Q2009().new Solution();
        solution.minOperations(new int[]{1,2,3,5,6});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int m = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[m++] = nums[i]; // 原地去重
                }
            }

            int ans = 0;
            int left = 0;
            for (int i = 0; i < m; i++) {
                while (nums[left] < nums[i] - n + 1) { // nums[left] 不在窗口内
                    left++;
                }
                ans = Math.max(ans, i - left + 1);
            }
            return n - ans;
        }

        public int minOperations1(int[] nums) {
            Arrays.sort(nums);
            // 数字哈希
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length * 2 - 1; i++) {
                // 构建目标连续数组
                int[] target = new int[nums.length];
                if (i < nums.length) {
                    target[0]=nums[i];
                }else {
                    target[0] = nums[i-nums.length];
                }
                for (int j = 1; j < nums.length; j++) {
                    target[j] = target[j-1]+1;
                }

                // 判断需要修改几个
                int cnt = 0;
                for (int i1 : target) {
                    if (!set.contains(i1)){
                        cnt++;
                    }
                }
                res = Math.min(cnt,res);
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}