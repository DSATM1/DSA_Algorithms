public class AI2
/*
 * ArraysAssignment - all 25 questions, examples and automated tests.
 * Run: javac ArraysAssignment.java && java ArraysAssignment
 * Or with Java 11+: java ArraysAssignment.java
 *
 * INPUT RULES (the PDF does not specify these edge cases):
 * - null is invalid: throw IllegalArgumentException with a useful message.
 * - Empty arrays: counts/sums = 0; transformations = []; increasing = true.
 * - Q2, Q4, Q10, Q11, Q14, Q19 and each Q25 array must be nonempty.
 * - Q20, Q21, Q23 require matching lengths; Q22 permits different lengths.
 * - Q24 permits different lengths and empty individual score arrays (total 0),
 *   but rejects three empty arrays because there is no match data.
 * - Ties: first closest value, earliest over, lowest player number wins.
 * - Q13 is STRICTLY increasing. Q14 counts a single element twice.
 * - Q16: zero is a palindrome; negative numbers are not.
 * - Q17: sum digits of the magnitude, including Integer.MIN_VALUE.
 * - Q18: compare adjacent entries only; zero is neither positive nor negative.
 * - Q22 preserves order AND duplicates from the first array.
 * - Prices, steps and cricket runs/scores cannot be negative. Other questions
 *   accept all int values (no unspecified upper limit on marks is imposed).
 * - long sums/results avoid int overflow. Q8 returns long[]. Q2/Q25 return
 *   fractional averages; Q15 returns a double amount (no integer truncation).
 * - Q12 intentionally modifies and returns the input; other functions do not.
 *
 * The solving functions use loops and manual comparisons, not streams,
 * collections, sorting helpers or Math.abs. The test runner catches errors
 * so one bad input does not stop the remaining tests.
 */
{
//    Count how many numbers are odd and how many are even. Return both as [odd, even].
//    Input to the function: [3, 8, 5, 12, 7]
//    Return from the function: [3, 2]

    public static int[] countEvenOdd(int[] arr)
    {
        requireArray(arr);
        int odd = 0, even = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0) even++;
            else odd++;
        }
        return new int[]{odd, even};
    }

    public static void printCount()
    {
        printResult(1, "Odd and Even Count [odd, even]", countEvenOdd(new int[]{3,8,5,12,7}));
    }

//    Given the marks of a student, return the average mark.
//    Input to the function: [70, 85, 90, 55]
//    Return from the function: 75.0

    public static double avgMarks(int[] arr)
    {
        requireNonempty(arr);
        return (double) sumArray(arr) / arr.length;
    }

    public static void printAvgMarks()
    {
        printResult(2, "Average Student Marks", avgMarks(new int[]{70,85,90,55}));
    }

//    Return all numbers that are greater than 50 and less than 100.
//    Input to the function: [45, 67, 100, 52, 99, 120, 50]
//    Return from the function: [67, 52, 99]

    public static int[] above50below100Numbers(int arr[])
    {
        requireArray(arr);

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
        printResult(3, "Greater than 50 and Less than 100", above50below100Numbers(new int[]{45,67,100,52,99,120,50}));
    }

//    Return the difference between the largest and the smallest number.
//    Input to the function:  [14, 3, 27, 9]
//    Return from the function:  24

    public static long maxMinDifference(int[] arr)
    {
        requireNonempty(arr);
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        return (long) max - min;
    }

    public static void printDifference()
    {
        printResult(4, "Max Min Difference", maxMinDifference(new int[]{14,3,27,9}));
    }

//    Given marks of a class, return how many students passed. Pass mark is 35.
//    Input to the function: [40, 22, 35, 90, 18]
//    Return from the function: 3

    static int passedStudents(int arr[])
    {
        requireArray(arr);

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

    public static void printPassedStudents()
    {
        printResult(5, "Passed Students in Exam", passedStudents(new int[]{40,22,35,90,18}));
    }

//    Return the sum of the numbers at positions 0, 2, 4 and so on.
//    Input to the function: [10, 3, 20, 7, 30]
//    Return from the function: 60

    public static long sumOfPositions(int[] arr)
    {
        requireArray(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i += 2) sum += arr[i];
        return sum;
    }

    public static void printPositionSum()
    {
        printResult(6, "Sum at Positions 0, 2, 4, ...", sumOfPositions(new int[]{10,3,20,7,30}));
    }

//    Given a week of temperatures, return how many days were hotter than the day before.
//    Input to the function: [30, 32, 31, 35, 36, 34, 37]
//    Return from the function: 4

    static int tempCompare(int arr[])
    {
        requireArray(arr);

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

    public static void printTempComaparision()
    {
        printResult(7, "Days Hotter than Previous Day", tempCompare(new int[]{30,32,31,35,36,34,37}));
    }

//    Return a new array where every odd number is doubled and every even number is halved.
//    Input to the function: [4, 7, 10, 3]
//    Return from the function: [2, 14, 5, 6]

    public static long[] oddDoubleEvenSingle(int[] arr)
    {
        requireArray(arr);
        long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0) result[i] = arr[i] / 2;
            else result[i] = (long) arr[i] * 2;
        }
        return result;
    }

    public static void printDoubleAndHalf()
    {
        printResult(8, "Even Half and Odd Double", oddDoubleEvenSingle(new int[]{4,7,10,3}));
    }

