<p>给你一个 <strong>升序排列</strong> 的数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>只出现一次</strong> ，返回删除后数组的新长度。元素的 <strong>相对顺序</strong> 应该保持 <strong>一致</strong> 。然后返回 <code>nums</code> 中唯一元素的个数。</p>

<p>考虑 <code>nums</code> 的唯一元素的数量为 <code>k</code> ，你需要做以下事情确保你的题解可以被通过：</p>

<ul> 
 <li>更改数组 <code>nums</code> ，使 <code>nums</code> 的前 <code>k</code> 个元素包含唯一元素，并按照它们最初在 <code>nums</code> 中出现的顺序排列。<code>nums</code>&nbsp;的其余元素与 <code>nums</code> 的大小不重要。</li> 
 <li>返回 <code>k</code>&nbsp;。</li> 
</ul>

<p><strong>判题标准:</strong></p>

<p>系统会用下面的代码来测试你的题解:</p>

<pre>
int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}</pre>

<p>如果所有断言都通过，那么您的题解将被 <strong>通过</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,2]
<strong>输出：</strong>2, nums = [1,2,_]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>2</code></strong> ，并且原数组 <em>nums </em>的前两个元素被修改为 <strong><code>1</code></strong>, <strong><code>2 </code></strong><span><code>。</code></span>不需要考虑数组中超出新长度后面的元素。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,1,1,1,2,2,3,3,4]
<strong>输出：</strong>5, nums = [0,1,2,3,4]
<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong> ， 并且原数组 <em>nums </em>的前五个元素被修改为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>2</code></strong>, <strong><code>3</code></strong>, <strong><code>4</code></strong> 。不需要考虑数组中超出新长度后面的元素。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按 <strong>升序</strong> 排列</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针</details><br>

<div>👍 3294, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=remove-duplicates-from-sorted-array" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[数组双指针技巧汇总](https://www.bilibili.com/video/BV1iG411W7Wm)

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 371 页。

有序序列去重的通用解法就是我们前文 [双指针技巧](https://labuladong.github.io/article/fname.html?fname=双指针技巧) 中的快慢指针技巧。

我们让慢指针 `slow` 走在后面，快指针 `fast` 走在前面探路，找到一个不重复的元素就告诉 `slow` 并让 `slow` 前进一步。这样当 `fast` 指针遍历完整个数组 `nums` 后，**`nums[0..slow]` 就是不重复元素**。

![](https://labuladong.github.io/pictures/数组去重/1.gif)

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
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.size()) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        slow, fast = 0, 0
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                # 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast]
            fast += 1
        # 数组长度为索引 + 1
        return slow + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func removeDuplicates(nums []int) int {
    // 如果数组为空，直接返回 0
    if len(nums) == 0 {
        return 0
    }
    // 定义快慢指针，初始化都指向数组头部
    slow, fast := 0, 0
    // 快指针向后遍历数组，直到末尾
    for fast < len(nums) {
        // 如果两个指针指向的元素不相同
        if nums[fast] != nums[slow] {
            // 慢指针向后移动，并且将慢指针位置上的值设为快指针位置上的值
            slow++
            nums[slow] = nums[fast]
        }
        // 快指针继续向后移动
        fast++
    }
    // slow 指向数组的最后一个不重复元素的位置
    // 数组长度为索引 + 1
    return slow + 1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    let slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] !== nums[slow]) {
            slow++;
            // 维护 nums[0..slow] 无重复
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_remove-duplicates-from-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-duplicates-from-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [27. 移除元素 🟢](/problems/remove-element)
  - [283. 移动零 🟢](/problems/move-zeroes)
  - [344. 反转字符串 🟢](/problems/reverse-string)
  - [5. 最长回文子串 🟠](/problems/longest-palindromic-substring)
  - [80. 删除有序数组中的重复项 II 🟠](/problems/remove-duplicates-from-sorted-array-ii)
  - [83. 删除排序链表中的重复元素 🟢](/problems/remove-duplicates-from-sorted-list)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 006. 排序数组中两个数字之和 🟢](/problems/kLl5u1)

</details>
</div>

