/**
 * <p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [0,1]
 * <strong>输出:</strong> 2
 * <strong>说明:</strong> [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> nums = [0,1,0]
 * <strong>输出:</strong> 2
 * <strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>
 * <meta charset="UTF-8" />注意：本题与主站 525&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contiguous-array/">https://leetcode-cn.com/problems/contiguous-array/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 前缀和</details><br>
 *
 * <div>👍 148, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目理解: 求最大子数组长度，将题目转化为求最大子数组和为0的子数组长度
 * 解题思路:
 * 1. 只需要记录第一次元素出现的位置，一般这种求最大长度的都只记录第一次出现的位置
 * 2. 由于是求最大长度，所以只需要res不用累加，如果是求子数组个数才需要用到累加
 */
public class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {

            int[] p = new int[nums.length + 1];
            Map<Integer, Integer> pMap = new HashMap<>();
            pMap.put(0, 0);
            int res = 0;

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] + (nums[i - 1] > 0 ? 1 : -1);
                if (pMap.containsKey(p[i])) {
                    res = Math.max(i - pMap.get(p[i]), res);
                }
                pMap.putIfAbsent(p[i], i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}