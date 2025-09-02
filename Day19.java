import java.util.*;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        sc.close();
        
        System.out.println(evalPostfix(exp));
    }

    public static int evalPostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        String[] tokens = exp.trim().split("\\s+");

        for (String t : tokens) {
            if (isNumber(t)) {
                st.push(Integer.parseInt(t));
            } else {
                int b = st.pop();
                int a = st.pop();
                int res = 0;

                switch (t) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": 
                        res = a / b;   
                        break;
                }
                st.push(res);
            }
        }
        return st.pop();
    }

    private static boolean isNumber(String s) {
        if (s.length() == 1 && !Character.isDigit(s.charAt(0)) && s.charAt(0) != '-') {
            return false;
        }
        return true;
    }
}
