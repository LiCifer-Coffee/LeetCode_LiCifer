/**
 * <p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>注意：</strong></p>
 *
 * <ul>
 * <li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li>
 * <li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
 * <strong>输出：</strong>"BANC"
 * <strong>解释：</strong>最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "a", t = "a"
 * <strong>输出：</strong>"a"
 * <strong>解释：</strong>整个字符串 s 是最小覆盖子串。
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = "a", t = "aa"
 * <strong>输出:</strong> ""
 * <strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code><sup>m == s.length</sup></code></li>
 * <li><code><sup>n == t.length</sup></code></li>
 * <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> 和 <code>t</code> 由英文字母组成</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>进阶：</strong>你能设计一个在
 * <code>o(m+n)</code> 时间内解决此问题的算法吗？
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 2662, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: https://leetcode.cn/problems/minimum-window-substring/description/
 * 题目理解: 找出s字符串中包含t字符串的最小子串，s="ADOBECODEBANC"，t="ABC"，输出"BANC"
 * 解题思路:
 * 1. 利用滑动窗口，一般是3个变量（int left = 0, right = 0, valid = 0），2个map，有的时候可以用sum或者string代替map
 * 2. window里面放的都是满足条件的，所以都要if判断
 * 3. 窗口增加的条件：right < s.length()，一般都是这样的，以right指针到结尾为止
 * 4. 窗口缩小条件：need.size() == valid，valid的意义是在于t中满足条件的字符个数，例如"aa"这样的字符串，valid=1不是2，这个时候sum=2，所以条件不能用sum=valid来判断，
 * 因为是求最小子串，所以每次缩小窗口的当包含t中的字符串时都要更新start,len
 * 5. 返回的时候要用len != Integer.MAX_VALUE判断，不能用start判断，因为如果s整个字符串都满足条件的话，start还是等于0，但是len会改变
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("aa", "aa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            int left = 0, right = 0, valid = 0;

            int start = 0;
            int len = Integer.MAX_VALUE;

            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            while (right < s.length()) {

                char c = s.charAt(right);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        valid++;
                    }
                }
                right++;

                while (need.size() == valid) {
                    char d = s.charAt(left);
                    if (need.containsKey(d)) {
                        if (right - left < len) {
                            start = left;
                            len = right - left;
                        }
                        window.put(d, window.get(d) - 1);
                        if (window.get(d) < need.get(d)) {
                            valid--;
                        }
                    }
                    left++;
                }
            }

            return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}