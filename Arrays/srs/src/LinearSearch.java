public class LinearSearch
{
    static boolean search(int arr[], int key)
    {
        if(arr == null || arr.length == 0)
        {
            return false;
        }
        for(int i =0; i < arr.length; i++)
        {
            if(arr[i] == key)
            {
                return true;
            }
        }
        return false;
    }

    static int countEvenNumbers(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }
        int count = 0;
        for(int i =0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                count++;
            }
        }
        return  count;
    }

    static void main(String[] args)
    {
        int arr[] = {10,20,30,40,50};
        int key = 300;
        boolean result = search(arr, key);
        System.out.println(key + " Not Present in array so it's : " + result);
        System.out.println();

        int count = countEvenNumbers(arr);
        System.out.println(count);
    }
}
