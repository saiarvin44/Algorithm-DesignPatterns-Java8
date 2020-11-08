package algorithms.arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,1,4,7};
        int largest = arr[0];
        int secondLargest = arr[0];
        for(int i=0;i<5;i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]<largest)
                secondLargest = arr[i];
        }
        System.out.println(secondLargest);
    }
}
