/**
 * 给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回子数组内所有元素的乘积严格小于<em> </em><code>k</code> 的连续子数组的数目。
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [10,5,2,6], k = 100
 * <strong>输出：</strong>8
 * <strong>解释：</strong>8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3], k = 0
 * <strong>输出：</strong>0</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:&nbsp;</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 滑动窗口</details><br>
 *
 * <div>👍 727, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {

            //Map<Integer, Integer> pMap = new HashMap<>();
            int[] p = new int[nums.length + 1];
            //pMap.put(0, 1);
            int res = 0;

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] * nums[i - 1];

                for (int j = 0; j <= i; j++) {
                    if (p[i] * p[j] < 100) {
                        res++;
                    }
                }
                //pMap.put(p[i], pMap.getOrDefault(p[i], 0) + 1);
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}