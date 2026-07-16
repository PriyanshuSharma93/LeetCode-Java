import java.util.*;

public class Solution{

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.simplifyPath("/home/"));              // /home
        System.out.println(obj.simplifyPath("/../"));                // /
        System.out.println(obj.simplifyPath("/home//foo/"));         // /home/foo
        System.out.println(obj.simplifyPath("/a/./b/../../c/"));     // /c
    }
}