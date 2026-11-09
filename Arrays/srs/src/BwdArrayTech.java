public class BwdArrayTech
{
    static void countEven()
    {
        int count = 0;
        int arr[] = {3,2,5,6,0,1,2};
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i] % 2 == 0)
            {
                count++;
            }
        }
        System.out.println("Count of Even Numbers : " + count);
    }

    static void getNegativeNumber()
    {
        int arr[] = {0,1,-2,23,12,0,12,-99};

        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i] < 0)
            {
                System.out.println("First Negative number : " + arr[i]);
                break;
            }
        }
    }

    static int positiveNumber()
    {
        int lastOccurance = 0;
        int arr[] = {1,2,3,0,-1,-1,0};
        for(int i = arr.length - 1; i >= 0;i--)
        {
            if(arr[i] > 0)
            {
                lastOccurance = arr[i];
            }
        }
        return lastOccurance;
    }

    static int lastOccurance()
    {
        int arr[] = {1,2,3,4,5};
        int key = 4;
        int occurance = 0;

        for(int i = arr.length - 1; i >= 0; i--)
        {
            if( arr[i] == key)
            {
                occurance = i;
            }
        }
        return occurance;
    }

    static void maxValue(int arr[], int key)
    {
        int max = 0;
        int a = 0;
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i] > key)
            {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static void main(String[] args)
    {
        countEven();
        getNegativeNumber();
        System.out.println("Last Positive Number : " + positiveNumber());
        System.out.println("Index Value of Occured Key : " + lastOccurance());

        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        int key = 5;
        System.out.print("Max Value above the given Elements : ");
        maxValue(arr,key);
    }
}
