//给定 m x n 矩阵 matrix 。 
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行内所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 148 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class Q1072 {
    public static void main(String[] args) {
        Solution solution = new Q1072().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // format start with 0
            for (int i = 0; i < matrix.length; i++) {
                int[] line = matrix[i];
                // start with 1 -> reverse
                if (line[0] == 1) {
                    for (int j = 0; j < line.length; j++) {
                        line[j] = line[j] == 1 ? 0 : 1;
                    }
                }
            }
            // format finish
            // count
            Map<String,Integer> countMap = new HashMap<>();
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < matrix[i].length; j++) {
                    key.append(matrix[i][j]);
                }
                if (countMap.containsKey(key.toString())){
                    countMap.put(key.toString(),countMap.get(key.toString())+1);
                }else {
                    countMap.put(key.toString(),1);
                }
            }

            return countMap.values().stream().max(Integer::compare).orElse(0);


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}