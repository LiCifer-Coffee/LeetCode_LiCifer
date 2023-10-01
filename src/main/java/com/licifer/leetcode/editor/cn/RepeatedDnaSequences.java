/**
 * <p><strong>DNA序列</strong>&nbsp;由一系列核苷酸组成，缩写为
 * <meta charset="UTF-8" />&nbsp;<code>'A'</code>,&nbsp;<code>'C'</code>,&nbsp;<code>'G'</code>&nbsp;和
 * <meta charset="UTF-8" />&nbsp;<code>'T'</code>.。</p>
 *
 * <ul>
 * <li>例如，
 * <meta charset="UTF-8" /><code>"ACGAATTCCG"</code>&nbsp;是一个 <strong>DNA序列</strong> 。</li>
 * </ul>
 *
 * <p>在研究 <strong>DNA</strong> 时，识别 DNA 中的重复序列非常有用。</p>
 *
 * <p>给定一个表示 <strong>DNA序列</strong> 的字符串 <code>s</code> ，返回所有在 DNA 分子中出现不止一次的&nbsp;<strong>长度为&nbsp;<code>10</code></strong>&nbsp;的序列(子字符串)。你可以按 <strong>任意顺序</strong> 返回答案。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <strong>输出：</strong>["AAAAACCCCC","CCCCCAAAAA"]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "AAAAAAAAAAAAA"
 * <strong>输出：</strong>["AAAAAAAAAA"]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s[i]</code><code>==</code><code>'A'</code>、<code>'C'</code>、<code>'G'</code>&nbsp;or&nbsp;<code>'T'</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希</details><br>
 *
 * <div>👍 496, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * LeetCode: https://leetcode.cn/problems/repeated-dna-sequences/description/
 * 题目理解: 找出长度为10的重复子串，s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"，输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 解题思路:
 * 1. 利用滑动哈希窗口思想，将10位字符串转化为数字hash
 * 2. 窗口增大时，向右边加一位，82643 = 8264*10 + 3(rightNum)，此时只需要知道新加入的低位，windowHash=8264
 * 3. 窗口缩小时，向左边减一位，264 = 8264 - 8(leftNum)*10^(4-1)，10位进制数，4为窗口字符串长度，windowHash=8264
 * 4. 滑动窗口哈希，主要是需要弄懂上面那个算法，如何增加或者减少一位。
 */
public class RepeatedDnaSequences {
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {

            HashSet<String> res = new HashSet<>();
            int[] nums = new int[s.length()];

            // 将字符串转化为数字字符串
            for (int i = 0; i < nums.length; i++) {
                switch (s.charAt(i)) {
                    case 'A':
                        nums[i] = 1;
                        break;
                    case 'G':
                        nums[i] = 2;
                        break;
                    case 'C':
                        nums[i] = 3;
                        break;
                    case 'T':
                        nums[i] = 4;
                        break;
                }
            }

            int left = 0, right = 0, windowHash = 0;
            int R = 4;
            int L = 10;
            int p = (int)Math.pow(R, L - 1);
            HashSet<Integer> integerSet = new HashSet<>();
            while (right < nums.length) {

                // 向右加一个数字 82643 = 8264*10 + 3(rightNum)
                int rightNum = nums[right];
                int leftNum = nums[left];
                windowHash = windowHash * R + rightNum;
                right++;
                if (right - left == L) {
                    // 先判断windowHash,再缩小窗口
                    if (integerSet.contains(windowHash)) {
                        res.add(s.substring(left, right));
                    } else {
                        integerSet.add(windowHash);
                    }
                    // 缩小窗口，向左减一个数字  264 = 8264 - 8(leftNum)*10^3
                    windowHash = windowHash - leftNum * p;
                    left++;
                }
            }
            return new ArrayList<>(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}