import java.util.Arrays;

public class TrainProblem
{
    public static int getMinPlatform(int arivalTime[], int departTime[])
    {
        int maxSoFar = 0;
        int currentCount = 0;
        int arrivalIndex = 0;
        int departIndex = 0;

        Arrays.sort(arivalTime);
        Arrays.sort(departTime);

        while(arrivalIndex < arivalTime.length)
        {
            if(arivalTime[arrivalIndex] < departTime[departIndex])
            {
                currentCount++;
                arrivalIndex++;
                maxSoFar = Math.max(maxSoFar, currentCount);
            }
            else
            {
                currentCount--;
                departIndex++;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args)
    {
        int arr[] = {1030,1050,1035,1050,1037};
        int depart[] = {1045,1055,1040,1110,1058};
        int res = getMinPlatform(arr,depart);
        System.out.println("Number of Platforms is : " + res);
    }
}
