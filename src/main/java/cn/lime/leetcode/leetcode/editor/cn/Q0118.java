//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1130 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0118 {
    public static void main(String[] args) {
        Solution solution = new Q0118().new Solution();
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> line = new ArrayList<>();
                if (i==0){
                    line.add(1);
                }else if (i==1){
                    line.add(1);
                    line.add(1);
                }else {
                    line.add(1);
                    for (int j = 1; j <= i - 1; j++) {
                        line.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                    }
                    line.add(1);
                }
                result.add(line);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}