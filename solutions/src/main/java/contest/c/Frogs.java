package contest.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frogs {
  Map<Integer, List<Frog>> stepToFrogListMap = new HashMap();

  static Map<Integer, Integer> charToIndex;
  static {
    charToIndex = new HashMap();
    charToIndex.put('c' - 'a', 0);
    charToIndex.put('r' - 'a', 1);
    charToIndex.put('o' - 'a', 2);
    charToIndex.put('a' - 'a', 3);
    charToIndex.put('k' - 'a', 4);
  }

  public int minNumberOfFrogs(String croakOfFrogs) {
    int maxCount = 0;
    int curCount = 0;
    for (int i = 0; i < croakOfFrogs.length(); i ++) {
      int index = charToIndex.get(croakOfFrogs.charAt(i) - 'a');

      if (index == 0) {
        Frog newFrog = new Frog();
        newFrog.croak();
        List<Frog> initFrogs = stepToFrogListMap.get(0) != null ? stepToFrogListMap.get(0) : new ArrayList<Frog>();
        initFrogs.add(newFrog);
        stepToFrogListMap.put(0, initFrogs);
        curCount ++;
      } else {
        List<Frog> croakingFrogs = stepToFrogListMap.get(index - 1);
        if (null == croakingFrogs || croakingFrogs.size() <= 0) {
          return -1;
        }
        Frog lastFrog = croakingFrogs.get(croakingFrogs.size() - 1);
        lastFrog.croak();
        croakingFrogs.remove(croakingFrogs.size() - 1);
        if (index == 4) {
          curCount --;
        } else {
          List<Frog> nextFrogs = stepToFrogListMap.get(index) != null ? stepToFrogListMap.get(index) : new ArrayList<Frog>();
          nextFrogs.add(lastFrog);
          stepToFrogListMap.put(index, nextFrogs);
        }
        stepToFrogListMap.put(index - 1, croakingFrogs);

      }
      if (curCount > maxCount) {
        maxCount = curCount;
      }
    }
    return maxCount;
  }

  private class Frog {
    int cIndex = -1;

    public boolean isCroaking() {
      return cIndex != -1 && cIndex != 4;
    }

    public int croak() {
      cIndex ++;
      if (cIndex == 4) {
        cIndex = 0;
      }
      return cIndex;
    }
  }

  public static void main(String[] args) {
    Frogs frogs = new Frogs();
    System.out.println(frogs.minNumberOfFrogs("crcoakroak"));
  }
}
