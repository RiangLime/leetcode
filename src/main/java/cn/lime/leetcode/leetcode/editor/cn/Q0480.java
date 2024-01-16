//中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 
//窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
//
// Related Topics 数组 哈希表 滑动窗口 堆（优先队列） 👍 448 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q0480 {
    public static void main(String[] args) {
        Solution solution = new Q0480().new Solution();
        solution.medianSlidingWindow(new int[]{2147483647,2147483647},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            // total num of result
            double[] res = new double[nums.length - k + 1];

            for (int i = 0; i < (nums.length - k + 1); i++) {
                int[] subArr = new int[k];
                for (int i1 = 0; i1 < k; i1++) {
                    subArr[i1] = nums[i+i1];
                }
                // sort subArr
                Arrays.sort(subArr);

                res[i] = k%2 ==0 ? ((double)subArr[k/2] + (double) subArr[k/2-1])/2 : (double) subArr[k/2];
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}