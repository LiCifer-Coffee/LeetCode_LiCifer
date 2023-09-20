/**
 * <p>给你一个整数数组 <code>nums</code> 和一个整数 <code>x</code> 。每一次操作时，你应当移除数组 <code>nums</code> 最左边或最右边的元素，然后从 <code>x</code> 中减去该元素的值。请注意，需要 <strong>修改</strong> 数组以供接下来的操作使用。</p>
 *
 * <p>如果可以将 <code>x</code>&nbsp;<strong>恰好</strong> 减到&nbsp;<code>0</code> ，返回<strong> 最小操作数 </strong>；否则，返回 <code>-1</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,1,4,2,3], x = 5
 * <strong>输出：</strong>2
 * <strong>解释：</strong>最佳解决方案是移除后两个元素，将 x 减到 0 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [5,6,7,8,9], x = 4
 * <strong>输出：</strong>-1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,20,1,1,3], x = 10
 * <strong>输出：</strong>5
 * <strong>解释：</strong>最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= x &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 二分查找 | 前缀和 | 滑动窗口</details><br>
 *
 * <div>👍 302, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/description/
 * 题目理解: 可以将题目转化为寻找数组中和=x的最小元素个数，由于可能是不连续的数组元素相加，所以一个前缀和解决不了问题
 * 解题思路:
 * 1. 构建左前缀和  和  右前缀和，如果左，右两个前缀和中有一个等于x了，那么取当中最小的那一个数，如果没有，那么用左前缀和下标 + 右前缀的下标相加
 * 2. 取三种情况的最小值
 * 3. 这个题目思路很简单，但是代码量比较多，细节比较多，由于是取最小值，所以int res = Integer.MAX_VALUE; 不能定义成res=-1;
 * 4. 利用滑动窗口思路解题，可以把题目理解为求窗口里面的最大值，窗口大小为total-x，由于是求最小操作数，所以nums.length-(right-left)（子数组长度）就可以求得操作次数
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {

            // 使用滑动窗口解题
            int left = 0, right = 0, windowSum = 0;
            int len = Integer.MIN_VALUE, total = 0;
            for (int num : nums) {
                total += num;
            }
            if (x > total) {
                return -1;
            }

            while (right < nums.length) {
                windowSum += nums[right];
                right++;
                while (windowSum > total - x) {
                    windowSum = windowSum - nums[left];
                    left++;
                }
                if (windowSum == total - x) {
                    len = Math.max(len, right - left);
                }
            }
            return len == Integer.MIN_VALUE ? -1 : nums.length - len;



            //int[] leftSum = new int[nums.length + 1];
            //int[] rightSum = new int[nums.length + 1];
            //Map<Integer, Integer> rightMap = new HashMap<>();
            //int res = Integer.MAX_VALUE;
            //
            //for (int i = 1; i <= nums.length; i++) {
            //    leftSum[i] = leftSum[i - 1] + nums[i - 1];
            //    if (leftSum[i] == x) {
            //        res = Math.min(i, res);
            //    }
            //    if (leftSum[i] >= x) {
            //        break;
            //    }
            //}
            //
            //for (int i = nums.length; i >= 1; i--) {
            //    rightSum[rightSum.length - i] = rightSum[rightSum.length - i - 1] + nums[i - 1];
            //    if (rightSum[rightSum.length - i] == x) {
            //        res = Math.min(res, rightSum.length - i);
            //    }
            //    if (rightSum[rightSum.length - i] < x) {
            //        rightMap.putIfAbsent(rightSum[rightSum.length - i], rightSum.length - i);
            //    }
            //}
            //
            //for (int i = 1; i < leftSum.length; i++) {
            //    if (rightMap.containsKey(x - leftSum[i])) {
            //        if (i + rightMap.get(x - leftSum[i]) < nums.length) {
            //            res = Math.min(i + rightMap.get(x - leftSum[i]), res);
            //        }
            //    }
            //}
            //
            //return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}