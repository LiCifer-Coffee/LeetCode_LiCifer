/**
 * <p>给你两个按 <strong>非递减顺序</strong> 排列的整数数组&nbsp;<code>nums1</code><em> </em>和 <code>nums2</code>，另有两个整数 <code>m</code> 和 <code>n</code> ，分别表示 <code>nums1</code> 和
 * <code>nums2</code> 中的元素数目。</p>
 *
 * <p>请你 <strong>合并</strong> <code>nums2</code><em> </em>到 <code>nums1</code> 中，使合并后的数组同样按 <strong>非递减顺序</strong> 排列。</p>
 *
 * <p><strong>注意：</strong>最终，合并后数组不应由函数返回，而是存储在数组 <code>nums1</code> 中。为了应对这种情况，<code>nums1</code> 的初始长度为 <code>m + n</code>，其中前 <code>m</code> 个元素表示应合并的元素，后 <code>n</code> 个元素为
 * <code>0</code> ，应忽略。<code>nums2</code> 的长度为 <code>n</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <strong>输出：</strong>[1,2,2,3,5,6]
 * <strong>解释：</strong>需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [<em><strong>1</strong></em>,<em><strong>2</strong></em>,2,<em><strong>3</strong></em>,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1], m = 1, nums2 = [], n = 0
 * <strong>输出：</strong>[1]
 * <strong>解释：</strong>需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [0], m = 0, nums2 = [1], n = 1
 * <strong>输出：</strong>[1]
 * <strong>解释：</strong>需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>nums1.length == m + n</code></li>
 * <li><code>nums2.length == n</code></li>
 * <li><code>0 &lt;= m, n &lt;= 200</code></li>
 * <li><code>1 &lt;= m + n &lt;= 200</code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你可以设计实现一个时间复杂度为 <code>O(m + n)</code> 的算法解决此问题吗？</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>
 *
 * <div>👍 2098, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 解题思路:
 * 1.对于Nums1数组，从后面开始遍历，大的放在后面
 * 2.如果nums2还有剩余，那么要把nums2剩余的元素插入到nums1数组的前面来
 * 3.难点在于插入的时候，要用while循环，然后利用两个指针p,j来取值，每次遍历p,j都减少。如果用for循环，容易出错。
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = m - 1;
            int j = n - 1;
            int p = m + n - 1;

            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[p] = nums1[i];
                    i--;
                } else {
                    nums1[p] = nums2[j];
                    j--;
                }
                p--;
            }

            while (j >= 0) {
                nums1[p] = nums2[j];
                j--;
                p--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}