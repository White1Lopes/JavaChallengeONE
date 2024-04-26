public class ExchangeCalculator {
    public static double calculateConversion(double baseRate, double conversionRate, double value){
        var firstValue = value / baseRate;

        return firstValue * conversionRate;
    }
}
