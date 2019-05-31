package opKFrequentWords;

import java.util.*;

/**
 * created by huang 5/30/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; i ++) {
            if(map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }
        PriorityQueue<Item> itemPriorityQueue = new PriorityQueue<>(itemComparator);
        for(String key: map.keySet()) {
            itemPriorityQueue.add(new Item(key, map.get(key)));
        }
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < k ; i ++) {
            list.add(itemPriorityQueue.poll().word);
        }
        return list;
    }

    static Comparator<Item> itemComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            if(o2.times != o1.times) {
                return o2.times - o1.times;
            }else {
                return o1.word.compareTo(o2.word);
            }
        }
    };

    class Item{
        String word;
        int times;

        public Item(String word, int times) {
            this.word = word;
            this.times = times;
        }

    }

}
