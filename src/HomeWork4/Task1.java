package HomeWork4;

// SimplifyPath

import java.util.ArrayDeque;
import java.util.Deque;

public class Task1 {

    public static void main(String[] args) {

        String path = "/home/../foo/"; //  -> /foo
        System.out.println(simplifyPath(path));
        System.out.println(simplifyPath("/../")); // -> /
        System.out.println(simplifyPath("/a/./b/../../c/"));  // -> /c

    }

    public static String simplifyPath(String path) {

        String[] tokens = path.split("/");

        Deque<String> dq = new ArrayDeque<>();

        for (String token : tokens) {
            if (token == "" || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!dq.isEmpty()) {
                    dq.removeLast();
                }
            } else {
                dq.addLast(token);
            }
        }

        if (dq.isEmpty()) return "/";

        StringBuilder newPath = new StringBuilder();
        while (!dq.isEmpty()) {
            newPath.append("/").append(dq.pollFirst());
        }

        return newPath.toString();
    }

}
