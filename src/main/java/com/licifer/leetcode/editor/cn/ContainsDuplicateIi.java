/**
 * <p>给你一个整数数组&nbsp;<code>nums</code> 和一个整数&nbsp;<code>k</code> ，判断数组中是否存在两个 <strong>不同的索引</strong><em>&nbsp;</em><code>i</code>&nbsp;和<em>&nbsp;</em><code>j</code> ，满足
 * <code>nums[i] == nums[j]</code> 且 <code>abs(i - j) &lt;= k</code> 。如果存在，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3,1], k<em> </em>= 3
 * <strong>输出：</strong>true</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1
 * <strong>输出：</strong>true</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3,1,2,3], k<em> </em>=<em> </em>2
 * <strong>输出：</strong>false</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 滑动窗口</details><br>
 *
 * <div>👍 638, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashSet;

/**
 * LeetCode: https://leetcode.cn/problems/contains-duplicate-ii/description/
 * 题目理解: 找出一个子数组，其中数组的第一个元素值和数组的最后一个元素值相等，并且索引的差值<=k
 * 解题思路:
 * 1. 滑动窗口思想，维护一个HashSet，目的是存放窗口中的元素，如果新加入的元素已经存在窗口中，那么返回true
 * 2. 要定义一个HashSet，不能单纯的用nums[right]=nums[left]来判断，这点是关键
 */
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            int left = 0, right = 0;
            HashSet<Integer> windowSet = new HashSet<>();
            while (right < nums.length) {
                if (windowSet.contains(nums[right])) {
                    return true;
                }
                windowSet.add(nums[right]);
                right++;
                while (right - left > k) {
                    windowSet.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}