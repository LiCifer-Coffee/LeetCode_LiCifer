//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics数组 | 哈希表 | 数学 | 前缀和 
//
// 👍 535, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 解题思路:
 * 1. 利用前缀和，p[i] % k = p[j] % k ，如果表达式成立，则结果为[i....j]
 * 2. 注意countMap.put(0,0)，这种主要是解决 从第0个元素计算的数组 例如 [23,2,4,6,6]  7  ，得到的数组为[23,2,4,6]=35 ，不设置0的话会有问题
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {

            int[] p = new int[nums.length + 1];

            HashMap<Integer,Integer> countMap = new HashMap<>();
            countMap.put(0, 0);

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] + nums[i - 1];
            }

            for (int i = 1; i < p.length; i++) {
                if (!countMap.containsKey(p[i] % k)) {
                    countMap.put(p[i] % k, i);
                } else {
                    if (i - countMap.get(p[i] % k) > 1) {
                        return true;
                    }
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}