//    Return how many numbers are divisible by both 3 and 5.
//    Input to the function: [15, 9, 30, 10, 45, 7]
//    Return from the function: 3

    static int divisibleBy3And5(int arr[])
    {
        requireArray(arr);

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

    public static void printDivisibleValue()
    {
        printResult(9, "Divisible by Both 3 and 5", divisibleBy3And5(new int[]{15,9,30,10,45,7}));
    }

//    Return the number that is closest to the average of the array.
//    Input to the function: [2, 9, 4, 15]
//    Return from the function: 9

    public static int closestToAversfge(int[] arr)
    {
        requireNonempty(arr);
        long sum = sumArray(arr);
        int closest = arr[0];
        // Compare scaled distances exactly, without rounding the average.
        long best = (long) closest * arr.length - sum;
        if (best < 0) best = -best;
        for (int i = 1; i < arr.length; i++)
        {
            long distance = (long) arr[i] * arr.length - sum;
            if (distance < 0) distance = -distance;
            if (distance < best)
            {
                best = distance;
                closest = arr[i];
            }
        }
        return closest;
    }

    public static void printClosestValue()
    {
        printResult(10, "Closest to Average", closestToAversfge(new int[]{2,9,4,15}));
    }

//    Given daily step counts, return how many days crossed 10,000 steps and the best day's steps, as [days, best].
//    Input to the function: [8000, 12000, 10500, 9000, 15000]
//    Return from the function: [3, 15000] //

    static int[] stepCount(int arr[])
    {
        requireNonempty(arr);
        requireNonnegative(arr);
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

    public static void printStepCount()
    {
        printResult(11, "Steps [days above 10000, best]", stepCount(new int[]{8000,12000,10500,9000,15000}));
    }

//    Return the array with every negative number replaced by 0.
//    Input to the function: [5, -3, 8, -1, 0]
//    Return from the function: [5, 0, 8, 0, 0]

    public static int[] replaceByZero(int arr[])
    {
        requireArray(arr);
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0)
            {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static void printNegativeByZero()
    {
        printResult(12, "Replace Negative Values by Zero", replaceByZero(new int[]{5,-3,8,-1,0}));
    }

//    Return true if the numbers are in increasing order, otherwise false.
//    Input to the function: [2, 5, 9, 14]
//    Return from the function: true

    static boolean increasingOrder(int arr[])
    {
        requireArray(arr);
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

    public static void printIncreasingOrder()
    {
        printResult(13, "Strictly Increasing Order", increasingOrder(new int[]{2,5,9,14}));
    }

//    Return the sum of the first and the last number.
//    Input to the function: [7, 3, 9, 4]
//    Return from the function: 11

    public static long sumOfFirstLast(int[] arr)
    {
        requireNonempty(arr);
        return (long) arr[0] + arr[arr.length - 1];
    }

    public static void printSumFirstlast()
    {
        printResult(14, "Sum of First and Last Element", sumOfFirstLast(new int[]{7,3,9,4}));
    }

//    Given prices of items in a shopping cart, give a 10% discount if the total is above 1000. Return
//    the amount to pay.
//    Input to the function: [400, 350, 450]
//    Return from the function: 1080

    public static double getDiscountAmout(int[] arr)
    {
        requireNonnegative(arr);
        long total = sumArray(arr);
        if (total > 1000) return total * 0.9;
        return total;
    }

    public static void printDiscountAmt()
    {
        printResult(15, "Shopping Cart Amount to Pay", getDiscountAmout(new int[]{400,350,450}));
    }

//    Return how many numbers are palindromes (read the same both ways, like 121).
//    Input to the function: [121, 45, 7, 1331, 80]
//    Return from the function: 3

    public static int countpalindrome(int[] arr)
    {
        requireArray(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 0) continue;
            long reversed = 0;
            int remaining = arr[i];
            while (remaining > 0)
            {
                reversed = reversed * 10 + remaining % 10;
                remaining /= 10;
            }
            if (reversed == arr[i]) count++;
        }
        return count;
    }

    public static void printCountPalindrome()
    {
        printResult(16, "Palindrome Count", countpalindrome(new int[]{121,45,7,1331,80}));
    }

//    Return a new array where each number is replaced by the sum of its digits.
//    Input to the function: [123, 45, 9]
//    Return from the function: [6, 9, 9]

    public static int[] sumOfElements(int[] arr)
    {
        requireArray(arr);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            long remaining = arr[i];
            if (remaining < 0) remaining = -remaining;
            while (remaining > 0)
            {
                result[i] += (int) (remaining % 10);
                remaining /= 10;
            }
        }
        return result;
    }

    public static void printSumOfElements()
    {
        printResult(17, "Sum of Digits of Each Element", sumOfElements(new int[]{123,45,9}));
    }

//    Return how many times the sign changes from positive to negative or negative to positive.
//    Input to the function: [3, -2, -5, 4, 6, -1]
//    Return from the function: 3

    static int signCount(int arr[])
    {
        requireArray(arr);
        int count = 0;
        int i = 0;
        int j = 1;

        while(j < arr.length)
        {
            if(arr[i] > 0 && arr[j] < 0)
                count++;
            if(arr[i] < 0 && arr[j] > 0)
                count++;
            i++;
            j++;
        }
        return count;
    }

    public static void printSignCount()
    {
        printResult(18, "Adjacent Sign Changes", signCount(new int[]{3,-2,-5,4,6,-1}));
    }

//    Given runs scored in each over of a cricket match,return the over number (starting from 1) with the most runs.
//    Input to the function:  [6, 12, 4, 15, 9]
//    Return from the function:  4

    static int getOver(int arr[])
    {
        requireNonempty(arr);
        requireNonnegative(arr);
        int over = 1;
        int max = arr[0];

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                over = i + 1;
            }
        }
        return over;
    }

    public static void printCricketOver()
    {
        printResult(19, "Over with Highest Runs", getOver(new int[]{6,12,4,15,9}));
    }

