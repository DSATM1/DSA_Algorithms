public class TwoDArrayAssignment
{
    static int getEvenSum(int A[][])
    {
        int evenSum = 0;
        for (int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] % 2 == 0)
                {
                    evenSum = evenSum + A[row][col];
                }
            }
        }
        return evenSum;
    }

    static int[] rowSum(int A[][])
    {
        int result[] = new int[A.length];

        for(int row = 0; row < A.length; row++)
        {
            int rowSum = 0;
            for(int col = 0; col < A[row].length; col++)
            {
                rowSum = rowSum + A[row][col];
            }
            result[row] = rowSum;
        }
        return result;
    }

    static int[] getColumnSum(int A[][])
    {
        int res[] = new int[A[0].length];

        for(int col = 0; col < A[0].length; col ++)
        {
            int colSum = 0;
            for(int row = 0; row < A.length; row++)
            {
                colSum = colSum + A[row][col];
            }
            res[col] = colSum;
        }
        return res;
    }

    static int getElementsAboveFifty(int A[][])
    {
        int sum = 0;
        for (int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] > 50)
                {
                    sum = sum + A[row][col];
                }
            }
        }
        return sum;
    }

    static int[] maxInEachRow(int A[][])
    {
        int result[] = new int[A.length];

        for(int row = 0; row < A.length; row++)
        {
            int max = A[0][0];
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] > max)
                {
                    max = A[row][col];
                }
            }
            result[row] = max;
        }
        return result;
    }

    static void getMinEven(int A[][])
    {
        int MinEven = A[0][0];
        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] % 2 == 0 && A[row][col] < MinEven)
                {
                    MinEven = A[row][col];
                }
            }
        }
        if(MinEven % 2 == 1)
        {
            System.out.println("-1");
        }
        else
        {
            System.out.println("Min Even : " + MinEven);
        }
    }

    static int[][] diagonalMultiplicationBy10(int A[][])
    {
        int res[][] = new int[A.length][A[0].length];
        for (int row = 0; row < A.length; row++)
        {
            for (int col = 0; col < A[row].length; col++)
            {
                if(row == col)
                {
                    res[row][col] = A[row][col] * 10;
                }
                else
                {
                    res[row][col] = A[row][col] ;
                }
            }
        }
        return res;
    }

    static int countElementOccurence(int A[][], int key)
    {
        int count = 0;

        for(int row = 0; row < A.length; row++)
        {
            for(int col = 0; col < A[row].length; col++)
            {
                if(A[row][col] == key)
                {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args)
    {
        // find sum of all even elements
        int A[][] = {
                {30,50,90},
                {70,60,20},
                {40,80,30}
        };
        System.out.println("Even Count Count : " + getEvenSum(A));

        // find sum of each row
        int res[] = rowSum(A);
        System.out.print("Row Sum : [");
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
            if(i < res.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");

        // find sum of each column
        int res1[] = getColumnSum(A);
        System.out.print("Column Sum : [");
        for(int i = 0; i < res1.length; i++)
        {
            System.out.print(res1[i]);
            if(i < res1.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");

        // find sum of elements greater than 50 ---> imp
        System.out.println("Sum of Elements Above 50 : " + getElementsAboveFifty(A));

        // find max present in every row ---> imp
        int re[] = maxInEachRow(A);
        System.out.print("Column Sum : [");
        for(int i = 0; i < re.length; i++)
        {
            System.out.print(re[i]);
            if(i < re.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");

        // find min even ---> imp
        getMinEven(A);

        // multiply only the main diagonal by 10 --->        imp
        int res2[][] = diagonalMultiplicationBy10(A);

        System.out.println("Diagonal Product by 10 : ");
        for(int row = 0; row < res2.length; row++)
        {
            for(int col = 0; col < res2[row].length; col++)
            {
                System.out.printf(" %3d ",res2[row][col]);
            }
            System.out.println();
        }

        // count how many times an element occurs --->       imp
        int key = 30;
        System.out.println("Count of Element Occurence : " + countElementOccurence(A,key));

    }
}