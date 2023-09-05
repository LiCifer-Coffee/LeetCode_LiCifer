<p>给你四个整数：<code>n</code> 、<code>a</code> 、<code>b</code> 、<code>c</code> ，请你设计一个算法来找出第&nbsp;<code>n</code>&nbsp;个丑数。</p>

<p>丑数是可以被&nbsp;<code>a</code>&nbsp;<strong>或</strong>&nbsp;<code>b</code>&nbsp;<strong>或</strong> <code>c</code>&nbsp;整除的 <strong>正整数</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3, a = 2, b = 3, c = 5
<strong>输出：</strong>4
<strong>解释：</strong>丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 4, a = 2, b = 3, c = 4
<strong>输出：</strong>6
<strong>解释：</strong>丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 5, a = 2, b = 11, c = 13
<strong>输出：</strong>10
<strong>解释：</strong>丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>n = 1000000000, a = 2, b = 217983653, c = 336916467
<strong>输出：</strong>1999999984
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n, a, b, c &lt;= 10^9</code></li> 
 <li><code>1 &lt;= a * b * c &lt;= 10^18</code></li> 
 <li>本题结果在&nbsp;<code>[1,&nbsp;2 * 10^9]</code>&nbsp;的范围内</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数学 | 二分查找 | 数论</details><br>

<div>👍 140, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=ugly-number-iii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [264. 丑数 II](/problems/ugly-number-ii) 有些类似，你把第 264 题合并有序链表的解法照搬过来稍微改改就能解决这道题，代码我写在 `Solution2` 里面了。

但是注意题目给的数据规模，`a, b, c, n` 都是非常大的数字，如果用合并有序链表的思路，其复杂度是 O(N)，对于这么大的数据规模来说也是比较慢的，应该会超时，无法通过一些测试用例。

