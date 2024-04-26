import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<Integer, String> currentCodes()
    {
        var currentCodes = new HashMap<Integer, String>();
        currentCodes.put(1, "USD");
        currentCodes.put(2, "ARS");
        currentCodes.put(3, "COP");
        currentCodes.put(4, "BOB");
        currentCodes.put(5, "BRL");
        currentCodes.put(6, "CLP");
        currentCodes.put(7, "CAD");
        currentCodes.put(8, "CNY");
        currentCodes.put(9, "EUR");
        currentCodes.put(10, "JPY");
        return currentCodes;
    }
}
