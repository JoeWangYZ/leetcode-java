package string;

import java.util.Arrays;

/**
 * Created by joe wang on 2017/4/27.
 */
public class LongestCommonPrefix {
    /**
     * common solutions , 13ms
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (null == strs || strs.length == 0) {
            return result.toString();
        }
        boolean flag = true;
        int j = 0;

        while (flag) {
            if (strs[0] == null || strs[0].length() <= j) {
                return result.toString();
            }
            char curChar = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i ++) {
                if (strs[i] == null || strs[i].length() <=j || strs[i].charAt(j) != curChar) {
                    return result.toString();
                }
            }
            result.append(curChar);
            j ++;
        }
        return result.toString();

    }

    /**
     * better solutions, with 2ms
     * @param strs
     * @return
     */
    public String longestCommonPrefixB(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }
}
