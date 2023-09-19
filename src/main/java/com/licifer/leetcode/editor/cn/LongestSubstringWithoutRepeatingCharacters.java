/**
 * <p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = "abcabcbb"
 * <strong>输出: </strong>3
 * <strong>解释:</strong> 因为无重复字符的最长子串是 <span><code>"abc"</code></span>，所以其长度为 3。
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = "bbbbb"
 * <strong>输出: </strong>1
 * <strong>解释: </strong>因为无重复字符的最长子串是 <span><code>"b"</code></span>，所以其长度为 1。
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = "pwwkew"
 * <strong>输出: </strong>3
 * <strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<span><code>"wke"</code></span>，所以其长度为 3。
 * &nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<span><code>"pwke"</code></span>&nbsp;是一个<em>子序列，</em>不是子串。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 9637, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * 题目理解: 求最大无重复子串，例如：s = "abcabcbb"，输出 3，因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 解题思路:
 * 1. 利用滑动窗口
 * 2. 滑动窗口最难以想到的就是缩小窗口的时机，例如该题是window.get(c) > 1，因为这个时候有重复的子串了，需要缩小窗口
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0, len = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                right++;
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    window.put(d, window.get(d) - 1);
                    left++;
                }
                len = Math.max(len, right - left);
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}