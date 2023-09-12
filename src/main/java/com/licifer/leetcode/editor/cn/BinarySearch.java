/**
 * <p>给定一个&nbsp;<code>n</code>&nbsp;个元素有序的（升序）整型数组&nbsp;<code>nums</code> 和一个目标值&nbsp;<code>target</code> &nbsp;，写一个函数搜索&nbsp;<code>nums</code>&nbsp;中的
 * <code>target</code>，如果目标值存在返回下标，否则返回 <code>-1</code>。</p>
 *
 * <p><br> <strong>示例 1:</strong></br></p>
 *
 * <pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 9
 * <strong>输出:</strong> 4
 * <strong>解释:</strong> 9 出现在 <span><code>nums</code></span> 中并且下标为 4
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre><strong>输入:</strong> <span><code>nums</code></span> = [-1,0,3,5,9,12], <span><code>target</code></span> = 2
 * <strong>输出:</strong> -1
 * <strong>解释:</strong> 2 不存在 <span><code>nums</code></span> 中因此返回 -1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ol>
 * <li>你可以假设 <code>nums</code>&nbsp;中的所有元素是不重复的。</li>
 * <li><code>n</code>&nbsp;将在&nbsp;<code>[1, 10000]</code>之间。</li>
 * <li><code>nums</code>&nbsp;的每个元素都将在&nbsp;<code>[-9999, 9999]</code>之间。</li>
 * </ol>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 1440, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 标准的二分查找，nums = [-1,0,3,5,9,12], target = 9，index = 4
 * 解题思路:
 * 1. 注意return nums[left] != target ? -1 : left; 如果直接返回left，那么当target不存在时，不会返回-1
 * 2. if (left > nums.length - 1) {
 *                 return -1;
 *             }
 *   如果不做这个判断，在[-1,0,3,5,9,12]  13这个输入下，会报错，因为此时left = nums.length了，索引越界了。
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            if (left > nums.length - 1) {
                return -1;
            }
            return nums[left] != target ? -1 : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}