//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics数组 | 双指针 | 二分查找 | 排序 | 滑动窗口 | 堆（优先队列） 
//
// 👍 509, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述: 找出与目标x最近的元素，组成排序好的数组，例如 arr = [1,2,3,4,5], k = 4, x = 3，输出：[1,2,3,4]，如果差值相同，那么取较小的那一个
 * 解题思路：
 * 1. 二分法找出x所在的位置，然后利用中间双指针从x的左右两边移动，注意判断指针索引值
 * 2. 注意 Math.abs(arr[p1] - x) <= Math.abs(arr[p2] - x) ，当相等时，取最小那一个
 * 3. 注意 P2=index，因为返回的数组中要包含x
 * 4. 由于结果要是排序好的，所以使用链表数组，利用addFirst和addLast排序
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            LinkedList<Integer> result = new LinkedList<Integer>();
            int index = getIndex(arr, x);
            int p1 = index - 1, p2 = index;
            for (int i = 0; i < k; i++) {
                if (p1 < 0) {
                    result.addLast(arr[p2]);
                    p2++;
                } else if (p2 > arr.length - 1) {
                    result.addFirst(arr[p1]);
                    p1--;
                } else if (Math.abs(arr[p1] - x) <= Math.abs(arr[p2] - x)) {
                    result.addFirst(arr[p1]);
                    p1--;
                } else if (Math.abs(arr[p1] - x) > Math.abs(arr[p2] - x)) {
                    result.addLast(arr[p2]);
                    p2++;
                }
            }
            return result;
        }

        private int getIndex(int[] arr, int x) {
            int left = 0, right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == x) {
                    return mid;
                } else if (arr[mid] < x) {
                    left = mid + 1;
                } else if (arr[mid] > x) {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}