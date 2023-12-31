//在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
//
//
// 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。 
//
// 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。 
//
// 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2],[3,4]], r = 1, c = 4
//输出：[[1,2,3,4]]
// 
//
// 示例 2： 
// 
// 
//输入：mat = [[1,2],[3,4]], r = 2, c = 4
//输出：[[1,2],[3,4]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// -1000 <= mat[i][j] <= 1000 
// 1 <= r, c <= 300 
// 
//
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 410, 👎 0 
//
//
//
//


package com.licifer.leetcode.editor.cn;

/**
 * 题目理解: 将m*n的矩阵转化为r*c的矩阵，m*n = r*c
 * 解题思路：
 * 1. 将二维数组转化为一维数组，一维数组的坐标是 x=i*n+j ，一维数组坐标转化为二维就是[x/n,x%n]，跟横坐标没关系，只跟列有关系
 * 2. x < m * n 的意思就是一维数组的坐标取值范围
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {

            int m = mat.length, n = mat[0].length;
            if (m * n != r * c) {
                return mat;
            }

            int[][] answer = new int[r][c];
            for (int x = 0; x < m * n; x++) {
                answer[x / c][x % c] = mat[x / n][x % n];
            }
            return answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}