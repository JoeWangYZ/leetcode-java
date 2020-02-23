package string;

/**
 * Created by joe wang on 2017/3/23.
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    private static final char STAR = '*';
    private static final char POINT = '.';
    public boolean isMatch(String s, String p) {
        int pIndex = 0;
        int sIndex = 0;
        if (null == p || p.length() == 0) {
            return false;
        }
        if (null == s || s.length() == 0) {

        }
        char cp;
        char cs;
        while (sIndex < s.length() && pIndex < p.length()) {
            cp = p.charAt(pIndex);
            if (cp == POINT) {
                if (sIndex < s.length() - 1) {
                    sIndex ++;
                    pIndex ++;
                }else {
                    sIndex ++;
                }
                continue;
            }
            if (cp == STAR) {
                return false;
            }
            cs = s.charAt(sIndex);
            if (cs != cp) {
                return false;
            }
            if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != STAR) {
                sIndex ++;
                pIndex ++;
                continue;
            }
//            if (p.charAt(pIndex + 1) == STAR && cs =)
        }

        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }else return false;

    }
}
