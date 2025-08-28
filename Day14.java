import java.util.*;

public class Main {
    public static int countExactlyKDistinct(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    private static int countAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        int n = s.length(), left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            while (freq.size() > k) {
                char l = s.charAt(left++);
                freq.put(l, freq.get(l) - 1);
                if (freq.get(l) == 0) freq.remove(l);
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countExactlyKDistinct("pqpqs", 2));
        System.out.println(countExactlyKDistinct("aabacbebebe", 3));
        System.out.println(countExactlyKDistinct("a", 1));
        System.out.println(countExactlyKDistinct("abc", 3));
        System.out.println(countExactlyKDistinct("abc", 2));
    }
}
