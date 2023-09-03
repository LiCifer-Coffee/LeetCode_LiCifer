<p>给你一个&nbsp;<code>n x n</code><em>&nbsp;</em>矩阵&nbsp;<code>matrix</code> ，其中每行和每列元素均按升序排序，找到矩阵中第 <code>k</code> 小的元素。<br /> 请注意，它是 <strong>排序后</strong> 的第 <code>k</code> 小元素，而不是第 <code>k</code> 个 <strong>不同</strong> 的元素。</p>

<p>你必须找到一个内存复杂度优于&nbsp;<code>O(n<sup>2</sup>)</code> 的解决方案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
<strong>输出：</strong>13
<strong>解释：</strong>矩阵中的元素为 [1,5,9,10,11,12,13,<strong>13</strong>,15]，第 8 小元素是 13
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>matrix = [[-5]], k = 1
<strong>输出：</strong>-5
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 300</code></li> 
 <li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li> 
 <li>题目数据 <strong>保证</strong> <code>matrix</code> 中的所有行和列都按 <strong>非递减顺序</strong> 排列</li> 
 <li><code>1 &lt;= k &lt;= n<sup>2</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul> 
 <li>你能否用一个恒定的内存(即 <code>O(1)</code> 内存复杂度)来解决这个问题?</li> 
 <li>你能在 <code>O(n)</code> 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（&nbsp;<a href="http://www.cse.yorku.ca/~andy/pubs/X+Y.pdf" target="_blank">this paper</a>&nbsp;）很有趣。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 矩阵 | 排序 | 堆（优先队列）</details><br>

<div>👍 993, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题其实是前文 [单链表的六大解题套路](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲过的 [23. 合并K个升序链表](/problems/merge-k-sorted-lists) 的变体。

矩阵中的每一行都是排好序的，就好比多条有序链表，你用优先级队列施展合并多条有序链表的逻辑就能找到第 `k` 小的元素了。

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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        // 存储二元组 (matrix[i][j], i, j)
        // i, j 记录当前元素的索引位置，用于生成下一个节点
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        // 初始化优先级队列，把每一行的第一个元素装进去
        for (int i = 0; i < matrix.size(); i++) {
            pq.push({matrix[i][0], i, 0});
        }

        int res = -1;
        // 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while (!pq.empty() && k > 0) {
            auto cur = pq.top();
            pq.pop();
            res = cur[0];
            k--;
            // 链表中的下一个节点加入优先级队列
            int i = cur[1], j = cur[2];
            if (j + 1 < matrix[i].size()) {
                pq.push({matrix[i][j + 1], i, j + 1});
            }
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
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # 存储二元组 (matrix[i][j], i, j)
        # i, j 记录当前元素的索引位置，用于生成下一个节点
        pq = []
        
        # 初始化优先级队列，把每一行的第一个元素装进去
        for i in range(len(matrix)):
            heapq.heappush(pq, [matrix[i][0], i, 0])

        res = -1
        # 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while len(pq) > 0 and k > 0:
            cur = heapq.heappop(pq)
            res = cur[0]
            k -= 1
            # 链表中的下一个节点加入优先级队列
            i, j = cur[1], cur[2]
            if j + 1 < len(matrix[i]):
                heapq.heappush(pq, [matrix[i][j + 1], i, j + 1])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 存储二元组 (matrix[i][j], i, j)
        // i, j 记录当前元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照元素大小升序排序
            return a[0] - b[0];
        });


        // 初始化优先级队列，把每一行的第一个元素装进去
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        // 执行合并多个有序链表的逻辑，找到第 k 小的元素
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            res = cur[0];
            k--;
            // 链表中的下一个节点加入优先级队列
            int i = cur[1], j = cur[2];
            if (j + 1 < matrix[i].length) {
                pq.add(new int[]{matrix[i][j + 1], i, j + 1});
            }
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

import (
    "container/heap"
)

