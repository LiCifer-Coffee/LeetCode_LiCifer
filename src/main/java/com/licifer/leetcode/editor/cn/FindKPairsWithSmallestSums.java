/**
 * <p>给定两个以 <strong>非递减顺序排列</strong> 的整数数组 <code>nums1</code> 和<strong> </strong><code>nums2</code><strong>&nbsp;</strong>,&nbsp;以及一个整数 <code>k</code><strong>&nbsp;</strong>。</p>
 *
 * <p>定义一对值&nbsp;<code>(u,v)</code>，其中第一个元素来自&nbsp;<code>nums1</code>，第二个元素来自 <code>nums2</code><strong>&nbsp;</strong>。</p>
 *
 * <p>请找到和最小的 <code>k</code>&nbsp;个数对&nbsp;<code>(u<sub>1</sub>,v<sub>1</sub>)</code>, <code>&nbsp;(u<sub>2</sub>,v<sub>2</sub>)</code> &nbsp;... &nbsp;<code>(u<sub>k</sub>,
 * v<sub>k</sub>)</code>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * <strong>输出:</strong> [1,2],[1,4],[1,6]
 * <strong>解释: </strong>返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * </pre>
 *
 * <p><strong class="example">示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * <strong>输出: </strong>[1,1],[1,1]
 * <strong>解释: </strong>返回序列中的前 2 对数：
 * &nbsp;    [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * </pre>
 *
 * <p><strong class="example">示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>nums1 = [1,2], nums2 = [3], k = 3
 * <strong>输出:</strong> [1,3],[2,3]
 * <strong>解释: </strong>也可能序列中所有的数对都被返回:[1,3],[2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>nums1</code> 和 <code>nums2</code> 均为升序排列</li>
 * <li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 堆（优先队列）</details><br>
 *
 * <div>👍 515, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 解题思路:
 * 1.当做3个链表合并来做，链表node={nums1[i],nums2[i],i}
 * 2.这种题目难点在于如何定义队列中的元素，可以从如何找到下一个元素来思考，首先node里面必须包含答案里面的值，然后可以找到下一个元素
 *   该题里面的答案由nums1[i],nums2[i]组成，i为nums2的索引
 */
public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            // {nums1[i],nums2[i],i}
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] + o1[1]) - (o2[0] + o2[1]);
                }
            });

            for (int i = 0; i < nums1.length; i++) {
                queue.offer(new int[]{nums1[i], nums2[0], 0});
            }

            List<List<Integer>> res = new ArrayList<>();
            while (!queue.isEmpty() && k > 0) {
                int[] poll = queue.poll();
                int num1 = poll[0];
                int num2 = poll[1];
                int index = poll[2];
                List<Integer> node = new ArrayList<>();
                node.add(num1);
                node.add(num2);
                res.add(node);
                int nums2Index = index + 1;
                if (nums2Index < nums2.length) {
                    queue.offer(new int[]{num1, nums2[nums2Index], nums2Index});
                }
                k--;
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}