package contest.weeklycontest172;

/**
 * Created by wangyuzhou on 2020/1/19.
 * STATUS: PASS
 */
public class Maximum69Number {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        if (!str.contains("6")) {
            return num;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (c == '6') {
                return Integer.valueOf(result.append("9").append((i < str.length() - 1) ? str.substring(i + 1) : "").toString());
            } else {
                result.append(c);
            }
        }
        return num;
    }
}
