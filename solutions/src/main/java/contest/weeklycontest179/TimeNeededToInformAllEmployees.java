package contest.weeklycontest179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/time-needed-to-inform-all-employees/
 * STATUS:PASS
 */
public class TimeNeededToInformAllEmployees {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

    Map<Integer, Node> idToNodeMap = new HashMap();
    for (int i = 0; i < n; i ++) {
      Node node = new Node(informTime[i], i);
      idToNodeMap.put(i, node);
    }
    for (int i = 0; i < n; i ++) {
      Node node = idToNodeMap.get(i);
      int managerId = manager[i];
      Node managerNode = idToNodeMap.get(managerId);
      if (null != managerNode) {
        managerNode.addFellow(node);
        idToNodeMap.put(managerId, managerNode);
      }

    }
    Node head = idToNodeMap.get(headID);
    return deepScan(head);

  }

  private int deepScan(Node manager) {
    List<Node> fellows = manager.getFellows();
    if (fellows == null || fellows.size() <= 0) {
      return 0;
    }
    int result = manager.getInformTime();
    int maxFellowTime = 0;
    for (Node fellow : fellows) {
      maxFellowTime = Math.max(maxFellowTime, deepScan(fellow));
    }
    return result + maxFellowTime;
  }

  private class Node{
    int informTime = 0;
    int id;
    List<Node> fellows;

    public Node(int informTime, int id) {
      this.informTime = informTime;
      this.id = id;
    }

    public List<Node> getFellows() {
      return this.fellows;
    }

    public void addFellow(Node fellow) {
      if (this.fellows == null) {
        this.fellows = new ArrayList();
      }
      this.fellows.add(fellow);
    }

    public int getId() {
      return this.id;
    }

    public int getInformTime() {
      return this.informTime;
    }
  }

  public static void main(String[] args) {
    TimeNeededToInformAllEmployees timeNeededToInformAllEmployees = new TimeNeededToInformAllEmployees();
    int n = 15;
    int headId = 0;
    int[] manager = new int[] {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
    int[] it = new int[] {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
    System.out.println("result: " + timeNeededToInformAllEmployees.numOfMinutes(n,
        headId, manager, it));
  }
}