//    Given Ravi's and Sita's marks in the same five subjects, return in how many subjects Ravi scored more than Sita.
//    Input to the function:  [78, 65, 90, 55, 82] and [70, 80, 85, 60, 82]
//    Return from the function:  2

    static int countHighestMarks(int ravi[], int sita[])
    {
        requireSameLength(ravi, sita);
        int count = 0;
        for(int i = 0; i < ravi.length; i++)
        {
            if (ravi[i] > sita[i])
            {
                count++;
            }
        }
        return count;
    }

    public static void printRaviMarks()
    {
        printResult(20, "Subjects Where Ravi Scored More", countHighestMarks(new int[]{78,65,90,55,82}, new int[]{70,80,85,60,82}));
    }

//    Given two arrays of the same length, return a new array with the bigger number at each position.
//    Input to the function: [4, 9, 2, 7] and [6, 3, 8, 7]
//    Return from the function: [6, 9, 8, 7]

    static int[] getBigNumber(int a1[], int a2[])
    {
        requireSameLength(a1, a2);
        int max = 0;

        int result[] = new int[a1.length];

        for(int i = 0; i < a1.length; i++)
        {
            if(a1[i] > a2[i])
            {
                max = a1[i];
            }
            else
            {
                max = a2[i];
            }
            result[i] = max;
        }

        return result;
    }

    public static void printBigNumber()
    {
        printResult(21, "Bigger Number at Each Position", getBigNumber(new int[]{4,9,2,7}, new int[]{6,3,8,7}));
    }

//    Return the numbers in the first array that are not present in the second array.
//    Input to the function: [1, 4, 6, 8, 10] and [4, 8, 12]
//    Return from the function: [1, 6, 10]


    static int[] getElementsFromFirstArray(int a1[], int a2[])
    {
        requireArray(a1);
        requireArray(a2);
        int count = 0;
        for(int i = 0; i < a1.length; i++)
        {
            boolean found = false;
            for(int j = 0; j < a2.length; j++)
            {
                if(a1[i] == a2[j])
                {
                    found = true;
                }
            }
            if(found == false)
            {
                count++;
            }
        }

        int result[] = new int[count];
        int position = 0;

        for(int i = 0; i < a1.length; i++)
        {
            boolean found = false;
            for(int j = 0; j < a2.length; j++)
            {
                if(a1[i] == a2[j])
                {
                    found = true;
                }
            }

            if (found == false)
            {
                result[position] = a1[i];
                position++;
            }
        }
        return result;
    }

    public static void printFirstElements()
    {
        printResult(22, "First Array Values Absent in Second", getElementsFromFirstArray(new int[]{1,4,6,8,10}, new int[]{4,8,12}));
    }

//    Given prices of the same items at Shop A and Shop B, return how much money is saved by
//    buying each item at the cheaper shop instead of buying everything at Shop A.
//    Input to the function: [100, 250, 80, 40] and [90, 260, 70, 45]
//    Return from the function: 20

    public static long getCheapItems(int[] shop1, int[] shop2)
    {
        requireSameLength(shop1, shop2);
        requireNonnegative(shop1);
        requireNonnegative(shop2);
        long saved = 0;
        for (int i = 0; i < shop1.length; i++)
        {
            // Save only when Shop B is cheaper than Shop A for this item.
            if (shop2[i] < shop1[i]) saved += (long) shop1[i] - shop2[i];
        }
        return saved;
    }

    public static void printCheapItems()
    {
        printResult(23, "Savings Compared with Shop A", getCheapItems(new int[]{100,250,80,40}, new int[]{90,260,70,45}));
    }

