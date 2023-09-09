/**
 * <p>给定一个整数数组和一个整数&nbsp;<code>k</code><strong> ，</strong>请找到该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>nums = [1,1,1], k = 2
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 此题 [1,1] 与 [1,1] 为两种不同的情况
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong>nums = [1,2,3], k = 3
 * <strong>输出:</strong> 2
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * <li> <p><code>-10<sup>7</sup>&nbsp;&lt;= k &lt;= 10<sup>7</sup></code></p> </li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p>注意：本题与主站 560&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">https://leetcode-cn.com/problems/subarray-sum-equals-k/</a></p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 前缀和</details><br>
 *
 * <div>👍 171, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目理解: 找到所有子数组和为k的个数，例如：[1,1,1], k = 2，结果要返回2，因为只有[1,1]和[1,1]
 * 解题思路:
 * 1. 将所有的前缀和存放在map中，在map中寻找p[j]=p[i]-k，如果存在就加上它的个数
 * 2. 好比p[1]=p[2]-1 只有1个 ，p[2]=p[3]-1 只有2个，那么总共有3个子数组和为k=1，所以res+=countMap.get(p[i] - k)，而不是res++或者res=countMap.get(p[i] - k)
 * 3. map里面的key应该是p[i]-k，而不是k-p[i]，这点要注意
 */
public class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int[] p = new int[nums.length + 1];
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);
            int res = 0;

            for (int i = 1; i <= nums.length; i++) {

                p[i] = p[i - 1] + nums[i - 1];
                if (countMap.containsKey(p[i] - k)) {
                    res += countMap.get(p[i] - k);
                }
                countMap.put(p[i], countMap.getOrDefault(p[i], 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}