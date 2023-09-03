/**
 * <p>给你一个整数 <code>n</code> ，请你找出并返回第 <code>n</code> 个 <strong>丑数</strong> 。</p>
 *
 * <p><strong>丑数 </strong>就是只包含质因数&nbsp;<code>2</code>、<code>3</code> 和/或&nbsp;<code>5</code>&nbsp;的正整数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 10
 * <strong>输出：</strong>12
 * <strong>解释：</strong>[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1
 * <strong>输出：</strong>1
 * <strong>解释：</strong>1 通常被视为丑数。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 1690</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>
 *
 * <div>👍 1100, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 解题思路:
 * 1.把丑数当做三个链表来看，分别是2，3，5的倍数链表
 * 2.比较3个链表中最小的值，将最小的值放在结果链表中
 * 3.dummy中所有节点都是2，3，5的倍数
 * 4.取出最小值后，对应链表的指针再往后走一步
 * 5.当前链表的下一个数为 ugly[p]，这一点不好理解
 * 6.如果一个数 x 是丑数，那么 x * 2, x * 3, x * 5 都一定是丑数。这里面的x是dummy中的值。
 * 7.注意不能写成if else if 这种形式，只能写成if这种，因为如果最小值相等时，对应链表的指针都要向后走一步。
 * 8.这个题不太好理解，下次刷题继续加深印象
 */
public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {

            int p1 = 1, p2 = 1, p3 = 1;
            int value1 = 1, value2 = 1, value3 = 1;

            int p = 1;
            int[] ugly = new int[n + 1];

            while (p <= n) {
                int min = Math.min(Math.min(value1, value2), value3);
                ugly[p] = min;
                p++;
                if (min == value1) {
                    value1 = 2 * ugly[p1];
                    p1++;
                }
                if (min == value2) {
                    value2 = 3 * ugly[p2];
                    p2++;
                }
                if (min == value3) {
                    value3 = 5 * ugly[p3];
                    p3++;
                }
            }
            return ugly[n];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}