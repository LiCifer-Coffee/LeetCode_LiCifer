/**
 * <p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>
 *
 * <p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "babad"
 * <strong>输出：</strong>"bab"
 * <strong>解释：</strong>"aba" 同样是符合题意的答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "cbbd"
 * <strong>输出：</strong>"bb"
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> 仅由数字和英文字母组成</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>
 *
 * <div>👍 6763, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 解题思路:利用双指针解题，不过不是左右双指针，而是从中心往两边延伸的双指针，在同一个字符串中，遍历每一个节点，找出以当前节点为中心的回文字符串，
 * 重点是要理解遍历字符串s，以i为中心去遍历字符串，找到所有存在的回文串，然后在所有的回文中找到最长的那个回文。
 * 难点：
 * 1.首先要写出一个方法，查找所有指定中心的回文串
 * 2.每次要找两个回文串，因为有奇数和偶数的区别，两个都找到，取最长的那个即可
 * 3.每次比较回文串，首先是奇数回文串和偶数回文串比大小，用最大的那一个跟res中的再做比较，取最大的那一个，保证是所有的回文串中最大的那一个
 * 4.在palindrome方法中，注意while条件，因为l和r一直在变化，很容易越界，所以l >= 0 && r < s.length()这两个条件必不可少
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String palindrome1 = palindrome(s, i, i);
                String palindrome2 = palindrome(s, i, i + 1);
                String max = palindrome1.length() > palindrome2.length() ? palindrome1 : palindrome2;
                res = res.length() > max.length() ? res : max;

                //// 以 s[i] 为中心的最长回文子串
                //String s1 = palindrome(s, i, i);
                //// 以 s[i] 和 s[i+1] 为中心的最长回文子串
                //String s2 = palindrome(s, i, i + 1);
                //// res = longest(res, s1, s2)
                //res = res.length() > s1.length() ? res : s1;
                //res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        // 在字符串s中寻找以l和r为中心的回文字符串，注意是中心，而不是字符串的中点
        private String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}