//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 
//true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
//
// Related Topics 贪心 数组 👍 813 👎 0


package cn.lime.leetcode.leetcode.editor.cn;
public class Q0334{
    public static void main(String[] args) {
         Solution solution = new Q0334().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        leftMin[0] = Integer.MAX_VALUE;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i - 1], leftMin[i - 1]);
            leftMin[i] = min;
        }
        rightMax[nums.length - 1] = Integer.MIN_VALUE;
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max = Math.max(nums[i + 1], rightMax[i + 1]);
            rightMax[i] = max;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > leftMin[i] && nums[i]<rightMax[i]){
                return true;
            }
        }
        return false;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}