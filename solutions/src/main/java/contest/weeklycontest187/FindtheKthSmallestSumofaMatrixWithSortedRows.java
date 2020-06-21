package contest.weeklycontest187;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * STATUS: NOT UNDERSTAND
 * CATEGORY: DP
 * link: https://leetcode-cn.com/contest/weekly-contest-187/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 */
public class FindtheKthSmallestSumofaMatrixWithSortedRows {
  int inf = (int)1e6;
  public int kthSmallest(int[][] mat, int k) {
    int n = mat.length;
    int m = mat[0].length;
    int len = 5000 * n + 1;
    int[][] dp = new int[n + 1][len];
    dp[0][0] = 1;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < len; j++){
        if(dp[i][j] == 0){
          continue;
        }
        for(int t = 0; t < m; t++){
          dp[i + 1][j + mat[i][t]] = Math.min(dp[i + 1][j + mat[i][t]] + dp[i][j], inf);
        }
      }
    }

    int ans = -1;
    while(k > 0){
      ans++;
      k -= dp[n][ans];
    }

    return ans;
  }

  /**
   * 由于每一个row都是sort，所以选取第一个col和一定是最小的
   * 找最小的K个sum,sum看作相对原点的最短路径
   * 每一个col选择的数组，近邻的下一个可能是数组中只改变一个number, col + 1 或者 col -1 这样我们就找到了如何找临近元素的方式
   * 然后用Dijkstra的思路就可以
   *
   * 作者：lcf_code
   * 链接：https://leetcode-cn.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/solution/java-dijkstra-by-lcf_code/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param mat
   * @param k
   * @return
   */
  public int kthSmallestWithDijkstra(int[][] mat, int k) {
    int r = mat.length;
    int c = mat[0].length;
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.sum - o2.sum);
    Point[] firstArr = new Point[r];
    for (int i = 0; i < r; i++) {
      firstArr[i] = new Point(i, 0, mat[i][0]);
    }
    Node first = new Node(firstArr);
    Set<String> visited = new HashSet<>();
    pq.offer(first);

    int res = 0;
    while (!pq.isEmpty() && k > 0) {
      Node node = pq.poll();
      if (visited.contains(node.hash)) {
        continue;
      }
      visited.add(node.hash);
      res = node.sum;
      Point[] arr = node.arr; //each point can find adk
      for (int i = 0; i < arr.length; i++) {
        Point p = arr[i];
        if (p.col + 1 < c) {
          Point[] next = arr.clone();
          next[i] = new Point(p.row, p.col + 1, mat[p.row][p.col+1]);
          Node nextNode = new Node(next);
          pq.offer(nextNode);
        }
        if (p.col - 1 > 0) {
          Point[] next = arr.clone();
          next[i] = new Point(p.row, p.col-1, mat[p.row][p.col-1]);
          Node nextNode = new Node(next);
          pq.offer(nextNode);

        }

      }
      k--;
    }
    return res;
  }

  class Node {
    int sum;
    Point[] arr;
    String hash;

    public Node(Point[] arr) {
      this.arr = arr;
      this.sum = 0;
      this.hash = "";
      for (Point p : arr) {
        sum += p.val;
        hash += "r" + p.row + "c" + p.col;
      }

    }
  }

  class Point {
    int row;
    int col;
    int val;
    public Point(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }

}
