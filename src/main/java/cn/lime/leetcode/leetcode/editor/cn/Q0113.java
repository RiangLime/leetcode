//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1090 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import cn.lime.leetcode.leetcode.editor.cn.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q0113 {
    public static void main(String[] args) {
        Solution solution = new Q0113().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> current = new ArrayList<>();
            int currentSum = 0;
            dfs(root,targetSum,current,currentSum, res);
            return res;
        }

        private void dfs(TreeNode node,int targetSum,List<TreeNode> currentPath,int currentSum, List<List<Integer>> result){
            currentPath.add(node);
            currentSum = currentSum + node.val;
            logPth(currentPath);
            if (node.left == null && node.right == null){
                if (currentSum == targetSum){
                    List<Integer> path = new ArrayList<>();
                    for (TreeNode treeNode : currentPath) {
                        path.add(treeNode.val);
                    }
                    result.add(path);
                }
                return;
            }
            if (node.left != null){
                dfs(node.left,targetSum,currentPath,currentSum,result);
                currentPath.remove(node.left);
            }
            if (node.right != null){
                dfs(node.right,targetSum,currentPath,currentSum,result);
                currentPath.remove(node.right);
            }
        }

        private void logPth(List<TreeNode> currentPath){
            for (TreeNode integer : currentPath) {
                System.out.print(integer.val+"-");
            }
            System.out.println();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}