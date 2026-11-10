import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Question 01 · Count odd and even numbers
 * Integer arrays · The Algorithms Way · algorithms365.com
 *
 * PROBLEM
 *   Count how many numbers are odd and how many are even. Return both as [odd, even].
 *
 *   Sample input to the function:    [3, 8, 5, 12, 7]
 *   Sample return from the function: [3, 2]
 *
 * HOW TO USE THIS FILE
 *   1. Write your code inside countOddEven(...) below. Do not change its signature.
 *   2. The function must RETURN the answer. Do not print it.
 *   3. Compile and run:  javac Q01_CountOddEven.java  then  java Q01_CountOddEven
 *      (or run it in one step with:  java Q01_CountOddEven.java)
 *   4. Fix your code until every test case says PASS.
 */
public class Q01_CountOddEven
{

    // ======================================================================
    //  Write your solution inside this function.
    // ======================================================================
    public static int[] countOddEven(int[] numbers)
    {
        // TODO: write your code here.
        if(numbers == null || numbers.length == 0)
        {
            return new int[]{0,0};
        }

        int countEven = 0;
        int countOdd = 0;

        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] % 2 == 0)
            {
                countEven++;
            }
            else
            {
                countOdd++;
            }
        }
        return new int []{countOdd,countEven};
    }

    // ======================================================================
    //  Test cases for countOddEven: run this file to check your code.
    // ======================================================================

    public static void main(String[] args) {
        run(1, "Sample from the question",
                () -> countOddEven(new int[]{3, 8, 5, 12, 7}),
                new int[]{3, 2});
        run(2, "Null input",
                () -> countOddEven((int[]) null),
                new int[]{0, 0});
        run(3, "Empty",
                () -> countOddEven(new int[]{}),
                new int[]{0, 0});
        run(4, "Single odd number",
                () -> countOddEven(new int[]{9}),
                new int[]{1, 0});
        run(5, "Single even number",
                () -> countOddEven(new int[]{4}),
                new int[]{0, 1});
        run(6, "All odd",
                () -> countOddEven(new int[]{1, 3, 5, 7}),
                new int[]{4, 0});
        run(7, "All even",
                () -> countOddEven(new int[]{2, 4, 6}),
                new int[]{0, 3});
        run(8, "Only negatives",
                () -> countOddEven(new int[]{-3, -8, -5}),
                new int[]{2, 1});
        run(9, "Mix with zero",
                () -> countOddEven(new int[]{0, -1, 2}),
                new int[]{1, 2});
        run(10, "Duplicates",
                () -> countOddEven(new int[]{5, 5, 6, 6, 6}),
                new int[]{2, 3});
        run(11, "Extreme values",
                () -> countOddEven(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}),
                new int[]{1, 1});

        printSummary();
    }

    // ======================================================================
    //  Test harness: you do not need to change anything below this line.
    // ======================================================================

    private static int passed = 0;
    private static int total = 0;

    private static void run(int number, String category, Supplier<Object> call, Object expected) {
        total++;
        String label = "Test " + number + " (" + category + ")";
        try {
            Object returned = call.get();
            if (matches(expected, returned)) {
                passed++;
                System.out.println("PASS   " + label);
            } else {
                System.out.println("FAIL   " + label);
                System.out.println("         expected: " + show(expected));
                System.out.println("         returned: " + show(returned));
            }
        } catch (UnsupportedOperationException notWritten) {
            System.out.println("TODO   " + label + "  ->  write your code in the function first");
        } catch (Throwable error) {
            System.out.println("ERROR  " + label + "  ->  " + error);
        }
    }

    private static boolean matches(Object expected, Object returned) {
        if (expected instanceof Number && returned instanceof Number
                && !(expected instanceof Character) && !(returned instanceof Character)) {
            return Math.abs(((Number) expected).doubleValue() - ((Number) returned).doubleValue()) < 1e-6;
        }
        if (expected instanceof double[] && returned instanceof double[]) {
            double[] want = (double[]) expected;
            double[] got = (double[]) returned;
            if (want.length != got.length) {
                return false;
            }
            for (int index = 0; index < want.length; index++) {
                if (Math.abs(want[index] - got[index]) >= 1e-6) {
                    return false;
                }
            }
            return true;
        }
        return Objects.deepEquals(expected, returned);
    }

    private static String show(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof int[]) {
            return Arrays.toString((int[]) value);
        }
        if (value instanceof double[]) {
            return Arrays.toString((double[]) value);
        }
        if (value instanceof boolean[]) {
            return Arrays.toString((boolean[]) value);
        }
        if (value instanceof char[]) {
            StringBuilder text = new StringBuilder("[");
            char[] letters = (char[]) value;
            for (int index = 0; index < letters.length; index++) {
                text.append(index == 0 ? "" : ", ").append('\'').append(letters[index]).append('\'');
            }
            return text.append("]").toString();
        }
        if (value instanceof Object[]) {
            return Arrays.deepToString((Object[]) value);
        }
        if (value instanceof Character) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }

    private static void printSummary() {
        System.out.println();
        System.out.println(passed + " / " + total + " test cases passed.");
        if (passed == total) {
            System.out.println("All test cases passed. Well done!");
        } else {
            System.out.println("Keep going: fix the failing cases, then run again.");
        }
    }
}
