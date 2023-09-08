/**
 * <p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>
 *
 * <p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>
 *
 * <p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>
 *
 * <p>请你返回「表现良好时间段」的最大长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>hours = [9,9,6,0,6,6,9]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>hours = [6,6,6]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= hours.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= hours[i] &lt;= 16</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 前缀和 | 单调栈</details><br>
 *
 * <div>👍 495, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路:
 * 1. 题目要求，大于8小时为表现优良的一天，要求这段时间内最长的优良时间有几天
 * 2. 面对这种问题，优先想到的就是利用前缀和来求最长区间长度，在构建前缀和数组的时候，把大于8小时的赋值为1，小于8小时的赋值为-1，所以题目就变成了求区间内大于0的子数组的最大长度
 * 3. 难以理解的地方为，int pj = p[i] - 1;
 *                     if (pMap.containsKey(pj)) {
 *                         res = Math.max(res, i - pMap.get(pj));
 *                     }
 *     可以这么理解，当p[i] = -1时，要找到p[j] = -2 ,从[j....i]这段时间内，数组和 = 1，代表表现优良的天数比不优良的天数多一天，
 *     整体来说刚好符合题目中说的求表现优良天数最大的子数组长度，i-j 即为最大长度。
 */
public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        Solution solution = new LongestWellPerformingInterval().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {

            int[] p = new int[hours.length + 1];
            int res = 0;
            Map<Integer, Integer> pMap = new HashMap<>();

            for (int i = 1; i <= hours.length; i++) {
                p[i] = p[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
                pMap.putIfAbsent(p[i], i);
            }

            for (int i = 1; i < p.length; i++) {
                if (p[i] > 0) {
                    res = Math.max(res, i);
                } else {
                    int pj = p[i] - 1;
                    if (pMap.containsKey(pj)) {
                        res = Math.max(res, i - pMap.get(pj));
                    }
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}