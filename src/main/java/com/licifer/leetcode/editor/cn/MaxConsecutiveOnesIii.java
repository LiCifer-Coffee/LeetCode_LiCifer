/**
 * <p>给定一个二进制数组&nbsp;<code>nums</code>&nbsp;和一个整数 <code>k</code>，如果可以翻转最多 <code>k</code> 个 <code>0</code> ，则返回 <em>数组中连续 <code>1</code> 的最大个数</em> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * <strong>输出：</strong>6
 * <strong>解释：</strong>[1,1,1,0,0,<strong>1</strong>,1,1,1,1,<strong>1</strong>]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * <strong>输出：</strong>10
 * <strong>解释：</strong>[0,0,1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>nums[i]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code></li>
 * <li><code>0 &lt;= k &lt;= nums.length</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 前缀和 | 滑动窗口</details><br>
 *
 * <div>👍 633, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * LeetCode: https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * 题目理解: 给你k次机会将0变为1，求最长都为1的子数组长度
 * 解题思路:
 * 1. 滑动窗口思想，窗口是都为1的子数组
 * 2. 当窗口中0的数量大于k时，缩小窗口，因为即使所有0都替换为1了，子数组也还包含0，不满足都为1的条件
 * 3. 结果求最大子数组长度，len = Math.max(len, right - left);
 */
public class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {

            // windowNus为窗口中1的数量
            int left = 0, right = 0, len = 0, windowNum = 0;
            while (right < nums.length) {
                if (nums[right] == 1) {
                    windowNum++;
                }
                right++;
                // 窗口中0的数量大于k时，缩小窗口
                while (right - left - windowNum > k) {
                    if (nums[left] == 1) {
                        windowNum--;
                    }
                    left++;
                }
                len = Math.max(len, right - left);
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}