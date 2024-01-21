//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1200 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

public class Q0063 {
    public static void main(String[] args) {
        Solution solution = new Q0063().new Solution();
        solution.uniquePathsWithObstacles(new int[][]{{0, 0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            return methodDynamic(obstacleGrid);
        }


        /**
         * f(m,n) = f(m-1,n) + f(m,n-1)
         * dp[i][j] = - dp[i-1][j] + dp[i][j-1]   [i][j]=0
         * - 0                         [i][j]=1
         *
         * @param obstacleGrid
         * @return
         */
        public int methodDynamic(int[][] obstacleGrid) {
            int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
            dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

            for (int i = 0; i < obstacleGrid.length; i++) {
                for (int j = 0; j < obstacleGrid[0].length; j++) {
                    if (i == 0 & j == 0) {
                        continue;
                    }
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        if (i == 0){
                            dp[i][j] = dp[i][j - 1];
                        }
                        else if (j == 0){
                            dp[i][j] = dp[i - 1][j];
                        }else {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                }
            }

            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }

        /**
         * dfs exceed time limit
         *
         * @param obstacleGrid
         * @return
         */
        private int methodDfs(int[][] obstacleGrid) {
            int res = 0;
            int sizeX = obstacleGrid.length;
            int sizeY = obstacleGrid[0].length;
            if ((sizeX == 1 && sizeY == 1)) {
                return obstacleGrid[0][0] == 1 ? 0 : 1;
            }
            if (obstacleGrid[0][0] == 1 || obstacleGrid[sizeX - 1][sizeY - 1] == 1) {
                return 0;
            }
            return dfs(0, 0, sizeX, sizeY, obstacleGrid, res);
        }

        /**
         * @param x
         * @param y
         * @param sizeX
         * @param sizeY
         * @param grid
         */
        public int dfs(int x, int y, int sizeX, int sizeY, int[][] grid, int res) {
            if (x == sizeX - 1 && y == sizeY - 1) {
                return res + 1;
            }
            if (x + 1 <= sizeX - 1 && grid[x + 1][y] != 1) {
                res = dfs(x + 1, y, sizeX, sizeY, grid, res);
            }
            if (y + 1 <= sizeY - 1 && grid[x][y + 1] != 1) {
                res = dfs(x, y + 1, sizeX, sizeY, grid, res);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}