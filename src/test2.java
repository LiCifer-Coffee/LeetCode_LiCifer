import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: MrLee
 * @Description: //TODO
 * @Date: Created in 21:09 2023/8/17
 */
public class test2 {

    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "hjklp";
        System.out.println(mergeAlternately(word1, word2));
    }


    public static String mergeAlternately(String word1, String word2) {
        char[] word1s = word1.toCharArray();
        char[] word2s = word2.toCharArray();
        int resultLength = Math.max(word1.length(), word2.length());
        char[] result = new char[resultLength];
        String last = null;
        if (word1.length() >= word2.length()) {
            last = word1.substring(word2.length());
        }else{
            last = word2.substring(word1.length());
        }
        for (int i = 0; i < word1s.length; i++) {
            if (i < word2s.length) {
                result[i] = word1s[i];
                result[i + 1] = word2s[i];
            }
        }

        String first = Arrays.toString(result);
        return first + last;


    }


}
