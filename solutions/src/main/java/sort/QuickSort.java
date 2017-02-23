package sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wangyuzhou on 2017/2/23.
 * time complex: O(N*logN)
 */
public class QuickSort {

    public static void sort(List<Integer> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        qsort(list, 0, list.size() - 1);
    }

    /**
     * 快速排序
     * @param list
     * @param l
     * @param r
     */
    private static void qsort(List<Integer> list, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int X = list.get(i); // 在索引i处挖坑
            while (i < j) {
                while (i < j && list.get(j) >= X) { // 从右向左找第一个小于x的数
                    j --;
                }
                if (i < j) {
                    list.set(i ++, list.get(j));
                }
                while (i < j && list.get(i) < X) { // 从左向右找第一个大于等于x的数
                    i ++;
                }
                if (i < j) {
                    list.set(j --, list.get(i));
                }
            }
            list.set(i, X); //填坑
            qsort(list, l, i - 1);  // 递归调用
            qsort(list, i + 1, r);
        }
    }

    public static void main(String[] args) {

        int[] intarray = new int[] {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < intarray.length; i++) {
            list.add(intarray[i]);
        }
        long startTime = Calendar.getInstance().getTimeInMillis();
        try {
            sort(list);
        } catch (Exception e) {

        } finally {
            long endTime = Calendar.getInstance().getTimeInMillis();
            System.out.println("sort time cost : " + (endTime -  startTime) + " ms");
        }

        System.out.println(list);

    }
}
