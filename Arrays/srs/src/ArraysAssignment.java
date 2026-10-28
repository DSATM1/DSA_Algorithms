public class ArraysAssignment
{
//    Count how many numbers are odd and how many are even. Return both as [odd, even].
//    Input to the function: [3, 8, 5, 12, 7]
//    Return from the function: [3, 2]

    public static int[] countEvenOdd(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return new int[]{-1};
        }

        int countEven = 0;
        int countOdd = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                countEven++;
            }
            else
            {
                countOdd++;
            }
        }
        return new int []{countEven,countOdd};
    }

    public static void printCount()
    {
        int arr[] = {3};
        int res[] = countEvenOdd(arr);

        System.out.print("1 --> Even and Odd Count : [");
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
            if(i < res.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Given the marks of a student, return the average mark.
//    Input to the function: [70, 85, 90, 55]
//    Return from the function: 75.0

    static double avgMarks(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }
        int sum = 0;
        double avg = 0;

        for(int i = 0; i < arr.length; i++)
        {
            sum = sum + arr[i];
        }
        avg = sum / arr.length;
        return avg;
    }

    static void printAvgMarks()
    {
        int arr[] = {70, 85, 90, 55};
        double result = avgMarks(arr);
        System.out.println("2 --> Average Student Marks : " + result);
    }

//    Return all numbers that are greater than 50 and less than 100.
//    Input to the function: [45, 67, 100, 52, 99, 120, 50]
//    Return from the function: [67, 52, 99]

    public static int[] above50below100Numbers(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return new int[]{-1};
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 50 && arr[i] < 100)
            {
                count++;
            }
        }

        int newArray[] = new int[count];
        int resultIndex = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if ( arr[i] > 50 && arr[i] < 100)
            {
                newArray[resultIndex] = arr[i];
                resultIndex++;
            }
        }
        return newArray;
    }

    public static void print50and100()
    {
        int arr[] = {45, 67, 100, 52, 99, 120, 50};
        int result[] = above50below100Numbers(arr);

        System.out.print("3 --> Greater than 50 and Less than 100 : [");
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if(i < result.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return the difference between the largest and the smallest number.
//    Input to the function:  [14, 3, 27, 9]
//    Return from the function:  24

    public static int maxMinDifference(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int max = arr[0];
        int min = arr[0];

        int diff = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
            else if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        diff = max - min;
        return diff;
    }

    static void printDifference()
    {
//      int arr[] = {-10, -20, -5, -30};
        int arr[] = {14,3,27,9};
        int result = maxMinDifference(arr);
        System.out.println("4 --> Max Min Difference : " + result);

    }

//    Given marks of a class, return how many students passed. Pass mark is 35.
//    Input to the function: [40, 22, 35, 90, 18]
//    Return from the function: 3

    static int passedStudents(int arr[])
    {
        if(arr == null || arr.length == 9)
        {
            return -1;
        }

        int marks = 35;
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if ( arr[i] >= marks )
            {
                count++;
            }
        }
        return count;
    }

    static void printPassedStudents()
    {
        int arr[] = {40, 22, 35, 90, 18};
        int pass = passedStudents(arr);
        System.out.println("5 --> Passed Students In Exam : " + pass);
    }

//    Return the sum of the numbers at positions 0, 2, 4 and so on.
//    Input to the function: [10, 3, 20, 7, 30]
//    Return from the function: 60

    static int sumOfPositions(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    static void printPositionSum()
    {
        int arr[] = {10, 3, 20, 7, 30};
        int sum = sumOfPositions(arr);
        System.out.println("6 --> Sum of Given Position : " + sum);
    }

//    Given a week of temperatures, return how many days were hotter than the day before.
//    Input to the function: [30, 32, 31, 35, 36, 34, 37]
//    Return from the function: 4

    static int tempCompare(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int count = 0;

        for(int i = 1; i < arr.length; i++)
        {
            if( arr[i] > arr[i - 1])
            {
                count++;
            }
        }
        return count;
    }

    static void printTempComaparision()
    {
        int arr[] = {30, 32, 31, 35, 36, 34, 37};
        int temperature = tempCompare(arr);
        System.out.println("7 --> Week of Hotter Temperatures : " + temperature);
    }

//    Return a new array where every odd number is doubled and every even number is halved.
//    Input to the function: [4, 7, 10, 3]
//    Return from the function: [2, 14, 5, 6]

    static int[] oddDoubleEvenSingle(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return new int[]{-1};
        }

        int newArray[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++ )
        {
            if(arr[i] % 2 == 0)
            {
                newArray[i] = arr[i] / 2;
            }

            if (arr[i] % 2 == 1)
            {
                newArray[i] = arr[i] * 2;
            }
        }
        return newArray;
    }

    static void printDoubleAndHalf()
    {
        int arr[] = {4, 7, 10, 3};
        int newArray[] = oddDoubleEvenSingle(arr);

        System.out.print("8 --> Even Half and Odd Double : [");
        for(int i = 0; i < newArray.length; i++ )
        {
            System.out.print(newArray[i]);
            if(i < newArray.length - 1)
            {
                System.out.print("," );
            }
        }
        System.out.println("]");
    }

//    Return how many numbers are divisible by both 3 and 5.
//    Input to the function: [15, 9, 30, 10, 45, 7]
//    Return from the function: 3

    static int divisibleBy3And5(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 3 == 0 && arr[i] % 5 == 0)
            {
                count++;
            }
        }
        return count;
    }

    static void printDivisibleValue()
    {
        int arr[] = {15, 9, 30, 10, 45, 7};
        int div = divisibleBy3And5(arr);
        System.out.println("9 --> Elements Divisible by both 3 and 5 : " + div);
    }

