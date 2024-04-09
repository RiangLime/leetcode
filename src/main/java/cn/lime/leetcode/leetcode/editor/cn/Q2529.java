//给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。 
//
// 
// 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。 
// 
//
// 注意：0 既不是正整数也不是负整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,-1,-1,1,2,3]
//输出：3
//解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-3,-2,-1,0,0,1,2]
//输出：3
//解释：共有 2 个正整数和 3 个负整数。计数得到的最大值是 3 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,20,66,1314]
//输出：4
//解释：共有 4 个正整数和 0 个负整数。计数得到的最大值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2000 
// -2000 <= nums[i] <= 2000 
// nums 按 非递减顺序 排列。 
// 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(log(n)) 的算法解决此问题吗？ 
//
// Related Topics 数组 二分查找 计数 👍 18 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Q2529 {
    public static void main(String[] args) {
        Solution solution = new Q2529().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCount(int[] nums) {
            int neg = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<0){
                    neg++;
                }
                if (nums[i]>0){
                    return Math.max(neg,nums.length-i);
                }
            }
            return neg;
        }

        public int maximumCount1(int[] nums) {
            List<Integer> pos = new LinkedList<>();
            List<Integer> neg = new LinkedList<>();
            for (int num : nums) {
                if (num<0){
                    neg.add(num);
                }
                if (num>0){
                    pos.add(num);
                }
            }
            return Math.max(pos.size(),neg.size());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}