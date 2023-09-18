/**
 * <p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong>异位词&nbsp;
 * </strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>
 *
 * <p><strong>异位词 </strong>指由相同字母重排列形成的字符串（包括相同的字符串）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = "cbaebabacd", p = "abc"
 * <strong>输出: </strong>[0,6]
 * <strong>解释:</strong>
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * </pre>
 *
 * <p><strong>&nbsp;示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>s = "abab", p = "ab"
 * <strong>输出: </strong>[0,1,2]
 * <strong>解释:</strong>
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 1283, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * 题目理解: 求p在s中的全排列子串的起始索引，例如：s = "cbaebabacd", p = "abc" ，返回 [0,6]
 * 解题思路:
 * 1. 滑动窗口解题思路
 * 2. 窗口的大小就是p.length的长度，因为 right - left >= p.length()，这是窗口缩小的条件，所以当need.size() == valid时，left就是符合条件的起始索引
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            List<Integer> res = new ArrayList<>();

            int left = 0, right = 0, valid = 0;
            for (char c1 : p.toCharArray()) {
                need.put(c1, need.getOrDefault(c1, 0) + 1);
            }
            while (right < s.length()) {
                char c = s.charAt(right);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }
                right++;

                while (right - left >= p.length()) {
                    char d = s.charAt(left);
                    if (need.size() == valid) {
                        res.add(left);
                    }
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}