import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:arr) map.put(x,map.getOrDefault(x,0)+1);
        int ans=-1;
        for(int x:arr){
            if(map.get(x)==k){
                ans=x;
                break;
            }
        }
        System.out.println(ans);
    }
}