func kthSmallest(matrix [][]int, k int) int {
    // 自定义一个最小堆类型
    pq := IntHeap{}
    // 初始化堆，把每一行的第一个元素装进去
    for i := 0; i < len(matrix); i++ {
        pq = append(pq, Item{value: matrix[i][0], row: i, col: 0})
    }
    heap.Init(&pq)

    var res int
    // 执行合并多个有序链表的逻辑，找到第 k 小的元素
    for k > 0 && pq.Len() > 0 {
        cur := heap.Pop(&pq).(Item)
        res = cur.value
        k--
        // 链表中的下一个节点加入堆
        row, col := cur.row, cur.col+1
        if col < len(matrix[row]) {
            heap.Push(&pq, Item{value: matrix[row][col], row: row, col: col})
        }
    }

    return res
}

// 定义一个 Item 类型，表示堆中的元素
type Item struct {
    value int // 当前元素的值
    row   int // 当前元素所在的行
    col   int // 当前元素所在的列
}

// 定义一个最小堆类型 IntHeap
// 实现 heap.Interface 接口的方法
type IntHeap []Item

func (t IntHeap) Len() int {
    return len(t)
}

func (t IntHeap) Less(i, j int) bool {
    return t[i].value < t[j].value
}

func (t IntHeap) Swap(i, j int) {
    t[i], t[j] = t[j], t[i]
}

func (t *IntHeap) Push(x interface{}) {
    *t = append(*t, x.(Item))
}

func (t *IntHeap) Pop() interface{} {
    n := len(*t)
    x := (*t)[n-1]
    *t = (*t)[:n-1]
    return x
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var kthSmallest = function(matrix, k) {
    // 存储二元组 (matrix[i][j], i, j)
    // i, j 记录当前元素的索引位置，用于生成下一个节点
    const pq = new PriorityQueue((a, b) => {
        // 按照元素大小升序排序
        return a[0] - b[0];
    });


    // 初始化优先级队列，把每一行的第一个元素装进去
    for (let i = 0; i < matrix.length; i++) {
        pq.offer([matrix[i][0], i, 0]);
    }

    let res = -1;
    // 执行合并多个有序链表的逻辑，找到第 k 小的元素
    while (!pq.isEmpty() && k > 0) {
        const cur = pq.poll();
        res = cur[0];
        k--;
        // 链表中的下一个节点加入优先级队列
        const i = cur[1], j = cur[2];
        if (j + 1 < matrix[i].length) {
            pq.offer([matrix[i][j + 1], i, j + 1]);
        }
    }
    return res;
};

class PriorityQueue {
    constructor(comparator) {
        this.heap = [];
        this.comparator = comparator;
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    offer(val) {
        this.heap.push(val);
        this.bubbleUp(this.heap.length - 1);
    }

    poll() {
        if (this.isEmpty()) {
            return null;
        }
        const val = this.heap[0];
        const lastVal = this.heap.pop();
        if (this.heap.length > 0) {
            this.heap[0] = lastVal;
            this.sinkDown(0);
        }
        return val;
    }

    bubbleUp(pos) {
        while (pos > 0) {
            const parentPos = (pos - 1) >>> 1;
            if (this.comparator(this.heap[pos], this.heap[parentPos]) < 0) {
                [this.heap[pos], this.heap[parentPos]] = [this.heap[parentPos], this.heap[pos]];
                pos = parentPos;
            } else {
                break;
            }
        }
    }

    sinkDown(pos) {
        const lastPos = this.heap.length - 1;
        while (STATUS_PASSED_TEST) {
            const leftChildPos = pos * 2 + 1;
            const rightChildPos = pos * 2 + 2;
            let minPos = pos;
            if (leftChildPos <= lastPos && this.comparator(this.heap[leftChildPos], this.heap[minPos]) < 0) {
                minPos = leftChildPos;
            }
            if (rightChildPos <= lastPos && this.comparator(this.heap[rightChildPos], this.heap[minPos]) < 0) {
                minPos = rightChildPos;
            }
            if (minPos !== pos) {
                [this.heap[pos], this.heap[minPos]] = [this.heap[minPos], this.heap[pos]];
                pos = minPos;
            } else {
                break;
            }
        }
    }
};
```

</div></div>
</div></div>

</details>
</div>

