//给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。 
//
// 一步操作中，你将创建一个新数组 arr ，对于每个 i ： 
//
// 
// 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2] 
// 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2] 
// 
//
// 然后将 arr 赋值给 perm 。 
//
// 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：最初，perm = [0,1]
//第 1 步操作后，perm = [0,1]
//所以，仅需执行 1 步操作 
//
// 示例 2： 
//
// 
//输入：n = 4
//输出：2
//解释：最初，perm = [0,1,2,3]
//第 1 步操作后，perm = [0,2,1,3]
//第 2 步操作后，perm = [0,1,2,3]
//所以，仅需执行 2 步操作 
//
// 示例 3： 
//
// 
//输入：n = 6
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// n 是一个偶数 
// 
//
// Related Topics 数组 数学 模拟 👍 108 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class Q1806 {
    public static void main(String[] args) {
        Solution solution = new Q1806().new Solution();
        solution.reinitializePermutation(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reinitializePermutation(int n) {
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = i;
            }
            int res = 0;
            while (true) {
                res++;
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    if (i % 2 == 0) arr[i] = perm[i / 2];
                    else arr[i] = perm[n / 2 + (i - 1) / 2];
                }
                System.arraycopy(arr, 0, perm, 0, n);
                if (is(perm)) return res;
            }
        }

        private boolean is(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != i) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}