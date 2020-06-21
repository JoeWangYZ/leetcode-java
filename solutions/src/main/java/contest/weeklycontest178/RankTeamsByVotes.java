package contest.weeklycontest178;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/rank-teams-by-votes/
 * STATUS:PASS
 */
public class RankTeamsByVotes {
  /**
   * self solution
   * @param votes
   * @return
   */
  public String rankTeams(String[] votes) {
    if (votes.length == 1) {
      return votes[0];
    }
    Map<String, Map<Integer, Integer>> countMap = new HashMap();
    for (int i = 0; i < votes.length; i ++) {
      for (int j = 0; j < votes[i].length(); j ++) {
        String key = String.valueOf(votes[i].charAt(j));
        Map<Integer, Integer> orderCountMap = countMap.get(key);
        if (orderCountMap == null) {
          orderCountMap = new HashMap();
        }

        Integer count = orderCountMap.containsKey(j) ? orderCountMap.get(j) : 0;
        count ++;
        orderCountMap.put(j, count);
        countMap.put(key, orderCountMap);
      }
    }

    int minOrder = votes[0].length();

    List<Map.Entry<String, Map<Integer, Integer>>> list = new ArrayList<Map.Entry<String, Map<Integer, Integer>>>(countMap.entrySet());
    list.sort(new Comparator<Map.Entry<String, Map<Integer, Integer>>>() {
      @Override
      public int compare(Map.Entry<String, Map<Integer, Integer>> o1, Map.Entry<String, Map<Integer, Integer>> o2) {
        Map<Integer, Integer> map1 = o1.getValue();
        Map<Integer, Integer> map2 = o2.getValue();

        for (int i = 0; i < minOrder; i ++) {
          int orderCount1 = map1.containsKey(i) ? map1.get(i) : 0;
          int orderCount2 = map2.containsKey(i) ? map2.get(i) : 0;
          if (orderCount1 < orderCount2) {
            return 1;
          } else if (orderCount1 > orderCount2) {
            return -1;
          }
        }
        return o1.getKey().compareTo(o2.getKey());
      }
    });
    StringBuffer sb = new StringBuffer();
    for (Map.Entry<String, Map<Integer, Integer>> en : list) {
      sb.append(en.getKey());
    }
    return sb.toString();
  }
}
