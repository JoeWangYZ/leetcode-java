package math;

/**
 * Created by joe wang on 2017/2/13.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        boolean flag = x < 0;
        x = flag ? -x : x;
        while (x > 0) {

            int tmp = result * 10;
            if (tmp / 10 != result) {
                return 0;
            }
            result = tmp;
            result += x % 10;
            x /= 10;
        }
        return flag ? -result : result;
    }
}
