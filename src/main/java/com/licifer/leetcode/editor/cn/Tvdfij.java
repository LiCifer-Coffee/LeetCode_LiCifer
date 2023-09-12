/**
 * <p>给你一个整数数组&nbsp;<code>nums</code> ，请计算数组的 <strong>中心下标 </strong>。</p>
 *
 * <p>数组<strong> 中心下标</strong><strong> </strong>是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。</p>
 *
 * <p>如果中心下标位于数组最左端，那么左侧数之和视为 <code>0</code> ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。</p>
 *
 * <p>如果数组有多个中心下标，应该返回 <strong>最靠近左边</strong> 的那一个。如果数组不存在中心下标，返回 <code>-1</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,7,3,6,5,6]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1, 2, 3]
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>
 * 数组中不存在满足此条件的中心下标。</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [2, 1, -1]
 * <strong>输出：</strong>0
 * <strong>解释：</strong>
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>
 * <meta charset="UTF-8" />注意：本题与主站 724&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/find-pivot-index/">https://leetcode-cn.com/problems/find-pivot-index/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 71, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 寻找中心数组下标索引，使得左边和等于右边和。nums = [1,7,3,6,5,6] ，输出3，因为[1,7,3]=[5,6]
 * 解题思路： 前缀和思路，构建前缀和数组，重点是要找出中心点右边的和[5,6]，rightSum = p[p.length - 1] - p[i] - nums[i]，记得要减去当前元素
 */
public class Tvdfij {
    public static void main(String[] args) {
        Solution solution = new Tvdfij().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {

            int index = -1;
            int[] p = new int[nums.length + 1];

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] + nums[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                if (p[i] == p[p.length - 1] - p[i] - nums[i]) {
                    index = i;
                    break;
                }
            }

            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}