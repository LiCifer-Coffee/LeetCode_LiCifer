/**
 * <p>整数数组 <code>nums</code> 按升序排列，数组中的值 <strong>互不相同</strong> 。</p>
 *
 * <p>在传递给函数之前，<code>nums</code> 在预先未知的某个下标 <code>k</code>（<code>0 &lt;= k &lt; nums.length</code>）上进行了 <strong>旋转</strong>，使数组变为 <code>[nums[k], nums[k+1], ..., nums[n-1],
 * nums[0], nums[1], ..., nums[k-1]]</code>（下标 <strong>从 0 开始</strong> 计数）。例如， <code>[0,1,2,4,5,6,7]</code> 在下标 <code>3</code> 处经旋转后可能变为&nbsp;<code>[4,5,6,7,0,1,2]</code> 。</p>
 *
 * <p>给你 <strong>旋转后</strong> 的数组 <code>nums</code> 和一个整数 <code>target</code> ，如果 <code>nums</code> 中存在这个目标值 <code>target</code> ，则返回它的下标，否则返回&nbsp;<code>-1</code>&nbsp;。</p>
 *
 * <p>你必须设计一个时间复杂度为 <code>O(log n)</code> 的算法解决此问题。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<span><code>4,5,6,7,0,1,2]</code></span>, target = 0
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<span><code>4,5,6,7,0,1,2]</code></span>, target = 3
 * <strong>输出：</strong>-1</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1], target = 0
 * <strong>输出：</strong>-1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 5000</code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>nums</code> 中的每个值都 <strong>独一无二</strong></li>
 * <li>题目数据保证 <code>nums</code> 在预先未知的某个下标上进行了旋转</li>
 * <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 2737, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 在一组有序的数组中，将数组分成2半，后面一半移动到前面来，[4,5,6,7,0,1,2]，target = 0，找出数组中等于target元素的索引
 * 解题思路:
 * 1. 将数组拆分成2段，中间有个断崖，利用 nums[mid] > nums[left]的比较来判断mid处于断崖左边还是右边
 * 2. 确定了mid位置后，再来判断target在不在区间内，然后再不断缩小左右区间
 * 3. 要注意nums[mid] == target这个判断，不然找不到target
 * 4. 注意 target <= nums[right - 1]，因为 right = nums.length ，不然就越界了
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
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
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}