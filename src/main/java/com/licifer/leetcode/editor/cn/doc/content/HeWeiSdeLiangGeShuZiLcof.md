<p>输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[2,7] 或者 [7,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [10,26,30,31,47,60], target = 40
<strong>输出：</strong>[10,30] 或者 [30,10]
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10^5</code></li> 
 <li><code>1 &lt;= nums[i]&nbsp;&lt;= 10^6</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 二分查找</details><br>

<div>👍 277, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=he-wei-sde-liang-ge-shu-zi-lcof" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [1. 两数之和](/problems/two-sum) 基本一样，而且还说了 `nums` 是有序的，所以直接用 [数组双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中讲的左右双指针解决即可。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 左右双指针
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return {nums[left], nums[right]};
            }
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 左右双指针
        left, right = 0, len(nums) - 1
        while left < right:
            sum = nums[left] + nums[right]
            if sum < target:
                # 让和大一点
                left += 1
            elif sum > target:
                # 让和小一点
                right -= 1
            else:
                # 找到两个数
                return [nums[left], nums[right]]
        return None
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 左右双指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                // 让和大一点
                left++;
            } else if (sum > target) {
                // 让和小一点
                right--;
            } else {
                // 找到两个数
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func twoSum(nums []int, target int) []int {
    // 左右双指针
    left, right := 0, len(nums)-1
    for left < right {
        sum := nums[left] + nums[right]
        if sum < target {
            // 让和大一点
            left++
        } else if sum > target {
            // 让和小一点
            right--
        } else {
            // 找到两个数
            return []int{nums[left], nums[right]}
        }
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var twoSum = function(nums, target) {
    // 左右双指针
    let left = 0, right = nums.length - 1;
    while (left < right) {
        let sum = nums[left] + nums[right];
        if (sum < target) {
            // 让和大一点
            left++;
        } else if (sum > target) {
            // 让和小一点
            right--;
        } else {
            // 找到两个数
            return [nums[left], nums[right]];
        }
    }
    return null;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_he-wei-sde-liang-ge-shu-zi-lcof" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_he-wei-sde-liang-ge-shu-zi-lcof"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组](/problems/two-sum-ii-input-array-is-sorted/)
  - [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)
  - [27. 移除元素](/problems/remove-element)
  - [283. 移动零](/problems/move-zeroes)
  - [344. 反转字符串](/problems/reverse-string/)
  - [5. 最长回文子串](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer II 006. 排序数组中两个数字之和](/problems/kLl5u1/)

</details>
</div>

