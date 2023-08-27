package com.licifer.other;

/**
 * @Author: MrLee
 * @Description: //二分查找
 * @Date: Created in 22:12 2023/7/28
 */
public class BinarySearch {

    /**
     * @Param [array 待查找数组, target 目标值]
     * @return int
     **/
    public static int binarySearchBasic(int[] array, int target) {
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < array[m]) {
                j = m - 1;
            } else if (array[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 帮我写个二分查找测试用例
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int target = 3;
        int index = binarySearchBasic(array, target);
        System.out.println(index);
    }


}
