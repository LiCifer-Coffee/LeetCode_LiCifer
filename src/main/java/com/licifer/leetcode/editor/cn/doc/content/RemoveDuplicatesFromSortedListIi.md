<p>给定一个已排序的链表的头&nbsp;<code>head</code> ，&nbsp;<em>删除原始链表中所有重复数字的节点，只留下不同的数字</em>&nbsp;。返回 <em>已排序的链表</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg" style="height: 142px; width: 500px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,3,4,4,5]
<strong>输出：</strong>[1,2,5]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg" style="height: 164px; width: 400px;" /> 
<pre>
<strong>输入：</strong>head = [1,1,1,2,3]
<strong>输出：</strong>[2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围 <code>[0, 300]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
 <li>题目数据保证链表已经按升序 <strong>排列</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 1174, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题是前文 [链表的双指针技巧汇总](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_629e11bae4b0812e17a33045/1) 中讲的 [83. 删除排序链表中的重复元素](/problems/remove-duplicates-from-sorted-list) 的进阶版。如果只让你把多于的重复元素去掉，那么快慢指针可以搞定，但这道题要求你把存在重复的元素全都去掉，一个简单粗暴的解法就是借助像哈希表这样的数据结构记录哪些节点重复了，然后去掉它们。

不过这道题输入的链表是有序的，这意味着重复元素都靠在一起，其实不用额外的空间复杂度来辅助，用两个指针就可以达到去重的目的，只是细节有点多，直接结合代码的详细注释来看吧。

值得一提的是，这道题也可以用递归思维来做，虽然存在堆栈消耗空间复杂度，不过理解起来更容易，我也写出来供大家参考。

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// Definition for singly-linked list.
// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* dummy = new ListNode(-1);
        ListNode* p = dummy, *q = head;
        while (q != nullptr) {
            if (q->next != nullptr && q->val == q->next->val){
                // 发现重复节点，跳过这些重复节点
                while (q->next != nullptr && q->val == q->next->val) {
                    q = q->next;
                }
                q = q->next;
                // 此时 q 跳过了这一段重复元素
                if (q == nullptr) {
                    p->next = nullptr;
                }
                // 不过下一段元素也可能重复，等下一轮 while 循环判断
            } else {
                // 不是重复节点，接到 dummy 后面
                p->next = q;
                p = p->next;
                q = q->next;
            }
        }
        return dummy->next;
    }
};

// 递归解法
// Definition for singly-linked list.
// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };
class Solution2 {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        if (head->val != head->next->val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head->next = deleteDuplicates(head->next);
            return head;
        }
        while (head->next != nullptr && head->val == head->next->val) {
            head = head->next;
        }
        return deleteDuplicates(head->next);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(-1)
        p = dummy
        q = head
        while q:
            if q.next and q.val == q.next.val:
                while q.next and q.val == q.next.val:
                    q = q.next
                q = q.next
                if not q:
                    p.next = None
            else:
                p.next = q
                p = p.next
                q = q.next
        return dummy.next

# 递归解法
class Solution2:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        if head.val != head.next.val:
            head.next = self.deleteDuplicates(head.next)
            return head
        while head.next and head.val == head.next.val:
            head = head.next
        return self.deleteDuplicates(head.next)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {
            if (q.next != null && q.val == q.next.val){
                // 发现重复节点，跳过这些重复节点
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                // 此时 q 跳过了这一段重复元素
                if (q == null) {
                    p.next = null;
                }
                // 不过下一段元素也可能重复，等下一轮 while 循环判断
            } else {
                // 不是重复节点，接到 dummy 后面
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}

// 递归解法
class Solution2 {
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates(head.next);
            return head;
        }
        // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
        // 越过重复节点，找到 head 之后那个不重复的节点
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
        return deleteDuplicates(head.next);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func deleteDuplicates(head *ListNode) *ListNode {
    dummy := &ListNode{-1, nil}
    p, q := dummy, head
    for q != nil {
        if q.Next != nil && q.Val == q.Next.Val {
            // 发现重复节点，跳过这些重复节点
            for q.Next != nil && q.Val == q.Next.Val {
                q = q.Next
            }
            q = q.Next
            // 此时 q 跳过了这一段重复元素
            if q == nil {
                p.Next = nil
            }
            // 不过下一段元素也可能重复，等下一轮 for 循环判断
        } else {
            // 不是重复节点，接到 dummy 后面
            p.Next = q
            p = p.Next
            q = q.Next
        }
    }
    return dummy.Next
}

// 递归解法
func deleteDuplicates2(head *ListNode) *ListNode {
    // base case
    if head == nil || head.Next == nil {
        return head
    }
    if head.Val != head.Next.Val {
        // 如果头结点和身后节点的值不同，则对之后的链表去重即可
        head.Next = deleteDuplicates(head.Next)
        return head
    }
    // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
    // 越过重复节点，找到 head 之后那个不重复的节点
    for head.Next != nil && head.Val == head.Next.Val {
        head = head.Next
    }
    // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
    return deleteDuplicates(head.Next)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var deleteDuplicates = function(head) {
  // 创建 dummy 节点，作为 head 的前置节点
  let dummy = new ListNode(-1);
  // 由于要对链表进行增删操作，所以需要一个指针 p 来遍历链表
  let p = dummy;
  // q 指向原链表的 head 节点
  let q = head;
  // 循环遍历整个链表
  while (q !== null) {
    if (q.next !== null && q.val === q.next.val) {
      // 发现重复节点，跳过这些重复节点
      while (q.next !== null && q.val === q.next.val) {
        q = q.next;
      }
      q = q.next;
      // 此时 q 跳过了这一段重复元素
      if (q === null) {
        p.next = null;
      }
      // 不过下一段元素也可能重复，等下一轮 while 循环判断
    } else {
      // 不是重复节点，接到 dummy 后面
      p.next = q;
      p = p.next;
      q = q.next;
    }
  }
  return dummy.next;
};

var deleteDuplicates = function(head) {
  // base case
  if (head === null || head.next === null) {
    return head;
  }
  if (head.val !== head.next.val) {
    // 如果头结点和身后节点的值不同，则对之后的链表去重即可
    head.next = deleteDuplicates(head.next);
    return head;
  }
  // 如果如果头结点和身后节点的值相同，则说明从 head 开始存在若干重复节点
  // 越过重复节点，找到 head 之后那个不重复的节点
  while (head.next !== null && head.val === head.next.val) {
    head = head.next;
  }
  // 直接返回那个不重复节点开头的链表的去重结果，就把重复节点删掉了
  return deleteDuplicates(head.next);
};
```

</div></div>
</div></div>

</details>
</div>

