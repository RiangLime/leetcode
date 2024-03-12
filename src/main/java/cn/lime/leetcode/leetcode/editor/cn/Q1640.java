//给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 
//pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。 
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [15,88], pieces = [[88],[15]]
//输出：true
//解释：依次连接 [15] 和 [88]
// 
//
// 示例 2： 
//
// 
//输入：arr = [49,18,16], pieces = [[16,18,49]]
//输出：false
//解释：即便数字相符，也不能重新排列 pieces[0]
// 
//
// 示例 3： 
//
// 
//输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//输出：true
//解释：依次连接 [91]、[4,64] 和 [78] 
//
// 
//
// 提示： 
//
// 
// 1 <= pieces.length <= arr.length <= 100 
// sum(pieces[i].length) == arr.length 
// 1 <= pieces[i].length <= arr.length 
// 1 <= arr[i], pieces[i][j] <= 100 
// arr 中的整数 互不相同 
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同） 
// 
//
// Related Topics 数组 哈希表 👍 144 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1640{
    public static void main(String[] args) {
         Solution solution = new Q1640().new Solution();
         solution.canFormArray(new int[]{91,4,64,78},new int[][]{new int[]{78},new int[]{4,64},new int[]{91}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        List<int[]> pieceList = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        pieceList.addAll(Arrays.asList(pieces));
        for (int i : arr) {
            arrList.add(i);
        }

        while (arrList.size()>0){
            if (!match(arrList,pieceList)){
                return false;
            }
        }
        return true;
    }

    private boolean match(List<Integer> arr,List<int[]> pieces){
        for (int i = 0; i < pieces.size(); i++) {
            int[] piece  = pieces.get(i);
            boolean res = true;
            for (int i1 = 0; i1 < piece.length; i1++) {
                if (arr.get(i1)!=piece[i1]){
                    res = false;
                }
            }
            if (res){
                pieces.remove(i);
                for (int j = piece.length-1; j >=0; j--) {
                    arr.remove(j);
                }
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}