import java.util.*;

public class Main {
    public static List<String> permute(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        back(res, new StringBuilder(), new boolean[arr.length], arr);
        return res;
    }

    private static void back(List<String> res, StringBuilder path, boolean[] used, char[] arr) {
        if (path.length() == arr.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;
            used[i] = true;
            path.append(arr[i]);
            back(res, path, used, arr);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permute("abc"));
        System.out.println(permute("aab"));
        System.out.println(permute("aaa"));
        System.out.println(permute("a"));
        System.out.println(permute("abcd"));
    }
}
