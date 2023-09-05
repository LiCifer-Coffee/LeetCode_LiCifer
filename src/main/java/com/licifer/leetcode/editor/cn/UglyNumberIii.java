/**
 * <p>给你四个整数：<code>n</code> 、<code>a</code> 、<code>b</code> 、<code>c</code> ，请你设计一个算法来找出第&nbsp;<code>n</code>&nbsp;个丑数。</p>
 *
 * <p>丑数是可以被&nbsp;<code>a</code>&nbsp;<strong>或</strong>&nbsp;<code>b</code>&nbsp;<strong>或</strong> <code>c</code>&nbsp;整除的 <strong>正整数</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 3, a = 2, b = 3, c = 5
 * <strong>输出：</strong>4
 * <strong>解释：</strong>丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 4, a = 2, b = 3, c = 4
 * <strong>输出：</strong>6
 * <strong>解释：</strong>丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 5, a = 2, b = 11, c = 13
 * <strong>输出：</strong>10
 * <strong>解释：</strong>丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1000000000, a = 2, b = 217983653, c = 336916467
 * <strong>输出：</strong>1999999984
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n, a, b, c &lt;= 10^9</code></li>
 * <li><code>1 &lt;= a * b * c &lt;= 10^18</code></li>
 * <li>本题结果在&nbsp;<code>[1,&nbsp;2 * 10^9]</code>&nbsp;的范围内</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 二分查找 | 数论</details><br>
 *
 * <div>👍 140, 👎 0<span style='float: right;'><span style='color: gray;'>
 *     <a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a>
 *     | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a>
 *     | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a>
 *     </span></span></div>
 */

package com.licifer.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 解题思路:利用丑数模块解题，出现超时
 */
public class UglyNumberIii {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIii().new Solution();
        int i = solution.nthUglyNumber(5, 2, 11, 13);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n, int a, int b, int c) {

            //int[] result = new int[n + 1];
            ////Arrays.fill(result, 1);
            //int p1 = 1, p2 = 1, p3 = 1;
            //int v1 = a, v2 = b, v3 = c;
            //int p = 0;
            //
            //while (p < n) {
            //    p++;
            //    int min = Math.min(Math.min(v1, v2), v3);
            //    result[p] = min;
            //    if (min == v1) {
            //        p1++;
            //        v1 = a * p1;
            //    }
            //    if (min == v2) {
            //        p2++;
            //        v2 = b * p2;
            //    }
            //    if (min == v3) {
            //        p3++;
            //        v3 = c * p3;
            //    }
            //}
            //return result[p];

            // 二分搜索 + 数学解法
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
//leetcode submit region end(Prohibit modification and deletion)

}