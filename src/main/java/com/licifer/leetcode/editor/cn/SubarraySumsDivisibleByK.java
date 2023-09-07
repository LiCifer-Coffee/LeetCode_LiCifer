//给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
//
// 子数组 是数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,0,-2,-3,1], k = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 k = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 示例 2: 
//
// 
//输入: nums = [5], k = 9
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 462, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumsDivisibleByK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {

            int[] p = new int[nums.length + 1];
            int res = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] + nums[i - 1];

                int key = p[i] % k;
                if (key < 0) {
                    key += k;
                }

                if (countMap.get(key) != null) {
                    res = res + countMap.get(key);
                }

                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}