package contest.weeklycontest174;

import java.util.*;

/**
 * Created by wangyuzhou on 2020/2/2.
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * STATUS: PASS
 * TIME: 2hour
 */
public class KweakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> countToRowIdMap = new HashMap();
        int count = 0;
        int n = mat.length;
        int m = mat[0].length;
        int i = 0;

        while (i < n * m) {
            if (mat[i / m][i % (m)] == 1) {
                count++;
            } else {
                List<Integer> rowIds = countToRowIdMap.get(count);
                if (null == rowIds) {
                    rowIds = new ArrayList();
                }
                rowIds.add(i / m);
                countToRowIdMap.put(count, rowIds);

                i = ((i / m) + 1) * m;
                count = 0;
                continue;
            }
            if (i != 0 && (i % (m) == (m - 1))) {
                List<Integer> rowIds = countToRowIdMap.get(count);
                if (null == rowIds) {
                    rowIds = new ArrayList();
                }
                rowIds.add(i / m);
                countToRowIdMap.put(count, rowIds);
                count = 0;
            }
            i++;
        }

        Set<Map.Entry<Integer, List<Integer>>> entrySet = countToRowIdMap.entrySet();
        List<Integer> countList = new ArrayList();
        for (Map.Entry<Integer, List<Integer>> entry : entrySet) {
            countList.add(entry.getKey());
        }
        countList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
//        Arrays.sort(countList.toArray());

        List<Integer> result = new ArrayList();
        for (Integer key : countList) {
            List<Integer> keys = countToRowIdMap.get(key);
            Arrays.sort(keys.toArray());
            result.addAll(keys);
            if (result.size() >= k) {
                break;
            }
        }
        return result.subList(0, k).stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        KweakestRows kweakestRows = new KweakestRows();
//        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
//        int k = 3;
//        int[][] mat = new int[][]{{1,1,1,1,1,1}, {1,1,1,1,1,1}, {1,1,1,1,1,1}};
//        int k = 1;

//        int[][] mat = new int[][]{{1,0}, {1,0}, {1,0}, {1, 1}};
//        int k = 4;
        int[][] mat = new int[][]{{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int k = 1;
        System.out.println("result :");
        for (int i : kweakestRows.kWeakestRows(mat, k)) {
            System.out.println(i);
        }

    }
}
