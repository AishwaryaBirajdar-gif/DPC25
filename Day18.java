import java.util.Scanner;

public class DivisorCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  // Input number
        sc.close();
        
        int count = 0;
        
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;  // Perfect square, count only once
                } else {
                    count += 2;  // Pair of divisors
                }
            }
        }
        
        System.out.println(count);
    }
}
