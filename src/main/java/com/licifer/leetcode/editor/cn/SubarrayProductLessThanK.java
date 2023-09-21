/**
 * 给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回子数组内所有元素的乘积严格小于<em> </em><code>k</code> 的连续子数组的数目。
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [10,5,2,6], k = 100
 * <strong>输出：</strong>8
 * <strong>解释：</strong>8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3], k = 0
 * <strong>输出：</strong>0</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:&nbsp;</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 滑动窗口</details><br>
 *
 * <div>👍 727, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/*
 * LeetCode: https://leetcode.cn/problems/subarray-product-less-than-k/description/
 * 题目理解: 找出子数组的积小于k的子数组个数
 * 解题思路:
 * 1. 滑动窗口思想，双指针
 * 2. 利用滑动窗口解题思路，要注意窗口缩小时left<right的判断，如果不加这个判断，当输入为[1,1,1]时会有问题
 * 3. 对于结果集count = count + right - left; 例如此时left=1,right=4,结果数组[1,2,3]，此时满足条件的子数组为:[3],[2,3],[1,2,3]，没有[1,2]这个数组，这个数组在right=3,[1,2]时已经处理了
 * 4. 对于滑动窗口，比较难以确定两点是窗口缩小时机和什么时候得到一个合法的答案
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            // 滑动窗口
            if (k == 0) {
                return 0;
            }
            int left = 0, right = 0, count = 0, windowProduct = 1;
            while (right < nums.length) {
                windowProduct = windowProduct * nums[right];
                right++;
                while (left < right && windowProduct >= k) {
                    windowProduct = windowProduct / nums[left];
                    left++;
                }
                count = count + right - left;
            }
            return count;



            // 前缀积思想
            //if (k <= 1) return 0;
            //int left = 0, count = 0, product = 1;
            //for (int right = 0; right < nums.length; right++) {
            //    product = product * nums[right];
            //    while (product >= k) {
            //        product = product / nums[left];
            //        left++;
            //    }
            //    count = count + (right - left + 1);
            //}
            //
            //return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}