/**
 * <p>给你一个数组 <code>nums</code><em>&nbsp;</em>和一个值 <code>val</code>，你需要 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a>
 * </strong> 移除所有数值等于&nbsp;<code>val</code><em>&nbsp;</em>的元素，并返回移除后数组的新长度。</p>
 *
 * <p>不要使用额外的数组空间，你必须仅使用 <code>O(1)</code> 额外空间并 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组</strong>。</p>
 *
 * <p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>说明:</strong></p>
 *
 * <p>为什么返回数值是整数，但输出的答案是数组呢?</p>
 *
 * <p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>
 *
 * <p>你可以想象内部操作如下:</p>
 *
 * <pre>
 * // <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
 * for (int i = 0; i &lt; len; i++) {
 * &nbsp; &nbsp; print(nums[i]);
 * }
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,2,3], val = 3
 * <strong>输出：</strong>2, nums = [2,2]
 * <strong>解释：</strong>函数应该返回新的长度 <strong>2</strong>, 并且 nums<em> </em>中的前两个元素均为 <strong>2</strong>。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,1,2,2,3,0,4,2], val = 2
 * <strong>输出：</strong>5, nums = [0,1,4,0,3]
 * <strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong>, 并且 nums 中的前五个元素为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>3</code></strong>, <strong><code>0</code></strong>, <strong>4</strong>。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 100</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 50</code></li>
 * <li><code>0 &lt;= val &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
 *
 * <div>👍 1942, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {

            int slow = 0, fast = 0;
            for (int num : nums) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }

            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}