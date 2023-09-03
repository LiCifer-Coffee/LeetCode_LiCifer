<p>给定两个以 <strong>非递减顺序排列</strong> 的整数数组 <code>nums1</code> 和<strong> </strong><code>nums2</code><strong>&nbsp;</strong>,&nbsp;以及一个整数 <code>k</code><strong>&nbsp;</strong>。</p>

<p>定义一对值&nbsp;<code>(u,v)</code>，其中第一个元素来自&nbsp;<code>nums1</code>，第二个元素来自 <code>nums2</code><strong>&nbsp;</strong>。</p>

<p>请找到和最小的 <code>k</code>&nbsp;个数对&nbsp;<code>(u<sub>1</sub>,v<sub>1</sub>)</code>, <code>&nbsp;(u<sub>2</sub>,v<sub>2</sub>)</code> &nbsp;... &nbsp;<code>(u<sub>k</sub>,v<sub>k</sub>)</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums1 = [1,7,11], nums2 = [2,4,6], k = 3
<strong>输出:</strong> [1,2],[1,4],[1,6]
<strong>解释: </strong>返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
</pre>

<p><strong class="example">示例 2:</strong></p>

<pre>
<strong>输入: </strong>nums1 = [1,1,2], nums2 = [1,2,3], k = 2
<strong>输出: </strong>[1,1],[1,1]
<strong>解释: </strong>返回序列中的前 2 对数：
&nbsp;    [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
</pre>

<p><strong class="example">示例 3:</strong></p>

<pre>
<strong>输入: </strong>nums1 = [1,2], nums2 = [3], k = 3 
<strong>输出:</strong> [1,3],[2,3]
<strong>解释: </strong>也可能序列中所有的数对都被返回:[1,3],[2,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>nums1</code> 和 <code>nums2</code> 均为升序排列</li> 
 <li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 堆（优先队列）</details><br>

<div>👍 515, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题其实是前文 [单链表的六大解题套路](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲过的 [23. 合并K个升序链表](/problems/merge-k-sorted-lists) 的变体。

怎么把这道题变成合并多个有序链表呢？就比如说题目输入的用例：

```java
nums1 = [1,7,11], nums2 = [2,4,6]
```

组合出的所有数对儿这就可以抽象成三个有序链表：

```java
[1, 2] -> [1, 4] -> [1, 6]
[7, 2] -> [7, 4] -> [7, 6]
[11, 2] -> [11, 4] -> [11, 6]
```

这三个链表中每个元素（数对之和）是递增的，所以就可以按照 [23. 合并K个升序链表](/problems/merge-k-sorted-lists) 的思路来合并，取出前 `k` 个作为答案即可。

**标签：二叉堆，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq([](const vector<int>& a, const vector<int>& b) {
            // 按照数对的元素和升序排序
            return a[0] + a[1] < b[0] + b[1];
        });
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.size(); i++) {
            pq.push({nums1[i], nums2[0], 0});
        }

        vector<vector<int>> res;
        // 执行合并多个有序链表的逻辑
        while (!pq.empty() && k > 0) {
            auto cur = pq.top();
            pq.pop();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.size()) {
                pq.push({cur[0], nums2[next_index], next_index});
            }

            vector<int> pair = {cur[0], cur[1]};
            res.push_back(pair);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

import heapq

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        # 存储三元组 (num1[i], nums2[i], i)
        # i 记录 nums2 元素的索引位置，用于生成下一个节点
        pq = []
        for i in range(len(nums1)):
            heapq.heappush(pq, [nums1[i], nums2[0], 0])
            
        res = []
        # 执行合并多个有序链表的逻辑
        while pq and k > 0:
            cur = heapq.heappop(pq)
            k -= 1
            # 链表中的下一个节点加入优先级队列
            next_index = cur[2] + 1
            if next_index < len(nums2):
                heapq.heappush(pq, [cur[0], nums2[next_index], next_index])
            
            pair = [cur[0], cur[1]]
            res.append(pair)
        
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) - (b[0] + b[1]);
        });
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        // 执行合并多个有序链表的逻辑
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {
    // 存储三元组 (num1[i], nums2[i], i)
    // i 记录 nums2 元素的索引位置，用于生成下一个节点
    pq := make(PriorityQueue, 0)
    heap.Init(&pq)
    // 按照 23 题的逻辑初始化优先级队列
    for i := 0; i < len(nums1); i++ {
        pq.Push([]int{nums1[i], nums2[0], 0})
    }

    res := make([][]int, 0)
    // 执行合并多个有序链表的逻辑
    for pq.Len() > 0 && k > 0 {
        cur := pq.Pop().([]int)
        k--
        // 链表中的下一个节点加入优先级队列
        next_index := cur[2] + 1
        if next_index < len(nums2) {
            pq.Push([]int{cur[0], nums2[next_index], next_index})
        }

        pair := []int{cur[0], cur[1]}
        res = append(res, pair)
    }
    return res
}

