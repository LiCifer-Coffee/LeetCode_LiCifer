import java.util.Iterator;

/**
 * @Author: MrLee
 * @Description: //TODO
 * @Date: Created in 22:09 2023/8/1
 */
public class test1 {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int demo = demo(2, array);
        System.out.println(demo);
    }

    public static int demo(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (target < array[middle]) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    class test22{

        void aa(){

            Iterator<Integer> iterator = new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Integer next() {
                    return null;
                }
            };

            Integer next = iterator.next();

        }


    }


}
