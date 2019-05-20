package reverseWordsInAString;

/**
 * created by huang 5/9/19
 */
public class Solution {

    public static void main(String[] args) {
        String s = reverseWords(" a");
        System.out.print(s);
    }

    public static String reverseWords(String s) {
        if(s == null) {
            return null;
        }
        String result = "";
        String newWord = "";
        int blankCount = 0;
        Boolean isFirstWord = true;
        for(int i = s.length() - 1 ; i >= 0 ; i --) {
            char t = s.charAt(i);
            if(t == ' ') {
                if(blankCount == 0) {
                    if(!isFirstWord) {
                        result = result + " ";
                    }
                    if(newWord != "") {
                        result += newWord;
                        isFirstWord = false;
                    }
                }
                newWord = "";
                blankCount ++;
            }else {
                blankCount = 0;
                newWord = t + newWord;
            }
        }
        if(newWord != "") {
            if(result != "") {
                result = result + " " + newWord;
            }else {
                result = newWord;
            }
        }
        return result;
    }
}