type PriorityQueue [][]int

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
    return pq[i][0]+pq[i][1] < pq[j][0]+pq[j][1]
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    *pq = append(*pq, x.([]int))
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var kSmallestPairs = function(nums1, nums2, k) {
    // 存储三元组 (num1[i], nums2[i], i)
    // i 记录 nums2 元素的索引位置，用于生成下一个节点
    const pq = new PriorityQueue((a, b) => {
        // 按照数对的元素和升序排序
        return (a[0] + a[1]) - (b[0] + b[1]);
    });
    // 按照 23 题的逻辑初始化优先级队列
    for (let i = 0; i < nums1.length; i++) {
        pq.offer([nums1[i], nums2[0], 0]);
    }

    const res = [];
    // 执行合并多个有序链表的逻辑
    while (!pq.isEmpty() && k > 0) {
        const cur = pq.poll();
        k--;
        // 链表中的下一个节点加入优先级队列
        const next_index = cur[2] + 1;
        if (next_index < nums2.length) {
            pq.add([cur[0], nums2[next_index], next_index]);
        }

        const pair = [cur[0], cur[1]];
        res.push(pair);
    }
    return res;
};

// 优先级队列的实现，用于存储三元组
class PriorityQueue {
    constructor(comparator) {
        this.heap = [];
        this.comparator = comparator;
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    size() {
        return this.heap.length;
    }

    peek() {
        return this.heap[0];
    }

    offer(value) {
        this.heap.push(value);
        this.bubbleUp(this.heap.length - 1);
    }

    poll() {
        const result = this.heap[0];
        const end = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = end;
            this.bubbleDown(0);
        }
        return result;
    }

    bubbleUp(index) {
        while (index > 0) {
            const parentIndex = (index - 1) >> 1;
            if (this.comparator(this.heap[index], this.heap[parentIndex]) < 0) {
                const tmp = this.heap[index];
                this.heap[index] = this.heap[parentIndex];
                this.heap[parentIndex] = tmp;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    bubbleDown(index) {
        const lastIndex = this.heap.length - 1;
        while (STATUS_PASSED_TEST) {
            const leftIndex = index * 2 + 1;
            const rightIndex = index * 2 + 2;
            let findIndex = index;
            if (leftIndex <= lastIndex && this.comparator(this.heap[leftIndex], this.heap[findIndex]) < 0) {
                findIndex = leftIndex;
            }
            if (rightIndex <= lastIndex && this.comparator(this.heap[rightIndex], this.heap[findIndex]) < 0) {
                findIndex = rightIndex;
            }
            if (index !== findIndex) {
                const tmp = this.heap[index];
                this.heap[index] = this.heap[findIndex];
                this.heap[findIndex] = tmp;
                index = findIndex;
            } else {
                break;
            }
        }
    }
}
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 061. 和最小的 k 个数对 🟠](/problems/qn8gGX)

</details>
</div>

