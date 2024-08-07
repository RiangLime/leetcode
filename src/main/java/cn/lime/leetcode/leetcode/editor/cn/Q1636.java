//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 排序 👍 170 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.*;

public class Q1636 {
    public static void main(String[] args) {
        Solution solution = new Q1636().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }

            Collections.sort(list, (a, b) -> {
                int cnt1 = map.get(a), cnt2 = map.get(b);
                return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
            });

            for (int i = 0; i < nums.length; i++) {
                nums[i] = list.get(i);
            }
            return nums;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}