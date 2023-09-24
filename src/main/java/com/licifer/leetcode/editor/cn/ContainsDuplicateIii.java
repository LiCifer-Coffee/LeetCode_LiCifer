/**
 * <p>给你一个整数数组 <code>nums</code> 和两个整数 <code>indexDiff</code> 和 <code>valueDiff</code> 。</p>
 *
 * <p>找出满足下述条件的下标对 <code>(i, j)</code>：</p>
 *
 * <ul>
 * <li><code>i != j</code>,</li>
 * <li><code>abs(i - j) &lt;= indexDiff</code></li>
 * <li><code>abs(nums[i] - nums[j]) &lt;= valueDiff</code></li>
 * </ul>
 *
 * <p>如果存在，返回 <code>true</code><em> ；</em>否则，返回<em> </em><code>false</code><em> </em>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * <strong>输出：</strong>true
 * <strong>解释：</strong>可以找出 (i, j) = (0, 3) 。
 * 满足下述 3 个条件：
 * i != j --&gt; 0 != 3
 * abs(i - j) &lt;= indexDiff --&gt; abs(0 - 3) &lt;= 3
 * abs(nums[i] - nums[j]) &lt;= valueDiff --&gt; abs(1 - 1) &lt;= 0
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * <strong>输出：</strong>false
 * <strong>解释：</strong>尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>1 &lt;= indexDiff &lt;= nums.length</code></li>
 * <li><code>0 &lt;= valueDiff &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 桶排序 | 有序集合 | 排序 | 滑动窗口</details><br>
 *
 * <div>👍 709, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.TreeSet;

/**
 * LeetCode: https://leetcode.cn/problems/contains-duplicate-iii/description/
 * 题目理解: 寻找一个子数组，需要满足首尾索引<=indexDiff，并且首尾元素对应的值<=valueDiff
 * 解题思路:
 * 1. 滑动窗口思想，窗口大小为indexDiff
 * 2. 每加入一个元素时，与最靠近这个元素的值做比较，如果这两个元素相减满足<=valueDiff，那么符合条件返回true，
 * 这个地方不太好理解，为什么要与新加入的元素做比较，因为每个元素加入时都会做判断，如果和最近的元素差值满足条件，那么与它远些的元素必然也满足条件
 * 3. TreeSet的作用是，找到与新加入元素最近的那个元素，ceiling是稍大的元素，floor是稍小的元素
 */
public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

            int left = 0, right = 0;
            TreeSet<Integer> windowSet = new TreeSet<>();

            while (right < nums.length) {
                // 先做逻辑判断，再right++，所以当right=nums.length时，索引不会越界。
                // 这里的判断都是对窗口内符合条件的元素进行判断
                if (windowSet.ceiling(nums[right]) != null && windowSet.ceiling(nums[right]) - nums[right] <= valueDiff) {
                    return true;
                }
                if (windowSet.floor(nums[right]) != null && nums[right] - windowSet.floor(nums[right]) <= valueDiff) {
                    return true;
                }

                windowSet.add(nums[right]);
                right++;
                while (right - left > indexDiff) {
                    windowSet.remove(nums[left]);
                    left++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}