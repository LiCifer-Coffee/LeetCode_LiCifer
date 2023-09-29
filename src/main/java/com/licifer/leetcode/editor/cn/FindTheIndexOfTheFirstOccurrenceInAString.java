/**
 * <p>给你两个字符串&nbsp;<code>haystack</code> 和 <code>needle</code> ，请你在 <code>haystack</code> 字符串中找出 <code>needle</code> 字符串的第一个匹配项的下标（下标从 0 开始）。如果&nbsp;<code>needle</code> 不是
 * <code>haystack</code> 的一部分，则返回&nbsp; <code>-1</code><strong> </strong>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>haystack = "sadbutsad", needle = "sad"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>"sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>haystack = "leetcode", needle = "leeto"
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>"leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= haystack.length, needle.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>haystack</code> 和 <code>needle</code> 仅由小写英文字符组成</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>双指针 | 字符串 | 字符串匹配</details><br>
 *
 * <div>👍 2020, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * LeetCode: https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 题目理解: 求txt中的 pat字符串的起始位置，如果txt中不存在pat字符串，那么返回-1,如果正确，返回起始索引
 * 解题思路:
 * 1. 滑动哈希窗口解题思路，还是把字符串转化为数字hash的方法，只不过要不断求余（%Q），重点是掌握滑动哈希窗口这种套路
 * 2. X % Q == (X + Q) % Q
 *    (X + Y) % Q == (X % Q + Y % Q) % Q
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String txt, String pat) {

            // 位数
            int L = pat.length();
            // 进制（只考虑 ASCII 编码）
            int R = 256;
            // 取一个比较大的素数作为求模的除数
            long Q = 1658598167;
            // R^(L - 1) 的结果
            long RL = 1;
            for (int i = 1; i <= L - 1; i++) {
                // 计算过程中不断求模，避免溢出
                RL = (RL * R) % Q;
            }
            // 计算模式串的哈希值，时间 O(L)
            long patHash = 0;
            for (int i = 0; i < pat.length(); i++) {
                patHash = (R * patHash + pat.charAt(i)) % Q;
            }

            // 滑动窗口中子字符串的哈希值
            long windowHash = 0;

            // 滑动窗口代码框架，时间 O(N)
            int left = 0, right = 0;
            while (right < txt.length()) {
                // 扩大窗口，移入字符
                windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
                right++;

                // 当子串的长度达到要求
                if (right - left == L) {
                    // 根据哈希值判断是否匹配模式串
                    if (windowHash == patHash) {
                        // 当前窗口中的子串哈希值等于模式串的哈希值
                        // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                        if (pat.equals(txt.substring(left, right))) {
                            return left;
                        }
                    }
                    // 缩小窗口，移出字符
                    windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
                    // X % Q == (X + Q) % Q 是一个模运算法则
                    // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
                    // 所以额外再加一个 Q，保证 windowHash 不会是负数

                    left++;
                }
            }
            // 没有找到模式串
            return -1;


            //int R = 256;
            //int L = pat.length();
            //int RL = 1;
            //int Q = 1658598167;
            //int needleHash = 0;
            //
            //for (int i = 1; i <= L - 1; i++) {
            //    RL = (RL * R) % Q;
            //}
            //
            //for (int i = 0; i < pat.length(); i++) {
            //    needleHash = (R * needleHash + pat.charAt(i)) % Q;
            //}
            //
            //int windowHash = 0;
            //int left = 0, right = 0;
            //while (right < txt.length()) {
            //    windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
            //    right++;
            //    if (right - left == L) {
            //        if (windowHash == needleHash) {
            //            if (pat.equals(txt.substring(left, right))) {
            //                return left;
            //            }
            //        }
            //        windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
            //        left++;
            //    }
            //}
            //return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}