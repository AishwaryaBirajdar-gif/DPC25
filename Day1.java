import java.util.Arrays;

class Sorting{
    public static void main(String args[]){
        int [] arr={0,1,2,1,0,2,1,0};
         dutchnationalflagalgo(arr);
         System.out.println(Arrays.toString(arr));

         int[]arr2={2,2,2,2};
         dutchnationalflagalgo(arr2);
         System.out.println(Arrays.toString(arr2));

         int[]arr3={2,0,1};
         dutchnationalflagalgo(arr3);
         System.out.println(Arrays.toString(arr3));
         
         int[] arr4 = {};
          dutchnationalflagalgo(arr4);
         System.out.println(Arrays.toString(arr4));
    }

    static void dutchnationalflagalgo(int[]arr){
        int low = 0;
        int mid = 0;
        int high= arr.length-1;

        while(mid<=high){

            if(arr[mid]==0){
              int temp = arr[mid];
              arr[mid]=arr[low];
              arr[low]=temp;
              low++;
              mid++;

            }else if(arr[mid]==1){
              mid++;
            }else{
                int temp = arr[high];
               arr[high]= arr[mid];
               arr[mid]=temp;
               high--;

            }
        }
    }
}
