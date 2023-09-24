/**
 * <p>给你一个字符串 <code>s</code> 和一个整数 <code>k</code> 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 <code>k</code> 次。</p>
 *
 * <p>在执行上述操作后，返回包含相同字母的最长子字符串的长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "ABAB", k = 2
 * <strong>输出：</strong>4
 * <strong>解释：</strong>用两个'A'替换为两个'B',反之亦然。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "AABABBA", k = 1
 * <strong>输出：</strong>4
 * <strong>解释：</strong>
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> 仅由大写英文字母组成</li>
 * <li><code>0 &lt;= k &lt;= s.length</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 814, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * LeetCode: https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 * 题目理解: 在字符串s中，可以有k次替换机会，求替换后，最长连续重复的字符串长度是多少
 * 解题思路:
 * 1. 滑动窗口思路，窗口中的内容为连续重复的字符串
 * 2. 思路是替换窗口中出现次数较少的字符
 * 3. 当窗口中可替换的字符串大于k时，缩小窗口
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {

            int left = 0, right = 0, windowMaxCount = 0, len = 0;
            int[] charCount = new int[26];

            while (right < s.length()) {
                charCount[s.charAt(right) - 'A']++;
                windowMaxCount = Math.max(windowMaxCount, charCount[s.charAt(right) - 'A']);
                right++;
                // 当窗口中其他字符的个数大于k时，缩小窗口，例如：BABAB，k=2，此时替换A，因为B出现的次数比A多
                while (right - left - windowMaxCount > k) {
                    charCount[s.charAt(left) - 'A']--;
                    left++;
                }
                // 这个时候，字符串为BBBBB，一定是连续的相同的字符组成的字符串
                len = Math.max(len, right - left);
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}