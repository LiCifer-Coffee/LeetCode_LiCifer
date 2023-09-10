/**
 * <p>车上最初有&nbsp;<code>capacity</code>&nbsp;个空座位。车&nbsp;<strong>只能&nbsp;</strong>向一个方向行驶（也就是说，<strong>不允许掉头或改变方向</strong>）</p>
 *
 * <p>给定整数&nbsp;<code>capacity</code>&nbsp;和一个数组 <code>trips</code> , &nbsp;<code>trip[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code>&nbsp;表示第
 * <code>i</code> 次旅行有&nbsp;<code>numPassengers<sub>i</sub></code>&nbsp;乘客，接他们和放他们的位置分别是&nbsp;<code>from<sub>i</sub></code>&nbsp;和&nbsp;<code>to<sub>i</sub></code>&nbsp;
 * 。这些位置是从汽车的初始位置向东的公里数。</p>
 *
 * <p>当且仅当你可以在所有给定的行程中接送所有乘客时，返回&nbsp;<code>true</code>，否则请返回 <code>false</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 4
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 5
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= trips.length &lt;= 1000</code></li>
 * <li><code>trips[i].length == 3</code></li>
 * <li><code>1 &lt;= numPassengers<sub>i</sub>&nbsp;&lt;= 100</code></li>
 * <li><code>0 &lt;= from<sub>i</sub>&nbsp;&lt; to<sub>i</sub>&nbsp;&lt;= 1000</code></li>
 * <li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列）</details><br>
 *
 * <div>👍 272, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: trips.length代表着有多少个操作，trips[i][0]代表着第一个操作，[2,1,5]，从第一个车站上来两个人，到第五个车站下车了，
 *          题目要求每个车站的人数不能超过最大容量capacity，所以题目可以理解为对车站数组进行了一系列操作后，能够知道当时每个车站有多少人
 *          ，通过人员数量和capacity做比较即可求解答案。
 * 解题思路:
 * 1. 编写查分数组工具类
 * 2. 注意操作的入参 diff.operate(trips[i][0], trips[i][1], trips[i][2] - 1);
 *    因为车站编号是从0开始的，所以车站编号跟索引是一样的，下车时要减一。
 */
public class CarPooling {
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {

            Diff diff = new Diff(new int[1001]);
            for (int i = 0; i < trips.length; i++) {
                diff.operate(trips[i][0], trips[i][1], trips[i][2] - 1);
            }

            int[] result = diff.getResult();
            for (int i = 0; i < result.length; i++) {
                if (result[i] > capacity) {
                    return false;
                }
            }
            return true;
        }
    }

    class Diff {

        private int[] data;

        public Diff(int[] nums) {
            data = new int[nums.length];
            data[0] = nums[0];
            for (int i = 1; i < data.length; i++) {
                data[i] = nums[i] - nums[i - 1];
            }
        }

        public void operate(int val, int i, int j) {
            data[i] = data[i] + val;
            if (j + 1 < data.length) {
                data[j + 1] = data[j + 1] - val;
            }
        }

        public int[] getResult() {
            int[] res = new int[data.length];
            res[0] = data[0];
            for (int i = 1; i < data.length; i++) {
                res[i] = res[i - 1] + data[i];
            }
            return res;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}