//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 859 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0994 {
    public static void main(String[] args) {
        Solution solution = new Q0994().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int fresh = 0;
            Queue<int[]> badList = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1){
                        fresh++;
                    }
                    if (grid[i][j]==2){
                        badList.add(new int[]{i,j});
                    }
                }
            }


            int ans = -1;
            while (!badList.isEmpty()){
                ans++;
                int size = badList.size();
                for (int i = 0; i < size; i++) {
                    int[] pos = badList.poll();
                    for (int[] d : DIRECTIONS) { // 四方向
                        int newI = pos[0] + d[0];
                        int newJ = pos[1] + d[1];
                        if (0 <= newI && newI < m && 0 <= newJ && newJ < n && grid[newI][newJ] == 1) { // 新鲜橘子
                            fresh--;
                            grid[newI][newJ] = 2; // 变成腐烂橘子
                            badList.offer(new int[]{newI, newJ});
                        }
                    }
                }
            }

            return fresh>0 ? -1 : Math.max(0,ans);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}