/**
 * <p>给你一个&nbsp;<code>m x n</code>&nbsp;的矩阵&nbsp;<code>mat</code>&nbsp;和一个整数 <code>k</code> ，请你返回一个矩阵&nbsp;<code>answer</code>&nbsp;，其中每个&nbsp;<code>answer[i][j]</code>&nbsp;
 * 是所有满足下述条件的元素&nbsp;<code>mat[r][c]</code> 的和：&nbsp;</p>
 *
 * <ul>
 * <li><code>i - k &lt;= r &lt;= i + k, </code></li>
 * <li><code>j - k &lt;= c &lt;= j + k</code> 且</li>
 * <li><code>(r, c)</code>&nbsp;在矩阵内。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * <strong>输出：</strong>[[12,21,16],[27,45,33],[24,39,28]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * <strong>输出：</strong>[[45,45,45],[45,45,45],[45,45,45]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>m ==&nbsp;mat.length</code></li>
 * <li><code>n ==&nbsp;mat[i].length</code></li>
 * <li><code>1 &lt;= m, n, k &lt;= 100</code></li>
 * <li><code>1 &lt;= mat[i][j] &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 前缀和</details><br>
 *
 * <div>👍 181, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 这个题目不好理解，可以理解为，在answer[i][j]中以i,j为坐标中心，长宽都为k的面积块
 * 解题思路：
 * 1. 求出前缀和，记住前缀和是要利用前面的和，例如p[i] = p[i-1]+nums[i-1]，以这个思路去求前缀和
 * 2. 求矩阵中任意两点的面积，这需要用到前缀和的差值求解，这里用不到原数组nums[]
 * 3. 要理解求(x1,y1)到(x2,y2)之间的面积，实际上是求(x1,y1)到(x2+1,y2+1)的面积，因为p[i][j]中存放的是p[i-1][j-1]的值
 * 4. 想想也不难，无非是求前缀和，利用前缀和求区间差值（这里是面积）
 */
public class MatrixBlockSum {
    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] p;

        public int[][] matrixBlockSum(int[][] mat, int k) {

            initPreSum(mat);

            int[][] answer = new int[mat.length][mat[0].length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int x1 = Math.max((i - k), 0);
                    int y1 = Math.max((j - k), 0);
                    int x2 = Math.min(i + k, mat.length - 1);
                    int y2 = Math.min(j + k, mat[0].length - 1);
                    answer[i][j] = getSum(x1, y1, x2, y2);
                }
            }
            return answer;
        }

        // 初始化前缀和
        private void initPreSum(int[][] mat) {
            p = new int[mat.length + 1][mat[0].length + 1];
            for (int i = 1; i <= mat.length; i++) {
                for (int j = 1; j <= mat[0].length; j++) {
                    p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + mat[i - 1][j - 1];
                }
            }
        }

        // 根据前缀和返回任意两点之间的面积
        private int getSum(int x1, int y1, int x2, int y2) {
            return p[x2 + 1][y2 + 1] - p[x1][y2 + 1] - p[x2 + 1][y1] + p[x1][y1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}