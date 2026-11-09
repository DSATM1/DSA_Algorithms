public class ArraysAi
/*
 * ONE METHOD PER PROGRAM: test data + validation + logic + output.
 * main() only calls the 25 methods. No separate helper/test methods.
 * Run with Java 11+: java ArraysAssignment.java
 * Or: javac ArraysAssignment.java, then java ArraysAssignment
 *
 * Each method loops over its own test cases. It checks input validity first,
 * computes the answer, compares with the expected answer, and prints PASS/FAIL.
 * Invalid inputs print a clear message and the next test still runs.
 *
 * Rules for cases not specified by the question sheet:
 * Null is invalid. Empty counts/sums are 0; empty transformations return [].
 * Q2,4,10,11,14,19,25 need nonempty inputs. Q24 needs at least one score.
 * Q20,21,23 need equal lengths; Q22,24,25 may have different lengths.
 * Ties use the first value, earliest over, or lowest player number.
 * Increasing means strictly increasing; empty/single arrays qualify.
 * Q14 adds the single element twice. Q16 counts 0 but not negatives.
 * Q17 uses the magnitude of negative numbers. Q18 compares adjacent values;
 * zero breaks a sign transition. Q22 keeps duplicates and input order.
 * Prices, steps and cricket scores/runs must be nonnegative.
 * long prevents integer overflow; double retains fractional averages/payments.
 * Q12 modifies the array; the other programs leave their inputs unchanged.
 *
 * This version prints results inside each program as requested. Unlike the
 * original PDF's function-only format, these methods are self-contained demos.
 */
{
    // 1. Odd and Even Count [odd, even]
    public static void program01()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{3,8,5,12,7},
                new int[]{},
                null,
                new int[]{-3,-2,0,7},
                new int[]{5},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Negative odd and zero", "Single odd"};
        int[][] expected = {new int[]{3,2}, new int[]{0,0}, null, new int[]{2,2}, new int[]{1,0}};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n01 --> Odd and Even Count [odd, even]");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int odd = 0, even = 0;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] % 2 == 0) even++;
                    else odd++;
                }
                answer = new int[]{odd, even};
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 2. Average Student Marks
    public static void program02()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{70,85,90,55},
                new int[]{},
                null,
                new int[]{1,2},
                new int[]{2147483647,2147483647},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Fractional average", "Large sum"};
        double[] expected = {75.0, 0, 0, 1.5, 2147483647.0};
        boolean[] expectInvalid = {false, true, true, false, false};
        int passed = 0;
        System.out.println("\n02 --> Average Student Marks");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
            }
            double answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long totalSum = 0;
                for (int i = 0; i < arr.length; i++) totalSum += arr[i];
                answer = (double) totalSum / arr.length;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                double difference = answer - expected[test];
                if (difference < 0) difference = -difference;
                if (difference > 0.000001) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 3. Greater than 50 and Less than 100
    public static void program03()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{45,67,100,52,99,120,50},
                new int[]{},
                null,
                new int[]{50,51,99,100},
                new int[]{-5,0,120},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Exclusive boundaries", "No matches"};
        int[][] expected = {new int[]{67,52,99}, new int[]{}, null, new int[]{51,99}, new int[]{}};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n03 --> Greater than 50 and Less than 100");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = newArray;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 4. Max Min Difference
    public static void program04()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{14,3,27,9},
                new int[]{},
                null,
                new int[]{-2147483648,2147483647},
                new int[]{7},
                new int[]{-5,-30},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Full int range", "Single value", "All negative"};
        long[] expected = {24L, 0, 0, 4294967295L, 0L, 25L};
        boolean[] expectInvalid = {false, true, true, false, false, false};
        int passed = 0;
        System.out.println("\n04 --> Max Min Difference");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
            }
            long answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int min = arr[0], max = arr[0];
                for (int i = 1; i < arr.length; i++)
                {
                    if (arr[i] < min) min = arr[i];
                    if (arr[i] > max) max = arr[i];
                }
                answer = (long) max - min;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 5. Passed Students in Exam
    public static void program05()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{40,22,35,90,18},
                new int[]{},
                null,
                new int[]{34,35,36},
                new int[]{35,35,35,35,35,35,35,35,35},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Pass boundary", "Nine students"};
        int[] expected = {3, 0, 0, 2, 9};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n05 --> Passed Students in Exam");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int marks = 35;
                int count = 0;
                for(int i = 0; i < arr.length; i++)
                {
                    if ( arr[i] >= marks )
                    {
                        count++;
                    }
                }
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 6. Sum at Positions 0, 2, 4, ...
    public static void program06()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{10,3,20,7,30},
                new int[]{},
                null,
                new int[]{1,2,3,4,5},
                new int[]{2147483647,0,2147483647},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Index versus value parity", "Large sum"};
        long[] expected = {60L, 0L, 0, 9L, 4294967294L};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n06 --> Sum at Positions 0, 2, 4, ...");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            long answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long sum = 0;
                for (int i = 0; i < arr.length; i += 2) sum += arr[i];
                answer = sum;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 7. Days Hotter than Previous Day
    public static void program07()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{30,32,31,35,36,34,37},
                new int[]{},
                null,
                new int[]{25,25,25},
                new int[]{35},
                new int[]{-5,-2,-3},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Equal temperatures", "Single day", "Negative temperatures"};
        int[] expected = {4, 0, 0, 0, 0, 1};
        boolean[] expectInvalid = {false, false, true, false, false, false};
        int passed = 0;
        System.out.println("\n07 --> Days Hotter than Previous Day");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int count = 0;
                for(int i = 1; i < arr.length; i++)
                {
                    if( arr[i] > arr[i - 1])
                    {
                        count++;
                    }
                }
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 8. Even Half and Odd Double
    public static void program08()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{4,7,10,3},
                new int[]{},
                null,
                new int[]{-3,-4,0},
                new int[]{2147483647,-2147483648,-2147483647},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Negative odd and zero", "Extreme values"};
        long[][] expected = {new long[]{2,14,5,6}, new long[]{}, null, new long[]{-6,-2,0}, new long[]{4294967294L,-1073741824L,-4294967294L}};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n08 --> Even Half and Odd Double");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            long[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long[] result = new long[arr.length];
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] % 2 == 0) result[i] = arr[i] / 2;
                    else result[i] = (long) arr[i] * 2;
                }
                answer = result;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 9. Divisible by Both 3 and 5
    public static void program09()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{15,9,30,10,45,7},
                new int[]{},
                null,
                new int[]{0,-15,-30,5},
                new int[]{1,2},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Zero and negatives", "No matches"};
        int[] expected = {3, 0, 0, 3, 0};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n09 --> Divisible by Both 3 and 5");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int count = 0;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] % 3 == 0 && arr[i] % 5 == 0)
                    {
                        count++;
                    }
                }
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 10. Closest to Average
    public static void program10()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{2,9,4,15},
                new int[]{},
                null,
                new int[]{9,1},
                new int[]{-2147483648,2147483647},
                new int[]{4},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Tie keeps first", "Full range tie", "Single"};
        int[] expected = {9, 0, 0, 9, -2147483648, 4};
        boolean[] expectInvalid = {false, true, true, false, false, false};
        int passed = 0;
        System.out.println("\n10 --> Closest to Average");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
            }
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long totalSum = 0;
                for (int i = 0; i < arr.length; i++) totalSum += arr[i];
                long sum = totalSum;
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
                answer = closest;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 11. Steps [days above 10000, best]
    public static void program11()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{8000,12000,10500,9000,15000},
                new int[]{},
                null,
                new int[]{9999,10000,10001},
                new int[]{0},
                new int[]{-1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Threshold is exclusive", "Single zero", "Negative steps"};
        int[][] expected = {new int[]{3,15000}, null, null, new int[]{1,10001}, new int[]{0,0}, null};
        boolean[] expectInvalid = {false, true, true, false, false, true};
        int passed = 0;
        System.out.println("\n11 --> Steps [days above 10000, best]");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] < 0) error = "Negative values are invalid.";
            }
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = new int[] {count, max};
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 12. Replace Negative Values by Zero
    public static void program12()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{5,-3,8,-1,0},
                new int[]{},
                null,
                new int[]{-2147483648,-1},
                new int[]{0,1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "All negative", "Nonnegative unchanged"};
        int[][] expected = {new int[]{5,0,8,0,0}, new int[]{}, null, new int[]{0,0}, new int[]{0,1}};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n12 --> Replace Negative Values by Zero");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                for(int i = 0; i < arr.length; i++)
                {
                    if(arr[i] < 0)
                    {
                        arr[i] = 0;
                    }
                }
                answer = arr;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 13. Strictly Increasing Order
    public static void program13()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{2,5,9,14},
                new int[]{},
                null,
                new int[]{1,1,2},
                new int[]{3,2,1},
                new int[]{7},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Duplicates", "Descending", "Single"};
        boolean[] expected = {true, true, false, false, false, true};
        boolean[] expectInvalid = {false, false, true, false, false, false};
        int passed = 0;
        System.out.println("\n13 --> Strictly Increasing Order");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            boolean answer = false;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                boolean first = true;
                for(int i = 0; i <= arr.length - 2; i++)
                {
                    if(arr[i] >= arr[i + 1])
                    {
                        first = false;
                    }
                }
                answer = first;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 14. Sum of First and Last Element
    public static void program14()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{7,3,9,4},
                new int[]{},
                null,
                new int[]{7},
                new int[]{2147483647},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Single counted twice", "Overflow protection"};
        long[] expected = {11L, 0, 0, 14L, 4294967294L};
        boolean[] expectInvalid = {false, true, true, false, false};
        int passed = 0;
        System.out.println("\n14 --> Sum of First and Last Element");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
            }
            long answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                answer = (long) arr[0] + arr[arr.length - 1];
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 15. Shopping Cart Amount to Pay
    public static void program15()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{400,350,450},
                new int[]{},
                null,
                new int[]{400,350},
                new int[]{500,500},
                new int[]{1001},
                new int[]{2147483647,2147483647},
                new int[]{-1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Below threshold", "Exactly threshold", "Fractional payment", "Large total", "Negative price"};
        double[] expected = {1080.0, 0.0, 0, 750.0, 1000.0, 900.9, 3865470564.6, 0};
        boolean[] expectInvalid = {false, false, true, false, false, false, false, true};
        int passed = 0;
        System.out.println("\n15 --> Shopping Cart Amount to Pay");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] < 0) error = "Negative values are invalid.";
            }
            double answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long totalSum = 0;
                for (int i = 0; i < arr.length; i++) totalSum += arr[i];
                long total = totalSum;
                if (total > 1000) answer = total * 0.9;
                else answer = total;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                double difference = answer - expected[test];
                if (difference < 0) difference = -difference;
                if (difference > 0.000001) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 16. Palindrome Count
    public static void program16()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{121,45,7,1331,80},
                new int[]{},
                null,
                new int[]{0,7,-121,10},
                new int[]{2147483647,2147447412},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Zero single digit negative", "Reversal overflow"};
        int[] expected = {3, 0, 0, 2, 1};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n16 --> Palindrome Count");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 17. Sum of Digits of Each Element
    public static void program17()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{123,45,9},
                new int[]{},
                null,
                new int[]{0,-123,-9},
                new int[]{-2147483648,2147483647},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Zero and negative", "Integer limits"};
        int[][] expected = {new int[]{6,9,9}, new int[]{}, null, new int[]{0,6,9}, new int[]{47,46}};
        boolean[] expectInvalid = {false, false, true, false, false};
        int passed = 0;
        System.out.println("\n17 --> Sum of Digits of Each Element");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = result;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 18. Adjacent Sign Changes
    public static void program18()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{3,-2,-5,4,6,-1},
                new int[]{},
                null,
                new int[]{3,0,-2},
                new int[]{-1,1,-1,1},
                new int[]{0},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Zeros break adjacency", "Alternating", "Single zero"};
        int[] expected = {3, 0, 0, 0, 3, 0};
        boolean[] expectInvalid = {false, false, true, false, false, false};
        int passed = 0;
        System.out.println("\n18 --> Adjacent Sign Changes");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 19. Over with Highest Runs
    public static void program19()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] arrTests = {
                new int[]{6,12,4,15,9},
                new int[]{},
                null,
                new int[]{6,12,12},
                new int[]{0},
                new int[]{-1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Tie earliest over", "Single zero", "Negative runs"};
        int[] expected = {4, 0, 0, 2, 1, 0};
        boolean[] expectInvalid = {false, true, true, false, false, true};
        int passed = 0;
        System.out.println("\n19 --> Over with Highest Runs");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] arr = arrTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (arr == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (arr.length == 0)
                    error = "Input must not be empty.";
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] < 0) error = "Negative values are invalid.";
            }
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = over;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 20. Subjects Where Ravi Scored More
    public static void program20()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] raviTests = {
                new int[]{78,65,90,55,82},
                new int[]{},
                null,
                new int[]{78,65,90,55,82},
                new int[]{50,50},
                new int[]{80},
                new int[]{1,2},
        };
        int[][] sitaTests = {
                new int[]{70,80,85,60,82},
                new int[]{},
                new int[]{70,80,85,60,82},
                null,
                new int[]{50,50},
                new int[]{70},
                new int[]{1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Equal marks", "Single win", "Length mismatch"};
        int[] expected = {2, 0, 0, 0, 0, 1, 0};
        boolean[] expectInvalid = {false, false, true, true, false, false, true};
        int passed = 0;
        System.out.println("\n20 --> Subjects Where Ravi Scored More");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] ravi = raviTests[test];
            int[] sita = sitaTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (ravi == null) error = "Input must not be null.";
            if (sita == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (ravi.length != sita.length) error = "Array lengths must match.";
            }
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                int count = 0;
                for(int i = 0; i < ravi.length; i++)
                {
                    if (ravi[i] > sita[i])
                    {
                        count++;
                    }
                }
                answer = count;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 21. Bigger Number at Each Position
    public static void program21()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] a1Tests = {
                new int[]{4,9,2,7},
                new int[]{},
                null,
                new int[]{4,9,2,7},
                new int[]{-5,-9},
                new int[]{4},
                new int[]{1},
        };
        int[][] a2Tests = {
                new int[]{6,3,8,7},
                new int[]{},
                new int[]{6,3,8,7},
                null,
                new int[]{-7,-2},
                new int[]{4},
                new int[]{1,2},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Negative values", "Equal values", "Length mismatch"};
        int[][] expected = {new int[]{6,9,8,7}, new int[]{}, null, null, new int[]{-5,-2}, new int[]{4}, null};
        boolean[] expectInvalid = {false, false, true, true, false, false, true};
        int passed = 0;
        System.out.println("\n21 --> Bigger Number at Each Position");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] a1 = a1Tests[test];
            int[] a2 = a2Tests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (a1 == null) error = "Input must not be null.";
            if (a2 == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (a1.length != a2.length) error = "Array lengths must match.";
            }
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = result;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 22. First Array Values Absent in Second
    public static void program22()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] a1Tests = {
                new int[]{1,4,6,8,10},
                new int[]{},
                null,
                new int[]{1,4,6,8,10},
                new int[]{1,1,2,3},
                new int[]{1,-1},
                new int[]{1,1},
        };
        int[][] a2Tests = {
                new int[]{4,8,12},
                new int[]{},
                new int[]{4,8,12},
                null,
                new int[]{2},
                new int[]{},
                new int[]{1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Keep duplicates", "Empty second array", "All excluded"};
        int[][] expected = {new int[]{1,6,10}, new int[]{}, null, null, new int[]{1,1,3}, new int[]{1,-1}, new int[]{}};
        boolean[] expectInvalid = {false, false, true, true, false, false, false};
        int passed = 0;
        System.out.println("\n22 --> First Array Values Absent in Second");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] a1 = a1Tests[test];
            int[] a2 = a2Tests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (a1 == null) error = "Input must not be null.";
            if (a2 == null) error = "Input must not be null.";
            int[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
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
                answer = result;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            if (answer[i] != expected[test][i]) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 23. Savings Compared with Shop A
    public static void program23()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] shop1Tests = {
                new int[]{100,250,80,40},
                new int[]{},
                null,
                new int[]{100,250,80,40},
                new int[]{10,20},
                new int[]{10},
                new int[]{2147483647,2147483647},
                new int[]{1},
                new int[]{10},
        };
        int[][] shop2Tests = {
                new int[]{90,260,70,45},
                new int[]{},
                new int[]{90,260,70,45},
                null,
                new int[]{11,21},
                new int[]{10},
                new int[]{0,0},
                new int[]{},
                new int[]{-1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Shop A always cheaper", "Equal prices", "Large savings", "Length mismatch", "Negative price"};
        long[] expected = {20L, 0L, 0, 0, 0L, 0L, 4294967294L, 0, 0};
        boolean[] expectInvalid = {false, false, true, true, false, false, false, true, true};
        int passed = 0;
        System.out.println("\n23 --> Savings Compared with Shop A");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] shop1 = shop1Tests[test];
            int[] shop2 = shop2Tests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (shop1 == null) error = "Input must not be null.";
            if (shop2 == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (shop1.length != shop2.length) error = "Array lengths must match.";
                for (int i = 0; i < shop1.length; i++)
                    if (shop1[i] < 0) error = "Negative values are invalid.";
                for (int i = 0; i < shop2.length; i++)
                    if (shop2[i] < 0) error = "Negative values are invalid.";
            }
            long answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long saved = 0;
                for (int i = 0; i < shop1.length; i++)
                {
                    // Save only when Shop B is cheaper than Shop A for this item.
                    if (shop2[i] < shop1[i]) saved += (long) shop1[i] - shop2[i];
                }
                answer = saved;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 24. Player with Highest Total
    public static void program24()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] dhoniTests = {
                new int[]{30,45,20},
                new int[]{},
                null,
                new int[]{30,45,20},
                new int[]{30,45,20},
                new int[]{9},
                new int[]{1},
                new int[]{8},
                new int[]{7},
                new int[]{8},
                new int[]{},
                new int[]{2147483647,2147483647},
                new int[]{1},
        };
        int[][] viratTests = {
                new int[]{50,10,40},
                new int[]{},
                new int[]{50,10,40},
                null,
                new int[]{50,10,40},
                new int[]{8},
                new int[]{2},
                new int[]{8},
                new int[]{8},
                new int[]{8},
                new int[]{5},
                new int[]{2147483647},
                new int[]{-1},
        };
        int[][] rohitTests = {
                new int[]{25,35,30},
                new int[]{},
                new int[]{25,35,30},
                new int[]{25,35,30},
                null,
                new int[]{7},
                new int[]{3},
                new int[]{7},
                new int[]{8},
                new int[]{8},
                new int[]{},
                new int[]{1},
                new int[]{1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Null input 3", "First wins", "Third wins", "Tie first two", "Tie last two", "All tied", "Empty individual arrays", "Large sums", "Negative score"};
        int[] expected = {2, 0, 0, 0, 0, 1, 3, 1, 2, 1, 2, 1, 0};
        boolean[] expectInvalid = {false, true, true, true, true, false, false, false, false, false, false, false, true};
        int passed = 0;
        System.out.println("\n24 --> Player with Highest Total");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] dhoni = dhoniTests[test];
            int[] virat = viratTests[test];
            int[] rohit = rohitTests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (dhoni == null) error = "Input must not be null.";
            if (virat == null) error = "Input must not be null.";
            if (rohit == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (dhoni.length == 0 && virat.length == 0 && rohit.length == 0) error = "At least one score is required.";
                for (int i = 0; i < dhoni.length; i++)
                    if (dhoni[i] < 0) error = "Negative values are invalid.";
                for (int i = 0; i < virat.length; i++)
                    if (virat[i] < 0) error = "Negative values are invalid.";
                for (int i = 0; i < rohit.length; i++)
                    if (rohit[i] < 0) error = "Negative values are invalid.";
            }
            int answer = 0;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long first = 0, second = 0, third = 0;
                for (int i = 0; i < dhoni.length; i++) first += dhoni[i];
                for (int i = 0; i < virat.length; i++) second += virat[i];
                for (int i = 0; i < rohit.length; i++) third += rohit[i];
                if (first >= second && first >= third) answer = 1;
                else if (second >= third) answer = 2;
                else answer = 3;
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (answer != expected[test]) success = false;
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "" + expected[test];
            }
            if (error.length() == 0)
            {
                actualText = "" + answer;
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    // 25. Average of Each of Three Arrays
    public static void program25()
    {
        // 1. Test inputs and independently specified expected answers.
        int[][] a1Tests = {
                new int[]{10,20,30},
                new int[]{},
                null,
                new int[]{10,20,30},
                new int[]{10,20,30},
                new int[]{1,2},
                new int[]{1},
                new int[]{2147483647,2147483647},
        };
        int[][] a2Tests = {
                new int[]{5,15},
                new int[]{},
                new int[]{5,15},
                null,
                new int[]{5,15},
                new int[]{3,4},
                new int[]{},
                new int[]{0},
        };
        int[][] a3Tests = {
                new int[]{8,8,8,8},
                new int[]{},
                new int[]{8,8,8,8},
                new int[]{8,8,8,8},
                null,
                new int[]{-1,-2},
                new int[]{2},
                new int[]{1},
        };
        String[] caseNames = {"PDF example", "Empty array(s)", "Null input 1", "Null input 2", "Null input 3", "Fractional averages", "Empty middle", "Large sums"};
        double[][] expected = {new double[]{20,10,8}, null, null, null, null, new double[]{1.5,3.5,-1.5}, null, new double[]{2147483647,0,1}};
        boolean[] expectInvalid = {false, true, true, true, true, false, true, false};
        int passed = 0;
        System.out.println("\n25 --> Average of Each of Three Arrays");
        for (int test = 0; test < caseNames.length; test++)
        {
            int[] a1 = a1Tests[test];
            int[] a2 = a2Tests[test];
            int[] a3 = a3Tests[test];
            String error = "";
            // 2. Validate this test input before accessing array elements.
            if (a1 == null) error = "Input must not be null.";
            if (a2 == null) error = "Input must not be null.";
            if (a3 == null) error = "Input must not be null.";
            if (error.length() == 0)
            {
                if (a1.length == 0 || a2.length == 0 || a3.length == 0)
                    error = "Input must not be empty.";
            }
            double[] answer = null;
            if (error.length() == 0)
            {
                // 3. Main logic for this program.
                long sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < a1.length; i++) sum1 += a1[i];
                for (int i = 0; i < a2.length; i++) sum2 += a2[i];
                for (int i = 0; i < a3.length; i++) sum3 += a3[i];
                answer = new double[]{(double) sum1 / a1.length,
                        (double) sum2 / a2.length, (double) sum3 / a3.length};
            }
            // 4. Compare actual and expected results.
            boolean success;
            if (error.length() > 0)
            {
                success = expectInvalid[test];
            }
            else
            {
                success = !expectInvalid[test];
                if (success)
                {
                    if (answer.length != expected[test].length) success = false;
                    else
                    {
                        for (int i = 0; i < answer.length; i++)
                        {
                            double difference = answer[i] - expected[test][i];
                            if (difference < 0) difference = -difference;
                            if (difference > 0.000001) success = false;
                        }
                    }
                }
            }
            // 5. Format arrays manually and print a readable test result.
            String expectedText = "Invalid input";
            String actualText = error;
            if (!expectInvalid[test])
            {
                expectedText = "[";
                for (int i = 0; i < expected[test].length; i++)
                {
                    if (i > 0) expectedText += ", ";
                    expectedText += expected[test][i];
                }
                expectedText += "]";
            }
            if (error.length() == 0)
            {
                actualText = "[";
                for (int i = 0; i < answer.length; i++)
                {
                    if (i > 0) actualText += ", ";
                    actualText += answer[i];
                }
                actualText += "]";
            }
            if (success) passed++;
            String status = "FAIL";
            if (success) status = "PASS";
            System.out.printf("  %-4s | %-28s | Expected: %-26s | Actual: %s%n",
                    status, caseNames[test], expectedText, actualText);
        }
        System.out.println("  Passed: " + passed + "/" + caseNames.length);
    }

    public static void main(String[] args)
    {
        program01();
        program02();
        program03();
        program04();
        program05();
        program06();
        program07();
        program08();
        program09();
        program10();
        program11();
        program12();
        program13();
        program14();
        program15();
        program16();
        program17();
        program18();
        program19();
        program20();
        program21();
        program22();
        program23();
        program24();
        program25();
    }
}

