题目描述
Given an absolute path for a file (Unix-style), simplify it.
For example,
path ="/home/", =>"/home"
path ="/a/./b/../../c/", =>"/c"
click to show corner cases.
import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1){
            return path;
        }
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        set.add("");
        set.add(".");
        set.add("..");
        String[] s = path.split("/");
        for(String t : s){
            if (!set.contains(t)){
                stack.push("/" + t);
                continue;
            }
            if (!stack.isEmpty() && t.equals("..")){
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String t : stack){
            sb.append(t);
        }
        return sb.toString();
    }
}