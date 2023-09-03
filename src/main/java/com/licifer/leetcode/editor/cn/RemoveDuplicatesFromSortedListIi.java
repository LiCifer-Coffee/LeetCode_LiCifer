/**
 * <p>给定一个已排序的链表的头&nbsp;<code>head</code> ，&nbsp;<em>删除原始链表中所有重复数字的节点，只留下不同的数字</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="height: 142px; width: 500px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,2,3,3,4,4,5]
 * <strong>输出：</strong>[1,2,5]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="height: 164px; width: 400px;" />
 * <pre>
 * <strong>输入：</strong>head = [1,1,1,2,3]
 * <strong>输出：</strong>[2,3]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * <li>题目数据保证链表已经按升序 <strong>排列</strong></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>
 *
 * <div>👍 1174, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 解题思路: 利用双指针遍历，有两个需要注意的地方：
 * 1.好比 2->3->3->4这段，q=2的时候，判断2!=3，这个时候把2加进去了，然后下一个节点3=3，q这个时候走了两步，
 *   一下子走到了4这个节点，即遇到了重复数字，需要走两步，这里不好想到
 * 2.  1->2->2->null ，如果此时q=null，这个时候要把p的尾部掐断，不然q会保留2->2这段，这点也不好考虑到，主要注意
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {

            ListNode dummy = new ListNode(-1);
            ListNode p = dummy, q = head;

            while (q != null) {
                if (q.next != null && q.val == q.next.val) {
                    while (q.next != null && q.val == q.next.val) {
                        q = q.next;
                    }
                    q = q.next;

                    // 这里是重点
                    if (q == null) {
                        p.next = null;
                    }
                } else {
                    p.next = q;
                    p = p.next;
                    q = q.next;
                }
            }
            return dummy.next;

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