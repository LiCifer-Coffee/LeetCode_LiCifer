<p>给你一个数组 <code>nums</code><em>&nbsp;</em>和一个值 <code>val</code>，你需要 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong> 移除所有数值等于&nbsp;<code>val</code><em>&nbsp;</em>的元素，并返回移除后数组的新长度。</p>

<p>不要使用额外的数组空间，你必须仅使用 <code>O(1)</code> 额外空间并 <strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地 </a>修改输入数组</strong>。</p>

<p>元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。</p>

<p>&nbsp;</p>

<p><strong>说明:</strong></p>

<p>为什么返回数值是整数，但输出的答案是数组呢?</p>

<p>请注意，输入数组是以<strong>「引用」</strong>方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。</p>

<p>你可以想象内部操作如下:</p>

<pre>
// <strong>nums</strong> 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中<strong> 该长度范围内</strong> 的所有元素。
for (int i = 0; i &lt; len; i++) {
&nbsp; &nbsp; print(nums[i]);
}
</pre>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,2,3], val = 3
<strong>输出：</strong>2, nums = [2,2]
<strong>解释：</strong>函数应该返回新的长度 <strong>2</strong>, 并且 nums<em> </em>中的前两个元素均为 <strong>2</strong>。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,2,2,3,0,4,2], val = 2
<strong>输出：</strong>5, nums = [0,1,4,0,3]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong>, 并且 nums 中的前五个元素为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>3</code></strong>, <strong><code>0</code></strong>, <strong>4</strong>。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= nums.length &lt;= 100</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 50</code></li> 
 <li><code>0 &lt;= val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 1942, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=remove-element" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

类似 [26. 删除有序数组中的重复项](/problems/remove-duplicates-from-sorted-array)，需要使用 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中的快慢指针：

如果 `fast` 遇到需要去除的元素，则直接跳过，否则就告诉 `slow` 指针，并让 `slow` 前进一步。

**详细题解：[双指针技巧秒杀七道数组题目](https://labuladong.github.io/article/fname.html?fname=双指针技巧)**

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    int removeElement(vector<int>& nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        fast, slow = 0, 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 双指针法
func removeElement(nums []int, val int) int {
    var fast, slow int
    for fast < len(nums) {
        if nums[fast] != val {
            nums[slow] = nums[fast]
            slow++
        }
        fast++
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] !== val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-element" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-element"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [26. 删除有序数组中的重复项 🟢](/problems/remove-duplicates-from-sorted-array)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 🟢](/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>

