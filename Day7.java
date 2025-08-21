public class RainWaterCollector {

    public static int calculateWater(int[] bars) {
        if (bars == null || bars.length < 3) return 0;

        int start = 0, end = bars.length - 1;
        int maxLeft = 0, maxRight = 0;
        int totalWater = 0;

        while (start < end) {
            if (bars[start] < bars[end]) {
                if (bars[start] >= maxLeft) {
                    maxLeft = bars[start];
                } else {
                    totalWater += maxLeft - bars[start];
                }
                start++;
            } else {
                if (bars[end] >= maxRight) {
                    maxRight = bars[end];
                } else {
                    totalWater += maxRight - bars[end];
                }
                end--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calculateWater(arr1)); 

        int[] arr2 = {4, 2, 0, 3, 2, 5};
        System.out.println(calculateWater(arr2)); 

        int[] arr3 = {1, 1, 1};
        System.out.println(calculateWater(arr3)); 

        int[] arr4 = {5};
        System.out.println(calculateWater(arr4)); 

        int[] arr5 = {2, 0, 2};
        System.out.println(calculateWater(arr5)); 
    }
}
