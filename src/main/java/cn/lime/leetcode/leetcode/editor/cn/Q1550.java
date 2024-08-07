//给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,6,4,1]
//输出：false
//解释：不存在连续三个元素都是奇数的情况。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,34,3,4,5,7,23,12]
//输出：true
//解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 
//
// Related Topics 数组 👍 31 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q1550 {
    public static void main(String[] args) {
        Solution solution = new Q1550().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            if (arr.length < 3) {
                return false;
            }

            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}