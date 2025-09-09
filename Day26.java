import java.util.*;

public class Main {
    static boolean dfs(int u, int p, List<List<Integer>> g, boolean[] vis) {
        vis[u] = true;
        for (int v : g.get(u)) {
            if (!vis[v]) {
                if (dfs(v, u, g, vis)) return true;
            } else if (v != p) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        boolean cycle = false;
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(i, -1, g, vis)) {
                cycle = true;
                break;
            }
        }
        System.out.println(cycle);
    }
}