//    Given the scores of three players across matches, return which player (1, 2 or 3) has the highest total.
//    Input to the function:  [30, 45, 20], [50, 10, 40] and [25, 35, 30]
//    Return from the function:  2

    public static int getHighestScoredPlayer(int[] dhoni, int[] virat, int[] rohit)
    {
        requireNonnegative(dhoni);
        requireNonnegative(virat);
        requireNonnegative(rohit);
        if (dhoni.length == 0 && virat.length == 0 && rohit.length == 0)
            throw new IllegalArgumentException("At least one score is required.");
        long first = sumArray(dhoni), second = sumArray(virat), third = sumArray(rohit);
        if (first >= second && first >= third) return 1;
        if (second >= third) return 2;
        return 3;
    }

    public static void printSumOfHighScore()
    {
        printResult(24, "Player with Highest Total", getHighestScoredPlayer(new int[]{30,45,20}, new int[]{50,10,40}, new int[]{25,35,30}));
    }


//    Given three arrays, return the average of each array as a new array.
//    Input to the function: [10, 20, 30], [5, 15] and [8, 8, 8, 8]
//    Return from the function: [20, 10, 8]

    public static double getAverage(int[] arr)
    {
        return avgMarks(arr);
    }

    public static double[] getAvgofThreeArrays(int[] a1, int[] a2, int[] a3)
    {
        return new double[]{getAverage(a1), getAverage(a2), getAverage(a3)};
    }

    public static void printAvgofThree()
    {
        printResult(25, "Average of Each of Three Arrays", getAvgofThreeArrays(new int[]{10,20,30}, new int[]{5,15}, new int[]{8,8,8,8}));
    }


    public static void main(String[] args)
    {
        System.out.println("================ ALL 25 SAMPLE OUTPUTS ================");
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
        printCricketOver();         // 19
        printRaviMarks();           // 20
        printBigNumber();           // 21
        printFirstElements();       // 22
        printCheapItems();          // 23
        printSumOfHighScore();      // 24
        printAvgofThree();          // 25
        runTests();
    }

    // Shared input validation: null is different from an empty array.
    static void requireArray(int[] arr)
    {
        if (arr == null) throw new IllegalArgumentException("Array must not be null.");
    }

    static void requireNonempty(int[] arr)
    {
        requireArray(arr);
        if (arr.length == 0) throw new IllegalArgumentException("Array must not be empty.");
    }

    static void requireSameLength(int[] a, int[] b)
    {
        requireArray(a);
        requireArray(b);
        if (a.length != b.length)
            throw new IllegalArgumentException("Arrays must have the same length.");
    }

    static void requireNonnegative(int[] arr)
    {
        requireArray(arr);
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0) throw new IllegalArgumentException("Values cannot be negative.");
    }

    static long sumArray(int[] arr)
    {
        requireArray(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        return sum;
    }

    // Object is used only by output/test helpers to accept different return types.
    static String display(Object value)
    {
        String text = "[";
        if (value instanceof int[])
        {
            int[] a = (int[]) value;
            for (int i = 0; i < a.length; i++)
            {
                if (i > 0) text += ", ";
                text += a[i];
            }
            return text + "]";
        }
        if (value instanceof long[])
        {
            long[] a = (long[]) value;
            for (int i = 0; i < a.length; i++)
            {
                if (i > 0) text += ", ";
                text += a[i];
            }
            return text + "]";
        }
        if (value instanceof double[])
        {
            double[] a = (double[]) value;
            for (int i = 0; i < a.length; i++)
            {
                if (i > 0) text += ", ";
                text += a[i];
            }
            return text + "]";
        }
        return String.valueOf(value);
    }

    static void printResult(int number, String label, Object result)
    {
        System.out.printf("%-2d --> %-43s : %s%n", number, label, display(result));
    }

    static int passed = 0, failed = 0;

    // Dispatch lets tests catch errors from any of the 25 functions.
    static Object solve(int question, int[] a, int[] b, int[] c)
    {
        switch (question)
        {
            case 1: return countEvenOdd(a);
            case 2: return avgMarks(a);
            case 3: return above50below100Numbers(a);
            case 4: return maxMinDifference(a);
            case 5: return passedStudents(a);
            case 6: return sumOfPositions(a);
            case 7: return tempCompare(a);
            case 8: return oddDoubleEvenSingle(a);
            case 9: return divisibleBy3And5(a);
            case 10: return closestToAversfge(a);
            case 11: return stepCount(a);
            case 12: return replaceByZero(a);
            case 13: return increasingOrder(a);
            case 14: return sumOfFirstLast(a);
            case 15: return getDiscountAmout(a);
            case 16: return countpalindrome(a);
            case 17: return sumOfElements(a);
            case 18: return signCount(a);
            case 19: return getOver(a);
            case 20: return countHighestMarks(a, b);
            case 21: return getBigNumber(a, b);
            case 22: return getElementsFromFirstArray(a, b);
            case 23: return getCheapItems(a, b);
            case 24: return getHighestScoredPlayer(a, b, c);
            case 25: return getAvgofThreeArrays(a, b, c);
            default: throw new IllegalArgumentException("Unknown question.");
        }
    }

    // Numeric comparison uses a small absolute tolerance for fractional results.
    static boolean same(Object expected, Object actual)
    {
        if (expected instanceof Number && actual instanceof Number)
        {
            double difference = ((Number) expected).doubleValue() - ((Number) actual).doubleValue();
            if (difference < 0) difference = -difference;
            return difference < 0.000001;
        }
        if (expected instanceof double[] && actual instanceof double[])
        {
            double[] a = (double[]) expected, b = (double[]) actual;
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++)
                if (!same(a[i], b[i])) return false;
            return true;
        }
        return display(expected).equals(display(actual));
    }

    static void test(int question, String label, Object expected, boolean expectError,
                     int[] a, int[] b, int[] c)
    {
        Object actual;
        boolean success;
        try
        {
            actual = solve(question, a, b, c);
            success = !expectError && same(expected, actual);
        }
        catch (IllegalArgumentException error)
        {
            actual = "IllegalArgumentException: " + error.getMessage();
            success = expectError;
        }
        catch (Exception error)
        {
            actual = "Unexpected " + error;
            success = false;
        }
        if (success) passed++;
        else failed++;
        System.out.printf("  %-4s | %-30s | expected: %-28s | actual: %s%n",
                success ? "PASS" : "FAIL", label,
                expectError ? "IllegalArgumentException" : display(expected), display(actual));
    }

    static void runTests()
    {
        passed = 0;
        failed = 0;
        System.out.println("\n================ AUTOMATED TEST CASES ================");

        System.out.println("\n01 --> Odd and Even Count [odd, even]");
        test(1, "PDF example", new int[]{3,2}, false, new int[]{3,8,5,12,7}, null, null);
        test(1, "Empty array(s)", new int[]{0,0}, false, new int[]{}, null, null);
        test(1, "Null input 1", null, true, null, null, null);
        test(1, "Negative odd and zero", new int[]{2,2}, false, new int[]{-3,-2,0,7}, null, null);
        test(1, "Single odd", new int[]{1,0}, false, new int[]{5}, null, null);

        System.out.println("\n02 --> Average Student Marks");
        test(2, "PDF example", 75.0, false, new int[]{70,85,90,55}, null, null);
        test(2, "Empty array(s)", null, true, new int[]{}, null, null);
        test(2, "Null input 1", null, true, null, null, null);
        test(2, "Fractional average", 1.5, false, new int[]{1,2}, null, null);
        test(2, "Large sum", 2147483647.0, false, new int[]{2147483647,2147483647}, null, null);

        System.out.println("\n03 --> Greater than 50 and Less than 100");
        test(3, "PDF example", new int[]{67,52,99}, false, new int[]{45,67,100,52,99,120,50}, null, null);
        test(3, "Empty array(s)", new int[]{}, false, new int[]{}, null, null);
        test(3, "Null input 1", null, true, null, null, null);
        test(3, "Exclusive boundaries", new int[]{51,99}, false, new int[]{50,51,99,100}, null, null);
        test(3, "No matches", new int[]{}, false, new int[]{-5,0,120}, null, null);

        System.out.println("\n04 --> Max Min Difference");
        test(4, "PDF example", 24L, false, new int[]{14,3,27,9}, null, null);
        test(4, "Empty array(s)", null, true, new int[]{}, null, null);
        test(4, "Null input 1", null, true, null, null, null);
        test(4, "Full int range", 4294967295L, false, new int[]{-2147483648,2147483647}, null, null);
        test(4, "Single value", 0L, false, new int[]{7}, null, null);
        test(4, "All negative", 25L, false, new int[]{-5,-30}, null, null);

        System.out.println("\n05 --> Passed Students in Exam");
        test(5, "PDF example", 3, false, new int[]{40,22,35,90,18}, null, null);
        test(5, "Empty array(s)", 0, false, new int[]{}, null, null);
        test(5, "Null input 1", null, true, null, null, null);
        test(5, "Pass boundary", 2, false, new int[]{34,35,36}, null, null);
        test(5, "Nine students", 9, false, new int[]{35,35,35,35,35,35,35,35,35}, null, null);

        System.out.println("\n06 --> Sum at Positions 0, 2, 4, ...");
        test(6, "PDF example", 60L, false, new int[]{10,3,20,7,30}, null, null);
        test(6, "Empty array(s)", 0L, false, new int[]{}, null, null);
        test(6, "Null input 1", null, true, null, null, null);
        test(6, "Index versus value parity", 9L, false, new int[]{1,2,3,4,5}, null, null);
        test(6, "Large sum", 4294967294L, false, new int[]{2147483647,0,2147483647}, null, null);

        System.out.println("\n07 --> Days Hotter than Previous Day");
        test(7, "PDF example", 4, false, new int[]{30,32,31,35,36,34,37}, null, null);
        test(7, "Empty array(s)", 0, false, new int[]{}, null, null);
        test(7, "Null input 1", null, true, null, null, null);
        test(7, "Equal temperatures", 0, false, new int[]{25,25,25}, null, null);
        test(7, "Single day", 0, false, new int[]{35}, null, null);
        test(7, "Negative temperatures", 1, false, new int[]{-5,-2,-3}, null, null);

        System.out.println("\n08 --> Even Half and Odd Double");
        test(8, "PDF example", new long[]{2,14,5,6}, false, new int[]{4,7,10,3}, null, null);
        test(8, "Empty array(s)", new long[]{}, false, new int[]{}, null, null);
        test(8, "Null input 1", null, true, null, null, null);
        test(8, "Negative odd and zero", new long[]{-6,-2,0}, false, new int[]{-3,-4,0}, null, null);
        test(8, "Extreme values", new long[]{4294967294L,-1073741824L,-4294967294L}, false, new int[]{2147483647,-2147483648,-2147483647}, null, null);

        System.out.println("\n09 --> Divisible by Both 3 and 5");
        test(9, "PDF example", 3, false, new int[]{15,9,30,10,45,7}, null, null);
        test(9, "Empty array(s)", 0, false, new int[]{}, null, null);
        test(9, "Null input 1", null, true, null, null, null);
        test(9, "Zero and negatives", 3, false, new int[]{0,-15,-30,5}, null, null);
        test(9, "No matches", 0, false, new int[]{1,2}, null, null);

        System.out.println("\n10 --> Closest to Average");
        test(10, "PDF example", 9, false, new int[]{2,9,4,15}, null, null);
        test(10, "Empty array(s)", null, true, new int[]{}, null, null);
        test(10, "Null input 1", null, true, null, null, null);
        test(10, "Tie keeps first", 9, false, new int[]{9,1}, null, null);
        test(10, "Full range tie", -2147483648, false, new int[]{-2147483648,2147483647}, null, null);
        test(10, "Single", 4, false, new int[]{4}, null, null);

        System.out.println("\n11 --> Steps [days above 10000, best]");
        test(11, "PDF example", new int[]{3,15000}, false, new int[]{8000,12000,10500,9000,15000}, null, null);
        test(11, "Empty array(s)", null, true, new int[]{}, null, null);
        test(11, "Null input 1", null, true, null, null, null);
        test(11, "Threshold is exclusive", new int[]{1,10001}, false, new int[]{9999,10000,10001}, null, null);
        test(11, "Single zero", new int[]{0,0}, false, new int[]{0}, null, null);
        test(11, "Negative steps", null, true, new int[]{-1}, null, null);

        System.out.println("\n12 --> Replace Negative Values by Zero");
        test(12, "PDF example", new int[]{5,0,8,0,0}, false, new int[]{5,-3,8,-1,0}, null, null);
        test(12, "Empty array(s)", new int[]{}, false, new int[]{}, null, null);
        test(12, "Null input 1", null, true, null, null, null);
        test(12, "All negative", new int[]{0,0}, false, new int[]{-2147483648,-1}, null, null);
        test(12, "Nonnegative unchanged", new int[]{0,1}, false, new int[]{0,1}, null, null);

        System.out.println("\n13 --> Strictly Increasing Order");
        test(13, "PDF example", true, false, new int[]{2,5,9,14}, null, null);
        test(13, "Empty array(s)", true, false, new int[]{}, null, null);
        test(13, "Null input 1", null, true, null, null, null);
        test(13, "Duplicates", false, false, new int[]{1,1,2}, null, null);
        test(13, "Descending", false, false, new int[]{3,2,1}, null, null);
        test(13, "Single", true, false, new int[]{7}, null, null);

        System.out.println("\n14 --> Sum of First and Last Element");
        test(14, "PDF example", 11L, false, new int[]{7,3,9,4}, null, null);
        test(14, "Empty array(s)", null, true, new int[]{}, null, null);
        test(14, "Null input 1", null, true, null, null, null);
        test(14, "Single counted twice", 14L, false, new int[]{7}, null, null);
        test(14, "Overflow protection", 4294967294L, false, new int[]{2147483647}, null, null);

        System.out.println("\n15 --> Shopping Cart Amount to Pay");
        test(15, "PDF example", 1080.0, false, new int[]{400,350,450}, null, null);
        test(15, "Empty array(s)", 0.0, false, new int[]{}, null, null);
        test(15, "Null input 1", null, true, null, null, null);
        test(15, "Below threshold", 750.0, false, new int[]{400,350}, null, null);
        test(15, "Exactly threshold", 1000.0, false, new int[]{500,500}, null, null);
        test(15, "Fractional payment", 900.9, false, new int[]{1001}, null, null);
        test(15, "Large total", 3865470564.6, false, new int[]{2147483647,2147483647}, null, null);
        test(15, "Negative price", null, true, new int[]{-1}, null, null);

        System.out.println("\n16 --> Palindrome Count");
        test(16, "PDF example", 3, false, new int[]{121,45,7,1331,80}, null, null);
        test(16, "Empty array(s)", 0, false, new int[]{}, null, null);
        test(16, "Null input 1", null, true, null, null, null);
        test(16, "Zero single digit negative", 2, false, new int[]{0,7,-121,10}, null, null);
        test(16, "Reversal overflow", 1, false, new int[]{2147483647,2147447412}, null, null);

        System.out.println("\n17 --> Sum of Digits of Each Element");
        test(17, "PDF example", new int[]{6,9,9}, false, new int[]{123,45,9}, null, null);
        test(17, "Empty array(s)", new int[]{}, false, new int[]{}, null, null);
        test(17, "Null input 1", null, true, null, null, null);
        test(17, "Zero and negative", new int[]{0,6,9}, false, new int[]{0,-123,-9}, null, null);
        test(17, "Integer limits", new int[]{47,46}, false, new int[]{-2147483648,2147483647}, null, null);

        System.out.println("\n18 --> Adjacent Sign Changes");
        test(18, "PDF example", 3, false, new int[]{3,-2,-5,4,6,-1}, null, null);
        test(18, "Empty array(s)", 0, false, new int[]{}, null, null);
        test(18, "Null input 1", null, true, null, null, null);
        test(18, "Zeros break adjacency", 0, false, new int[]{3,0,-2}, null, null);
        test(18, "Alternating", 3, false, new int[]{-1,1,-1,1}, null, null);
        test(18, "Single zero", 0, false, new int[]{0}, null, null);

        System.out.println("\n19 --> Over with Highest Runs");
        test(19, "PDF example", 4, false, new int[]{6,12,4,15,9}, null, null);
        test(19, "Empty array(s)", null, true, new int[]{}, null, null);
        test(19, "Null input 1", null, true, null, null, null);
        test(19, "Tie earliest over", 2, false, new int[]{6,12,12}, null, null);
        test(19, "Single zero", 1, false, new int[]{0}, null, null);
        test(19, "Negative runs", null, true, new int[]{-1}, null, null);

        System.out.println("\n20 --> Subjects Where Ravi Scored More");
        test(20, "PDF example", 2, false, new int[]{78,65,90,55,82}, new int[]{70,80,85,60,82}, null);
        test(20, "Empty array(s)", 0, false, new int[]{}, new int[]{}, null);
        test(20, "Null input 1", null, true, null, new int[]{70,80,85,60,82}, null);
        test(20, "Null input 2", null, true, new int[]{78,65,90,55,82}, null, null);
        test(20, "Equal marks", 0, false, new int[]{50,50}, new int[]{50,50}, null);
        test(20, "Single win", 1, false, new int[]{80}, new int[]{70}, null);
        test(20, "Length mismatch", null, true, new int[]{1,2}, new int[]{1}, null);

        System.out.println("\n21 --> Bigger Number at Each Position");
        test(21, "PDF example", new int[]{6,9,8,7}, false, new int[]{4,9,2,7}, new int[]{6,3,8,7}, null);
        test(21, "Empty array(s)", new int[]{}, false, new int[]{}, new int[]{}, null);
        test(21, "Null input 1", null, true, null, new int[]{6,3,8,7}, null);
        test(21, "Null input 2", null, true, new int[]{4,9,2,7}, null, null);
        test(21, "Negative values", new int[]{-5,-2}, false, new int[]{-5,-9}, new int[]{-7,-2}, null);
        test(21, "Equal values", new int[]{4}, false, new int[]{4}, new int[]{4}, null);
        test(21, "Length mismatch", null, true, new int[]{1}, new int[]{1,2}, null);

        System.out.println("\n22 --> First Array Values Absent in Second");
        test(22, "PDF example", new int[]{1,6,10}, false, new int[]{1,4,6,8,10}, new int[]{4,8,12}, null);
        test(22, "Empty array(s)", new int[]{}, false, new int[]{}, new int[]{}, null);
        test(22, "Null input 1", null, true, null, new int[]{4,8,12}, null);
        test(22, "Null input 2", null, true, new int[]{1,4,6,8,10}, null, null);
        test(22, "Keep duplicates", new int[]{1,1,3}, false, new int[]{1,1,2,3}, new int[]{2}, null);
        test(22, "Empty second array", new int[]{1,-1}, false, new int[]{1,-1}, new int[]{}, null);
        test(22, "All excluded", new int[]{}, false, new int[]{1,1}, new int[]{1}, null);

        System.out.println("\n23 --> Savings Compared with Shop A");
        test(23, "PDF example", 20L, false, new int[]{100,250,80,40}, new int[]{90,260,70,45}, null);
        test(23, "Empty array(s)", 0L, false, new int[]{}, new int[]{}, null);
        test(23, "Null input 1", null, true, null, new int[]{90,260,70,45}, null);
        test(23, "Null input 2", null, true, new int[]{100,250,80,40}, null, null);
        test(23, "Shop A always cheaper", 0L, false, new int[]{10,20}, new int[]{11,21}, null);
        test(23, "Equal prices", 0L, false, new int[]{10}, new int[]{10}, null);
        test(23, "Large savings", 4294967294L, false, new int[]{2147483647,2147483647}, new int[]{0,0}, null);
        test(23, "Length mismatch", null, true, new int[]{1}, new int[]{}, null);
        test(23, "Negative price", null, true, new int[]{10}, new int[]{-1}, null);

        System.out.println("\n24 --> Player with Highest Total");
        test(24, "PDF example", 2, false, new int[]{30,45,20}, new int[]{50,10,40}, new int[]{25,35,30});
        test(24, "Empty array(s)", null, true, new int[]{}, new int[]{}, new int[]{});
        test(24, "Null input 1", null, true, null, new int[]{50,10,40}, new int[]{25,35,30});
        test(24, "Null input 2", null, true, new int[]{30,45,20}, null, new int[]{25,35,30});
        test(24, "Null input 3", null, true, new int[]{30,45,20}, new int[]{50,10,40}, null);
        test(24, "First wins", 1, false, new int[]{9}, new int[]{8}, new int[]{7});
        test(24, "Third wins", 3, false, new int[]{1}, new int[]{2}, new int[]{3});
        test(24, "Tie first two", 1, false, new int[]{8}, new int[]{8}, new int[]{7});
        test(24, "Tie last two", 2, false, new int[]{7}, new int[]{8}, new int[]{8});
        test(24, "All tied", 1, false, new int[]{8}, new int[]{8}, new int[]{8});
        test(24, "Empty individual arrays", 2, false, new int[]{}, new int[]{5}, new int[]{});
        test(24, "Large sums", 1, false, new int[]{2147483647,2147483647}, new int[]{2147483647}, new int[]{1});
        test(24, "Negative score", null, true, new int[]{1}, new int[]{-1}, new int[]{1});

        System.out.println("\n25 --> Average of Each of Three Arrays");
        test(25, "PDF example", new double[]{20,10,8}, false, new int[]{10,20,30}, new int[]{5,15}, new int[]{8,8,8,8});
        test(25, "Empty array(s)", null, true, new int[]{}, new int[]{}, new int[]{});
        test(25, "Null input 1", null, true, null, new int[]{5,15}, new int[]{8,8,8,8});
        test(25, "Null input 2", null, true, new int[]{10,20,30}, null, new int[]{8,8,8,8});
        test(25, "Null input 3", null, true, new int[]{10,20,30}, new int[]{5,15}, null);
        test(25, "Fractional averages", new double[]{1.5,3.5,-1.5}, false, new int[]{1,2}, new int[]{3,4}, new int[]{-1,-2});
        test(25, "Empty middle", null, true, new int[]{1}, new int[]{}, new int[]{2});
        test(25, "Large sums", new double[]{2147483647,0,1}, false, new int[]{2147483647,2147483647}, new int[]{0}, new int[]{1});

        // Explicitly check the input-mutation contracts.
        int[] source = {4, -3};
        oddDoubleEvenSingle(source);
        boolean unchanged = source[0] == 4 && source[1] == -3;
        if (unchanged) passed++; else failed++;
        System.out.println("\n" + (unchanged ? "PASS" : "FAIL") + " | Q8 leaves its input unchanged");
        int[] result = replaceByZero(source);
        boolean inPlace = result == source && source[0] == 4 && source[1] == 0;
        if (inPlace) passed++; else failed++;
        System.out.println((inPlace ? "PASS" : "FAIL") + " | Q12 modifies and returns the same array");
        System.out.println("\n=====================================================");
        System.out.println("TOTAL: " + (passed + failed) + " | PASSED: " + passed + " | FAILED: " + failed);
        if (failed > 0) throw new AssertionError("Some tests failed. Check the FAIL rows above.");
    }
}
