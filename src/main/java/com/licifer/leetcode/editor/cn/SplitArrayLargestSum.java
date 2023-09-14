//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
//
// Related Topics贪心 | 数组 | 二分查找 | 动态规划 | 前缀和 
//
// 👍 838, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 可以理解为，有nums[]个货物，每个货物重nums[i]，求解在指定的天数K内，多少的装载能力能把货物运完，跟运送货物一模一样
 * 解题思路：
 * 1. 子数组和最小就是指的最小装载量是多少，子数组个数就是运送的次数。这题主要就是把题目理解成“运送货物”
 * 2. 子数组个数相同时(m=2)，相加的和(x)可能不同，及时一个单调递减函数，有一块是平的。
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {

            int left = 0, right = 1000000 * 1000 + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (getCount(nums, mid) == k) {
                    right = mid;
                } else if (getCount(nums, mid) < k) {
                    right = mid;
                } else if (getCount(nums, mid) > k) {
                    left = mid + 1;
                }
            }

            return left;
        }

        // x为装载能力，当装载能力为x时，运输nums货物需要的次数为f(x),单调递减函数
        private int getCount(int[] nums, int x) {

            int count = 1;
            int currentWeight = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>x) {
                    return Integer.MAX_VALUE;
                }
                currentWeight += nums[i];
                if (currentWeight > x) {
                    count++;
                    currentWeight = nums[i];
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}