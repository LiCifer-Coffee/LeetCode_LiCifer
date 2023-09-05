<p>给你一个字符串 <code>s</code> ，请你反转字符串中 <strong>单词</strong> 的顺序。</p>

<p><strong>单词</strong> 是由非空格字符组成的字符串。<code>s</code> 中使用至少一个空格将字符串中的 <strong>单词</strong> 分隔开。</p>

<p>返回 <strong>单词</strong> 顺序颠倒且 <strong>单词</strong> 之间用单个空格连接的结果字符串。</p>

<p><strong>注意：</strong>输入字符串 <code>s</code>中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "<span><code>the sky is blue</code></span>"
<strong>输出：</strong>"<span><code>blue is sky the</code></span>"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = " &nbsp;hello world &nbsp;"
<strong>输出：</strong>"world hello"
<strong>解释：</strong>反转后的字符串中不能存在前导空格和尾随空格。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "a good &nbsp; example"
<strong>输出：</strong>"example good a"
<strong>解释：</strong>如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> 包含英文大小写字母、数字和空格 <code>' '</code></li> 
 <li><code>s</code> 中 <strong>至少存在一个</strong> 单词</li> 
</ul>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用&nbsp;<code>O(1)</code> 额外空间复杂度的 <strong>原地</strong> 解法。</p>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>

<div>👍 998, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=reverse-words-in-a-string" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

常规方法是用类似 `split` 再 `reverse` 最后 `join` 的方法得到结果，但更巧妙的方法是我在 [二维数组的花式遍历](https://labuladong.github.io/article/fname.html?fname=花式遍历) 中讲到的：**先把整个字符串进行翻转，再把每个单词中的字母翻转**。

比如说，给你输入这样一个字符串：

```shell
s = "hello world labuladong"
```

那么我们先将整个字符串 `s` 反转：

```shell
s = "gnodalubal dlrow olleh"
```

**然后将每个单词分别反转**：

```shell
s = "labuladong world hello"
```

这样，就实现了原地反转所有单词顺序的目的。

整体的思路应该不难，就是细节比较恶心，直接看我写的代码吧。

**详细题解：[二维数组的花式遍历技巧](https://labuladong.github.io/article/fname.html?fname=花式遍历)**

**标签：字符串，[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    string reverseWords(string s) {
        string res;
        // 清洗一下数据，去除多余的空格
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (c != ' ') {
                // 单词中的字母/数字
                res += c;
            }
 
            else if (res.back() != ' ') {
                // 单词之间保留一个空格
                res += ' ';
            }
        }
        // 末尾如果有空格，清除之
        if (res.back() == ' ') {
            res.pop_back();
        }
 
        // 清洗之后的字符串
        char *chars = new char[res.size() + 1];
        strcpy(chars, res.c_str());
        int n = strlen(chars);
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return chars;
    }
 
    // 翻转 arr[i..j]
    void reverse(char* arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def reverseWords(self, s: str) -> str:
        sb = []
        # 先清洗一下数据，把多余的空格都删掉
        for c in s:
            if c != ' ':
                # 单词中的字母/数字
                sb.append(c)
            elif sb and sb[-1] != ' ':
                # 单词之间保留一个空格
                sb.append(' ')
        # 末尾如果有空格，清除之
        if sb and sb[-1] == ' ':
            sb.pop()
        
        # 清洗之后的字符串
        chars = sb

        # 进行单词的翻转，先整体翻转
        def reverse(l, r):
            while l < r:
                chars[l], chars[r] = chars[r], chars[l]
                l += 1
                r -= 1
        
        n = len(chars)
        reverse(0, n-1)
        
        # 再把每个单词翻转
        start = end = 0
        while end < n:
            if chars[end] == ' ':
                reverse(start, end-1)
                start = end + 1
            end += 1
        
        # 翻转最后一个单词
        reverse(start, n-1)
        
        # 最后得到题目想要的结果
        return "".join(chars)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 单词中的字母/数字
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }
        // 末尾如果有空格，清除之
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return new String(chars);
    }

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func reverseWords(s string) string {
    sb := strings.Builder{}
    // 先清洗一下数据，把多于的空格都删掉
    for i := 0; i < len(s); i++ {
        c := s[i]
        if c != ' ' {
            // 单词中的字母/数字
            sb.WriteByte(c)
        } else if sb.Len() > 0 && sb.String()[sb.Len()-1] != ' ' {
            // 单词之间保留一个空格
            sb.WriteByte(' ')
        }
    }
    // 末尾如果有空格，清除之
    str := sb.String()
    if len(str) > 0 && str[len(str)-1] == ' ' {
        str = str[:len(str)-1]
    }

    // 清洗之后的字符串
    chars := []byte(str)
    n := len(chars)
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n-1)
    // 再把每个单词翻转
    for i := 0; i < n; {
        for j := i; j < n; j++ {
            if j+1 == n || chars[j+1] == ' ' {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j)
                // 把 i 置为下一个单词的首字母
                i = j + 2
                break
            }
        }
    }
    // 最后得到题目想要的结果
    return string(chars)
}

// 翻转 arr[i..j]
func reverse(arr []byte, i, j int) {
    for i < j {
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var reverseWords = function(s) {
    let sb = "";
    // 先清洗一下数据，把多于的空格都删掉
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c !== ' ') {
            // 单词中的字母/数字
            sb += c;
        } else if (sb !== "" && sb[sb.length - 1] !== ' ') {
            // 单词之间保留一个空格
            sb += ' ';
        }
    }
    // 末尾如果有空格，清除之
    if (sb[sb.length - 1] === ' ') {
        sb = sb.substring(0, sb.length - 1);
    }

    // 清洗之后的字符串
    let chars = sb.split('');
    let n = chars.length;
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n - 1);
    // 再把每个单词翻转
    for (let i = 0; i < n;) {
        for (let j = i; j < n; j++) {
            if (j + 1 === n || chars[j + 1] === ' ') {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j);
                // 把 i 置为下一个单词的首字母
                i = j + 2;
                break;
            }
        }
    }
    // 最后得到题目想要的结果
    return chars.join("");
};

// 翻转 arr[i..j]
function reverse(arr, i, j) {
    while (i < j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_reverse-words-in-a-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-words-in-a-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [1260. 二维网格迁移 🟢](/problems/shift-2d-grid)
  - [48. 旋转图像 🟠](/problems/rotate-image)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)
  - [剑指 Offer 58 - I. 翻转单词顺序 🟢](/problems/fan-zhuan-dan-ci-shun-xu-lcof)

</details>
</div>

