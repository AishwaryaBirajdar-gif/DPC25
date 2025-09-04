import java.util.*;

public class Main {
    static void put(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return;
        }
        int y = s.pop();
        put(s, x);
        s.push(y);
    }

    static void rev(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int x = s.pop();
        rev(s);
        put(s, x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) s.push(sc.nextInt());
        rev(s);
        System.out.println(s);
    }
}
