package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe wang on 2017/3/11.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Examples:
     * <p>
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * <p>
     * Given "bbbbb", the answer is "b", with the length of 1.
     * <p>
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        HashMap<Integer, Integer> mark = new HashMap<>();
        int longestLength = 0;
        int i = 0;
        int lastRepeatIndex = 0;
        for (int j = 0; j < s.length(); j++) {
            int c = (int) s.charAt(j);
            Integer valueOfCInMap = mark.get(c);
            if (null != valueOfCInMap && lastRepeatIndex <= valueOfCInMap) {
                longestLength = longestLength >= i ? longestLength : i;
                i = j - valueOfCInMap;
                lastRepeatIndex = valueOfCInMap;
            }else {
                i ++;
            }

            if (j == s.length() - 1){
                longestLength = longestLength >= i ? longestLength : i;
            }
            mark.put(c, j);
        }
        return longestLength;
    }
}
