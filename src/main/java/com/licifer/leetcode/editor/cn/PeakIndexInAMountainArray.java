/**
 * 符合下列属性的数组 <code>arr</code> 称为 <strong>山脉数组</strong> ：
 *
 * <ul>
 * <li><code>arr.length &gt;= 3</code></li>
 * <li>存在 <code>i</code>（<code>0 &lt; i&nbsp;&lt; arr.length - 1</code>）使得：
 * <ul>
 * <li><code>arr[0] &lt; arr[1] &lt; ... arr[i-1] &lt; arr[i] </code></li>
 * <li><code>arr[i] &gt; arr[i+1] &gt; ... &gt; arr[arr.length - 1]</code></li>
 * </ul> </li>
 * </ul>
 *
 * <p>给你由整数组成的山脉数组 <code>arr</code> ，返回满足 <code>arr[0] &lt; arr[1] &lt; ... arr[i - 1] &lt; arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code> 的下标 <code>i</code> 。</p>
 *
 * <p>你必须设计并实现时间复杂度为 <code>O(log(n))</code> 的解决方案。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [0,1,0]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [0,2,1,0]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>arr = [0,10,5,2]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
 * <li>题目数据保证 <code>arr</code> 是一个山脉数组</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>
 *
 * <div>👍 371, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 求峰值，跟162一样的题目
 * 解题思路:
 * 1. 这种峰值的问题都是比较mid 和 mid+1，一定要注意 right = arr.length - 1 ，
 * 这点跟普通二分法的定义不一样，如果直接right = arr.length，在只要一个元素时会索引越界
 */
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {

            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > arr[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}