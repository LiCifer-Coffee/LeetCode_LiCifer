/**
 * <p>已知存在一个按非降序排列的整数数组 <code>nums</code> ，数组中的值不必互不相同。</p>
 *
 * <p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>旋转 </strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,4,4,5,6,6,7]</code> 在下标 <code>5</code> 处经旋转后可能变为 <code>[4,5,6,6,7,0,1,2,4,4]</code>
 * 。</p>
 *
 * <p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回 <code>true</code>
 * ，否则返回 <code>false</code> 。</p>
 *
 * <p>你必须尽可能减少整个操作步骤。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2<span><code>,5,6,0,0,1,2]</code></span>, target = 0
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2<span><code>,5,6,0,0,1,2]</code></span>, target = 3
 * <strong>输出：</strong>false</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li>
 * <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>这是 <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/">搜索旋转排序数组</a>&nbsp;的延伸题目，本题中的&nbsp;<code>nums</code>&nbsp; 可能包含重复元素。</li>
 * <li>这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 733, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 有一个旋转断崖数组，其中left和right有重复元素，求target是否在数组中
 * 解题思路:
 * 1. 先left和right去重
 * 2. 去重时注意边界条件，这个地方很容易搞错，right = nums.length，left < nums.length - 1 && nums[left] == nums[left + 1]，right > 1 && nums[right - 1] == nums[right - 2]
 * 3. left < nums.length - 1 && nums[left] == nums[left + 1] 他们的顺序不能反了，不能写成nums[left] == nums[left + 1] && left < nums.length - 1
 */
public class SearchInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        solution.search(new int[]{1}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean search(int[] nums, int target) {

            int left = 0, right = nums.length;
            while (left < right) {
                while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (right > 1 && nums[right - 1] == nums[right - 2]) {
                    right--;
                }
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                if (nums[mid] > nums[left]) {
                    // mid在断崖左边
                    if (target >= nums[left] && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    // mid在右边
                    if (target >= nums[mid] && target <= nums[right - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}