public class MatrixProblem
{
    // Sum of Matrix
    static int getSumofEachElement(int A[][])
    {
        int sum = 0;
        for(int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                sum = sum + A[row][col];
            }
        }
        return sum;
    }

    // Printing Sum
    static void printSum()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };

        int res = getSumofEachElement(A);
        System.out.println("Sum of Elements in Matrix : " + res);
    }

    // Find Max Element in Matrix
    static int maxElementInMatrix(int A[][])
    {
        int max = A[0][0];
        for(int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] > max)
                {
                    max = A[row][col];
                }
            }
        }
        return max;
    }

    // Print Max
    static void printMaxElement()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        int res = maxElementInMatrix(A);
        System.out.println("Max Elements in Matrix : " + res);
    }

    // Find Min Element in Matrix
    static int minElementInMatrix(int A[][])
    {
        int min = A[0][0];
        for(int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] < min)
                {
                    min = A[row][col];
                }
            }
        }
        return min;
    }

    // Print Min
    static void printMinElement()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        int res = minElementInMatrix(A);
        System.out.println("Min Elements in Matrix : " + res);
    }

    // Even and Odd Count
    static int[] evenAndOddCount(int A[][])
    {
        int evenCount = 0;
        int oddCount = 0;

        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] % 2 == 0)
                {
                    evenCount++;
                }
                else
                {
                    oddCount++;
                }
            }
        }
        return new int[]{evenCount,oddCount};
    }

    //Print Count
    static void printEvenOdd()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        int result[] = evenAndOddCount(A);
        System.out.print("Even and Odd Count : [");
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

    // Find Key in matrix
    static boolean isKeyFound(int A[][])
    {
        boolean keyFound = false;
        int key = 0;

        System.out.print("Has Key Found (True/False) : ");
        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] == key)
                {
                    keyFound = true;
                }
            }
        }
        return keyFound;
    }

    // Print Key
    static void printKeyFound()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        boolean result = isKeyFound(A);
        System.out.println(result);
    }

    // Diagonals left to right
    static void mainDiagonal(int A[][])
    {
        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(row == col)
                {
                    System.out.print(A[row][col] + " ");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Print Left Diagonal
    static void printMainDiagonal()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };

        System.out.println("Main Diagonal : ");
        mainDiagonal(A);
    }

    // Second Diagonal
    static void secondaryDiagonal(int A[][])
    {
        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(row + col == A.length - 1)
                {
                    System.out.print(A[row][col] + " ");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Print Second Diagonal
    static void printSecondaryDiagonal()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        System.out.println("Secondary Diagonal : ");
        secondaryDiagonal(A);
    }

    // Diagonal X Formation
    static void bothXFormation(int A[][])
    {
        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(row == col)
                {
                    System.out.print(A[row][col] + " ");
                }
                else if(row + col == A.length - 1)
                {
                    System.out.print(A[row][col] + " ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Print X Diagonal
    static void printBothDiagonal()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };
        System.out.println("Diagonal X Formation : ");
        bothXFormation(A);
    }

    // scalar Multiplication
    static int[][] scalarMulti(int A[][])
    {
        for (int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                A[row][col] =  A[row][col] * 2;
            }
        }
        return A;
    }

    // print Scalar Matrix
    static void printScalar()
    {
        int A[][] = {
                {3,5,9},
                {7,6,2},
                {4,8,1}
        };

        int res[][] = scalarMulti(A);

        System.out.println("Scalar Matrix : ");
        for(int row = 0; row < res.length; row++)
        {
            for(int col = 0; col < res[row].length; col++)
            {
                System.out.printf(" %3d ",res[row][col]);
            }
            System.out.println();
        }
    }

    // main Method
    public static void main(String[] args)
    {
        printSum();
        printMaxElement();
        printMinElement();
        printEvenOdd();
        printKeyFound();
        printMainDiagonal();
        printSecondaryDiagonal();
        printBothDiagonal();
        printScalar();
    }
}
