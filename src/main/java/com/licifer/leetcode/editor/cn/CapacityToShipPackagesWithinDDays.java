//传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最
//大运载重量。 
//
// 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。 
//
// 
//
// 示例 1： 
//
// 
//输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。 
// 
//
// 示例 2： 
//
// 
//输入：weights = [3,2,2,4,1,4], days = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
// 
//
// 示例 3： 
//
// 
//输入：weights = [1,2,3,1,1], days = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days <= weights.length <= 5 * 10⁴ 
// 1 <= weights[i] <= 500 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 557, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 有n个货物，每个货物重量是weight[i]，一次能运载的重量是x，题目给出要5次运完所有货物（一次是一天），求传送带一次装载量是多少能满足5天运完。
 * 解题思路：
 * 1. 要看出随着运载量x的增加，运载次数count（day）随着减小，是一个单调递减函数
 * 2. 一次可以运送多个货物，由于要尽可能的多装满传送带，所以会有 currentWeight + weights[i] > x 时，count++;
 * 3. 要注意，      if (weights[i] > x) {
 *                     return Integer.MAX_VALUE;
 *                 }
 *     如果单个包裹的重量超过 x ，运载能力要增加，不需要计算了，直接返回最大值。例如：[1,2,3,1,1]，最小装载能力至少是3，不能是2，一个都运不走
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        int[] weights = {1,2,3,1,1};
        int days = 4;
        int result = solution.shipWithinDays(weights, days);
        System.out.println("最低运载能力为：" + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {

            int left = 1, right = 5 * 10000 * 500 + 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (getCount(weights, mid) == days) {
                    right = mid;
                } else if (getCount(weights, mid) < days) {
                    right = mid;
                } else if (getCount(weights, mid) > days) {
                    left = mid + 1;
                }
            }

            return left;
        }

        // x为运载能力,返回值为总共运载次数，一次一天
        private int getCount(int[] weights, int x) {

            int count = 1;
            int currentWeight = 0;

            for (int i = 0; i < weights.length; i++) {

                if (weights[i] > x) {
                    return Integer.MAX_VALUE; // 如果单个包裹的重量超过 x，直接返回最大值
                }
                if (currentWeight + weights[i] > x) {
                    count++;
                    // 重置当前重量
                    currentWeight = weights[i];
                } else {
                    currentWeight += weights[i];
                }

            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}