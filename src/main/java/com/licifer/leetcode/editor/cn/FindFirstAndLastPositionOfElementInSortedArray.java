/**
 * <p>给你一个按照非递减顺序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。请你找出给定目标值在数组中的开始位置和结束位置。</p>
 *
 * <p>如果数组中不存在目标值 <code>target</code>，返回&nbsp;<code>[-1, -1]</code>。</p>
 *
 * <p>你必须设计并实现时间复杂度为&nbsp;<code>O(log n)</code>&nbsp;的算法解决此问题。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 8
 * <strong>输出：</strong>[3,4]</pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<span><code>5,7,7,8,8,10]</code></span>, target = 6
 * <strong>输出：</strong>[-1,-1]</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [], target = 0
 * <strong>输出：</strong>[-1,-1]</pre>
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
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 2465, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            return new int[]{left(nums, target), right(nums, target)};
            //return new int[]{left_bound(nums, target), right_bound(nums, target)};

        }

        int left_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            // 搜索区间为 [left, right]
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    // 搜索区间变为 [mid+1, right]
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    // 搜索区间变为 [left, mid-1]
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 收缩右侧边界
                    right = mid - 1;
                }
            }
            // 检查出界情况
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 这里改成收缩左侧边界即可
                    left = mid + 1;
                }
            }
            // 这里改为检查 right 越界的情况，见下图
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }

        private int left(int[] nums, int target) {
            int left = 0, right = nums.length-1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            if (left >= nums.length|| nums[left] != target) {
                return -1;
            }

            return left;
        }

        private int right(int[] nums, int target) {
            int left = 0, right = nums.length-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            if (right < 0|| nums[right] != target) {
                return -1;
            }

            return left - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}