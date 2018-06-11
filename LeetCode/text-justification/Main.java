题目描述
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces' 'when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
For example,
words:["This", "is", "an", "example", "of", "text", "justification."]
L:16.
Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
import java.util.*;
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> list = new ArrayList<String>();
        if (words == null || words.length == 0){
            return list;
        }
        int n = words.length;
        int i = 0;
        while(i < n){
            int num = 0;
            int now = 0;
            int j = i;
            while(j < n && now + words[j].length() <= L){
                now+=words[j].length()+1;
                num++;
                j++;
            }
            int sum = 0;
            for(int k = i;k<j;k++){
            	sum+=words[k].length();
            }
            int gap = 1;
            int more = 0;
            if (j - i > 1 && j < n){
                gap = (L - sum)/(num - 1);
                more = (L - sum)%(num - 1);
            }
            StringBuilder space = new StringBuilder();
            for(int k = 1;k<=gap;k++){
                space.append(" ");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            for(int k = i + 1;k<j;k++){
                sb.append(space);
                if (more >= 1){
                    more--;
                    sb.append(" ");
                }
                sb.append(words[k]);
            }
            int len = sb.toString().length();
            for(int k = 1;k<=(L - len);k++){
                sb.append(" ");
            }
            list.add(new String(sb.toString()));
            i = j;
        }
        return list;
    }
}