import java.util.*;

public class StackSort {
    public static void sort(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int x = st.pop();
            sort(st);
            insert(st, x);
        }
    }

    private static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || x < st.peek()) {
            st.push(x);
            return;
        }
        int y = st.pop();
        insert(st, x);
        st.push(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }
        sort(st);
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
