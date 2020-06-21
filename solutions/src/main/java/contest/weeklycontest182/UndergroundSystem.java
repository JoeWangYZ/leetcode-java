package contest.weeklycontest182;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

  Map<String, Map<String, AverageHolder>> startToEndToTimeMap = new HashMap<>();
  Map<Integer, InAndOut> idToInOutMap = new HashMap<>();
  public UndergroundSystem() {

  }

  public void checkIn(int id, String stationName, int t) {
    InAndOut inAndOut = new InAndOut();
    inAndOut.setInTime(t);
    inAndOut.setStation(stationName);
    idToInOutMap.put(id, inAndOut);
  }

  public void checkOut(int id, String stationName, int t) {
    InAndOut inAndOut = idToInOutMap.get(id);
    Map<String, AverageHolder> endToTimeMap = startToEndToTimeMap.get(inAndOut.getStation());
    if (null == endToTimeMap) {
      endToTimeMap = new HashMap<>();
    }
    AverageHolder holder = endToTimeMap.get(stationName);
    if (null == holder) {
      holder = new AverageHolder();
    }
    holder.add(t - inAndOut.getInTime());
    endToTimeMap.put(stationName, holder);
    startToEndToTimeMap.put(inAndOut.getStation(), endToTimeMap);
    idToInOutMap.remove(id);
  }

  public double getAverageTime(String startStation, String endStation) {
    Map<String, AverageHolder> endToTimeMap = startToEndToTimeMap.get(startStation);
    if (null == endToTimeMap) {
      return 0;
    }
    AverageHolder holder = endToTimeMap.get(endStation);
    if (null == holder) {
      return 0;
    }
    return (double) (((double) holder.getTotalTime()) / (double) holder.getCount());
  }


  private class AverageHolder {
    int count = 0;
    int totalTime = 0;

    private void add (int thisTime) {
      this.totalTime += thisTime;
      this.count ++;
    }

    private int getCount() {
      return count;
    }

    private void setCount(int count) {
      this.count = count;
    }

    private int getTotalTime() {
      return totalTime;
    }

    private void setTotalTime(int totalTime) {
      this.totalTime = totalTime;
    }
  }

  private class InAndOut {
    int inTime;
    String station;

    private String getStation() {
      return station;
    }

    private void setStation(String station) {
      this.station = station;
    }

    private int getInTime() {
      return inTime;
    }

    private void setInTime(int inTime) {
      this.inTime = inTime;
    }
  }

  public static void main(String[] args) {
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(45, "Leyton", 3);
    undergroundSystem.checkIn(32, "Paradise", 8);
    undergroundSystem.checkIn(27, "Leyton", 10);
    undergroundSystem.checkOut(45, "Waterloo", 15);
    undergroundSystem.checkOut(27, "Waterloo", 20);
    undergroundSystem.checkOut(32, "Cambridge", 22);
    double result1 = undergroundSystem.getAverageTime("Paradise", "Cambridge");       //
    // 返回 14.0。从
    // "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
    result1= undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11
    // .0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客出发于 time=10 到达于 time=20。所以平均时间为 ( (15-3) + (20-10) ) / 2 = 11.0
    undergroundSystem.checkIn(10, "Leyton", 24);
    result1= undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 11.0
    undergroundSystem.checkOut(10, "Waterloo", 38);
    result1= undergroundSystem.getAverageTime("Leyton", "Waterloo");          // 返回 12.0

    String sss = new String();
    List<Integer> list = new ArrayList<>();

    Map<Integer, List> map = new HashMap<>();
    map.put('c' - 'a', null);
    Collections.sort(new ArrayList<Integer>(), new Comparator<Integer>() {
      @Override public int compare(Integer o1, Integer o2) {
        return 0;
      }
    });
  }
}
