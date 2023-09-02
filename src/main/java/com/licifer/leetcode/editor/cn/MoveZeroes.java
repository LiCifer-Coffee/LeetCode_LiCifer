/**
 * <p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>
 *
 * <p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = <span><code>[0,1,0,3,12]</code></span>
 * <strong>输出:</strong> <span><code>[1,3,12,0,0]</code></span>
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = <span><code>[0]</code></span>
 * <strong>输出:</strong> <span><code>[0]</code></span></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示</strong>:</p>
 * <meta charset="UTF-8" />
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>
 *
 * <div>👍 2144, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 结题思路：利用快慢指针赋值。
 * 注意点：
 * 1.第二个for循环中，i<nums.length，不要写成了i<nums.length-slow，很容易搞错
 * 2.slow是先替换然后往前走，所以slow最后停留在所有替换后的数组后面一位，这点要注意
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {

            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}