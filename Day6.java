import java.util.*;

public class ZeroSumFinder {

    public static List<int[]> zeroSumSubarrays(int[] arr) {
        List<int[]> ans = new ArrayList<>();
        Map<Long, List<Integer>> prefixMap = new HashMap<>();
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                ans.add(new int[]{0, i});
            }

            if (prefixMap.containsKey(sum)) {
                for (int start : prefixMap.get(sum)) {
                    ans.add(new int[]{start + 1, i});
                }
            }

            prefixMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, -3, 3, -1, 2};
        int[] a2 = {4, -1, -3, 1, 2, -1};
        int[] a3 = {0, 0, 0};

        System.out.println(printAns(zeroSumSubarrays(a1))); 
        System.out.println(printAns(zeroSumSubarrays(a2))); 
        System.out.println(printAns(zeroSumSubarrays(a3))); 
    }

    private static String printAns(List<int[]> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] p : list) {
            sb.append("(").append(p[0]).append(", ").append(p[1]).append("), ");
        }
        if (!list.isEmpty()) sb.setLength(sb.length() - 2); 
        sb.append("]");
        return sb.toString();
    }
}
