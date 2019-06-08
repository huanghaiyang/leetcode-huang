package indexPairsOfAString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by huang 6/8/19
 */
public class Solution {

    public static void main(String[] args) {
        //new Solution().indexPairs("ababa", new String[]{"aba", "ab"});
        new Solution().indexPairs("thestoryofleetcodeandme", new String[]{"story","fleet","leetcode"});
    }

    class R {
        int start;
        int end;

        public R(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] indexPairs(String text, String[] words) {
        List<R> list = new LinkedList<>();
        for(String word: words) {
            int index = 0;
            while (index <= text.length() - word.length()) {
                int findIndex = text.indexOf(word, index);
                if (findIndex != -1 && findIndex == index) {
                    list.add(new R(index, index + word.length() - 1));
                }
                index++;
            }
        }
        list.sort(new Comparator<R>() {
            @Override
            public int compare(R o1, R o2) {
                if(o1.start != o2.start) {
                    return o1.start - o2.start;
                }else {
                    return o1.end - o2.end;
                }
            }
        });
        int[][] arr = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i ++) {
            arr[i][0] = list.get(i).start;
            arr[i][1] = list.get(i).end;
        }
        return arr;
    }

}
