/**
 * <p>给你一个链表数组，每个链表都已经按升序排列。</p>
 *
 * <p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
 * <strong>输出：</strong>[1,1,2,3,4,4,5,6]
 * <strong>解释：</strong>链表数组如下：
 * [
 * 1-&gt;4-&gt;5,
 * 1-&gt;3-&gt;4,
 * 2-&gt;6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = [[]]
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>k == lists.length</code></li>
 * <li><code>0 &lt;= k &lt;= 10^4</code></li>
 * <li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
 * <li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
 * <li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li>
 * <li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>链表 | 分治 | 堆（优先队列） | 归并排序</details><br>
 *
 * <div>👍 2614, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解题思路:
 * 1.利用优先队列存入所有链表节点，优先队列的好处就是会自动排序，保证取出的元素是最小一个
 * 2.遍历优先队列，往新链表里面存值即可，新链表默认就是从小到大排列
 * 3.重点：优先队列的使用
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode n4 = new ListNode(-1, null);
        ListNode n3 = new ListNode(-1, n4);
        ListNode n2 = new ListNode(-1, n3);
        ListNode n1 = new ListNode(-2,n2);
        ListNode[] list = new ListNode[]{n1, new ListNode(0)};
        solution.mergeKLists(list);

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length == 0) {
                return null;
            }

            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    queue.add(node);
                }
            }

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;
                p = p.next;
                if (node.next != null) {
                    queue.add(node.next);
                }
            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static class ListNode {
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