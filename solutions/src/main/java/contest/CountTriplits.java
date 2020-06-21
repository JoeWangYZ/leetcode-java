package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountTriplits {
  public int countTriplets(int[] arr) {
    int n = arr.length;
    int count = 0;
    Map<Integer, Map<Integer, Integer>> map = new HashMap();
    for (int i = 0; i < n; i ++) {
      int temp = arr[i];
      Map<Integer, Integer> subMap = map.containsKey(i) ? map.get(i) : new HashMap();
      subMap.put(i, temp);
      for (int j = i + 1; j < n; j ++) {
        temp ^= arr[j];
        subMap.put(j, temp);

      }

      map.put(i, subMap);
    }
    for (int i = 0; i < n - 1; i ++) {
      for (int j = i + 1; j < n; j ++) {
        for (int k = j; k < n; k ++) {
          int a = map.containsKey(i) ? map.get(i).get(j - 1) : 0;
          int b = map.containsKey(j) ? map.get(j).get(k) : 0;
          if (a == b) {
            System.out.println(i +"," + j + "," + k);
            count ++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2,3,1,6,7};
    int[] other = Arrays.copyOf(arr, arr.length);
    System.out.println(new CountTriplits().countTriplets(arr));
  }
}
