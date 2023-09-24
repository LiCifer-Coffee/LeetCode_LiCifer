/**
 * <p>给你一个字符串 <code>s</code> 和一个整数 <code>k</code> ，请你找出 <code>s</code> 中的最长子串，&nbsp;要求该子串中的每一字符出现次数都不少于 <code>k</code> 。返回这一子串的长度。</p>
 * <p>
 * <p data-pm-slice="1 1 []">如果不存在这样的子字符串，则返回 0。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "aaabb", k = 3
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "ababbc", k = 2
 * <strong>输出：</strong>5
 * <strong>解释：</strong>最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>s</code> 仅由小写英文字母组成</li>
 * <li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 分治 | 滑动窗口</details><br>
 *
 * <div>👍 847, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * LeetCode: https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * 题目理解: 给你一个字符串，找出一个子字符串，要求子字符串中每个字符出现的个数>=k
 * 解题思路:
 * 1. 滑动窗口思想，设定一个方法，增加一个字符个数的条件限制，即找出一个字符串，其中只包含count种字符，每种字符出现的次数>=k
 * 2. 然后穷举出26种字符满足要求的所有字符串，取最大的一个
 * 3. 窗口中是满足条件的字符串，窗口缩小的时机为，字符的种类>count时
 * 4. kCount的意思是满足k个的字符个数，当窗口缩小时，先判断 countNums[removeCharIndex] == k ，这步很关键，不能用先自减，然后countNums[removeCharIndex] < k判断
 * 5. 最后满足条件要求的条件判断为validCount == count && kCount == count，一定要加kCount == count
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {

            int maxLen = 0;
            for (int i = 1; i <= 26; i++) {
                int subStringLen = getSubStringLen(i, k, s);
                maxLen = Math.max(maxLen, subStringLen);
            }
            return maxLen;
        }

        // count表示有几种字符，K表示每种字符必须出现的次数
        private int getSubStringLen(int count, int k, String s) {

            int left = 0, right = 0, len = 0, validCount = 0, kCount = 0;
            int[] countNums = new int[26];
            while (right < s.length()) {

                int addCharIndex = s.charAt(right) - 'a';
                if (countNums[addCharIndex] == 0) {
                    validCount++;
                }
                countNums[addCharIndex]++;
                if (countNums[addCharIndex] == k) {
                    kCount++;
                }
                right++;
                while (validCount > count) {
                    int removeCharIndex = s.charAt(left) - 'a';
                    if (countNums[removeCharIndex] == k) {
                        kCount--;
                    }
                    countNums[removeCharIndex]--;
                    if (countNums[removeCharIndex] == 0) {
                        validCount--;
                    }
                    left++;
                }
                if (validCount == count && kCount == count) {
                    len = Math.max(len, right - left);
                }
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}