//    Return the number that is closest to the average of the array.
//    Input to the function: [2, 9, 4, 15]
//    Return from the function: 9

    static int closestToAversfge(int arr[])
    {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }

        double avg = 0;
        int sum = 0;

        for(int i = 0; i < arr.length; i++)
        {
            sum = sum + arr[i];
        }
        avg = (double) sum  / arr.length;

        int closest = arr[0];
        double minDistance = closest - avg;

        if (minDistance < 0)
        {
            minDistance = -minDistance;
        }

        for (int i = 0; i < arr.length; i++)
        {
            double difference = arr[i] - avg;

            if (difference < 0)
            {
                difference = -difference;
            }

            if (difference < minDistance)
            {
                minDistance = difference;
                closest = arr[i];
            }
        }
        return closest;
    }

    static void printClosestValue()
    {
        int arr[] = {2, 9, 4, 15};
        int close = closestToAversfge(arr);
        System.out.println("10 --> Closest to Average : " + close);
    }

//    Given daily step counts, return how many days crossed 10,000 steps and the best day's steps, as [days, best].
//    Input to the function: [8000, 12000, 10500, 9000, 15000]
//    Return from the function: [3, 15000] //

    static int[] stepCount(int arr[])
    {
        int count = 0;
        int max = arr[0];

        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 10000)
            {
                count++;
            }
            if( arr[i] > max)
            {
                max = arr[i];
            }
        }
        return new int[] {count, max};
    }

    static void printStepCount()
    {
        int arr[] = {8000, 12000, 10500, 9000, 15000};
        int result[] = stepCount(arr);
        System.out.print("11 --> StepCount Highest Days And Best Streak : [");
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if(i < result.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return the array with every negative number replaced by 0.
//    Input to the function: [5, -3, 8, -1, 0]
//    Return from the function: [5, 0, 8, 0, 0]

    public static int[] replaceByZero(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0)
            {
                arr[i] = 0;
            }
        }
        return arr;
    }

    static void printNegativeByZero()
    {
        int arr[] = {5, -3, 8, -1, 0};
        int result[] = replaceByZero(arr);

        System.out.print("12 --> Replace Negative value By Zero : [");
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if(i < arr.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return true if the numbers are in increasing order, otherwise false.
//    Input to the function: [2, 5, 9, 14]
//    Return from the function: true

    static boolean increasingOrder(int arr[])
    {
        boolean first = true;

        for(int i = 0; i <= arr.length - 2; i++)
        {
            if(arr[i] >= arr[i + 1])
            {
                first = false;
            }
        }
        return first;
    }

    static void printIncreasingOrder()
    {
        int arr[] = {2,1};
        boolean result = increasingOrder(arr);
        System.out.println("13 --> Array is in Increasing Order : "+result);
    }

//    Return the sum of the first and the last number.
//    Input to the function: [7, 3, 9, 4]
//    Return from the function: 11

    static int sumOfFirstLast(int arr[])
    {
        if(arr == null)
        {
            return -1;
        }

        if(arr.length == 0)
        {
            return -1;
        }

        int sum = arr[0];

        for(int i = arr.length - 1; i >= 0; i--)
        {
           sum = sum + arr[i] ;
           break;
        }
        return sum;
    }

    static void printSumFirstlast()
    {
        int arr[] = {7, 3, 9, 4};
        int res = sumOfFirstLast(arr);
        System.out.println("14 --> Sum of First and last Element : " + res);
    }

//    Given prices of items in a shopping cart, give a 10% discount if the total is above 1000. Return
//    the amount to pay.
//    Input to the function: [400, 350, 450]
//    Return from the function: 1080

    static int getDiscountAmout(int arr[])
    {
        int sum = 0;
        int final_amt = 0;

        for(int x : arr)
        {
            sum = sum + x;
        }
        if(sum >= 1000)
        {
            int discount = sum * 10/100;
            final_amt = sum - discount;
        }
        return final_amt;
    }

    static void printDiscountAmt()
    {
        int arr[] = {400, 350, 450};
        int result = getDiscountAmout(arr);
        System.out.println("15 --> Discount Amount in Shopping Cart : " + result);
    }

//    Return how many numbers are palindromes (read the same both ways, like 121).
//    Input to the function: [121, 45, 7, 1331, 80]
//    Return from the function: 3

    static int countpalindrome(int arr[])
    {
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int revNum = 0;
            for(int j = arr[i]; j > 0; j = j / 10)
            {
                int lastDigit = j % 10;
                revNum = revNum * 10 + lastDigit;
            }
            if (revNum == arr[i])
            {
                count++;
            }
        }
        return count;
    }

    static void printCountPalindrome()
    {
        int arr[] = {121, 45, 7, 1331, 80,0,1,-1,12,234,323};
        int result = countpalindrome(arr);
        System.out.println("16 --> Palindrome Count in Array : " + result);
    }

//    Return a new array where each number is replaced by the sum of its digits.
//    Input to the function: [123, 45, 9]
//    Return from the function: [6, 9, 9]

    static int[] sumOfElements(int arr[])
    {
        int result[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            int total_sum = 0;
            for(int j = arr[i]; j > 0; j = j / 10 )
            {
                int lastDigit = j % 10;
                total_sum = total_sum + lastDigit;
            }
            result[i] = total_sum;
        }
        return result;
    }

    static void printSumOfElements()
    {
        int arr[] = {123, 45, 9};
        int res[] = sumOfElements(arr);
        System.out.print("17 --> Sum of Each Elements of the Array : [");
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
            if(i < res.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return how many times the sign changes from positive to negative or negative to positive.
//    Input to the function: [3, -2, -5, 4, 6, -1]
//    Return from the function: 3

    static int signCount(int arr[])
    {
        int count = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 0 || arr[i] < 0)
            {
                count++;
            }
        }
        return count;
    }

    static void printSignCount()
    {
        int arr[] = {3, -2, -5, 4, 6, -1};
        int result = signCount(arr);
        System.out.println("18 --> Count when Sign Changes : " + result);
    }



    public static void main(String[] args)
    {
        printCount();               // 1
        printAvgMarks();            // 2
        print50and100();            // 3
        printDifference();          // 4
        printPassedStudents();      // 5
        printPositionSum();         // 6
        printTempComaparision();    // 7
        printDoubleAndHalf();       // 8
        printDivisibleValue();      // 9
        printClosestValue();        // 10
        printStepCount();           // 11
        printNegativeByZero();      // 12
        printIncreasingOrder();     // 13
        printSumFirstlast();        // 14
        printDiscountAmt();         // 15
        printCountPalindrome();     // 16
        printSumOfElements();       // 17
        printSignCount();           // 18


    }
}