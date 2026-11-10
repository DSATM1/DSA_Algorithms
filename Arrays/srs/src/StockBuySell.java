public class StockBuySell
{
    static double getMaxProgitInStock(double stock[])
    {
        double maxProfit = 0;//Double.MIN_VALUE;

        for(int buy = 0; buy < stock.length; buy++)
        {
            for(int sell = buy + 1; sell < stock.length; sell++)
            {
                double currentProfit = stock[sell] - stock[buy];

                if(currentProfit > maxProfit)
                {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    static double getMax(double stock[])
    {
        double maxProfit = Double.MIN_VALUE;
        double buyDay = stock[0];

        for(int day = 1; day < stock.length; day++)
        {
            double currentProfit = stock[day] - buyDay;
            if(currentProfit > maxProfit)
            {
                maxProfit = currentProfit;
            }
            if(stock[day] < buyDay)
            {
                buyDay = stock[day];
            }
        }
        return maxProfit;
    }
    static void main(String[] args)
    {
        double stock[] = {1.0,0.1,2.3,5.7,3.4};//{1.2,1.5,6.4,3.2,0.5,5.7,5.2};//{0.9,1.3,2.7,1.0,7.5,5.0};
        double result = getMaxProgitInStock(stock);
        System.out.println(result);
        System.out.println(getMax(stock));
    }
}