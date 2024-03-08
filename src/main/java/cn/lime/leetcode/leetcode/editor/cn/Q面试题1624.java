//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 
//输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 
//输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// -10^5 <= nums[i], target <= 10^5 
// 
//
// Related Topics 数组 哈希表 双指针 计数 排序 👍 52 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.*;

public class Q面试题1624 {
    public static void main(String[] args) {
        Solution solution = new Q面试题1624().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int start=0,end=nums.length-1;start<end;){
                if (nums[start] + nums[end] == target){
                    res.add(Arrays.asList(nums[start], nums[end]));
                    start++;
                    end--;
                }
                if (nums[start] + nums[end] > target) {
                    end--;
                }
                if (nums[start] + nums[end] < target) {
                    start++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 暴力求解
     * time exceed
     */
    class Solution2 {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            Set<Integer> positionMap = new HashSet<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] + nums[j] == target && !positionMap.contains(i) && !positionMap.contains(j)) {
                        positionMap.add(i);
                        positionMap.add(j);
                        res.add(Arrays.asList(nums[i], nums[j]));
                        break;
                    }
                }
            }
            return res;
        }
    }
}