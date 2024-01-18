//给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。 
//
// 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出
//，你不能再将它放到任何袋子中。 
//
// 请返回你需要拿出魔法豆的 最少数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：beans = [4,1,6,5]
//输出：4
//解释：
//- 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
//  剩下袋子中魔法豆的数目为：[4,0,6,5]
//- 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
//  剩下袋子中魔法豆的数目为：[4,0,4,5]
//- 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
//  剩下袋子中魔法豆的数目为：[4,0,4,4]
//总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
//没有比取出 4 个魔法豆更少的方案。
// 
//
// 示例 2： 
//
// 
//输入：beans = [2,10,3,2]
//输出：7
//解释：
//- 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
//  剩下袋子中魔法豆的数目为：[0,10,3,2]
//- 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
//  剩下袋子中魔法豆的数目为：[0,10,3,0]
//- 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
//  剩下袋子中魔法豆的数目为：[0,10,0,0]
//总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
//没有比取出 7 个魔法豆更少的方案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beans.length <= 10⁵ 
// 1 <= beans[i] <= 10⁵ 
// 
//
// Related Topics 数组 前缀和 排序 👍 77 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class Q2171 {
    public static void main(String[] args) {
        Solution solution = new Q2171().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumRemoval(int[] beans) {
            long sum = 0;
            // cannot use jdk stream to get sum
            for (int x : beans) {
                sum += x;
            }
            Arrays.sort(beans);
            long ans = sum;

            for (int i = 0; i < beans.length; ++i) {
                // left number [x] in each pocket
                ans = Math.min(ans, sum - (long) beans[i] * (beans.length - i));
                System.out.println(i + "-" + (sum - (long) beans[i] * (beans.length - i)));
            }
            return ans;
//            return minimumRemoval1(beans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*
 * [1,4,5,6]
 * num->1                   1,1,1,1         3+4+5->12
 * num->4                   0,4,4,4         1+1+2->4
 * num->5                   0,0,5,5         1+4+1->6
 * num->6                   0,0,0,6         1+4+5->10
 */