<p>给你一个按 <strong>非递减顺序</strong> 排序的整数数组 <code>nums</code>，返回 <strong>每个数字的平方</strong> 组成的新数组，要求也按 <strong>非递减顺序</strong> 排序。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-4,-1,0,3,10]
<strong>输出：</strong>[0,1,9,16,100]
<strong>解释：</strong>平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [-7,-3,2,3,11]
<strong>输出：</strong>[4,9,9,49,121]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code><span>1 &lt;= nums.length &lt;= </span>10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按 <strong>非递减顺序</strong> 排序</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul> 
 <li>请你<span style="color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;">设计时间复杂度为 <code>O(n)</code> 的算法解决本问题</span></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 878, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

平方的特点是会把负数变成正数，所以一个负数和一个正数平方后的大小要根据绝对值来比较。

可以把元素 0 作为分界线，0 左侧的负数是一个有序数组 `nums1`，0 右侧的正数是另一个有序数组 `nums2`，那么这道题就和 [88. 合并两个有序数组](/problems/merge-sorted-array) 差不多，在进一步就是前文 [链表的双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 讲过的 [21. 合并两个有序链表](/problems/merge-two-sorted-lists) 的变体。

所以，我们可以去寻找正负数的分界点，然后向左右扩展，执行合并有序数组的逻辑。不过还有个更好的办法，不用找正负分界点，而是直接将双指针分别初始化在 `nums` 的开头和结尾，相当于合并两个从大到小排序的数组，和 88 题类似。有了思路，直接看代码吧。

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        vector<int> res(n);
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (abs(nums[i]) > abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
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
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 两个指针分别初始化在正负子数组绝对值最大的元素索引
        i, j = 0, n - 1
        # 得到的有序结果是降序的
        p = n - 1
        res = [0] * n
        # 执行双指针合并有序数组的逻辑
        while i <= j:
            if abs(nums[i]) > abs(nums[j]):
                res[p] = nums[i] * nums[i]
                i += 1
            else:
                res[p] = nums[j] * nums[j]
                j -= 1
            p -= 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        int[] res = new int[n];
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
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

func sortedSquares(nums []int) []int {
    n := len(nums)
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    i, j := 0, n-1
    // 得到的有序结果是降序的
    p := n - 1
    res := make([]int, n)
    // 执行双指针合并有序数组的逻辑
    for i <= j {
        if math.Abs(float64(nums[i])) > math.Abs(float64(nums[j])) {
            res[p] = nums[i] * nums[i]
            i++
        } else {
            res[p] = nums[j] * nums[j]
            j--
        }
        p--
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let n = nums.length;
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    let i = 0, j = n - 1;
    // 得到的有序结果是降序的
    let p = n - 1;
    let res = new Array(n);
    // 执行双指针合并有序数组的逻辑
    while (i <= j) {
        if (Math.abs(nums[i]) > Math.abs(nums[j])) {
            res[p] = nums[i] * nums[i];
            i++;
        } else {
            res[p] = nums[j] * nums[j];
            j--;
        }
        p--;
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_squares-of-a-sorted-array" data="G7AxEZWj8QBodcAbKs3dRST7m5mYuaj+1oMKryzBDLMQGZfL13/vLkF0P1GD4qXAiSaDx9xPZd99RehwxrcZuWbAqhfh3EydCUkq3Wc7RrgdQmMcsPVWMDgv5LpT9J/2+9/TngxivrESz0E0afeDWIU9e7+FipyZuYKYNNFIJURCJRVCI0b4Dp7iN5GZcsQskXRikCdGeYSh31Xx20m8FV9778wxseVr79t5h4FLFXY2Onglm+oz8FtsmdmVP+B3YYJ0X/8li/RDEVs2C5dqmq7WnrPfbGtqODqtmSM2PKU0Ry3+dgqH13ob3dgXu/yuRPWhC/ODz/TNFlYDvq9bYV01GVb+rgHfmH30UDXvQzQ95OT55nBciMPRfYiEjEKsq8w+P3Jo1SozMCLFeB7b1i+LcZZJbJ8VGZRXyJ+IY84waUO3uruhyMiV0zkbX0XAjkDDWSrnOl8sX7KbBgYOj6yzzbA4oOPQsxR/d75UoVmMd/6MGYLoRNzZ2uglkE6g/HzTHh+Xl7x4YH5MbBWhaihosvmC24OAO4llWCDY56/2dLfNo53YXTn7NCw/rNpF8H9ufNXnOsb2i06Pn3o5lgXKRDmm8R6UZnn+Qzy8r8E7k4QWnsgm5YexojPpuYj3oumGKFLndQUz7osTfLJPzJMsNxzqcpSafetT+Y+y/7OYdAnkXRRTgcCFo9FhUNquAycB3uzAI/blTHFSkBRh74TTAz9OEO9WEvV4cOb+48OcP/r6+OaJochpvGOdGh4/4EBRX6TFPpO9Y32h4/a08ld0u/Avj5Is6v+ezTmzyfkBCfRlBOUb/GbNeReNGbfthCgD0y7ORZuYz3KbeE5ss8wFA5o14vGaeByWF3Ze8kWg+TZwE+N/DzZfMzZ//GJY1P8RG5f1p0rnYvuozuX2X+72X4Sb7x4qv6L676H5NgBi7NIwzPuTRT5MjHk1n635Ith8G7CJ6r8H8zVD8fXHj6i6MMKsP1V0CUTRJfHlovki1HRRZJ/x5c3q/zTOLobPoJy+nC8NFwTtlFFXnfeTMre5yPOTv+FTM0XVu5LUQCHbc/4+4b9j8pKp4OWbqTDxp6CsPwV/ZzSVvEYtJ9DlRKRl1U8hKeIlBO1uINk2xYK3AA6enfHXCIrgCPF7ox+NLDB1DN5bk1C0MAjZppw67H68CbmvE5PeJrDfFGOw5dLhel6KUZrCkFQDFmWajc0EQdUGPWzebx1YG8pNh6fQXq3skFSPNKrPq0YqVRok5fJIx6Q2WniSVKkpkaQWgSiR1EI4DZIKgNGYlGmQ26RWcejp4E9ij+QUK1dLSqZNGvUAFGBQNbKloUgy1pILAllOGcEqFt+oG0NFoQxnnBcOi+N809E8stKfZNfykN/f37EKWCfR/wFIiVDkspe4HWnDdfOq4ISZ1jYBKjpJaKlaS1tJRUUYyHDspa1bCSN5Q0kQjSq0lOU4VKukdt9Jrsox0jjYihpUC2jQFoF9D2rNVpWBsvEBinZcAa3ZaKHcrS3VNqrACq5VCT1tUgpF73KHiaayUCk37kNLEwNxsxUywdDSlUBRp5dnJZoWaxzX6eWxp96IVGwFUZ6OLFLMQ1XR025Zc55UyB9W5mrNvza0kJXYfP6qHUS6yfPDuaGlHZhh7T1Y0cZkD7gmsQJa6ChSs/Myz42WOjjJL/rvtExnDgq6JvyY51jmIktRb6E0087tsXEzNHh5Eci6VkudEA6ssG2rMyRzdzBqlceoQQA0Smqszcber35KACJfjBF/NyuM0zcQh1mNzZr1SHFe2MKD6Ccvo0ZrOBJe6RTnhpyOJnKVYKzmCGua1BD6665Vi5L7PYWBKSxp5gkn5z3akZah8ZErZ3OYbVPOEWnrbLdVN4/jfnbeeuNKI46h0HuSpvgtUQJF9tJYlBqo3tMzHavrRpGxs/UerKNloygca2xfjX1+OLcfQI8GJlBnHFakQpnFF7WFCS1cxg1tAORqBFV0SjFS71ULF1sUa1qZITFW+oUVxWhqWhhnJ8eCiF3jFG3t+TdqR61di1A93dTUyIUa5V6UwV2TFKBScW2By2I/G2lKAUtLX62u804GUdu07dTPw8a0vSdr0RUhxeMA4krlrhWEbxcQoP2AnAy44rALSL0uINz6ARkWcEVVF5BIXUDw9APyJeCKkS4gLbqAUOgCsl8AEPEAjyQHuAKbC8hlLiB++QEpC5j2/02erQRRRKrJSGMWucVqzU4hFsgrjNkQHbKKwBikMAVSmAtSmAUJKqECKcyABJUwQApDkMIMSGEWJKhEBFIYgxRmQYJKlCCFCUhhCiSoxAhSGIMUpkGKMgNaiIuVhZUeX9/S5Ln3d3J2V1RNjlruq5wY+s9iL/r/6c7aTWhm1vd3X0xxK8ZhLgsz4lQfuLbgzgLU+tV6t6bhf6bvYMZ7YonLJBJHNkhPwWB1bpku2RroxGhjH/SSq48OvHGBtKiNwpCuYdfYq7lZFFa2Jer0/VR0s1y/M25zeY8sZt/C5Tk7xRxucYvOt1FWJz55qAUH2HNvmPPvmQtyGdUSAhuqzSLp2l3TYBxhowfPfumH/KfU7xOYFzTieOLKmtyHzlykzp94fR0XJGNleaFi05KJ/bnQPWWSj7nkfyvxLxy6oCgW41losuFZTtuvPWtVpf8+7WkNK8lk7ATbtrDJ+7vG9IJf/k5uTnu31D3joeoObclQ0rWSTeWfXr9hjV24y/tXvmE8e7KwLAE="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_squares-of-a-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [360. 有序转化数组 🟠](/problems/sort-transformed-array)

</details>
</div>

