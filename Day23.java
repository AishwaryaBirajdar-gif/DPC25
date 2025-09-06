import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] ans = slideMax(a, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static int[] slideMax(int[] a, int k) {
        int n = a.length;
        int[] out = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                out[i - k + 1] = a[dq.peekFirst()];
            }
        }
        return out;
    }
}
