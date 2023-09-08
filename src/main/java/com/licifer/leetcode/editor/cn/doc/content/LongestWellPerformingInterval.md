<p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>

<p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>

<p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>

<p>请你返回「表现良好时间段」的最大长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>hours = [9,9,6,0,6,6,9]
<strong>输出：</strong>3
<strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>hours = [6,6,6]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= hours.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= hours[i] &lt;= 16</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 前缀和 | 单调栈</details><br>

<div>👍 495, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

题目说 `hours[i]` 以 8 作为分界线，**那么我们就要条件反射地想到对数据进行「归一化」处理**，比如把所有大于 8 的元素视为 +1，把所有小于 8 的元素视为 -1，这样一来，这道题就改造成了：计算数组中元素和大于 0 的子数组的最大长度。

然后回想之前子数组相关的题目，第 [525. 连续数组](/problems/contiguous-array) 是问和为 0 的子数组，[974. 和可被 K 整除的子数组](/problems/subarray-sums-divisible-by-k) 是问和能被 `k` 整除的子数组，这道题和它们很类似，都是考察前缀和 + 哈希表的组合场景。

我们借助哈希表存储前缀和到索引的映射，这样就能快速寻找一个 `j` 使得 `preSum[i] - preSum[j] > 0` 了，具体看代码注释吧。值得一提的是，我给的解法中 `preSum` 数组可以进一步简化成变量，这个优化可以留给你来做。

**标签：前缀和，哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int longestWPI(vector<int>& hours) {
        int n = hours.size();
        vector<int> preSum(n + 1, 0);
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        unordered_map<int, int> valToIndex;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 计算 hours[0..i-1] 的前缀和
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.count(preSum[i])) {
                valToIndex[preSum[i]] = i;
            } else {
                // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
                // 所以这里什么都不做
            }

            // 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
            // 这就要根据 preSum[i] 的正负分情况讨论了
            if (preSum[i] > 0) {
                // preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
                res = max(res, i);
            } else {
                // preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
                // 且 j 应该尽可能小，即寻找 preSum[j] == preSum[i] - 1
                if (valToIndex.count(preSum[i] - 1)) {
                    int j = valToIndex[preSum[i] - 1];
                    res = max(res, i - j);
                }
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

class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        n = len(hours)
        preSum = [0] * (n + 1)
        # 前缀和到索引的映射，方便快速查找所需的前缀和
        valToIndex = {}
        res = 0
        for i in range(1, n + 1):
            # 计算 hours[0..i-1] 的前缀和
            preSum[i] = preSum[i - 1] + (1 if hours[i - 1] > 8 else -1)
            # 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if preSum[i] not in valToIndex:
                valToIndex[preSum[i]] = i
            else:
                # 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
                # 所以这里什么都不做
                pass

            # 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
            # 这就要根据 preSum[i] 的正负分情况讨论了
            if preSum[i] > 0:
                # preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
                res = max(res, i)
            else:
                # preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
                # 且 j 应该尽可能小，即寻找 preSum[j] == preSum[i] - 1
                if preSum[i] - 1 in valToIndex:
                    j = valToIndex[preSum[i] - 1]
                    res = max(res, i - j)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 计算 nums[0..i-1] 的前缀和
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.containsKey(preSum[i])) {
                valToIndex.put(preSum[i], i);
            } else {
                // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
                // 所以这里什么都不做
            }

            // 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
            // 这就要根据 preSum[i] 的正负分情况讨论了
            if (preSum[i] > 0) {
                // preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
                res = Math.max(res, i);
            } else {
                // preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
                // 考虑到我们的 preSum 数组每两个相邻元素的差的绝对值都是 1 且 j 应该尽可能小，
                // 那么只要找到 preSum[j] == preSum[i] - 1，nums[j+1..i] 就是一个「表现良好的时间段」
                if (valToIndex.containsKey(preSum[i] - 1)) {
                    int j = valToIndex.get(preSum[i] - 1);
                    res = Math.max(res, i - j);
                }
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

func longestWPI(hours []int) int {
    n := len(hours)
    preSum := make([]int, n + 1)
    preSum[0] = 0
    // 前缀和到索引的映射，方便快速查找所需的前缀和
    valToIndex := make(map[int]int)
    res := 0
    for i := 1; i <= n; i++ {
        // 计算 nums[0..i-1] 的前缀和
        preSum[i] = preSum[i - 1] + func() int {
            if hours[i - 1] > 8 {
                return 1
            }
            return -1
        }()
        // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
        if _, ok := valToIndex[preSum[i]]; !ok {
            valToIndex[preSum[i]] = i
        } else {
            // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
            // 所以这里什么都不做
        }

        // 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
        // 这就要根据 preSum[i] 的正负分情况讨论了
        if preSum[i] > 0 {
            // preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
            res = max(res, i)
        } else {
            // preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
            // 且 j 应该尽可能小，即寻找 preSum[j] == preSum[i] - 1
            if j, ok := valToIndex[preSum[i] - 1]; ok {
                res = max(res, i - j)
            }
        }
    }
    return res
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var longestWPI = function(hours) {
    let n = hours.length;
    let preSum = new Array(n + 1).fill(0);
    preSum[0] = 0;
    // 前缀和到索引的映射，方便快速查找所需的前缀和
    let valToIndex = new Map();
    let res = 0;
    for (let i = 1; i <= n; i++) {
        // 计算 nums[0..i-1] 的前缀和
        preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
        if (!valToIndex.has(preSum[i])) {
            valToIndex.set(preSum[i], i);
        } else {
            // 因为题目想找长度最大的子数组，valToIndex 中的索引应尽可能小，
            // 所以这里什么都不做
        }

        // 现在我们想找 hours[0..i-1] 中元素和大于 0 的子数组
        // 这就要根据 preSum[i] 的正负分情况讨论了
        if (preSum[i] > 0) {
            // preSum[i] 为正，说明 hours[0..i-1] 都是「表现良好的时间段」
            res = Math.max(res, i);
        } else {
            // preSum[i] 为负，需要寻找一个 j 使得 preSum[i] - preSum[j] > 0
            // 且 j 应该尽可能小，即寻找 preSum[j] == preSum[i] - 1
            if (valToIndex.has(preSum[i] - 1)) {
                let j = valToIndex.get(preSum[i] - 1);
                res = Math.max(res, i - j);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

</details>
</div>

