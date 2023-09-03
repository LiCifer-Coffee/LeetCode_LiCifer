<p>给你一个整数 <code>n</code> ，请你找出并返回第 <code>n</code> 个 <strong>丑数</strong> 。</p>

<p><strong>丑数 </strong>就是只包含质因数&nbsp;<code>2</code>、<code>3</code> 和/或&nbsp;<code>5</code>&nbsp;的正整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 10
<strong>输出：</strong>12
<strong>解释：</strong>[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
<strong>解释：</strong>1 通常被视为丑数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 1690</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 动态规划 | 堆（优先队列）</details><br>

<div>👍 1100, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=ugly-number-ii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题很精妙，你看着它好像是道数学题，实际上它却是一个合并多个有序链表的问题，同时用到了筛选素数的思路。

建议你先做一下 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists)，然后再做一下 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 中讲的 [204. 计数质数（简单）](/problems/count-primes)，这样的话就能比较容易理解这道题的思路了。

**类似 [如何高效寻找素数](https://labuladong.github.io/article/fname.html?fname=打印素数) 的思路：如果一个数 `x` 是丑数，那么 `x * 2, x * 3, x * 5` 都一定是丑数**。

我们把所有丑数想象成一个从小到大排序的链表，就是这个样子：

```java
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8 -> ...
```

然后，我们可以把丑数分为三类：2 的倍数、3 的倍数、5 的倍数（按照题目的意思，1 算作特殊的丑数，放在开头），这三类丑数就好像三条有序链表，如下：

能被 2 整除的丑数：

```java
1 -> 1*2 -> 2*2 -> 3*2 -> 4*2 -> 5*2 -> 6*2 -> 8*2 ->...
```

能被 3 整除的丑数：

```java
1 -> 1*3 -> 2*3 -> 3*3 -> 4*3 -> 5*3 -> 6*3 -> 8*3 ->...
```

能被 5 整除的丑数：

```java
1 -> 1*5 -> 2*5 -> 3*5 -> 4*5 -> 5*5 -> 6*5 -> 8*5 ->...
```

我们其实就是想把这三条「有序链表」合并在一起并去重，合并的结果就是丑数的序列。然后求合并后的这条有序链表中第 `n` 个元素是什么。所以这里就和 [链表双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 中讲到的合并 `k` 条有序链表的思路基本一样了。

具体思路看注释吧，你也可以对照我在 [21. 合并两个有序链表（简单）](/problems/merge-two-sorted-lists) 中给出的思路代码来看本题的思路代码，就能轻松看懂本题的解法代码了。

**详细题解：[丑数系列算法详解](https://labuladong.github.io/article/fname.html?fname=丑数)**

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        vector<int> ugly(n + 1, 0);
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min_val = min(min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min_val;
            p++;
            // 前进对应有序链表上的指针
            if (min_val == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min_val == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min_val == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def nthUglyNumber(self,n: int) -> int:
        # 三个指向有序链表头结点的指针
        p2,p3,p5 = 1,1,1
        # 三个有序链表的头节点的值
        product2, product3, product5 = 1, 1, 1
        # 最终合并的有序链表（结果链表）
        ugly = [0] * (n + 1)
        # 结果链表上的指针
        p = 1

        # 开始合并三个有序链表
        while p <= n:
            # 取三个链表的最小结点
            minv = min(product2, product3, product5)
            # 接到结果链表上
            ugly[p] = minv
            p += 1
            # 前进对应有序链表上的指针
            if minv == product2:
                product2 = 2 * ugly[p2]
                p2 += 1
            if minv == product3:
                product3 = 3 * ugly[p3]
                p3 += 1
            if minv == product5:
                product5 = 5 * ugly[p5]
                p5 += 1

        # 返回第 n 个丑数
        return ugly[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func nthUglyNumber(n int) int {
    // 可以理解为三个指向有序链表头结点的指针
    p2, p3, p5 := 1, 1, 1
    // 可以理解为三个有序链表的头节点的值
    product2, product3, product5 := 1, 1, 1
    // 可以理解为最终合并的有序链表（结果链表）
    ugly := make([]int, n+1)
    // 可以理解为结果链表上的指针
    p := 1

    // 开始合并三个有序链表
    for p <= n {
        // 取三个链表的最小结点
        min := min(product2, product3, product5)
        // 接到结果链表上
        ugly[p] = min
        p++
        // 前进对应有序链表上的指针
        if min == product2 {
            product2 = 2 * ugly[p2]
            p2++
        }
        if min == product3 {
            product3 = 3 * ugly[p3]
            p3++
        }
        if min == product5 {
            product5 = 5 * ugly[p5]
            p5++
        }
    }
    // 返回第 n 个丑数
    return ugly[n]
}

// 取三个数的最小值
func min(i, j, k int) int {
    if i < j {
        if i < k {
            return i
        } else {
            return k
        }
    } else {
        if j < k {
            return j
        } else {
            return k
        }
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var nthUglyNumber = function(n) {
    // 可以理解为三个指向有序链表头结点的指针
    let p2 = 1, p3 = 1, p5 = 1;
    // 可以理解为三个有序链表的头节点的值
    let product2 = 1, product3 = 1, product5 = 1;
    // 可以理解为最终合并的有序链表（结果链表）
    let ugly = new Array(n + 1);
    // 可以理解为结果链表上的指针
    let p = 1;
  
    // 开始合并三个有序链表
    while (p <= n) {
        // 取三个链表的最小结点
        let min = Math.min(Math.min(product2, product3), product5);
        // 接到结果链表上
        ugly[p] = min;
        p++;
        // 前进对应有序链表上的指针
        if (min === product2) {
            product2 = 2 * ugly[p2];
            p2++;
        }
        if (min === product3) {
            product3 = 3 * ugly[p3];
            p3++;
        }
        if (min === product5) {
            product5 = 5 * ugly[p5];
            p5++;
        }
    }
    // 返回第 n 个丑数
    return ugly[n];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_ugly-number-ii" data="GzZWoxDYOBBC2EYUJYMSBKj1AXcYTO5VxBTcRFw6N7ob4RRZwNNlP1mtLnVw+Ff026lBrER2zE6nPfPiIFQOVXzQZTX0+ek2RPucmMMR8FxqZtr+UwiywPOzvTAo4oH3DhQWVAopqtpFTU5UQAdHOnHoX1GD80KuO0VLN5U92bHg8wqqFCDnVKTCSfxq7fOiDmirxob3gh1ysbGMHljF/u3p3hdCkJmeDwFGxcLEpnycjB+/1volTFt/6ItYKJsQ7Wcfk0zqp5oWQiFuRUMPYjM3h1uMqXdGEmtGJ/jMCF0PHbvcPJR5O347fJ05JbKpcNTfMHDVpoOHkoMd+VxfUe83e2He8X/8Q7KQfrs7IsJBEReM32bhcb760+l4Wr+UeZWQJXni41OlJSp7FAmfe/lgAnGK8T32LuyzMZxuNTqvefqlR8vGOljsYA9KC5k4Wf3isT+7VAV5RMry9Wsewt+S5Hq9T0VDiFTgLA3nT47nPSreJ5Rv9+2HpqaHH1SKQ0zJzFC5QyyzY3N29C5WuXT8HcE+kH0dckpcY9E75JLEI27GZSAUwXimeYawuZM4ZJdjeFzUETl1iO8nfjGDVPq1q1rwd6lYSiSsF8xaz6/fz5Jkh8u9KuwM/RixI+apcbgPs47Lz8W+7hyVMFUmVJPNIxxKLA1zU/pofV0hJvE8iJv70+P//Mb4Fc1OeFiDUbU3fbNQaWLYQubtpKnR6tpQJGw2lp4Lj+D/uw7+JvpYU8Ot/PwemvibpcVJq4NN8eIO+Ynn3lOZVnpJnLe8e1KedB1j+xvxlS0I74CBKGeW6OQwZB5ZJyCEJFbH3HGeZFzFufNMsTLP/1SedWR8bpy3XjanCxqC1bd42jXpOAHd3EROiyaTEvJlpjCZM5VnHbHPWQ70cubuamisfnjPaCbfTkAoSZyWTKZLxJeZgjNnKs86guaEL44GCJlqCAaRTKolbEAgpRKyDRUGn/GPYuW9QnMCXxw7SLLUCAyhmFIr0OWK9cugtY+USshuqGjYlhPZagyG0UyrNWzg1iNKqiC7oaLRRhHIrSZgBMOM2qC1BE7gy+DjjkipxM9GmV+BMuYgyK2mwWhsZqtt2KCBlmrIXqhY2MAfDEFJFWRfqLiwrUBeNQvG4jBX7cIGA4zU4GejzK9AmTZKQL5qLhgXl3nVXohavADaj2ipxs8Gza8AjW0Nn1Hm16CMHyiD10+U+bUoY4MLbLEN4YQKgtAvmg/yo8QKwgMVgT1Us7Gph2CwCWWoVEv8D1AGR+xCeENFwwbzHhtGbCA8UBG0msAJTC4K+dlBu+sDbeFs7bukRv86R49ATUNyOJKrWKdiIovH67Kcs3YNGVWzkaFmi/T15CoXe5ZH75QPJ3HBv2v0LTv1YkT6hYfwKhAEhkDDwMIthJdRFSOxb9CPBM3jDLbNhueRni/FcqMDzh4HY5ujLbFgm3X0DcTo0C84skFdRbOHabFkT7UEBd4i9+PKsgw9Dou1pg2wWGlUnIvVrFs+KC4bDS6W1xEwKEtJQBotVrc9iMVSxtbwpJB0Ht3ihkxgy7HhnUN+Nz0kIpexN4AqIX5ATbvx8KGrvJ3OUnZsfhvezjTV6LjiBUrY3E6vDDlTpb/onqUEuLBdir050e+DiXyorWz72q4XOi1wpQqMcKbITQDROYSJfmkSyzsiw4nGiqX7vtOwUIfJPPbZciBYSdkroXrp6dyDZ/T4yBd6SK6mzJtj5z7c9wkBT3RiNiTar/pJN0tWRmOEqWVORO41LRCWclmNjmIJhoQzBjIwp2rajWz3Ha7BUEyGJPrsizgilaXt3GdfxJ7CnK76DuAihiT2taCKLDIdeYcMLOavw9NwKT81i1lWUhWZqTrc82O+fHxhTStX0qydC1ZU/Kgb9xRYTVhj911e4On8aC1RUnnR38NEWDiIBYT2mS8NT12RIkdU++Vf2B/zgmfa+DbcmB7YOYkiDo4xo6rOI5Cixx9ZjUVI345RcTGOX6coYtN1BEZ9hK6ijPC3PZphESQxKRoaGx+24jR6PRr5hM3RFV7MpF0gcZd/rMYsiPzWWiHzLqb0erh1JTSIcOqAwk2fwIaUTdW480Uj7NguNQ5bs93RaXjp97OLL3MjVXYOHXMYDgQ2F+x92jCoedMxe4VC9kUxyNt2HyFTqzz58xNse4IvH1/YT4N1ygN9QmIiazXxEQLSXYkiWIQEGXgSnXHBkgq14e3O0JqK7MGzUj9YkXoXx8Z28rQuaIYj4tPiE1cqiGfaTfeqhw+2FLTYnYw1q+hds8VFC9wb6La2nZAYK+9bv0Hs05JX6GVj+6W/qo1lhyPnVYdo0toKBE1Ka4WWoyUaiHGiHWiJ5p4lWnWWaLzFiTaaJZpilmhxWaJhFSfaT5ZoJlmiNWSJRk+caNuAy+7ez/Bdi0pDxrf3L3plkui5WxbRRvJIWR+sQqfCKnQGVqFLsApdD1ahW2IVuiusyvrFKlyGCGLyVo4GlU4NKp0JKl0E5qxfUOnaYEbOEt6R+GxiVZT23V7bZ9Ofh1Hy1b8RALwfSISoCV4/5/2shlpc/x63/kGU6lK5hVP+jcqkq48ifGmjLracTIr5y9Ke4sgRyQwHvVzH11J4ZLzYoI0+tF4afiTgpX4UTi/ylv6pHE9Pqwt8yF/a14prj4TxffO/pHra/E0XU2RlbpfBIEh+IEIjk54ZcU+ek06wILgQJQPJkEAWSSF1K/+8HR8fKCMZidAs1rdGqspvo2v1KGQd3EtAtqwjjtAje3WZOObJHST1RXJB3PUsv1mw25FjtANnPgUPVtQQvTTbP+7QH+I2/xT3e/g6Nly51djH0xFbsRJXH43CE5QQJAqmsOxsyaGC9Ni86fQyOa8heTZoVEvNNBAacjRoXMvNPBAeBL4oFTpRrtyHbcuGmnq3VG08qIJl8WERzgvTC9mRi49og79M3MksEsMe8fWFapH1s3/jKePFZ1wfvdyYOw=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [1201. 丑数 III 🟠](/problems/ugly-number-iii)
  - [263. 丑数 🟢](/problems/ugly-number)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>

