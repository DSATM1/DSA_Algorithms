public class PrintCentertoEnd
{
    static void printValuesCenterToEnd(int arr[])
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
        while (left >= 0 && right <= arr.length-1)
        {
            if(left == right)
            {
                System.out.println("( " + arr[right] + " ) " + "Single Value ");
            }
            else
            {
                System.out.print("( " + arr[left] + " -> " + arr[right] + " )");
            }
            left--;
            right++;
        }

    }

    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,6,7};
        printValuesCenterToEnd(arr);
    }
}
