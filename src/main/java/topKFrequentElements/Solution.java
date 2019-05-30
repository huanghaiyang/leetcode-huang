package topKFrequentElements;

import java.util.*;

/**
 * created by huang 5/30/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Item> itemPriorityQueue = new PriorityQueue<>(itemComparator);
        for(Integer key: map.keySet()) {
            itemPriorityQueue.add(new Item(key, map.get(key)));
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < k ; i ++) {
            list.add(itemPriorityQueue.poll().val);
        }
        return list;
    }

    static Comparator<Item> itemComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o2.times - o1.times;
        }
    };

    class Item{
        int val;
        int times;

        public Item(int val, int times) {
            this.val = val;
            this.times = times;
        }

        public Item(int val) {
            this.val = val;
        }

    }

}
