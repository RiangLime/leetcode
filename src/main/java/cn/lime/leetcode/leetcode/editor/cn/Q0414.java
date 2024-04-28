//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
//
// Related Topics 数组 排序 👍 459 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0414 {
    public static void main(String[] args) {
        Solution solution = new Q0414().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            list = list.stream().distinct().sorted().toList();
            for (Integer integer : list) {
                System.out.println(integer);
            }
            return list.get(list.size() >= 3 ? list.size()-3 : list.size()-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}