/**
 * <p>给你两个单链表的头节点&nbsp;<code>headA</code> 和 <code>headB</code> ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 <code>null</code> 。</p>
 *
 * <p>图示两个链表在节点 <code>c1</code> 开始相交<strong>：</strong></p>
 *
 * <p>ref="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" target="_blank"><img alt="" src="https://assets.leetcode-cn
 * .com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" style="height:130px; width:400px" /></a>
 * </p>
 *
 * <p>题目数据 <strong>保证</strong> 整个链式结构中不存在环。</p>
 *
 * <p><strong>注意</strong>，函数返回结果后，链表必须 <strong>保持其原始结构</strong> 。</p>
 *
 * <p><strong>自定义评测：</strong></p>
 *
 * <p><strong>评测系统</strong> 的输入如下（你设计的程序 <strong>不适用</strong> 此输入）：</p>
 *
 * <ul>
 * <li><code>intersectVal</code> - 相交的起始节点的值。如果不存在相交节点，这一值为 <code>0</code></li>
 * <li><code>listA</code> - 第一个链表</li>
 * <li><code>listB</code> - 第二个链表</li>
 * <li><code>skipA</code> - 在 <code>listA</code> 中（从头节点开始）跳到交叉节点的节点数</li>
 * <li><code>skipB</code> - 在 <code>listB</code> 中（从头节点开始）跳到交叉节点的节点数</li>
 * </ul>
 *
 * <p>评测系统将根据这些输入创建链式数据结构，并将两个头节点 <code>headA</code> 和 <code>headB</code> 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 <strong>视作正确答案</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p>ref="https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png" target="_blank"><img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png"
 * style="height:130px; width:400px" /></a>
 * </p>
 *
 * <pre>
 * <strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * <strong>输出：</strong>Intersected at '8'
 * <strong>解释：</strong>相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中<font size="1">第三个</font>节点，B 中第四个节点) 在内存中指向相同的位置。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <p>ref="https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png" target="_blank"><img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png"
 * style="height:136px; width:350px" /></a>
 * </p>
 *
 * <pre>
 * <strong>输入：</strong>intersectVal&nbsp;= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * <strong>输出：</strong>Intersected at '2'
 * <strong>解释：</strong>相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * </pre>
 *
 * <p><strong>示例&nbsp;3：</strong></p>
 *
 * <p>ref="https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png" target="_blank"><img alt="" src="https://assets.leetcode-cn
 * .com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png" style="height:126px; width:200px" /></a>
 * </p>
 *
 * <pre>
 * <strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * <strong>输出：</strong>null
 * <strong>解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>listA</code> 中节点数目为 <code>m</code></li>
 * <li><code>listB</code> 中节点数目为 <code>n</code></li>
 * <li><code>1 &lt;= m, n &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * <li><code>0 &lt;= skipA &lt;= m</code></li>
 * <li><code>0 &lt;= skipB &lt;= n</code></li>
 * <li>如果 <code>listA</code> 和 <code>listB</code> 没有交点，<code>intersectVal</code> 为 <code>0</code></li>
 * <li>如果 <code>listA</code> 和 <code>listB</code> 有交点，<code>intersectVal == listA[skipA] == listB[skipB]</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你能否设计一个时间复杂度 <code>O(m + n)</code> 、仅用 <code>O(1)</code> 内存的解决方案？</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>
 *
 * <div>👍 2211, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;


/**
 * 解题思路:
 * 1.题目重点，如果两个链表相交，则说明相交后的所有节点都相同
 * 2.分别遍历出两个链表的长度
 * 3.让相对长的链表开始向后走，直到两个链表的长度相同
 * 4.两个相同的链表同步开始走，如果相等则说明有相交
 * 思考：第一种解法比较巧妙，跳出while的条件是有两个，1.相交跳出 2.不相交的话，p1 = p2 = null
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            // 解法一：
            // p1 指向 A 链表头结点，p2 指向 B 链表头结点
            //ListNode p1 = headA, p2 = headB;
            //while (p1 != p2) {
            //    // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            //    if (p1 == null) p1 = headB;
            //    else            p1 = p1.next;
            //    // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            //    if (p2 == null) p2 = headA;
            //    else            p2 = p2.next;
            //}
            //return p1;

            // 解法二：
            int lenA = 0, lenB = 0;
            ListNode p1 = headA;
            ListNode p2 = headB;
            while (headA != null) {
                lenA++;
                headA = headA.next;
            }
            while (headB != null) {
                lenB++;
                headB = headB.next;
            }
            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; i++) {
                    p1 = p1.next;
                }
            } else {
                for (int i = 0; i < lenB - lenA; i++) {
                    p2 = p2.next;
                }
            }

            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;

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