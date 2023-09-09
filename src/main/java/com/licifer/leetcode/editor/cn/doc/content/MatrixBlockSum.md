<p>给你一个&nbsp;<code>m x n</code>&nbsp;的矩阵&nbsp;<code>mat</code>&nbsp;和一个整数 <code>k</code> ，请你返回一个矩阵&nbsp;<code>answer</code>&nbsp;，其中每个&nbsp;<code>answer[i][j]</code>&nbsp;是所有满足下述条件的元素&nbsp;<code>mat[r][c]</code> 的和：&nbsp;</p>

<ul> 
 <li><code>i - k &lt;= r &lt;= i + k, </code></li> 
 <li><code>j - k &lt;= c &lt;= j + k</code> 且</li> 
 <li><code>(r, c)</code>&nbsp;在矩阵内。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
<strong>输出：</strong>[[12,21,16],[27,45,33],[24,39,28]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
<strong>输出：</strong>[[45,45,45],[45,45,45],[45,45,45]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;mat.length</code></li> 
 <li><code>n ==&nbsp;mat[i].length</code></li> 
 <li><code>1 &lt;= m, n, k &lt;= 100</code></li> 
 <li><code>1 &lt;= mat[i][j] &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 前缀和</details><br>

<div>👍 181, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，[新版刷题打卡挑战](https://labuladong.gitee.io/algo/challenge/) 上线！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题可以直接套用前文 [前缀和数组技巧](https://labuladong.github.io/article/fname.html?fname=前缀和技巧) 中讲 [304. 二维区域和检索](/problems/range-sum-query-2d-immutable) 时实现的 `NumMatrix` 类，没什么难度。主要注意下通过 `min, max` 函数优雅避免索引越界的技巧，这个还是蛮常用的。

**标签：前缀和，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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

class NumMatrix {
private:
    vector<vector<int>> preSum;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = vector<vector<int>>(m + 1, vector<int>(n + 1));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
};

class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int k) {
        int m = mat.size(), n = mat[0].size();
        NumMatrix numMatrix(mat);
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角的坐标
                int x1 = max(i - k, 0);
                int y1 = max(j - k, 0);
                // 右下角坐标
                int x2 = min(i + k, m - 1);
                int y2 = min(j + k, n - 1);
                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
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
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        numMatrix = NumMatrix(mat)
        res = [[0]*n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                # 左上角的坐标
                x1, y1 = max(i - k, 0), max(j - k, 0)
                # 右下角坐标
                x2, y2 = min(i + k, m - 1), min(j + k, n - 1)

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2)
        return res

class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        m, n = len(matrix), len(matrix[0])
        if m == 0 or n == 0:
            return
        # 构造前缀和矩阵
        self.preSum = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                # 计算每个矩阵 [0, 0, i, j] 的元素和
                self.preSum[i][j] = self.preSum[i-1][j] + self.preSum[i][j-1] + matrix[i-1][j-1] - self.preSum[i-1][j-1]

    # 计算子矩阵 [x1, y1, x2, y2] 的元素和
    def sumRegion(self, x1: int, y1: int, x2: int, y2: int) -> int:
        # 目标矩阵之和由四个相邻矩阵运算获得
        return self.preSum[x2+1][y2+1] - self.preSum[x1][y2+1] - self.preSum[x2+1][y1] + self.preSum[x1][y1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左上角的坐标
                int x1 = Math.max(i - k, 0);
                int y1 = Math.max(j - k, 0);
                // 右下角坐标
                int x2 = Math.min(i + k, m - 1);
                int y2 = Math.min(j + k, n - 1);

                res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
            }
        }
        return res;
    }
}

class NumMatrix {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) return;
        // 构造前缀和矩阵
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

type NumMatrix struct {
    // 定义：preSum[i][j] 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    preSum [][]int
}

func Constructor(matrix [][]int) NumMatrix {
    m, n := len(matrix), len(matrix[0])
    // 构造前缀和矩阵
    preSum := make([][]int, m+1)
    for i := range preSum {
        preSum[i] = make([]int, n+1)
    }
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            // 计算每个矩阵 [0, 0, i, j] 的元素和
            preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1]
        }
    }
    return NumMatrix{preSum: preSum}
}

// 计算子矩阵 [x1, y1, x2, y2] 的元素和
func (n *NumMatrix) SumRegion(x1 int, y1 int, x2 int, y2 int) int {
    // 目标矩阵之和由四个相邻矩阵运算获得
    return n.preSum[x2+1][y2+1] - n.preSum[x1][y2+1] - n.preSum[x2+1][y1] + n.preSum[x1][y1]
}

func matrixBlockSum(mat [][]int, k int) [][]int {
    m, n := len(mat), len(mat[0])
    numMatrix := Constructor(mat)
    res := make([][]int, m)
    for i := range res {
        res[i] = make([]int, n)
    }
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            // 左上角的坐标
            x1 := max(i-k, 0)
            y1 := max(j-k, 0)
            // 右下角坐标
            x2 := min(i+k, m-1)
            y2 := min(j+k, n-1)

            res[i][j] = numMatrix.SumRegion(x1, y1, x2, y2)
        }
    }
    return res
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[][]}
 */
var matrixBlockSum = function(mat, k) {
    const m = mat.length, n = mat[0].length;
    const numMatrix = new NumMatrix(mat);
    const res = new Array(m);
    for (let i = 0; i < m; i++) {
        res[i] = new Array(n);
        for (let j = 0; j < n; j++) {
            // 左上角的坐标
            const x1 = Math.max(i - k, 0);
            const y1 = Math.max(j - k, 0);
            // 右下角坐标
            const x2 = Math.min(i + k, m - 1);
            const y2 = Math.min(j + k, n - 1);

            res[i][j] = numMatrix.sumRegion(x1, y1, x2, y2);
        }
    }
    return res;
};

class NumMatrix {
    /**
     * @param {number[][]} matrix
     */
    constructor(matrix) {
        const m = matrix.length, n = matrix[0].length;
        if (m === 0 || n === 0) return;
        // 构造前缀和矩阵
        this.preSum = new Array(m + 1);
        for (let i = 0; i <= m; i++) {
            this.preSum[i] = new Array(n + 1).fill(0);
        }
        for (let i = 1; i <= m; i++) {
            for (let j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                this.preSum[i][j] = this.preSum[i - 1][j] + this.preSum[i][j - 1] + matrix[i - 1][j - 1] - this.preSum[i - 1][j - 1];
            }
        }
    }

    /**
     * @param {number} x1
     * @param {number} y1
     * @param {number} x2
     * @param {number} y2
     * @return {number}
     */
    sumRegion(x1, y1, x2, y2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return this.preSum[x2 + 1][y2 + 1] - this.preSum[x1][y2 + 1] - this.preSum[x2 + 1][y1] + this.preSum[x1][y1];
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_matrix-block-sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_matrix-block-sum"></div></div>
</details><hr /><br />

</details>
</div>

