<p>给你一个整数数组&nbsp;<code>nums</code> ，请计算数组的 <strong>中心下标 </strong>。</p>

<p>数组<strong> 中心下标</strong><strong> </strong>是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。</p>

<p>如果中心下标位于数组最左端，那么左侧数之和视为 <code>0</code> ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。</p>

<p>如果数组有多个中心下标，应该返回 <strong>最靠近左边</strong> 的那一个。如果数组不存在中心下标，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1, 7, 3, 6, 5, 6]
<strong>输出：</strong>3
<strong>解释：</strong>
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1, 2, 3]
<strong>输出：</strong>-1
<strong>解释：</strong>
数组中不存在满足此条件的中心下标。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [2, 1, -1]
<strong>输出：</strong>0
<strong>解释：</strong>
中心下标是 0 。
左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 1991 题相同：<a href="https://leetcode-cn.com/problems/find-the-middle-index-in-array/" target="_blank">https://leetcode-cn.com/problems/find-the-middle-index-in-array/</a></p>

<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>

<div>👍 579, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题考察前文讲的 [前缀和技巧](https://appktavsiei5995.pc.xiaoe-tech.com/detail/i_62656034e4b0cedf38a93af3/1)，有了前缀和数组 `preSum`，就可以根据 `preSum` 快速计算 `nums` 中任意位置的左侧元素和右侧元素之和了。

**标签：前缀和，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int pivotIndex(vector<int>& nums) {
        int n = nums.size();
        vector<int> preSum(n + 1, 0);
        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // 根据前缀和判断左半边数组和右半边数组的元素和是否相同
        for (int i = 1; i < preSum.size(); i++) {
            // 计算 nums[i-1] 左侧和右侧的元素和
            int leftSum = preSum[i - 1] - preSum[0];
            int rightSum = preSum[n] - preSum[i];
            if (leftSum == rightSum) {
                // 相对 nums 数组，preSum 数组有一位索引偏移
                return i - 1;
            }
        }
        return -1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        n = len(nums)
        preSum = [0] * (n + 1)
        preSum[0] = 0
        # 计算 nums 的前缀和
        for i in range(1, n + 1):
            preSum[i] = preSum[i - 1] + nums[i - 1]
        # 根据前缀和判断左半边数组和右半边数组的元素和是否相同
        for i in range(1, len(preSum)):
            # 计算 nums[i-1] 左侧和右侧的元素和
            leftSum = preSum[i - 1] - preSum[0]
            rightSum = preSum[n] - preSum[i]
            if leftSum == rightSum:
                # 相对 nums 数组，preSum 数组有一位索引偏移
                return i - 1
        return -1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // 根据前缀和判断左半边数组和右半边数组的元素和是否相同
        for (int i = 1; i < preSum.length; i++) {
            // 计算 nums[i-1] 左侧和右侧的元素和
            int leftSum = preSum[i - 1] - preSum[0];
            int rightSum = preSum[n] - preSum[i];
            if (leftSum == rightSum) {
                // 相对 nums 数组，preSum 数组有一位索引偏移
                return i - 1;
            }
        }
        return -1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func pivotIndex(nums []int) int {
    n := len(nums)
    preSum := make([]int, n+1)
    preSum[0] = 0
    // 计算 nums 的前缀和
    for i := 1; i <= n; i++ {
        preSum[i] = preSum[i-1] + nums[i-1]
    }
    // 根据前缀和判断左半边数组和右半边数组的元素和是否相同
    for i := 1; i < len(preSum); i++ {
        // 计算 nums[i-1] 左侧和右侧的元素和
        leftSum := preSum[i-1] - preSum[0]
        rightSum := preSum[n] - preSum[i]
        if leftSum == rightSum {
            // 相对 nums 数组，preSum 数组有一位索引偏移
            return i - 1
        }
    }
    return -1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var pivotIndex = function(nums) {
    const n = nums.length;
    const preSum = new Array(n + 1).fill(0);
    preSum[0] = 0;
    // 计算 nums 的前缀和
    for (let i = 1; i <= n; i++) {
        preSum[i] = preSum[i - 1] + nums[i - 1];
    }
    // 根据前缀和判断左半边数组和右半边数组的元素和是否相同
    for (let i = 1; i < preSum.length; i++) {
        // 计算 nums[i-1] 左侧和右侧的元素和
        const leftSum = preSum[i - 1] - preSum[0];
        const rightSum = preSum[n] - preSum[i];
        if (leftSum === rightSum) {
            // 相对 nums 数组，preSum 数组有一位索引偏移
            return i - 1;
        }
    }
    return -1;
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 012. 左右两边子数组的和相等 🟢](/problems/tvdfij)

</details>
</div>

