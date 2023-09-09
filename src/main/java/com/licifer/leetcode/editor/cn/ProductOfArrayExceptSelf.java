/**
 * <p>给你一个整数数组&nbsp;<code>nums</code>，返回 <em>数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;等于&nbsp;<code>nums</code>&nbsp;中除&nbsp;
 * <code>nums[i]</code>&nbsp;之外其余各元素的乘积</em>&nbsp;。</p>
 *
 * <p>题目数据 <strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内。</p>
 *
 * <p>请<strong>不要使用除法，</strong>且在&nbsp;<code>O(<em>n</em>)</code> 时间复杂度内完成此题。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = <span><code>[1,2,3,4]</code></span>
 * <strong>输出:</strong> <span><code>[24,12,8,6]</code></span>
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [-1,1,0,-3,3]
 * <strong>输出:</strong> [0,0,9,0,0]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
 * <li><strong>保证</strong> 数组&nbsp;<code>nums</code>之中任意元素的全部前缀元素和后缀的乘积都在&nbsp; <strong>32 位</strong> 整数范围内</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你可以在 <code>O(1)</code>&nbsp;的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组<strong>不被视为</strong>额外空间。）</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 1573, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 求除了本元素外，数组中其他元素的积
 * 解题思路:
 * 1. 求出数组的前缀积和后缀积
 * 2. 然后前缀积 * 后缀积 就等于题目答案
 * 3. 注意后缀积这里要减去一，int end = endSum[nums.length - i - 1]; 这里容易搞错，自己画图一看便知。
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {

            int[] startSum = new int[nums.length + 1];
            startSum[0] = 1;
            int[] endSum = new int[nums.length + 1];
            endSum[0] = 1;
            int[] answer = new int[nums.length];

            for (int i = 1; i <= nums.length; i++) {
                startSum[i] = startSum[i - 1] * nums[i - 1];
            }

            for (int i = nums.length; i >= 1; i--) {
                endSum[endSum.length - i] = endSum[endSum.length - i - 1] * nums[i - 1];
            }

            for (int i = 0; i < nums.length; i++) {
                int left = startSum[i];
                int end = endSum[nums.length - i - 1];
                answer[i] = left * end;
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}