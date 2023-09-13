/**
 * <p>统计一个数字在排序数组中出现的次数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 8
 * <strong>输出:</strong> 2</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 6
 * <strong>输出:</strong> 0</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
 * <li><code>nums</code>&nbsp;是一个非递减数组</li>
 * <li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意：</strong>本题与主站 34 题相同（仅返回值不同）：
 * <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 446, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 求数组中target出现的次数，nums = [5,7,7,8,8,10], target = 8，输出2
 * 解题思路:
 * 1. 利用二分法找出左右边界，由于是递增数组，所以结果是 right-left+1
 * 2. 注意 右边界一定是返回 left-1，不能返回right或者left
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int leftIndex = getTargetIndex(nums, target, true);
            int rightIndex = getTargetIndex(nums, target, false);
            return (leftIndex == -1 || rightIndex == -1) ? 0 : rightIndex - leftIndex + 1;

        }


        private int getTargetIndex(int[] nums, int target, boolean isLeft) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (isLeft) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }

            if (isLeft) {
                if (left > nums.length - 1 || nums[left] != target) {
                    return -1;
                }
                return left;
            } else {
                if ((left - 1 < 0 || left - 1 > nums.length - 1) || nums[left - 1] != target) {
                    return -1;
                }
                return left - 1;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}