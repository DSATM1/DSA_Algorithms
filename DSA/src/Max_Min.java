import java.util.Arrays;

public class Max_Min
{
    static void printArray(int arr[])
    {
        System.out.print("Array : ");

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i < arr.length - 1)
            {
                System.out.print(",");
            }
        }
//        System.out.println();
    }
    static void Largest(int arr[])
    {
        int large = arr[0];
        for ( int i = 0; i <= arr.length - 1; i++)
        {
            if(arr[i] > large)
            {
                large = arr[i];
            }
        }
        System.out.println();
        System.out.println("Largest Element in Given Array : " + large );
    }

    static void Smallest(int arr[])
    {
        int small = arr[0];
        for(int i = 0 ; i <= arr.length - 1; i++)
        {
            if(arr[i] < small)
            {
                small = arr[i];
            }
        }
        System.out.println("Smallest Element in Given Array : " + small);
    }

    public static void main(String[] args)
    {
        int arr[] = {12,5,89,34,2,45};

        printArray(arr);
        Largest(arr);
        Smallest(arr);
    }
}