这道题的正确解法难度比较大，难点在于你要把一些数学知识和 [二分搜索技巧](https://labuladong.github.io/article/fname.html?fname=二分查找详解) 结合起来才能高效解决这个问题。

首先，根据 [二分查找的实际运用](https://labuladong.github.io/article/fname.html?fname=二分运用) 中讲到的二分搜索运用方法，我们可以抽象出一个单调递增的函数 `f`：

`f(num, a, b, c)` 计算 `[1..num]` 中，能够整除 `a` 或 `b` 或 `c` 的数字的个数，显然函数 `f` 的返回值是随着 `num` 的增加而增加的（单调递增）。

**题目让我们求第 `n` 个能够整除 `a` 或 `b` 或 `c` 的数字是什么，也就是说我们要找到一个 `num`，使得 `f(num, a, b, c) == n`**。

有了上述思路，就可以按照 [二分查找的实际运用](https://labuladong.github.io/article/fname.html?fname=二分运用) 中给出的模板运用二分搜索算法了。

关键说一下函数 `f` 怎么实现，这里面涉及集合论定理以及最小公因数、最小公倍数的计算方法。

首先，`[1..num]` 中，我把能够整除 `a` 的数字归为集合 `A`，能够整除 `b` 的数字归为集合 `B`，能够整除 `c` 的数字归为集合 `C`，那么 `len(A) = num / a, len(B) = num / b, len(C) = num / c`，这个很好理解。

但是 `f(num, a, b, c)` 的值肯定不是 `num / a + num / b + num / c` 这么简单，因为你注意有些数字可能可以被 `a, b, c` 中的两个数或三个数同时整除，如下图：

![](https://labuladong.github.io/pictures/丑数/1.jpg)

**按照集合论的算法，这个集合中的元素应该是：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C**。结合上图应该很好理解。

问题来了，`A, B, C` 三个集合的元素个数我们已经算出来了，但如何计算像 `A ∩ B` 这种交集的元素个数呢？

其实也很容易想明白，`A ∩ B` 的元素个数就是 `n / lcm(a, b)`，其中 `lcm` 是计算最小公倍数（Least Common Multiple）的函数。

类似的，`A ∩ B ∩ C` 的元素个数就是 `n / lcm(lcm(a, b), c)` 的值。

现在的问题是，最小公倍数怎么求？

直接记住定理吧：`lcm(a, b) = a * b / gcd(a, b)`，其中 `gcd` 是计算最大公因数（Greatest Common Divisor）的函数。

现在的问题是，最大公因数怎么求？

这应该是经典算法了，我们一般叫辗转相除算法（或者欧几里得算法）。

好了，套娃终于套完了，我们可以把上述思路翻译成解法，注意本题数据规模比较大，有时候需要用 `long` 类型防止 `int` 溢出，具体看我的代码实现以及注释吧。

**详细题解：[丑数系列算法详解](https://labuladong.github.io/article/fname.html?fname=丑数)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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

// 二分搜索 + 数学解法
class Solution {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        // 题目说本题结果在 [1, 2 * 10^9] 范围内，
        // 所以就按照这个范围初始化两端都闭的搜索区间
        int left = 1, right = (int) 2e9;
        // 搜索左侧边界的二分搜索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                // [1..mid] 中的元素个数不足 n，所以目标在右侧
                left = mid + 1;
            } else {
                // [1..mid] 中的元素个数大于 n，所以目标在左侧
                right = mid - 1;
            }
        }
        return left;
    }

    // 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
    long f(int num, int a, int b, int c) {
        long setA = num / a, setB = num / b, setC = num / c;
        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num / lcm(b, c);
        long setABC = num / lcm(lcm(a, b), c);
        // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
        return setA + setB + setC - setAB - setAC - setBC + setABC;
        /*
        ![](https://labuladong.github.io/pictures/丑数/1.jpg)
        */
    }

    // 计算最大公因数（辗转相除/欧几里得算法）
    long gcd(long a, long b) {
        if (a < b) {
            // 保证 a > b
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 最小公倍数
    long lcm(long a, long b) {
        // 最小公倍数就是乘积除以最大公因数
        return a * b / gcd(a, b);
    }
};

// 用合并单链表的思路（超时）
class Solution2 {
public:
    int nthUglyNumber(int n, int a, int b, int c) {
        // 可以理解为三个有序链表的头结点的值
        long productA = a, productB = b, productC = c;
        // 可以理解为合并之后的有序链表上的指针
        int p = 1;

        long min = -666;

        // 开始合并三个有序链表，获取第 n 个节点的值
        while (p <= n) {
            // 取三个链表的最小结点
            min = std::min({productA, productB, productC});
            p++;
            // 前进最小结点对应链表的指针
            if (min == productA) {
                productA += a;
            }
            if (min == productB) {
                productB += b;
            }
            if (min == productC) {
                productC += c;
            }
        }
        return (int) min;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        def gcd(x: int, y: int) -> int:
            if x < y:
                # 保证 x > y
                return gcd(y, x)
            if y == 0:
                return x
            return gcd(y, x % y)

        def lcm(x: int, y: int) -> int:
            # 最小公倍数就是乘积除以最大公因数
            return x * y // gcd(x, y)

        # 题目说本题结果在 [1, 2 * 10^9] 范围内，
        # 所以就按照这个范围初始化两端都闭的搜索区间
        left, right = 1, 2 * 10 ** 9
        # 搜索左侧边界的二分搜索
        while left <= right:
            mid = (left + right) // 2
            if (mid // a + mid // b + mid // c -
               mid // lcm(a, b) - mid // lcm(b, c) -
               mid // lcm(a, c) + mid // lcm(lcm(a, b), c)) < n:
                # [1..mid] 中的元素个数不足 n，所以目标在右侧
                left = mid + 1
            else:
                # [1..mid] 中的元素个数大于 n，所以目标在左侧
                right = mid - 1
        return left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 二分搜索 + 数学解法
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // 题目说本题结果在 [1, 2 * 10^9] 范围内，
        // 所以就按照这个范围初始化两端都闭的搜索区间
        int left = 1, right = (int) 2e9;
        // 搜索左侧边界的二分搜索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                // [1..mid] 中的元素个数不足 n，所以目标在右侧
                left = mid + 1;
            } else {
                // [1..mid] 中的元素个数大于 n，所以目标在左侧
                right = mid - 1;
            }
        }
        return left;
    }

    // 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
    long f(int num, int a, int b, int c) {
        long setA = num / a, setB = num / b, setC = num / c;
        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num / lcm(b, c);
        long setABC = num / lcm(lcm(a, b), c);
        // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
        return setA + setB + setC - setAB - setAC - setBC + setABC;/**<extend up -400>![](https://labuladong.github.io/pictures/丑数/1.jpg) */
    }

    // 计算最大公因数（辗转相除/欧几里得算法）
    long gcd(long a, long b) {
        if (a < b) {
            // 保证 a > b
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 最小公倍数
    long lcm(long a, long b) {
        // 最小公倍数就是乘积除以最大公因数
        return a * b / gcd(a, b);
    }
}

// 用合并单链表的思路（超时）
class Solution2 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // 可以理解为三个有序链表的头结点的值
        long productA = a, productB = b, productC = c;
        // 可以理解为合并之后的有序链表上的指针
        int p = 1;

        long min = -666;

        // 开始合并三个有序链表，获取第 n 个节点的值
        while (p <= n) {
            // 取三个链表的最小结点
            min = Math.min(Math.min(productA, productB), productC);
            p++;
            // 前进最小结点对应链表的指针
            if (min == productA) {
                productA += a;
            }
            if (min == productB) {
                productB += b;
            }
            if (min == productC) {
                productC += c;
            }
        }
        return (int) min;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

// 二分搜索 + 数学解法
func nthUglyNumber(n int, a int, b int, c int) int {
    // 题目说本题结果在 [1, 2 * 10^9] 范围内，
    // 所以就按照这个范围初始化两端都闭的搜索区间
    left, right := 1, 2*int(1e9)
    // 搜索左侧边界的二分搜索
    for left <= right {
        mid := left + (right-left)/2
        if f(mid, a, b, c) < n {
            // [1..mid] 中的元素个数不足 n，所以目标在右侧
            left = mid + 1
        } else {
            // [1..mid] 中的元素个数大于 n，所以目标在左侧
            right = mid - 1
        }
    }
    return left
}

// 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
func f(num int, a int, b int, c int) int {
    setA := num / a
    setB := num / b
    setC := num / c
    setAB := num / lcm(a, b)
    setAC := num / lcm(a, c)
    setBC := num / lcm(b, c)
    setABC := num / lcm(lcm(a, b), c)
    // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
    return setA + setB + setC - setAB - setAC - setBC + setABC
}

// 计算最大公因数（辗转相除/欧几里得算法）
func gcd(a int64, b int64) int64 {
    if a < b {
        // 保证 a > b
        return gcd(b, a)
    }
    if b == 0 {
        return a
    }
    return gcd(b, a%b)
}

// 最小公倍数
func lcm(a int64, b int64) int64 {
    // 最小公倍数就是乘积除以最大公因数
    return a * b / gcd(a, b)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number} n
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var nthUglyNumber = function(n, a, b, c) {
  // 题目说本题结果在 [1, 2 * 10^9] 范围内，
  // 所以就按照这个范围初始化两端都闭的搜索区间
  let left = 1, right = 2e9;
  // 搜索左侧边界的二分搜索
  while (left <= right) {
    let mid = left + (right - left) / 2;
    if (f(mid, a, b, c) < n) {
      // [1..mid] 中的元素个数不足 n，所以目标在右侧
      left = mid + 1;
    } else {
      // [1..mid] 中的元素个数大于 n，所以目标在左侧
      right = mid - 1;
    }
  }
  return left;
  
  // 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
  function f(num, a, b, c) {
    let setA = Math.floor(num / a), setB = Math.floor(num / b), setC = Math.floor(num / c);
    let setAB = Math.floor(num / lcm(a, b));
    let setAC = Math.floor(num / lcm(a, c));
    let setBC = Math.floor(num / lcm(b, c));
    let setABC = Math.floor(num / lcm(lcm(a, b), c));
    // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
    return setA + setB + setC - setAB - setAC - setBC + setABC;/**<extend up -400>![](https://labuladong.github.io/pictures/丑数/1.jpg) */
  }

  // 计算最大公因数（辗转相除/欧几里得算法）
  function gcd(a, b) {
    if (a < b) {
      // 保证 a > b
      return gcd(b, a);
    }
    if (b === 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  // 最小公倍数
  function lcm(a, b) {
    // 最小公倍数就是乘积除以最大公因数
    return a * b / gcd(a, b);
  }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_ugly-number-iii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_ugly-number-iii"></div></div>
</details><hr /><br />

**类似题目**：
  - [263. 丑数 🟢](/problems/ugly-number)
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)
  - [剑指 Offer 49. 丑数 🟠](/problems/chou-shu-lcof)

</details>
</div>

