public class MaxAndMin
{
    static void main(String[] args) {
        int arr[][] = {{1,2,3},{3,2,1}};
        int max = arr[0][0];
        int min = arr[0][0];

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + " ");
                if(arr[i][j] > max)
                {
                    max = arr[i][j];
                }

                if(arr[i][j] < min)
                {
                    min = arr[i][j];
                }
            }
            System.out.println();
        }

        System.out.println("Max Element in Array : " + max);
        System.out.println("Min Element in Array : " + min);
    }
}
