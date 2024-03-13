//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 531 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0119{
    public static void main(String[] args) {
         Solution solution = new Q0119().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        int numRows = rowIndex+1;
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
        return result.get(rowIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}