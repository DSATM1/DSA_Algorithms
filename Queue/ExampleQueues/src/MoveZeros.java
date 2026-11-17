public class MoveZeros
{
    static void removeZerosAtStart(int arr[])
    {
        int firstNonZero = 0;
        int index = 0;
        while (index < arr.length)
        {
            if(arr[index] != 0)
                break;
            firstNonZero++;
            index++;
        }

        int writeIndex = 0;
        int readIndex = firstNonZero;

        while(index < arr.length)
        {
            arr[writeIndex] = arr[readIndex];
            writeIndex++;
            readIndex++;
            index++;
        }

        while (writeIndex < arr.length)
        {
            arr[writeIndex] = 0;
            writeIndex++;
        }
    }

    static void main(String[] args)
    {
        //int arr[] = {0,0,0,0,1,2,3,4,5};

        //int arr[] = {0,1,2,3,4};

        //int arr[] = {1,2,3};

        int arr[] = {0,0,0};
        removeZerosAtStart(arr);
        for (int x : arr)
            System.out.print(x + " ");
    }
}
