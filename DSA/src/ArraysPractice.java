public class ArraysPractice
{
    static void leftToRight(int arr[])
    {
        for (int i = 0; i< arr.length; i++)
        {
            System.out.print(arr[i]);

            if(i < arr.length - 1)
            {
                System.out.print(" -> ");
            }
        }
    }

    static void rightToLeft(int arr[])
    {
        for (int i = arr.length - 1; i >= 0; i--)
        {
            System.out.print(arr[i]);

            if(i > 0)
            {
                System.out.print(" <- ");
            }
        }
    }

    static void edgeToCenter(int arr[])
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right&& right >= (arr.length - 1) / 2)
        {
            System.out.print("( " + arr[left] + " -> ");
            left ++;
            System.out.print(arr[right] + " )");
            right --;
        }
    }

    static void main()
    {
        int arr[] = {10,20,30,40,50,60,70,80,90};
        leftToRight(arr);
        System.out.println();
        rightToLeft(arr);
        System.out.println();
        edgeToCenter(arr);
    }
}
