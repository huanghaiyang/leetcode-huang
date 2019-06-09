package occurrencesAfterBigram;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by huang 6/9/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().findOcurrences(
                "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa",
                "jkypmsxd");
    }

    public String[] findOcurrences(String text, String first, String second) {
        Pattern pattern = Pattern.compile(first + " " + second + "\\s" + "\\w+");
        List<String> result = new ArrayList<>();
        while(true) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                if(matcher.start() == 0) {
                    result.add(text.substring(matcher.start() + first.length() + second.length() + 2, matcher.end()));
                }
                text = text.substring(1, text.length());
            }else {
                break;
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
