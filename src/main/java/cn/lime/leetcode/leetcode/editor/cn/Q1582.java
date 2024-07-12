//给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。 
//
// 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 
//特殊 位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,0,0],[0,0,1],[1,0,0]]
//输出：1
//解释：位置 (1, 2) 是一个特殊位置，因为 mat[1][2] == 1 且第 1 行和第 2 列的其他所有元素都是 0。
// 
//
// 示例 2： 
// 
// 
//输入：mat = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
//解释：位置 (0, 0)，(1, 1) 和 (2, 2) 都是特殊位置。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// mat[i][j] 是 0 或 1。 
// 
//
// Related Topics 数组 矩阵 👍 107 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import javax.management.InstanceNotFoundException;

public class Q1582 {
    public static void main(String[] args) {
        Solution solution = new Q1582().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSpecial(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[] mSum = new int[m], nSum = new int[n];

            for (int i = 0; i < m; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += mat[i][j];
                }
                mSum[i] = sum;
            }

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += mat[j][i];
                }
                nSum[i] = sum;
            }

            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mSum[i] == 1 && nSum[j] == 1 && mat[i][j] == 1) {
                        res++;
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}