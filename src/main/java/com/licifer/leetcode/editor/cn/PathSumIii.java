/**
 * <p>给定一个二叉树的根节点 <code>root</code>&nbsp;，和一个整数 <code>targetSum</code> ，求该二叉树里节点值之和等于 <code>targetSum</code> 的 <strong>路径</strong> 的数目。</p>
 *
 * <p><strong>路径</strong> 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img src="https://assets.leetcode.com/uploads/2021/04/09/pathsum3-1-tree.jpg" style="width: 452px; " /></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * <strong>输出：</strong>3
 * <strong>解释：</strong>和等于 8 的路径有 3 条，如图所示。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li>二叉树的节点个数的范围是 <code>[0,1000]</code></li>
 * <li>
 * <meta charset="UTF-8" /><code>-10<sup>9</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>9</sup></code>&nbsp;</li>
 * <li><code>-1000&nbsp;&lt;= targetSum&nbsp;&lt;= 1000</code>&nbsp;</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>
 *
 * <div>👍 1710, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目理解: 需要求一个路径上和为targetSum的子数组有多少个
 * 解题思路:
 * 1. 前缀和思想+countMap即可求解子数组的个数，老套路
 * 2. 不理解的地方在于去除当前节点  countMap.put(curSum, countMap.get(curSum) - 1);
 */
public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
    }

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

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int target;
        Map<Long, Integer> countMap;
        public int pathSum(TreeNode root, int targetSum) {
            target = targetSum;
            countMap = new HashMap<>();
            countMap.put(0L, 1);
            return recur(root, 0L);
        }

        private int recur(TreeNode node, Long curSum) {
            if (node == null) {
                return 0;
            }
            curSum += node.val;

            int res = 0;

            res += countMap.getOrDefault(curSum - target, 0);
            countMap.put(curSum, countMap.getOrDefault(curSum, 0) + 1);

            int left = recur(node.left, curSum);
            int right = recur(node.right, curSum);

            res = res + left + right;

            countMap.put(curSum, countMap.get(curSum) - 1);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}