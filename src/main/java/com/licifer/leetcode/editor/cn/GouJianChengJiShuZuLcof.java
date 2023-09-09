/**
 * <p>给定一个数组 <code>A[0,1,…,n-1]</code>，请构建一个数组 <code>B[0,1,…,n-1]</code>，其中&nbsp;<code>B[i]</code> 的值是数组 <code>A</code> 中除了下标 <code>i</code> 以外的元素的积, 即&nbsp;
 * <code>B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]</code>。不能使用除法。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> [1,2,3,4,5]
 * <strong>输出:</strong> [120,60,40,30,24]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>所有元素乘积之和不会溢出 32 位整数</li>
 * <li><code>a.length &lt;= 100000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 347, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解:
 * 解题思路:
 * 1. 没什么好说的，求前缀积，后缀积，跟例题一模一样
 */
public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] nums) {
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