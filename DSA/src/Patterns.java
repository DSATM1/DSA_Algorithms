public class Patterns
{
        static void printLeftToRight(int arr[])
        {
            for(int i = 0; i< arr.length; i++)
            {
                System.out.print(arr[i]);

                if( i  < arr.length - 1)
                {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

        static void printRightToLeft(int arr[])
        {
            for(int i = arr.length - 1; i >= 0; i--)
            {
                System.out.print(arr[i]);


                if( i > 0)
                {
                    System.out.print(" <- ");
                }
            }
            System.out.println();
        }

        static void printFromBothSides(int arr[])
        {
            int left = 0;
            int right = arr.length - 1;

            while (left <= right)
            {
                System.out.print(arr[left] + " -> ");
                left++;
                System.out.print(arr[right] + " <- ");
                right--;
            }
            System.out.println();
        }

        static void printFromCenterTowardsEnd(int arr[])
        {
            int right = 0;
            int left = 0;

            if ( arr.length % 2 == 0)
            {
                right = arr.length / 2;
                left = right - 1;

//                while (left >= 0)
//                {
//                    System.out.println(arr[left] + " -> "+ arr[right]);
//                    left --;
//                    right ++;
//                }
            }
            else
            {
                right = arr.length / 2;
                left = arr.length / 2;

//                while (left >= 0)
//                {
//                    if ( left == right)
//                    {
//                        System.out.println(arr[left]);
//                    }
//                    else
//                    {
//                        System.out.println(arr[left] + " -> " + arr[right]);
//                    }
//                    left--;
//                    right++;
//                }
            }

            while (left >= 0 && right <= arr.length - 1)
            {
                if(left == right)
                {
                    System.out.println(arr[left] + " -> ");
                }
                else
                {
                    System.out.println(arr[left] + arr[right] + " -> ");
                }
                left --;
                right ++;
            }
        }

        public static void main(String [] suraj)
        {
            int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
            printLeftToRight(arr);
            printRightToLeft(arr);
//            printFromBothSides(arr);
//            printFromCenterTowardsEnd(arr);
        }
    }

