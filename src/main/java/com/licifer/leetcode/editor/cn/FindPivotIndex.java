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
 * <strong>输入：</strong>nums = [1, 7, 3, 6, 5, 6]
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
 * <p><strong>注意：</strong>本题与主站 1991 题相同：
 * <a href="https://leetcode-cn.com/problems/find-the-middle-index-in-array/" target="_blank">https://leetcode-cn.com/problems/find-the-middle-index-in-array/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 579, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;
/**
 * 题目理解: [1, 7, 3, 6, 5, 6] ，求数组中元素左右两边和相等的索引 ，例如 1+7+3 = 5+6 ，方法返回4(6的索引)
 * 解题思路:
 * 1. 求出前缀和
 * 2. 前缀和左右相等的那个索引就是答案
 * 3. 第二个for循环要按照nums来循环，不要按照p[]来循环，这样更容易知道数组中的前缀和
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        Solution solution = new FindPivotIndex().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {

            int[] p = new int[nums.length + 1];
            int index = -1;
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