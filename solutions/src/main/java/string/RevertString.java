package string;

/**
 * Created by joe wang on 2017/3/20.
 */
public class RevertString {
    public String reverseStringA(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        return reverse(s, 0, s.length()-1);
    }

    private String reverse(String s, int l, int r) {
        if (l > r || l < 0 || r >= s.length()) {
            return null;
        }
        if (l == r) {
            return "" + s.charAt(l);
        }
        int mid = (r - l) / 2;
        StringBuilder builder = new StringBuilder();
        String leftResult = reverse(s, l, mid);
        String rightResult = reverse(s, mid + 1, r);
        if (null != rightResult) {
            builder.append(rightResult);
        }
        if (null != leftResult) {
            builder.append(leftResult);
        }
        return builder.toString();
    }


}
