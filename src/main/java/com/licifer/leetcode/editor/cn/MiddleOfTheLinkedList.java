/**
 * <p>给你单链表的头结点 <code>head</code> ，请你找出并返回链表的中间结点。</p>
 *
 * <p>如果有两个中间结点，则返回第二个中间结点。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5]
 * <strong>输出：</strong>[3,4,5]
 * <strong>解释：</strong>链表只有一个中间结点，值为 3 。
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,4,5,6]
 * <strong>输出：</strong>[4,5,6]
 * <strong>解释：</strong>该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表的结点数范围是 <code>[1, 100]</code></li>
 * <li><code>1 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>
 *
 * <div>👍 932, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package com.licifer.leetcode.editor.cn;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode middleNode(ListNode head) {

            ListNode fast = head, slow = head;
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            return slow;
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