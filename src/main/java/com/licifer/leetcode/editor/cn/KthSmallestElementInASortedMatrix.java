/**
 * <p>给你一个&nbsp;<code>n x n</code><em>&nbsp;</em>矩阵&nbsp;<code>matrix</code> ，其中每行和每列元素均按升序排序，找到矩阵中第 <code>k</code> 小的元素。<br /> 请注意，它是 <strong>排序后</strong> 的第 <code>k</code>
 * 小元素，而不是第 <code>k</code> 个 <strong>不同</strong> 的元素。</p>
 *
 * <p>你必须找到一个内存复杂度优于&nbsp;<code>O(n<sup>2</sup>)</code> 的解决方案。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * <strong>输出：</strong>13
 * <strong>解释：</strong>矩阵中的元素为 [1,5,9,10,11,12,13,<strong>13</strong>,15]，第 8 小元素是 13
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>matrix = [[-5]], k = 1
 * <strong>输出：</strong>-5
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == matrix.length</code></li>
 * <li><code>n == matrix[i].length</code></li>
 * <li><code>1 &lt;= n &lt;= 300</code></li>
 * <li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li>
 * <li>题目数据 <strong>保证</strong> <code>matrix</code> 中的所有行和列都按 <strong>非递减顺序</strong> 排列</li>
 * <li><code>1 &lt;= k &lt;= n<sup>2</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>你能否用一个恒定的内存(即 <code>O(1)</code> 内存复杂度)来解决这个问题?</li>
 * <li>你能在 <code>O(n)</code> 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（&nbsp;<a href="http://www.cse.yorku.ca/~andy/pubs/X+Y.pdf" target="_blank">this paper</a>&nbsp;）很有趣。</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 矩阵 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 993, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路:
 * 1.还是利用链表排序的思路来看，把[[1,5,9],[10,11,13],[12,13,15]] 看成3个排序过的链表
 * 2.老套路，把链表中的第一个节点放在优先队列里面，取到最小的节点，然后再把它的下一个节点放到队列里面
 * 3.想要获取下一个节点，必须知道横坐标和纵坐标，所以定义队列里面的元素为[matrix[i][j],i,j],i为当前行，j为当前列，matrix[i][j]为当前坐标的值
 * 4.获取下一个节点的坐标为[matrix[i][j+1],i,j+1]
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < matrix.length; i++) {
                queue.offer(new int[]{matrix[i][0], i, 0});
            }

            int res = 0;
            while (k > 0 && !queue.isEmpty()) {
                int[] minNode = queue.poll();
                res = minNode[0];
                k--;
                int j = minNode[2];
                int i = minNode[1];
                if (j + 1 < matrix[i].length) {
                    queue.offer(new int[]{matrix[i][j + 1], i, j + 1});
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}