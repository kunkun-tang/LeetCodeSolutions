package _347_Top_k_Frequent_Elem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(bucket[value] == null)
                bucket[value] = new ArrayList<>();
            bucket[value].add(key);
        }
        int count = 0;
        List<Integer> retList = new ArrayList<>();
        for(int i=nums.length; i>=0 && count < k; i--) {
            if(bucket[i] != null) {
                retList.addAll(bucket[i]);
                count += bucket[i].size();
                // System.out.println(bucket[i]);
                // System.out.println(count + " " + k);
                // if(count >= k) break;
            }
        }
        return retList;
    }
}
