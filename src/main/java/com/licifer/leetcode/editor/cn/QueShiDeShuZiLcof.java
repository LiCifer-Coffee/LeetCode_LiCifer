/**
 * <p>一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre><strong>输入:</strong> [0,1,3]
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> [0,1,2,3,4,5,6,7,9]
 * <strong>输出:</strong> 8</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <p><code>1 &lt;= 数组长度 &lt;= 10000</code></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 哈希表 | 数学 | 二分查找</details><br>
 *
 * <div>👍 415, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 自然数数组中缺失一位自然数，求缺失的自然数是多少，[0,1,3]，缺失的自然数是2
 * 解题思路:
 * 1. 如果 nums[mid] > mid，则缺失是在左边 ，正常没有缺失的情况应该是 nums[mid] = mid，最终left指向的是数组中的3，它对应的索引2就是缺失的数字
 */
public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > mid) {
                    // 左边缺失
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}