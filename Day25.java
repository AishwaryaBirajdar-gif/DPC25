import java.util.*;

class Main {
    static class N {
        int v;
        N l, r;
        N(int v) { this.v = v; }
    }

    static N buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) return null;
        N root = new N(Integer.parseInt(arr[0]));
        Queue<N> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            N n = q.poll();
            if (i < arr.length && !arr[i].equals("null")) {
                n.l = new N(Integer.parseInt(arr[i]));
                q.add(n.l);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                n.r = new N(Integer.parseInt(arr[i]));
                q.add(n.r);
            }
            i++;
        }
        return root;
    }

    static boolean isBst(N n, long min, long max) {
        if (n == null) return true;
        if (n.v <= min || n.v >= max) return false;
        return isBst(n.l, min, n.v) && isBst(n.r, n.v, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        s = s.replaceAll("\\[|\\]", "");
        String[] arr = s.split(",");
        for (int i = 0; i < arr.length; i++) arr[i] = arr[i].trim();
        N root = buildTree(arr);
        System.out.println(isBst(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
