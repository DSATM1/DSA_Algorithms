public class Array_PPPPP
{
    static void printCenterToEnd(int arr[])
    {
        int left = 0;
        int right = 0;

        if(arr.length % 2 == 0)
        {
            right = arr.length / 2;
            left = right - 1;
        }
        else
        {
            right = arr.length / 2;
            left = arr.length / 2;
        }
        while ( left >= 0 && right <= arr.length - 1)
        {
            if(arr[left]  == arr[right])
            {
                System.out.print(arr[right] + " -> ");
            }
            else
            {
                System.out.println(arr[left]  + " -> " + arr[right]);
            }
            left --;
            right ++;
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {10,20,30,40,50,60};
        printCenterToEnd(arr);
    }
}
