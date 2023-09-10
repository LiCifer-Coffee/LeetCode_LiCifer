/**
 * <p>输入一个正整数 <code>target</code> ，输出所有和为 <code>target</code> 的连续正整数序列（至少含有两个数）。</p>
 *
 * <p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>target = 9
 * <strong>输出：</strong>[[2,3,4],[4,5]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>target = 15
 * <strong>输出：</strong>[[1,2,3,4,5],[4,5,6],[7,8]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>限制：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= target &lt;= 10^5</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 双指针 | 枚举</details><br>
 *
 * <div>👍 567, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目理解: 求出连续自然整数相加等于target的子数组，target = 9 ， [[2,3,4],[4,5]]
 * 解题思路:
 * 1. 利用前缀和思想，一个int sum = 0 ， 还有一个Map ，即可知道满足条件的下标
 * 2. 容易搞错的地方是 for (int j = pMap.get(sum - target), k = 0; j < i; j++, k++) {
 *                             res[k] = j + 1;
 *                         }
 * 3. 弄清楚循环开始条件和结束条件，例如答案是[2,3,4]，那么j = [1,2,3]，所以res[k] = j+1
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {

            Map<Integer, Integer> pMap = new HashMap<>();
            List<int[]> answer = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < target; i++) {
                sum = sum + i;
                if (sum - target >= 0) {
                    if (pMap.containsKey(sum - target)) {
                        int[] res = new int[i - pMap.get(sum - target)];
                        for (int j = pMap.get(sum - target), k = 0; j < i; j++, k++) {
                            res[k] = j + 1;
                        }
                        answer.add(res);
                    }
                }
                pMap.put(sum, i);
            }

            return answer.toArray(new int[answer.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}