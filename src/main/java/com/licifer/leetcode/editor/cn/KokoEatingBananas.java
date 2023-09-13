/**
 * <p>珂珂喜欢吃香蕉。这里有 <code>n</code> 堆香蕉，第 <code>i</code> 堆中有&nbsp;<code>piles[i]</code>&nbsp;根香蕉。警卫已经离开了，将在 <code>h</code> 小时后回来。</p>
 *
 * <p>珂珂可以决定她吃香蕉的速度 <code>k</code> （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 <code>k</code> 根。如果这堆香蕉少于 <code>k</code> 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。&nbsp;&nbsp;</p>
 *
 * <p>珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。</p>
 *
 * <p>返回她可以在 <code>h</code> 小时内吃掉所有香蕉的最小速度 <code>k</code>（<code>k</code> 为整数）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <ul>
 * </ul>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>piles = [3,6,7,11], h = 8
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>piles = [30,11,23,4,20], h = 5
 * <strong>输出：</strong>30
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>piles = [30,11,23,4,20], h = 6
 * <strong>输出：</strong>23
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
 * <li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 537, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 有n堆香蕉，每堆香蕉有piles[i]根，吃香蕉的速度是每小时吃K根，不足一小时的按照一小时计算，要求计算在h小时内，吃完所有香蕉的最小速度是多少
 * 解题思路:
 * 1. 题目可以抽象出单调递减函数，x变量为吃香蕉的速度，f(x)为消耗的总时间，即x为横轴，h为纵轴
 * 2. left，right为最小，最大速度。最小速度是每小时吃1根，最大速度是每小时吃一堆，根据题目描述一堆的最大数量为10的9次方，因为是left<right，所以mid!=right，所以right最后+1
 * 3. 难点在于定义单调函数，变量x一般是要求的结果，纵轴一般为需要比较的变量，为输入的参数
 * 4. 这道题目f(x)的定义就是：当速度为x时，吃掉所有香蕉需要的总时间为f(x)
 * 5. 能够把单调函数整明白，题目就基本上搞定了
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {

            int left = 1, right = 1000000000 + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(piles, mid) == h) {
                    right = mid;
                } else if (f(piles, mid) < h) {
                    right = mid;
                } else if (f(piles, mid) > h) {
                    left = mid + 1;
                }
            }
            return left;

        }

        // 函数的意思是：x为变量，当速度为x时，吃完所有香蕉所需要的时间为f(x)，当速度越快时，时间越少，所以为单调递减函数
        // x为速度，结果为时间H
        private int f(int[] piles, int x) {
            // 计算吃完plies所有香蕉需要消耗的时间
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                int tempHour = piles[i] / x;
                if (piles[i] % x != 0) {
                    tempHour++;
                }
                hours = hours + tempHour;
            }
            return hours;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}