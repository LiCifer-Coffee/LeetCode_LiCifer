//给你一个满足下述两条属性的 m x n 整数矩阵：
//
// 
// 每行中的整数从左到右按非递减顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 | 矩阵 
//
// 👍 844, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 给定一个target，判断是否存在matrix二维数组中
 * 解题思路：
 * 1. 将二维数组转化为一维数组
 * 2. 利用一维数组中的index求出二维数组的坐标
 * 3. 注意 int i = x / col; 而不是 int i = x / row;
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            int left = 0, right = matrix.length * matrix[0].length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (getMatrix(matrix, mid) == target) {
                    return true;
                } else if (getMatrix(matrix, mid) < target) {
                    left = mid + 1;
                } else if (getMatrix(matrix, mid) > target) {
                    right = mid;
                }
            }

            return false;
        }

        // x为合并成一维数组后的索引，要求出二维数组中的值
        private int getMatrix(int[][] matrix, int x) {

            int col = matrix[0].length;
            int i = x / col;
            int j = x % col;

            return matrix[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}