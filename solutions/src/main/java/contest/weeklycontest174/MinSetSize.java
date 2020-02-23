package contest.weeklycontest174;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangyuzhou on 2020/2/2.
 * https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
 * STATUS: PASS
 */
public class MinSetSize {
    public int minSetSize(int[] arr) {
        int[] bitmap = new int[100001];
        for (int i : arr) {
            bitmap[i] = bitmap[i] + 1;
            if (bitmap[i] >= arr.length / 2) {
                return 1;
            }
        }
        List<Integer> timesList = Arrays.stream(bitmap).boxed().collect(Collectors.toList());
        timesList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int result = 0;
        int count = arr.length / 2;
        for (int i = timesList.size() - 1; i >= 0; i --) {
            if (timesList.get(i) == 0) {
                break;
            }
            count -= timesList.get(i);
            result ++;
            if (count <= 0) {
                break;
            }
        }
        return result;
    }
}
