/**
 * <p>这里有&nbsp;<code>n</code>&nbsp;个航班，它们分别从 <code>1</code> 到 <code>n</code> 进行编号。</p>
 *
 * <p>有一份航班预订表&nbsp;<code>bookings</code> ，表中第&nbsp;<code>i</code>&nbsp;条预订记录&nbsp;<code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code>&nbsp;意味着在从
 * <code>first<sub>i</sub></code>&nbsp;到 <code>last<sub>i</sub></code> （<strong>包含</strong> <code>first<sub>i</sub></code> 和 <code>last<sub>i</sub></code> ）的
 * <strong>每个航班</strong> 上预订了 <code>seats<sub>i</sub></code>&nbsp;个座位。</p>
 *
 * <p>请你返回一个长度为 <code>n</code> 的数组&nbsp;<code>answer</code>，里面的元素是每个航班预定的座位总数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * <strong>输出：</strong>[10,55,45,25,25]
 * <strong>解释：</strong>
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>bookings = [[1,2,10],[2,2,15]], n = 2
 * <strong>输出：</strong>[10,25]
 * <strong>解释：</strong>
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>bookings[i].length == 3</code></li>
 * <li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li>
 * <li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 478, 👎 0<span style='float: right;'></span></div>
 */

package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 1...n ,代表第1到第n号航班，然后通过booking[1,2,10]进行了一系列操作，代表在1，2号航班上订购了10张票，最终的结果是求出每个航班对应的订票数量
 * 解题思路:
 * 1. 利用差分数组，先写出工具类，工具类是输入一个数组，然后提供操作方法，就能对数组内指定的元素进行批量增减
 * 2. 在编写工具类时，要注意是从j+1的索引开始减  data[j + 1] = data[j + 1] - val;
 * 3. 在操作时，注意要减一，按照索引的顺序传值  diff.operate(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
 */
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {

            Diff diff = new Diff(new int[n]);
            for (int i = 0; i < bookings.length; i++) {
                diff.operate(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
            }

            return diff.getResult();

        }

    }

    class Diff {

        private int[] data;

        public Diff(int[] nums) {
            data = new int[nums.length];
            data[0] = nums[0];
            for (int i = 1; i< nums.length; i++) {
                data[i] = nums[i] - nums[i - 1];
            }
        }

        public void operate(int i, int j, int val) {
            data[i] = data[i] + val;
            if (j + 1 < data.length) {
                data[j + 1] = data[j + 1] - val;
            }
        }

        public int[] getResult() {
            int[] res = new int[data.length];
            res[0] = data[0];
            for (int i = 1; i < data.length; i++) {
                res[i] = data[i] + res[i - 1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}