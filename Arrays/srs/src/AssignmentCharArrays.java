public class AssignmentCharArrays
{
    static int claculateWriteIndex(char arr[])
    {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] >= '2' && arr[i] <= '9')
            {
                count = count + (arr[i] -'0') - 1;
            }
            else
            {
                count++;
            }
        }
        return count - 1;
    }

    static int copyFromRightToleft(char arr[], char ch, int count, int writeIndex)
    {
        while(count > 0)
        {
            arr[writeIndex] = ch;
            writeIndex--;
            count--;
        }
        return writeIndex;
    }

    static void expandString(char arr[])
    {
        int writeIndex = claculateWriteIndex(arr);
        int readIndex = arr.length - 1;

        while (writeIndex >= 0)
        {
            if(arr[readIndex] >= '2' && arr[readIndex] <= '9')
            {
                int count = arr[readIndex] - '0';
                writeIndex = copyFromRightToleft(arr, arr[readIndex - 1], count, writeIndex);
            }
            else
            {
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex--;
        }
    }

    public static void main(String[] args)
    {
        char arr[] = {'a','3','b','2','c'};
        expandString(arr);
        System.out.print("a3b2c : [");
        for(int i = 0; i< arr.length; i++)
        {
            System.out.print(arr[i]);
            if(i <arr.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}


































































































































//    static char[] expandArray(char ch[])
//    {
//        int readIndex = 4;
//        int writeIndex = 5;
//
//        while(readIndex >= 0)
//        {
//            if(ch[readIndex] >= '0' && ch[readIndex] <= '9')
//            {
//                int count = 0;
//                count = ch[readIndex] - '0';
//                char letter = ch[readIndex - 1];
//
//                for(int i = 0; i < count; i++)
//                {
//                    ch[writeIndex] = letter;
//                    writeIndex--;
//                }
//                readIndex = readIndex - 2;
//            }
//            else
//            {
//                ch[writeIndex] = ch[readIndex];
//                readIndex--;
//                writeIndex--;
//            }
//        }
//        return ch;
//    }
//
//    static void printexpandedArray()
//    {
//        char ch[] = {'a','4','b','2','c','\0'};
//        char result[] = expandArray(ch);
//
//        System.out.print("a3b2c : [");
//        for(int i = 0; i< result.length; i++)
//        {
//            System.out.print(result[i]);
//            if(i < result.length - 1)
//            {
//                System.out.print(",");
//            }
//        }
//        System.out.println("]");
//    }
//
//
//    static void main(String[] args)
//    {
//        printexpandedArray();
//    }
