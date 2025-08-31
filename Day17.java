import java.util.*;

public class PrimeFactors {
    public static List<Integer> getFactors(int n) {
        List<Integer> res = new ArrayList<>();
        while (n % 2 == 0) {
            res.add(2);
            n /= 2;
        }
        for (int i = 3; i * 1L * i <= n; i += 2) {
            while (n % i == 0) {
                res.add(i);
                n /= i;
            }
        }
        if (n > 2) res.add(n);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFactors(n));
        sc.close();
    }
}
