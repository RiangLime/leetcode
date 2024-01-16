//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-
//value/ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 48 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QLCR045 {
    public static void main(String[] args) {
        Solution solution = new QLCR045().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queen = new LinkedList<>();
            queen.offer(root);
            List<List<TreeNode>> levels = new LinkedList<>();


            while (!queen.isEmpty()){
                List<TreeNode> level = new ArrayList<>();
                int levelNum = queen.size();
                for (int i = 0; i < levelNum; i++) {
                    TreeNode node = queen.poll();
                    if (node.left != null){
                        queen.offer(node.left);
                    }
                    if (node.right != null){
                        queen.offer(node.right);
                    }
                    level.add(node);
                }
                levels.add(level);
            }
            return levels.get(levels.size()-1).get(0).val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}