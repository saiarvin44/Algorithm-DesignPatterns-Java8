package algorithms.arrays;

public class ZerosToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,0,4,0,5,0,0,0,6};
        int count=0;
        int temp=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                temp = arr[i];
                arr[i]=arr[count];
                arr[count]=temp;
                count++;
            }
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }
}
