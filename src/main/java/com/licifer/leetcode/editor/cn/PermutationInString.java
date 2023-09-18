/**
 * <p>给你两个字符串&nbsp;<code>s1</code>&nbsp;和&nbsp;<code>s2</code> ，写一个函数来判断 <code>s2</code> 是否包含 <code>s1</code><strong>&nbsp;</strong>的排列。如果是，返回 <code>true</code> ；否则，返回
 * <code>false</code> 。</p>
 *
 * <p>换句话说，<code>s1</code> 的排列之一是 <code>s2</code> 的 <strong>子串</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s1 = "ab" s2 = "eidbaooo"
 * <strong>输出：</strong>true
 * <strong>解释：</strong>s2 包含 s1 的排列之一 ("ba").
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s1= "ab" s2 = "eidboaoo"
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s1</code> 和 <code>s2</code> 仅包含小写字母</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 双指针 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 958, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: https://leetcode.cn/problems/permutation-in-string/description/
 * 题目理解: 字符串s1,s2,如果s2中包含s1子串的排列，那么输出true，例如：s1 = "ab" s2 = "eidbaooo" ，输出true
 * 解题思路:
 * 1. 利用滑动窗口，窗口缩小的时机是 right - left >= s1.length()，因为要保证s2包含s1的子串，所以窗口的大小就是s1的长度
 * 2. 注意window.get(d).equals(need.get(d))成立是，valid--，如果写成window.get(d) < need.get(d)，那么当window=2，need=5，那么条件成立，valid--，这个判断是不对的
 */
public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            int left = 0, right = 0, valid = 0;
            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            while (right < s2.length()) {
                char c = s2.charAt(right);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                right++;

                while (right - left >= s1.length()) {
                    if (valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d)))
                            valid--;
                        window.put(d, window.get(d) - 1);
                    }
                    left++;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}