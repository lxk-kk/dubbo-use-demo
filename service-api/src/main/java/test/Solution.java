package test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int count;
    public HashSet<Integer> set = new HashSet<>();

    public int sum;
      public class Interval {
          int start;
          int end;

          public Interval(int a, int b) {
              this.start = a;
              this.end = b;
          }
      }

    public Interval trim(int N, int M, Interval[] conn) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (Interval interval : conn) {
            if (map.containsKey(interval.start)) {
                map.get(interval.start).add(interval.end);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(interval.end);
                map.put(interval.start, arrayList);
            }
        }
        List<Integer> start = map.get(0);
        set.add(0);
        for (int key : start) {
            if (set.contains(key)) {
                continue;
            }
            set.add(key);
            judge(map, 0, 0, key);
        }
        return new Interval(count, sum);
    }

    private void judge(HashMap<Integer, List<Integer>> map, int count, int sum, int key) {
        if (key == 0) {
            this.count += count;
            this.sum = (this.sum + sum) % 1000000007;
            return;
        }
        if (!map.containsKey(key)) {
            return;
        }
        if (!set.contains(key)) {
            count++;
            sum = (sum + key) % 1000000007;
        }
        List<Integer> arrayList = map.get(key);
        for (int tempKey : arrayList) {
            if (!set.contains(tempKey)) {
                continue;
            }
            judge(map, count , sum, tempKey);
        }
    }
}