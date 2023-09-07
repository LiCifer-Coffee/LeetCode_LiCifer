//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 2066, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路:
 * 1. 考察点还是 前缀和 + hashMap ，注意 countMap 的定义
 * 2. 根据题目说明，如果 k=2 ，当p[i]=5时，要查询p[j]=3的个数，这个个数存放在countMap中
 * 3. p[5]-p[2] = 3 ,p[6]-p[3] = 3 ,如果p[2]有两个，p[3]有3个，那么总结果应该等于5个 ，所以应该使用 res = res + countMap.get(p[i] - k);
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            // countMap 记录前缀和出现的次数
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);
            int res = 0;
            int[] p = new int[nums.length + 1];

            for (int i = 1; i <= nums.length; i++) {
                p[i] = p[i - 1] + nums[i - 1];

                if (countMap.containsKey(p[i] - k)) {
                    res = res + countMap.get(p[i] - k);
                }

                if (!countMap.containsKey(p[i])) {
                    countMap.put(p[i], 1);
                } else {
                    countMap.put(p[i], countMap.get(p[i]) + 1);
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}