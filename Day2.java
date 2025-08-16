public class MissingNumber{
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        System.out.println(findMissingNumber(arr1));

        int[] arr2 = {2, 3, 4, 5};
        System.out.println(findMissingNumber(arr2));

        int[] arr3 = {1, 2, 3, 4};
        System.out.println( findMissingNumber(arr3)); 

        int[] arr4 = {1};
        System.out.println( findMissingNumber(arr4)); 

        int[] arr5 = new int[999999];
        
        for (int i = 0; i < 999999; i++) {
            arr5[i] = i + 1;
        }
        System.out.println(findMissingNumber(arr5));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;

        int totalSum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return totalSum - arrSum;
    }
}
