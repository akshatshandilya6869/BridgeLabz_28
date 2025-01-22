public class profitloss {
    public static void main(String[] args) {
        int costPrice = 129, sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit / (double) costPrice) * 100;
        System.out.printf("The Cost Price is INR %d and Selling Price is INR %d\n" +
                          "The Profit is INR %d and the Profit Percentage is %.2f%%\n\n",
                          costPrice, sellingPrice, profit, profitPercentage);
    }
}
