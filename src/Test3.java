/**
 * @Author: MrLee
 * @Description: //TODO
 * @Date: Created in 21:07 2023/8/22
 */
public class Test3 {

    public static void main(String[] args) {
        int[] array = {1,2,5,3,4,1};
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res = Math.max(res, array[i]);
        }
        System.out.println(res);

    }

}
