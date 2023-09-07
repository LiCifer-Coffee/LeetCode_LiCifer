//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics数组 | 哈希表 | 前缀和 
//
// 👍 675, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路:
 * 1. 题目要求是子数组中0和1的数量相同，求这个子数组最大的长度
 * 2. 所以需要变换数组，如果为则变为-1，所以最大长度为子数组中元素和为0
 * 3. 如何sum = 0 ，那么就是我们需要的子数组
 * 4. 我们利用Map来存储所有子数组的前缀和，如果两个前缀和相等，则表示中间的数组是满足条件的数组
 * 5. 所以结果集就是 两个前缀和相等的索引差值，需要求最大的那个
 * 6. 容易踩得坑是输入[0,1]这个数组时，测试用例不通过，要把p[0]这个利用起来，它代表第一个满足条件的子数组的起点，第二个for循环为 for (int i = 0; i < p.length; i++)
 */
public class ContiguousArray {
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int res = 0;
            int[] p = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                int temp = nums[i - 1] == 0 ? -1 : 1;
                p[i] = p[i - 1] + temp;
            }
            for (int i = 0; i < p.length; i++) {
                if (countMap.containsKey(p[i])) {
                    res = Math.max(i - countMap.get(p[i]), res);
                }else{
                    countMap.put(p[i], i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}