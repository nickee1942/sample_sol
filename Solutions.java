import java.util.*;
public class Solutions {
    public static void main(String[] args){
        //test case1
        int[][] arr = new int[][]{{94133,94133}, {94200,94299}, {94600,94699}};
        int[][] ans = merge(arr);
        for(int[] a : ans)
            System.out.println(a[0] + " " + a[1]);

        //test case 2
        int[][] arr2 = new int[][]{{94133,94133}, {94200,94299}, {94226,94399}};
        int[][] ans2 = merge(arr2);
        for(int[] a : ans2)
            System.out.println(a[0] + " " + a[1]);
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0)
            return new int[][]{};
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            int left = list.get(list.size() - 1)[0];
            int right = list.get(list.size() - 1)[1];
            if(a > right){
                list.add(intervals[i]);
            }
            else{
                list.get(list.size() - 1)[0] = left;
                list.get(list.size() - 1)[1] = Math.max(b, right);
            }
        }
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for(int[] arr : list){
            res[idx][0] = arr[0];
            res[idx][1] = arr[1];
            idx++;
        }
        return res;
    }
}
